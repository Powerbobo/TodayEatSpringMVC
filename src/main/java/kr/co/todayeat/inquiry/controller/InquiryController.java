package kr.co.todayeat.inquiry.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import kr.co.todayeat.inquiry.domain.Inquiry;
import kr.co.todayeat.inquiry.domain.PageInfo;
import kr.co.todayeat.inquiry.service.InquiryService;

@Controller
public class InquiryController {

	@Autowired
	private InquiryService service;

	
	/**
	 * 문의 게시판 페이지이동 Controller
	 * @param currentPage
	 * @param model
	 * @return String
	 */
	@RequestMapping(value="/inquiry/list.do", method=RequestMethod.GET)
	public String showlistForm(
			@RequestParam(value="page", required=false, defaultValue="1") Integer currentPage
			, Model model) {
		try {
			// 문의사항 전체 갯수 조회 메소드
			int totalCount = service.getListCount();
			PageInfo pInfo = this.getPageInfo(currentPage, totalCount);
			List<Inquiry> iList = service.selectInquiryList(pInfo);
			if(iList.size() > 0) {
				model.addAttribute("pInfo", pInfo);
				model.addAttribute("iList", iList);
				return "inquiry/list";
			} else {
				// 실패 -> 메인페이지로 이동
				model.addAttribute("msg", "데이터 조회 실패!");
				model.addAttribute("url", "/index.jsp");
				return "common/serviceFailed";
			}
		} catch (Exception e) {
			model.addAttribute("msg", "관리자에게 문의해주세요.");
			model.addAttribute("url", "/inquiry/list.do");
			model.addAttribute("error", e.getMessage());
			return "common/serviceFailed";
		}
	}

	// 네비게이션 검색하기
	@RequestMapping(value="/inquiry/search.do", method=RequestMethod.GET)
	public String searchInquiryList(
			@RequestParam("searchCondition") String searchCondition
			, @RequestParam("searchKeyword") String searchKeyword
			, @RequestParam(value="page", required=false, defaultValue="1") Integer currentPage
			, Model model) {
		try {
			List<Inquiry> searchList = new ArrayList<Inquiry>();
			
			// searchCondition, searchKeyword 2개의 값을 넘겨줘야함
			// 방법 1 : VO클래스 만들기, 방법 2 : HashMap 이용하기 -> 2번 사용
			Map<String, String> paramMap = new HashMap<String, String>();
			
			// paramMap 변수에 searchCondition, searchKeyword 값 넣기
			paramMap.put("searchCondition", searchCondition);
			paramMap.put("searchKeyword", searchKeyword);
			
			// 페이징처리
			int totalCount = service.getListCount(paramMap);
			PageInfo pInfo = this.getPageInfo(currentPage, totalCount);
			
			// 키워드 검색
			searchList = service.searchInquiryKeyword(pInfo, paramMap);
			if(!searchList.isEmpty()) {
				// 조건으로 검색 후 2페이지 이후에도 해당 조건에 맞게 조회하기 위해서
				// searchCondition, searchKeyword를 model.attribute 해 jsp에서 사용
				model.addAttribute("searchCondition", searchCondition);
				model.addAttribute("searchKeyword", searchKeyword);
				model.addAttribute("pInfo", pInfo);
				model.addAttribute("iList", searchList);
				return "inquiry/search";
			} else {
				model.addAttribute("msg", "데이터 조회가 완료되지 않았습니다.");
				model.addAttribute("error", "공지사항 제목으로 조회 실패");
				model.addAttribute("url", "/list.jsp");
				return "common/serviceFailed";
			}
		} catch (Exception e) {
			model.addAttribute("msg", "관리자에게 문의해주세요.");
			model.addAttribute("url", "/inquiry/list.do");
			model.addAttribute("error", e.getMessage());
			return "common/serviceFailed";
		}
	}

	/**
	 * 문의 등록 페이지이동 Controller
	 * @return String
	 */
	@RequestMapping(value="/inquiry/insert.do", method=RequestMethod.GET)
	public String showinsertForm() {
		return "inquiry/insert";
	}

	// 문의사항 번호로 조회
	@RequestMapping(value="/inquiry/detail.do", method=RequestMethod.GET)
	public String showDetailForm(
			@RequestParam("inquiryNo") Integer inquiryNo
			, Model model) {
		Inquiry inquiry = service.selectInquiryByNo(inquiryNo);
		model.addAttribute("inquiry", inquiry);
		return "inquiry/detail";
	}

	// 문의 수정페이지로 이동하기
	@RequestMapping(value="/inquiry/modify.do", method=RequestMethod.GET)
	public String showModifyForm(
			@RequestParam("inquiryNo") Integer inquiryNo
			, Model model) {
		Inquiry inquiry = service.selectInquiryByNo(inquiryNo);
		model.addAttribute("inquiry", inquiry);
		return "inquiry/modify";
	}

	/**
	 * 문의 등록하기 Controller
	 * @param inquiry
	 * @param uploadFile
	 * @param request
	 * @param model
	 * @return int
	 */
	@RequestMapping(value="/inquiry/insert.do", method=RequestMethod.POST)
	public String insertInquiry(
			@ModelAttribute Inquiry inquiry
			, @RequestParam(value="uploadFile", required=false) MultipartFile uploadFile
			, HttpServletRequest request
			, Model model) {
		try {
			// ■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■ 파일 첨부 ■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■
			// 파일이 있는지 여부 유효선 검사 후 파일 첨부 진행
			if(uploadFile != null && !uploadFile.getOriginalFilename().equals("")) {
				Map<String, Object> iMap = this.saveFile(uploadFile, request);
				String fileName = (String)iMap.get("fileName");
				String fileRename = (String)iMap.get("fileRename");
				String filePath = (String)iMap.get("filePath");
				long fileLength = (long)iMap.get("fileLength");
				
				// DB에 저장하기 위해 inquiry에 데이터를 Set 하는 부분
				inquiry.setInquiryFilename(fileName);
				inquiry.setInquiryFileRename(fileRename);
				inquiry.setInquiryFilepath(filePath);
				inquiry.setInquiryFilelength(fileLength);
			}
			
			// ■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■ 문의 등록■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■
			int result = service.insertInquiry(inquiry);
			if(result > 0) {	// 유효성 검사
				// 성공 -> 문의하기 게시판으로 이동
				model.addAttribute("inquiry", inquiry);
				model.addAttribute("msg", "문의 등록 성공!");
				model.addAttribute("url", "/inquiry/list.do");
				return "common/serviceSuccess";
			} else {
				// 실패 -> 문의하기 게시판으로 이동
				model.addAttribute("msg", "문의 등록 실패!.");
				model.addAttribute("url", "/inquiry/list.do");
				return "common/serviceFailed";
			}
		} catch (Exception e) {
			model.addAttribute("msg", "관리자에게 문의해주세요.");
			model.addAttribute("url", "/inquiry/list.do");
			model.addAttribute("error", e.getMessage());
			return "common/serviceFailed";
		}
		
	}
	
	/**
	 * 페이지 네비게이션
	 * @param currentPage
	 * @param totalCount
	 * @return PageInfo
	 */
	public PageInfo getPageInfo(int currentPage, int totalCount) {
		PageInfo pi = null;
		int recordCountPerPage = 10;
		int naviCountPerPage = 10;
		int naviTotalCount;
		int startNavi;
		int endNavi;
		
		// 전체 페이지 갯수
		naviTotalCount = (int)(((double)totalCount/recordCountPerPage)+ 0.9);
		
		// 한 페이지의 시작 값
		startNavi = (((int)(((double)currentPage/naviCountPerPage) + 0.9))-1) * naviCountPerPage + 1;
		
		// 한 페이지의 끝 값
		endNavi = startNavi + naviCountPerPage -1;
		
		// endNavi는 startNavi에 무조건 naviCountPerPage값을 더하므로 실제 최대값보다 커질 수 있음
		// 총 페이지 12일때 endNavi가 15가 될 수 있음. 그것을 방지하기 위해서 아래 식 작성
		if(endNavi > naviTotalCount) {
			endNavi = naviTotalCount;
		}
		
		// PageInfo Class를 만들어서 모든 변수를 담고, 해당 클래스를 이용해서 리턴
		pi = new PageInfo(currentPage, recordCountPerPage, naviCountPerPage, startNavi, endNavi, totalCount, naviTotalCount);
		return pi;
	}
	
	// 파일 이름/경로/크기 가져오기
	public Map<String, Object> saveFile(MultipartFile uploadFile, HttpServletRequest request) throws Exception {
		// 이름/경로/크기 총 3개를 넘겨야 하기 때문에 Hashmap 사용함!
		Map<String, Object> infoMap	 = new HashMap<String, Object>();
		
		// ============================== 파일 이름 ==============================
		// FileRename
		
		String fileName = uploadFile.getOriginalFilename();
		String root = request.getSession().getServletContext().getRealPath("resources");
		String saveFolder = root + "\\iuploadFiles";
		File folder = new File(saveFolder);
		if(!folder.exists()) { // 해당 경로에 파일 있는지 여부 확인
			// 없을 경우 폴더 생성
			folder.mkdir();
		}
		// ============================== 파일 경로 ==============================
		// FileRename 으로 저장되게끔 함!
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHss");
		String strResult = sdf.format(new Date(System.currentTimeMillis()));
		
		// 파일 이름에서 확장자명 추출하기
		String ext = fileName.substring(fileName.lastIndexOf(".")+1);
		String fileRename = "N" + strResult + "." + ext;
		
		String savePath = saveFolder + "\\" + fileRename;
		File file = new File(savePath);
		// ****************************** 파일 저장 ******************************
		uploadFile.transferTo(file);
		// ============================== 파일 크기 ==============================
		long fileLength = uploadFile.getSize();
		
		// DB에 저장하기 위해 inquiry에 데이터를 Set 하는 부분
		infoMap.put("fileName", fileName);
		infoMap.put("fileRename", fileRename);
		infoMap.put("filePath", savePath);
		infoMap.put("fileLength", fileLength);
		return infoMap;
	}
	
	
	
	
}
