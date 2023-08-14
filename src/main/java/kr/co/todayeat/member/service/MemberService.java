package kr.co.todayeat.member.service;

import org.springframework.stereotype.Service;

import kr.co.todayeat.member.domain.Member;

@Service
public interface MemberService {
	
	/**
	 * ȸ�� ��� Service
	 * @param member
	 * @return
	 */
	public int insertMember(Member member);
	
	/**
	 * ȸ�� �α��� Service
	 * @param member
	 * @return
	 */
	public Member selectLongin(Member member);

	/**
	 * ȸ�� ���̵� ã��Service(�̸���)
	 * @param member
	 * @return
	 */
	public Member selectOneByEmail(Member member);

	/**
	 * ȸ�� ���̵� ã�� Service(��ȭ��ȣ)
	 * @param member
	 * @return
	 */
	public Member selectOneByPhone(Member member);

	/**
	 * ȸ�� ��й�ȣ ã�� Service(��ȭ��ȣ)
	 * @param member
	 * @return
	 */
	public Member selectPwOneByPhone(Member member);

	/**
	 * ȸ�� ��й�ȣ ã�� Service(�̸���)
	 * @param member
	 * @return
	 */
	public Member selectPwOneByEmail(Member member);

	/**
	 * ȸ�� ���������� ��ȸ Service
	 * @param memberId
	 * @return
	 */
	public Member selectOneById(String memberId);

	/**
	 * ȸ�� ���� ���� Service
	 * @param member
	 * @return
	 */
	public int updateMember(Member member);
	
	/**
	 * ȸ�� Ż���ϱ� Service
	 * @param memberId
	 * @return
	 */
	public int deleteMember(String memberId);
	
}
