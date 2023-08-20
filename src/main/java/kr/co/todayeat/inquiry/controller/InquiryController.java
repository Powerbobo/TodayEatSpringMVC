package kr.co.todayeat.inquiry.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.co.todayeat.inquiry.service.InquiryService;

@Controller
public class InquiryController {

	@Autowired
	private InquiryService service;
	
	// 공지사항 페이지로 이동
	@RequestMapping(value="/inquiry/list.do", method=RequestMethod.GET)
	public String showInsertForm() {
		return "inquiry/insert";
	}
}
