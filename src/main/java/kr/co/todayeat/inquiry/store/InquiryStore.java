package kr.co.todayeat.inquiry.store;

import java.util.List;
import java.util.Map;

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

	/**
	 * 문의사항 검색 게시물 전체 갯수 Store
	 * @param session
	 * @param paramMap
	 * @return int
	 */
	int selectListCount(SqlSession session, Map<String, String> paramMap);

	/**
	 * 문의사항 조건에 따라 키워드로 검색 Store
	 * @param session
	 * @param paramMap
	 * @return List
	 */
	List<Inquiry> searchInquiryKeyword(SqlSession session, PageInfo pInfo, Map<String, String> paramMap);

	/**
	 * 문의사항 번호로 조회 Store
	 * @param session
	 * @param inquiryNo
	 * @return Inquiry
	 */
	Inquiry selectInquiryByNo(SqlSession session, Integer inquiryNo);

	/**
	 * 문의사항 수정하기 Store
	 * @param session
	 * @param inquiry
	 * @return int
	 */
	int updateInquiry(SqlSession session, Inquiry inquiry);

	/**
	 * 문의사항 삭제하기 Store
	 * @param session
	 * @param inquirtNo
	 * @return int
	 */
	int deleteInquiry(SqlSession session, Integer inquiryNo);


}
