package kr.co.todayeat.inquiry.store.logic;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kr.co.todayeat.inquiry.domain.Inquiry;
import kr.co.todayeat.inquiry.domain.PageInfo;
import kr.co.todayeat.inquiry.store.InquiryStore;

@Repository
public class InquiryStorelogic implements InquiryStore{

	// 문의 등록하기
	@Override
	public int insertInquiry(SqlSession session, Inquiry inquiry) {
		int result = session.insert("InquiryMapper.insertInquiry", inquiry);
		return result;
	}

	// 문의사항 전체 갯수 조회
	@Override
	public int selectInquiryCount(SqlSession session) {
		int result = session.selectOne("InquiryMapper.selectInquiryCount");
		return result;
	}

	// 문의사항 게시판 리스트 가져오기
	@Override
	public List<Inquiry> selectInquiryList(SqlSession session, PageInfo pInfo) {
		int limit = pInfo.getRecordCountPerPage();
		int offset = (pInfo.getCurrentPage()-1) * limit;
		RowBounds rowBounds = new RowBounds(offset, limit);
		List<Inquiry> iList = session.selectList("InquiryMapper.selectInquiryList", null, rowBounds);
		return iList;
	}

	// 문의사항 검색 게시물 전체 갯수
	@Override
	public int selectListCount(SqlSession session, Map<String, String> paramMap) {
		int result = session.selectOne("InquiryMapper.selectListByKeywordCount", paramMap);
		return result;
	}

	// 문의사항 조건에 따라 키워드로 검색
	@Override
	public List<Inquiry> searchInquiryKeyword(SqlSession session, PageInfo pInfo, Map<String, String> paramMap) {
		int limit = pInfo.getRecordCountPerPage();
		int offset = (pInfo.getCurrentPage()-1) * limit;
		RowBounds rowBounds = new RowBounds(offset, limit);
		List<Inquiry> searchList = session.selectList("InquiryMapper.searchInquiryByKeyword", paramMap, rowBounds);
		return searchList;
	}

	// 문의사항 번호로 조회
	@Override
	public Inquiry showInquiryByNo(SqlSession session, Integer inquiryNo) {
		Inquiry inquiry = session.selectOne("InquiryMapper.showInquiryByNo", inquiryNo);
		return inquiry;
	}


	
}
