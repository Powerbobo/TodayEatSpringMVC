package kr.co.todayeat.member.service.impl;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.todayeat.member.domain.Member;
import kr.co.todayeat.member.service.MemberService;
import kr.co.todayeat.member.store.MemberStore;

@Service
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	private MemberStore mStore;
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public Member selectLongin(Member member) {
		Member mOne = mStore.selectLongin(sqlSession, member);
		return mOne;
	}

	@Override
	public Member selectOneByEmail(Member member) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Member selectOneByPhone(Member member) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Member selectPwOneByPhone(Member member) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Member selectPwOneByEmail(Member member) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Member selectOneById(String memberId) {
		Member mOne = mStore.selectOneById(sqlSession, memberId);
		return mOne;
	}

	@Override
	public int insertMember(Member member) {
		int result = mStore.insertMember(sqlSession, member);
		return result;
	}

	@Override
	public int updateMember(Member member) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteMember(String memberId) {
		// TODO Auto-generated method stub
		return 0;
	}

}
