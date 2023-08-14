package kr.co.todayeat.member.store;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kr.co.todayeat.member.domain.Member;

@Repository
public interface MemberStore {

	public int insertMember(SqlSession session, Member member);
	
	public int updateMember(SqlSession session, Member member);
	
	public Member selectLongin(SqlSession session, Member member);
	
	public Member selectOneByEmail(SqlSession session, Member member);
	
	public Member selectOneByPhone(SqlSession session, Member member);
	
	public Member selectPwOneByPhone(SqlSession session, Member member);
	
	public Member selectPwOneByEmail(SqlSession session, Member member);
	
	public Member selectOneById(SqlSession session, String memberId);
	
	public int deleteMember(SqlSession session, String memberId);
}
