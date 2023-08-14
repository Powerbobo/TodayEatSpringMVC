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
@SessionAttributes({ "memberId", "memberName" })	// ���� ���� ��� 1)
public class MemberController {
	
	@Autowired
	private MemberService service;
	
	// ȸ������ ������ �̵�
	// a �±� -> doGet
	@RequestMapping(value="/member/join.do", method=RequestMethod.GET)
	public String showRegisterForm(Model model) {
		return "member/join";
	}
	
	// ȸ������
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
			// date Ÿ������ ��ȯ�ϱ� ���ؼ�
			, @RequestParam(value="joinBir", required = false) String mBirthday
			, Model model) {
		
		try {
			// date Ÿ������ ��ȯ
			DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			LocalDate date = LocalDate.parse(mBirthday, format);
			Date memberBirthday = Date.valueOf(date);
			Member member = new Member(memberId, memberPw, memberPwRe, memberName, memberPhone, memberEmail, memberAddress, memberGender, memberBirthday);
			int result = service.insertMember(member);
			// ��ȿ�� �˻�
			if(result > 0) {
				// ���� -> ���� alert â ���� �α��� �������� �̵�
				model.addAttribute("msg", "ȸ������ ����!");
				model.addAttribute("url", "/index.jsp");	// �α��� ������ ����� �� �ӽ�
				return "common/serviceSuccess";
			} else {
				// ���� -> ���� alert â ���� �ٽ� ȸ������ ������
				model.addAttribute("msg", "ȸ������ ����!");
				model.addAttribute("url", "/member/join.do");
				return "common/serviceFailed";
			}
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", e.getMessage());
			return "common/serviceFailed";
		}
		
	}
	
	// �α��� ������ �̵�
	// a �±� -> doGet
	@RequestMapping(value="/member/login.do", method=RequestMethod.GET)
	public String showLoginForm(Model model) {
		return "member/login";
	}
	
	// �α���
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
				// �α��� ���� -> ���� alert â�� �Բ� ������������ �̵�
				// ���� ���� ��� 2)
//				HttpSession session = request.getSession();
//				session.setAttribute("memberId", member.getMemberId());
//				session.setAttribute("memberPw", member.getMemberPw());
				
				model.addAttribute("memberId", member.getMemberId());
				model.addAttribute("memberName", member.getMemberName());
				model.addAttribute("msg", "�α��� ����!");
				model.addAttribute("url", "/index.jsp");
				return "common/serviceSuccess";
			} else {
				// �α��� ���� -> ���� alert â�� �Բ� �ٽ� �α��� ������
				model.addAttribute("msg", "�α��� ����!");
				model.addAttribute("url", "/member/login.do");
				return "common/serviceFailed";
			}
		} catch (Exception e) {
			// ����ó��
			e.getStackTrace();
			model.addAttribute("msg", e.getMessage());
			return "common/serviceFailed";
		}
	}
	
	// �α׾ƿ�
	@RequestMapping(value="/member/logout.do", method=RequestMethod.GET)
	public String logoutMember(
			HttpSession sessionPrev
			, SessionStatus session
			, Model model) {
		if(session != null) {	// �α����� �Ǿ��ִٸ�
			// ���� �ı�
			model.addAttribute("msg", "�α׾ƿ� ����!");
			model.addAttribute("url", "/index.jsp");
			session.setComplete();
			if(session.isComplete()) {
				// ���Ǹ��� ��ȿ�� üũ
			}
			// �α׾ƿ� ���� -> ������������ �̵�
			return "common/serviceSuccess";
		} else {
			// �α׾ƿ� ���� -> alert â���� ���� �޼��� ����
			model.addAttribute("msg", "�α׾ƿ� ����!");
			model.addAttribute("url", "/index.jsp");
			return "common/serviceFailed";
		}
	}
	
	// ������������ �̵�
	// a �±� -> doGet
	@RequestMapping(value="/member/myPage.do", method=RequestMethod.GET)
	public String selectOneById(
			@RequestParam("memberId") String memberId
			, RedirectAttributes redirect
			, Model model) {
		try {
			Member member = service.selectOneById(memberId);
			if(member != null) {
				// ���� -> ���� alertâ ��� �� ������������ �̵�
				model.addAttribute("member", member);
				return "member/myPage";
			} else {
				// ���� -> ���� alertâ ��� �� ����������
				model.addAttribute("msg", "������ ��ȸ�� �����߽��ϴ�.");
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
