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
	
	// 로그인 구현
	@Override
	public Member selectLongin(Member member) {
		Member mOne = mStore.selectLongin(sqlSession, member);
		return mOne;
	}
	
	// 아이디 찾기(이메일)
	@Override
	public Member selectOneByEmail(Member member) {
		// TODO Auto-generated method stub
		return null;
	}
	
	// 아이디 찾기(전화번호)
	@Override
	public Member selectOneByPhone(Member member) {
		// TODO Auto-generated method stub
		return null;
	}

	// 비밀번호 찾기(전화번호)
	@Override
	public Member selectPwOneByPhone(Member member) {
		// TODO Auto-generated method stub
		return null;
	}

	// 비밀번호 찾기(이메일)
	@Override
	public Member selectPwOneByEmail(Member member) {
		// TODO Auto-generated method stub
		return null;
	}

	// 마이페이지 조회
	@Override
	public Member selectOneById(String memberId) {
		Member mOne = mStore.selectOneById(sqlSession, memberId);
		return mOne;
	}

	// 회원가입 구현
	@Override
	public int insertMember(Member member) {
		int result = mStore.insertMember(sqlSession, member);
		return result;
	}

	// 회원정보 수정 구현
	@Override
	public int updateMember(Member member) {
		int result = mStore.updateMember(sqlSession, member);
		return result;
	}

	// 회원 탈퇴 구현
	@Override
	public int deleteMember(String memberId) {
		int result = mStore.deleteMember(sqlSession, memberId);
		return result;
	}
	

}
