package kr.co.todayeat.inquiry.service.impl;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.todayeat.inquiry.domain.Answer;
import kr.co.todayeat.inquiry.service.AnswerService;
import kr.co.todayeat.inquiry.store.AnswerStore;

@Service
public class AnswerServiceImpl implements AnswerService{

	@Autowired
	private AnswerStore aStore;
	@Autowired
	private SqlSession session;

	// 문의글 답변 등록
	@Override
	public int insertAnswer(Answer answer) {
		int result = aStore.insertAnswer(session, answer);
		return result;
	}

	// 문의글 답변 조회
	@Override
	public Answer selectAnswerByNo(Integer inquiryNo) {
		Answer answer = aStore.selectAnswerByNo(session, inquiryNo);
		return answer;
	}
}
