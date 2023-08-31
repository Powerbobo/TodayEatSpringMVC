package kr.co.todayeat.inquiry.store.logic;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kr.co.todayeat.inquiry.domain.Answer;
import kr.co.todayeat.inquiry.store.AnswerStore;

@Repository
public class AnswerStroeLogic implements AnswerStore{

	// 문의글 답변 등록
	@Override
	public int insertAnswer(SqlSession session, Answer answer) {
		int result = session.insert("AnswerMapper.insertAnswer", answer);
		return result;
	}

	// 문의글 답변 조회
	@Override
	public Answer selectAnswerByNo(SqlSession session, Integer inquiryNo) {
		Answer answer = session.selectOne("AnswerMapper.selectAnswerByNo", inquiryNo);
		return answer;
	}

	// 문의글 답변 수정
	@Override
	public int updateAnswer(SqlSession session, Answer answer) {
		int result = session.update("AnswerMapper.updateAnswer", answer);
		return result;
	}

}
