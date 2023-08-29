package kr.co.todayeat.inquiry.store.logic;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kr.co.todayeat.inquiry.domain.Answer;
import kr.co.todayeat.inquiry.store.AnswerStore;

@Repository
public class AnswerStroeLogic implements AnswerStore{

	// 게시판 답변 등록
	@Override
	public int insertAnswer(SqlSession session, Answer answer) {
		int result = session.insert("AnswerMapper.insertAnswer", answer);
		return result;
	}

}
