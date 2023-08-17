package kr.co.todayeat.member.store.logic;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kr.co.todayeat.member.domain.Member;
import kr.co.todayeat.member.store.MemberStore;

@Repository
public class MemberStroeLogic implements MemberStore {
	
	// 로그인 구현
	@Override
	public Member selectLongin(SqlSession session, Member member) {
		Member mOne = session.selectOne("MemberMapper.selectLongin", member);
		return mOne;
	}
	
	// 아이디 찾기(이메일)
	@Override
	public Member selectOneByEmail(SqlSession session, Member member) {
		// TODO Auto-generated method stub
		return null;
	}
	
	// 아이디 찾기(전화번호)
	@Override
	public Member selectOneByPhone(SqlSession session, Member member) {
		// TODO Auto-generated method stub
		return null;
	}

	// 비밀번호 찾기(전화번호)
	@Override
	public Member selectPwOneByPhone(SqlSession session, Member member) {
		// TODO Auto-generated method stub
		return null;
	}

	// 비밀번호 찾기(이메일)
	@Override
	public Member selectPwOneByEmail(SqlSession session, Member member) {
		// TODO Auto-generated method stub
		return null;
	}

	// 마이페이지 조회
	@Override
	public Member selectOneById(SqlSession session, String memberId) {
		Member mOne = session.selectOne("MemberMapper.selectOneById", memberId);
		return mOne;
	}

	// 회원가입 구현
	@Override
	public int insertMember(SqlSession session, Member member) {
		int result = session.insert("MemberMapper.insertMember", member);
		return result;
	}

	// 회원정보 수정 구현
	@Override
	public int updateMember(SqlSession session, Member member) {
		// TODO Auto-generated method stub
		return 0;
	}

	// 회원탈퇴 구현
	@Override
	public int deleteMember(SqlSession session, String memberId) {
		// TODO Auto-generated method stub
		return 0;
	}

}
