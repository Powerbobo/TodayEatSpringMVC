package kr.co.todayeat.member.domain;

import java.sql.Date;

public class Member {
	// �ʵ�
		private String memberId;
		private String memberPw;
		private String memberPwRe;
		private String memberName;
		private String memberPhone;
		private String memberEmail;
		private String memberAddress;
		private String memberGender;
		private Date memberBirthday;
		
		// �⺻ ������
		public Member() {}
		
		// �Ű����� ������	
		public Member(String memberId, String memberPw, String memberPwRe, String memberName, String memberPhone,
				String memberEmail, String memberAddress, String memberGender, Date memberBirthday) {
			super();
			this.memberId = memberId;
			this.memberPw = memberPw;
			this.memberPwRe = memberPwRe;
			this.memberName = memberName;
			this.memberPhone = memberPhone;
			this.memberEmail = memberEmail;
			this.memberAddress = memberAddress;
			this.memberGender = memberGender;
			this.memberBirthday = memberBirthday;
		}

		public Member(String memberId, String memberPw) {
			super();
			this.memberId = memberId;
			this.memberPw = memberPw;
		}
		
		// getter, setter �޼ҵ�
		public String getMemberId() {
			return memberId;
		}
		public void setMemberId(String memberId) {
			this.memberId = memberId;
		}
		public String getMemberPw() {
			return memberPw;
		}
		public void setMemberPw(String memberPw) {
			this.memberPw = memberPw;
		}
		public String getMemberPwRe() {
			return memberPwRe;
		}
		public void setMemberPwRe(String memberPwRe) {
			this.memberPwRe = memberPwRe;
		}
		public String getMemberName() {
			return memberName;
		}
		public void setMemberName(String memberName) {
			this.memberName = memberName;
		}
		public String getMemberPhone() {
			return memberPhone;
		}
		public void setMemberPhone(String memberPhone) {
			this.memberPhone = memberPhone;
		}
		public String getMemberEmail() {
			return memberEmail;
		}
		public void setMemberEmail(String memberEmail) {
			this.memberEmail = memberEmail;
		}
		public String getMemberAddress() {
			return memberAddress;
		}
		public void setMemberAddress(String memberAddress) {
			this.memberAddress = memberAddress;
		}
		public String getMemberGender() {
			return memberGender;
		}
		public void setMemberGender(String memberGender) {
			this.memberGender = memberGender;
		}
		public Date getMemberBirthday() {
			return memberBirthday;
		}
		public void setMemberBirthday(Date memberBirthday) {
			this.memberBirthday = memberBirthday;
		}
		
		// toString �������̵� - ������ Ȯ�ο�
		@Override
		public String toString() {
			return "ȸ�� [���̵�=" + memberId + ", ��й�ȣ=" + memberPw + ", ��й�ȣ Ȯ��=" + memberPwRe
					+ ", ȸ����=" + memberName + ", ��ȭ��ȣ=" + memberPhone + ", �̸���=" + memberEmail
					+ ", �ּ�=" + memberAddress + ", ����=" + memberGender + ", ����="
					+ memberBirthday + "]";
		}
}
