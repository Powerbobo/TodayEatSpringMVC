package kr.co.todayeat.member.controller;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.co.todayeat.member.domain.Member;
import kr.co.todayeat.member.service.MemberService;

@Controller
@SessionAttributes({ "memberId", "memberName" })	// 세션 저장 방법 1)
public class MemberController {
	
	@Autowired
	private MemberService service;
	
	// 회원가입 페이지 이동
	// a 태그 -> doGet
	@RequestMapping(value="/member/join.do", method=RequestMethod.GET)
	public String showRegisterForm(Model model) {
		return "member/join";
	}
	
	// 회원가입
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
			// date 타입으로 변환하기 위해서
			, @RequestParam(value="joinBir", required = false) String mBirthday
			, Model model) {
		
		try {
			// date 타입으로 변환
			DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			LocalDate date = LocalDate.parse(mBirthday, format);
			Date memberBirthday = Date.valueOf(date);
			Member member = new Member(memberId, memberPw, memberPwRe, memberName, memberPhone, memberEmail, memberAddress, memberGender, memberBirthday);
			int result = service.insertMember(member);
			// 유효성 검사
			if(result > 0) {
				// 성공 -> 성공 alert 창 띄우고 로그인 페이지로 이동
				model.addAttribute("msg", "회원가입 성공!");
				model.addAttribute("url", "/index.jsp");	// 로그인 페이지 만들기 전 임시
				return "common/serviceSuccess";
			} else {
				// 실패 -> 실패 alert 창 띄우고 다시 회원가입 페이지
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
	// a 태그 -> doGet
	@RequestMapping(value="/member/login.do", method=RequestMethod.GET)
	public String showLoginForm(Model model) {
		return "member/login";
	}
	
	// 로그인
	@RequestMapping(value="/member/login.do", method=RequestMethod.POST)
	public String loginMember(
			@RequestParam("memberId") String memberId
			, @RequestParam("memberPw") String memberPw
			, HttpServletRequest request
			, Model model) {
		try {
			Member member = new Member(memberId, memberPw);
			member = service.selectLongin(member);
			if(member != null) {
				// 로그인 성공 -> 성공 alert 창과 함께 메인페이지로 이동
				// 세션 저장 방법 2)
//				HttpSession session = request.getSession();
//				session.setAttribute("memberId", member.getMemberId());
//				session.setAttribute("memberPw", member.getMemberPw());
				
				model.addAttribute("memberId", member.getMemberId());
				model.addAttribute("memberName", member.getMemberName());
				model.addAttribute("msg", "로그인 성공!");
				model.addAttribute("url", "/index.jsp");
				return "common/serviceSuccess";
			} else {
				// 로그인 실패 -> 실패 alert 창과 함께 다시 로그인 페이지
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
	
	// 로그아웃
	@RequestMapping(value="/member/logout.do", method=RequestMethod.GET)
	public String logoutMember(
			HttpSession sessionPrev
			, SessionStatus session
			, Model model) {
		if(session != null) {	// 로그인이 되어있다면
			// 세션 파괴
			model.addAttribute("msg", "로그아웃 성공!");
			model.addAttribute("url", "/index.jsp");
			session.setComplete();
			if(session.isComplete()) {
				// 세션만료 유효성 체크
			}
			// 로그아웃 성공 -> 메인페이지로 이동
			return "common/serviceSuccess";
		} else {
			// 로그아웃 실패 -> alert 창으로 실패 메세지 띄우기
			model.addAttribute("msg", "로그아웃 실패!");
			model.addAttribute("url", "/index.jsp");
			return "common/serviceFailed";
		}
	}
	
	// 마이페이지로 이동
	// a 태그 -> doGet
	@RequestMapping(value="/member/myPage.do", method=RequestMethod.GET)
	public String selectOneById(
			@RequestParam("memberId") String memberId
			, RedirectAttributes redirect
			, Model model) {
		try {
			Member member = service.selectOneById(memberId);
			if(member != null) {
				// 성공 -> 성공 alert창 띄운 후 마이페이지로 이동
				model.addAttribute("member", member);
				return "member/myPage";
			} else {
				// 실패 -> 실패 alert창 띄운 후 메인페이지
				model.addAttribute("msg", "데이터 조회에 실패했습니다.");
				model.addAttribute("url", "/index.jsp");
				return "common/serviceFailed";
			}
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", e.getMessage());
			return "common/serviceFailed";
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
