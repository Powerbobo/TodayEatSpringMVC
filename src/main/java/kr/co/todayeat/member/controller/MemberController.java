package kr.co.todayeat.member.controller;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.todayeat.member.domain.Member;
import kr.co.todayeat.member.service.MemberService;

@Controller
public class MemberController {
	
	@Autowired
	private MemberService service;
	
	@RequestMapping(value="/member/join.do", method=RequestMethod.GET)
	public String showRegisterForm(Model model) {
		return "member/join";
	}
	
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
			, @RequestParam("joinBir") @DateTimeFormat(pattern = "yyyy-MM-dd") Date memberBirthday
			, Model model) {
		
		try {
			Member member = new Member(memberId, memberPw, memberPwRe, memberName, memberPhone, memberEmail, memberAddress, memberGender, memberBirthday);
			int result = service.insertMember(member);
			if(result > 0) {
				// ���� -> ���� alert â ���� �α��� �������� �̵�
				model.addAttribute("msg", "ȸ������ ����!");
				model.addAttribute("url", "/index.jsp");
				return "common/serviceSuccess";
			} else {
				// ���� -> ���� alert â ���� ȸ������ ������
				model.addAttribute("msg", "ȸ������ ����!");
				model.addAttribute("url", "/member/join.do");
				return "common/serviceFailed";
			}
		} catch (Exception e) {
			model.addAttribute("msg", e.getMessage());
			return "common/serviceFailed";
		}
		
	}
	
	
	
}
