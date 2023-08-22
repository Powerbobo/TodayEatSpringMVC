package kr.co.todayeat.inquiry.service;

import java.util.List;

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
	 * 공지사항 목록 조회 Service
	 * @param pInfo
	 * @return
	 */
	List<Inquiry> selectInquiryList(PageInfo pInfo);
	
}
