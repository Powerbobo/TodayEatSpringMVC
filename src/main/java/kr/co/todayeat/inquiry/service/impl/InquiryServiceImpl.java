package kr.co.todayeat.inquiry.service.impl;

import java.util.List;

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

}
