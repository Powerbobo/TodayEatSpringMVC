package kr.co.todayeat.inquiry.store;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import kr.co.todayeat.inquiry.domain.Inquiry;

public interface InquiryStore {

	/**
	 * 문의 등록하기 Store
	 * @param session
	 * @param inquiry
	 * @return int
	 */
	int insertInquiry(SqlSession session, Inquiry inquiry);

	/**
	 * 문의사항 전체 갯수 조회 Store
	 * @param session
	 * @return
	 */
	int selectInquiryCount(SqlSession session);

}
