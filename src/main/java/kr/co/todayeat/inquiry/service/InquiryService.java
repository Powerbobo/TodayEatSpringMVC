package kr.co.todayeat.inquiry.service;

import java.util.List;
import java.util.Map;

import kr.co.todayeat.inquiry.domain.Inquiry;
import kr.co.todayeat.inquiry.domain.PageInfo;

public interface InquiryService {
	
	/**
	 * 문의 등록하기 Service
	 * @param inquiry
	 * @return int
	 */
	int insertInquiry(Inquiry inquiry);

	/**
	 * 문의사항 전체 갯수 조회 Service
	 * @return int
	 */
	int getListCount();

	/**
	 * 문의사항 목록 조회 Service
	 * @param pInfo
	 * @return
	 */
	List<Inquiry> selectInquiryList(PageInfo pInfo);

	/**
	 * 문의사항 검색 게시물 전체 갯수 Service
	 * @param paramMap
	 * @return int
	 */
	int getListCount(Map<String, String> paramMap);

	/**
	 * 문의사항 조건에 따라 키워드로 검색 Service
	 * @param pInfo
	 * @param paramMap
	 * @return List
	 */
	List<Inquiry> searchInquiryKeyword(PageInfo pInfo, Map<String, String> paramMap);
	
}
