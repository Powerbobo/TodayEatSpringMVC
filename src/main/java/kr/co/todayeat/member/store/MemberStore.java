package kr.co.todayeat.member.store;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kr.co.todayeat.member.domain.Member;

@Repository
public interface MemberStore {

	/**
	 * 회원가입 Store
	 * @param session
	 * @param member
	 * @return int
	 */
	public int insertMember(SqlSession session, Member member);
	
	/**
	 * 회원정보 수정 Store
	 * @param session
	 * @param member
	 * @return int
	 */
	public int updateMember(SqlSession session, Member member);
	
	/**
	 * 로그인 Store
	 * @param session
	 * @param member
	 * @return Member
	 */
	public Member selectLongin(SqlSession session, Member member);
	
	/**
	 * 아이디 찾기(이메일) Store
	 * @param session
	 * @param member
	 * @return Member
	 */
	public Member selectOneByEmail(SqlSession session, Member member);
	
	/**
	 * 아이디 찾기(전화번호) Store
	 * @param session
	 * @param member
	 * @return
	 */
	public Member selectOneByPhone(SqlSession session, Member member);
	
	/**
	 * 비밀번호 찾기(전화번호) Store
	 * @param session
	 * @param member
	 * @return Member
	 */
	public Member selectPwOneByPhone(SqlSession session, Member member);
	
	/**
	 * 비밀번호 찾기(이메일) Stroe
	 * @param session
	 * @param member
	 * @return
	 */
	public Member selectPwOneByEmail(SqlSession session, Member member);
	
	/**
	 * 마이페이지 조회 Store
	 * @param session
	 * @param memberId
	 * @return
	 */
	public Member selectOneById(SqlSession session, String memberId);
	
	/**
	 * 회원탈퇴 Store
	 * @param session
	 * @param memberId
	 * @return
	 */
	public int deleteMember(SqlSession session, String memberId);
}
