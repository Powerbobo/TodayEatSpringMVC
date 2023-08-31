package kr.co.todayeat.inquiry.store;

import org.apache.ibatis.session.SqlSession;

import kr.co.todayeat.inquiry.domain.Answer;

public interface AnswerStore {

	/**
	 * 게시판 답변 등록 Store
	 * @param session
	 * @param answer
	 * @return int
	 */
	int insertAnswer(SqlSession session, Answer answer);

	/**
	 * 문의글 답변 조회 Store
	 * @param session
	 * @param inquiryNo
	 * @return
	 */
	Answer selectAnswerByNo(SqlSession session, Integer inquiryNo);

	/**
	 * 문의글 답변 수정 Store
	 * @param session
	 * @param answer
	 * @return int
	 */
	int updateAnswer(SqlSession session, Answer answer);

}
