package kr.co.todayeat.inquiry.service;

import kr.co.todayeat.inquiry.domain.Answer;

public interface AnswerService {

	/**
	 * 문의글 답변 등록 Service
	 * @param answer
	 * @return int
	 */
	int insertAnswer(Answer answer);

}
