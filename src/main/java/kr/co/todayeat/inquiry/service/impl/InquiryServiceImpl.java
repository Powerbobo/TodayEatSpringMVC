package kr.co.todayeat.inquiry.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.todayeat.inquiry.domain.Inquiry;
import kr.co.todayeat.inquiry.domain.PageInfo;
import kr.co.todayeat.inquiry.service.InquiryService;
import kr.co.todayeat.inquiry.store.InquiryStore;

@Service
public class InquiryServiceImpl implements InquiryService{
	
	@Autowired
	private SqlSession session;
	
	@Autowired
	private InquiryStore iStore;

	// 문의 등록하기
	@Override
	public int insertInquiry(Inquiry inquiry) {
		int result = iStore.insertInquiry(session, inquiry);
		return result;
	}

	// 문의사항 전체 갯수 조회
	@Override
	public int getListCount() {
		int result = iStore.selectInquiryCount(session);
		return result;
	}

	// 문의사항 목록 조회
	@Override
	public List<Inquiry> selectInquiryList(PageInfo pInfo) {
		List<Inquiry> iList = iStore.selectInquiryList(session, pInfo);
		return iList;
	}

	// 문의사항 검색 게시물 전체 갯수
	@Override
	public int getListCount(Map<String, String> paramMap) {
		int result = iStore.selectListCount(session, paramMap);
		return result;
	}

	// 문의사항 조건에 따라 키워드로 검색
	@Override
	public List<Inquiry> searchInquiryKeyword(PageInfo pInfo, Map<String, String> paramMap) {
		List<Inquiry> iList = iStore.searchInquiryKeyword(session, pInfo, paramMap);
		return iList;
	}

	// 문의사항 번호로 조회
	@Override
	public Inquiry selectInquiryByNo(Integer inquiryNo) {
		Inquiry inqiury = iStore.selectInquiryByNo(session, inquiryNo);
		return inqiury;
	}

	// 문의사항 수정하기
	@Override
	public int updateInquiry(Inquiry inquiry) {
		int result = iStore.updateInquiry(session, inquiry);
		return result;
	}

	// 문의사항 삭제하기
	@Override
	public int deleteInquiry(Integer inquiryNo) {
		int result = iStore.deleteInquiry(session, inquiryNo);
		return result;
	}

}
