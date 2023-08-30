package kr.co.todayeat.inquiry.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import kr.co.todayeat.inquiry.domain.Answer;
import kr.co.todayeat.inquiry.service.AnswerService;

@Controller
@RequestMapping("/answer")
public class AnswerController {
	
	@Autowired
	private AnswerService aService;
	
	/**
	 * 답변 등록하기
	 * @param mv
	 * @param answer
	 * @param session
	 * @return ModelAndView
	 */
	@RequestMapping(value="/add.do", method=RequestMethod.POST)
	public ModelAndView insertAnswer(
			ModelAndView mv
			, @ModelAttribute Answer answer
			, HttpSession session) {
		String url = "";
		try {
			String memberId = (String)session.getAttribute("memberId");
//			int ansInquiryNo = answer.getAnsInquiryNo();
//			Answer answerOne = aService.selectOneByNo(ansInquiryNo);
			if(memberId != null && memberId.equals("admin")) {
				int result = aService.insertAnswer(answer);
				url = "/inquiry/detail.do?inquiryNo="+answer.getAnsInquiryNo();
				if(result > 0) {
					// 성공
					mv.setViewName("redirect:"+url);
				} else {
					// 실패
					mv.addObject("msg", "답변 등록 실패!");
					mv.addObject("url", url);
					mv.setViewName("common/serviceFailed");
				}
			} else {
				// 비로그인 되어있을 경우
				mv.addObject("msg", "로그인을 해주세요");
				mv.addObject("url", "/member/login.jsp");
				mv.setViewName("common/serviceFailed");
			}
		} catch (Exception e) {
			mv.addObject("msg", "관리자에게 문의바랍니다.");
			mv.addObject("error", e.getMessage());
			mv.addObject("url", url);
			mv.setViewName("common/serviceFailed");
		}
		return mv;
	}
}
