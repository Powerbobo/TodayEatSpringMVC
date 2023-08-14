package kr.co.todayeat.member.service;

import org.springframework.stereotype.Service;

import kr.co.todayeat.member.domain.Member;

@Service
public interface MemberService {
	
	/**
	 * 회원 등록 Service
	 * @param member
	 * @return
	 */
	public int insertMember(Member member);
	
	/**
	 * 회원 정보 수정 Service
	 * @param member
	 * @return
	 */
	public int updateMember(Member member);
	
	/**
	 * 회원 로그인 Service
	 * @param member
	 * @return
	 */
	public Member selectLongin(Member member);
	
	/**
	 * 회원 아이디 찾기Service(이메일)
	 * @param member
	 * @return
	 */
	public Member selectOneByEmail(Member member);
	
	/**
	 * 회원 아이디 찾기 Service(전화번호)
	 * @param member
	 * @return
	 */
	public Member selectOneByPhone(Member member);
	
	/**
	 * 회원 비밀번호 찾기 Service(전화번호)
	 * @param member
	 * @return
	 */
	public Member selectPwOneByPhone(Member member);
	
	/**
	 * 회원 비밀번호 찾기 Service(이메일)
	 * @param member
	 * @return
	 */
	public Member selectPwOneByEmail(Member member);
	
	/**
	 * 회원 마이페이지 조회 Service
	 * @param memberId
	 * @return
	 */
	public Member selectOneById(String memberId);
	
	/**
	 * 회원 탈퇴하기 Service
	 * @param memberId
	 * @return
	 */
	public int deleteMember(String memberId);
	
}
