package kr.co.todayeat.inquiry.store;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import kr.co.todayeat.inquiry.domain.Inquiry;
import kr.co.todayeat.inquiry.domain.PageInfo;

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

	/**
	 * 문의사항 목록 조회 Store
	 * @param session
	 * @param pInfo
	 * @return List
	 */
	List<Inquiry> selectInquiryList(SqlSession session, PageInfo pInfo);

}
