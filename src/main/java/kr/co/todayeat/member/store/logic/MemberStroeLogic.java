package kr.co.todayeat.member.store.logic;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kr.co.todayeat.member.domain.Member;
import kr.co.todayeat.member.store.MemberStore;

@Repository
public class MemberStroeLogic implements MemberStore {

	@Override
	public int insertMember(SqlSession session, Member member) {
		int result = session.insert("MemberMapper.insertMember", member);
		return result;
	}

	@Override
	public int updateMember(SqlSession session, Member member) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Member selectLongin(SqlSession session, Member member) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Member selectOneByEmail(SqlSession session, Member member) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Member selectOneByPhone(SqlSession session, Member member) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Member selectPwOneByPhone(SqlSession session, Member member) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Member selectPwOneByEmail(SqlSession session, Member member) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Member selectOneById(SqlSession session, String memberId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int deleteMember(SqlSession session, String memberId) {
		// TODO Auto-generated method stub
		return 0;
	}

}
