package kr.co.todayeat.inquiry.service;

import kr.co.todayeat.inquiry.domain.Inquiry;

public interface InquiryService {
	
	/**
	 * 문의 등록하기 Service
	 * @param inquiry
	 * @return int
	 */
	int insertInquiry(Inquiry inquiry);

	/**
	 * 공지사항 전체 갯수 조회 Service
	 * @return int
	 */
	int getListCount();
	
}
