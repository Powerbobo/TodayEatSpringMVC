package kr.co.todayeat.member.service;

import kr.co.todayeat.member.domain.Member;

public interface MemberService {
	
	/**
	 * 회원가입 Service
	 * @param member
	 * @return int
	 */
	public int insertMember(Member member);
	
	/**
	 * 로그인 Service
	 * @param member
	 * @return Member
	 */
	public Member selectLongin(Member member);

	/**
	 * 아이디 찾기(이메일) Service
	 * @param member
	 * @return Member
	 */
	public Member selectOneByEmail(Member member);

	/**
	 * 아이디 찾기(전화번호) Service
	 * @param member
	 * @return Member
	 */
	public Member selectOneByPhone(Member member);

	/**
	 *  비밀번호 찾기(전화번호) Service
	 * @param member
	 * @return Member
	 */
	public Member selectPwOneByPhone(Member member);

	/**
	 * 비밀번호 찾기(이메일) Service
	 * @param member
	 * @return Member
	 */
	public Member selectPwOneByEmail(Member member);

	/**
	 * 마이페이지 조회 Service
	 * @param memberId
	 * @return Member
	 */
	public Member selectOneById(String memberId);

	/**
	 * 회원정보 수정 Service
	 * @param member
	 * @return int
	 */
	public int updateMember(Member member);
	
	/**
	 *  회원 탈퇴 Service
	 * @param memberId
	 * @return int
	 */
	public int deleteMember(String memberId);
	
}
