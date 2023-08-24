package kr.co.todayeat.member.controller;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.co.todayeat.member.domain.Member;
import kr.co.todayeat.member.service.MemberService;

//@SessionAttributes({ "memberId", "memberName" })	// 로그인 세션 저장 1)
@Controller
public class MemberController {
	
	@Autowired
	private MemberService service;
	
	// 회원가입 페이지 이동
	@RequestMapping(value="/member/join.do", method=RequestMethod.GET)
	public String showRegisterForm(Model model) {
		return "member/join";
	}
	
	// 회원가입 기능 구현
	@RequestMapping(value="/member/join.do", method=RequestMethod.POST)
	public String registerMember(
			@RequestParam("joinId") String memberId
			, @RequestParam("joinPw") String memberPw
			, @RequestParam("joinPwRe") String memberPwRe
			, @RequestParam("joinName") String memberName
			, @RequestParam("joinPhone") String memberPhone
			, @RequestParam("joinEmail") String memberEmail
			, @RequestParam("joinAddr") String memberAddress
			, @RequestParam("gender") String memberGender
			// date 형변환
			, @RequestParam(value="joinBir", required = false) String mBirthday
			, Model model) {
		
		try {
			// date 형변환
			DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			LocalDate date = LocalDate.parse(mBirthday, format);
			Date memberBirthday = Date.valueOf(date);
			Member member = new Member(memberId, memberPw, memberPwRe, memberName, memberPhone, memberEmail, memberAddress, memberGender, memberBirthday);
			int result = service.insertMember(member);
			// 유효성 검사
			if(result > 0) {
				// 성공 - > 메인페이지로 이동
				model.addAttribute("msg", "회원가입 성공!");
				model.addAttribute("url", "/index.jsp");
				return "common/serviceSuccess";
			} else {
				// 실패 -> alert 실패 메세지 띄우고 다시 회원가입 페이지로 이동
				model.addAttribute("msg", "회원가입 실패!");
				model.addAttribute("url", "/member/join.do");
				return "common/serviceFailed";
			}
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", e.getMessage());
			return "common/serviceFailed";
		}
		
	}
	
	// 로그인 페이지 이동
	@RequestMapping(value="/member/login.do", method=RequestMethod.GET)
	public String showLoginForm(Model model) {
		return "member/login";
	}
	
	// 로그인 기능 구현
	@RequestMapping(value="/member/login.do", method=RequestMethod.POST)
	public String loginMember(
			@ModelAttribute Member member
			, HttpSession session
			, HttpServletRequest request
			, Model model) {
		try {
			Member mOne = service.selectLongin(member);
			// 유효성 검사
			if(mOne != null) {
				// 성공 -> alert 성공 메세지 출력 후 메인 페이지
				// 로그인 세션 저장방법 2)
				session.setAttribute("memberId", mOne.getMemberId());
				session.setAttribute("memberName", mOne.getMemberName());
				
				model.addAttribute("msg", "로그인 성공!");
				model.addAttribute("url", "/index.jsp");
				return "common/serviceSuccess";
			} else {
				// 실패 -> alert 실패 메세지 출력 후 로그인 페이지
				model.addAttribute("msg", "로그인 실패!");
				model.addAttribute("url", "/member/login.do");
				return "common/serviceFailed";
			}
		} catch (Exception e) {
			// 예외처리
			e.getStackTrace();
			model.addAttribute("msg", e.getMessage());
			return "common/serviceFailed";
		}
	}
	
	// 로그아웃 구현
	@RequestMapping(value="/member/logout.do", method=RequestMethod.GET)
	public String logoutMember(
			HttpSession session
			, Model model) {
		if(session != null) {
			session.invalidate();
			return "redirect:/index.jsp";
		} else {
			// 실패 -> alert 실패 메세지 출력 후 메인 페이지
			model.addAttribute("msg", "로그아웃 실패!");
			model.addAttribute("url", "/index.jsp");
			return "common/serviceFailed";
		}
	}
	
	// 마이페이지 이동
	@RequestMapping(value="/member/myPage.do", method=RequestMethod.POST)
	public String selectOneById(
			@RequestParam("memberId") String memberId
			, RedirectAttributes redirect
			, Model model) {
		try {
			Member member = service.selectOneById(memberId);
			if(member != null) {
				// 성공 -> alert 성공 메세지 출력 후 마이 페이지
				model.addAttribute("member", member);
				return "member/myPage";
			} else {
				// 실패 -> alert 실패 메세지 출력 후 메인 페이지
				model.addAttribute("msg", "데이터 조회 실패!");
				model.addAttribute("url", "/index.jsp");
				return "common/serviceFailed";
			}
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", e.getMessage());
			return "common/serviceFailed";
		}
	}
	
	// 수정페이지 이동
	@RequestMapping(value="/member/update.do", method=RequestMethod.GET)
	public String showModifyForm(
			@RequestParam("memberId") String memberId
			, Model model) {
		Member member = service.selectOneById(memberId);
		model.addAttribute("member", member);
		return "member/modify";
	}
	
	// 회원정보 수정
	@RequestMapping(value="/member/update.do", method=RequestMethod.POST)
	public String modifyMember(
			@ModelAttribute Member member
			, Model model
			) {
		try {
			int result = service.updateMember(member);
			if(result > 0) {
				// 성공 - 메인페이지
				return "redirect:/index.jsp";
			} else {
				// 실패 - 마이페이지
				model.addAttribute("msg", "데이터 조회 실패");
				model.addAttribute("url", "/member/myPage.do?memberId=" + member.getMemberId());
				return "member/serviceFailed";
			}
		} catch (Exception e) {
			model.addAttribute("msg", "관리자에게 문의해주세요.");
//			model.addAttribute("error", e.getMessage());
			model.addAttribute("url", "/index.jsp");
			return "common/serviceFailed";
		}
	}
	
	// 회원 탈퇴하기
	@RequestMapping(value="/member/delete.do", method=RequestMethod.GET)
	public String outService(
			@RequestParam("memberId") String memberId
			, Model model) {
		try {
			int result = service.deleteMember(memberId);
			if(result > 0) {
				model.addAttribute("msg", "회원 탈퇴 성공!");
				model.addAttribute("url", "/member/logout.do");
				return "common/serviceSuccess";
			} else {
				// 실패하면 에러페이지로 이동
				model.addAttribute("msg", "회원 탈퇴가 완료되지 않았습니다.");
//				model.addAttribute("error", "회원탈퇴 실패");
				model.addAttribute("url", "/index.jsp");
				return "common/serviceFailed";
			}
		} catch (Exception e) {
			model.addAttribute("msg", "관리자에게 문의해주세요.");
//			model.addAttribute("error", e.getMessage());
			model.addAttribute("url", "/index.jsp");
			return "common/serviceFailed";
		}
	}
	
	
	
}
