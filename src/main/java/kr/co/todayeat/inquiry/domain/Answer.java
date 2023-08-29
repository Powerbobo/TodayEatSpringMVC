package kr.co.todayeat.inquiry.domain;

import java.sql.Date;

public class Answer {
	// field
	private int answerNo;
	private int ansInquiryNo;
	private String answerContent;
	private String answerWriter;
	private Date aCreateDate;
	private Date aUpdateDate;
	private char updateYN;
	private char aStatus;
	
	// getter, setter method
	public int getAnswerNo() {
		return answerNo;
	}
	public void setAnswerNo(int answerNo) {
		this.answerNo = answerNo;
	}
	public int getAnsInquiryNo() {
		return ansInquiryNo;
	}
	public void setAnsInquiryNo(int ansInquiryNo) {
		this.ansInquiryNo = ansInquiryNo;
	}
	public String getAnswerContent() {
		return answerContent;
	}
	public void setAnswerContent(String answerContent) {
		this.answerContent = answerContent;
	}
	public String getAnswerWriter() {
		return answerWriter;
	}
	public void setAnswerWriter(String answerWriter) {
		this.answerWriter = answerWriter;
	}
	public Date getaCreateDate() {
		return aCreateDate;
	}
	public void setaCreateDate(Date aCreateDate) {
		this.aCreateDate = aCreateDate;
	}
	public Date getaUpdateDate() {
		return aUpdateDate;
	}
	public void setaUpdateDate(Date aUpdateDate) {
		this.aUpdateDate = aUpdateDate;
	}
	public char getUpdateYN() {
		return updateYN;
	}
	public void setUpdateYN(char updateYN) {
		this.updateYN = updateYN;
	}
	public char getaStatus() {
		return aStatus;
	}
	public void setaStatus(char aStatus) {
		this.aStatus = aStatus;
	}
	
	// toString() - overriding
	@Override
	public String toString() {
		return "Answer [answerNo=" + answerNo + ", ansInquiryNo=" + ansInquiryNo + ", answerContent=" + answerContent
				+ ", answerWriter=" + answerWriter + ", aCreateDate=" + aCreateDate + ", aUpdateDate=" + aUpdateDate
				+ ", updateYN=" + updateYN + ", aStatus=" + aStatus + "]";
	}
}

