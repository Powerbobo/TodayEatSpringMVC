package kr.co.todayeat.inquiry.domain;

import java.sql.Timestamp;

public class Inquiry {
	
	// 필드
	private int inquiryNo;
	private String inquirySubject;
	private String inquiryContent;
	private String inquiryWriter;
	private Timestamp iCreateDate;
	private Timestamp iUpdateDate;
	private String inquiryFilename;
	private String inquiryFileRename;
	private String inquiryFilepath;
	private long inquiryFilelength;
	private String inquiryYn;
	
	// 기본 생성자
	public Inquiry() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	// 매개변수 생성자
	public Inquiry(int inquiryNo, String inquirySubject, String inquiryContent, String inquiryWriter,
			Timestamp iCreateDate, Timestamp iUpdateDate, String inquiryFilename, String inquiryFileRename,
			String inquiryFilepath, long inquiryFilelength, String inquiryYn) {
		super();
		this.inquiryNo = inquiryNo;
		this.inquirySubject = inquirySubject;
		this.inquiryContent = inquiryContent;
		this.inquiryWriter = inquiryWriter;
		this.iCreateDate = iCreateDate;
		this.iUpdateDate = iUpdateDate;
		this.inquiryFilename = inquiryFilename;
		this.inquiryFileRename = inquiryFileRename;
		this.inquiryFilepath = inquiryFilepath;
		this.inquiryFilelength = inquiryFilelength;
		this.inquiryYn = inquiryYn;
	}
	
	// getter, setter 메소드
	public int getInquiryNo() {
		return inquiryNo;
	}


	public void setInquiryNo(int inquiryNo) {
		this.inquiryNo = inquiryNo;
	}

	public String getInquirySubject() {
		return inquirySubject;
	}

	public void setInquirySubject(String inquirySubject) {
		this.inquirySubject = inquirySubject;
	}

	public String getInquiryContent() {
		return inquiryContent;
	}

	public void setInquiryContent(String inquiryContent) {
		this.inquiryContent = inquiryContent;
	}

	public String getInquiryWriter() {
		return inquiryWriter;
	}

	public void setInquiryWriter(String inquiryWriter) {
		this.inquiryWriter = inquiryWriter;
	}

	public Timestamp getiCreateDate() {
		return iCreateDate;
	}

	public void setiCreateDate(Timestamp iCreateDate) {
		this.iCreateDate = iCreateDate;
	}

	public Timestamp getiUpdateDate() {
		return iUpdateDate;
	}

	public void setiUpdateDate(Timestamp iUpdateDate) {
		this.iUpdateDate = iUpdateDate;
	}

	public String getInquiryFilename() {
		return inquiryFilename;
	}

	public void setInquiryFilename(String inquiryFilename) {
		this.inquiryFilename = inquiryFilename;
	}

	public String getInquiryFilepath() {
		return inquiryFilepath;
	}

	public void setInquiryFilepath(String inquiryFilepath) {
		this.inquiryFilepath = inquiryFilepath;
	}

	public long getInquiryFilelength() {
		return inquiryFilelength;
	}

	public void setInquiryFilelength(long inquiryFilelength) {
		this.inquiryFilelength = inquiryFilelength;
	}

	public String getInquiryYn() {
		return inquiryYn;
	}

	public void setInquiryYn(String inquiryYn) {
		this.inquiryYn = inquiryYn;
	}

	public String getInquiryFileRename() {
		return inquiryFileRename;
	}

	public void setInquiryFileRename(String inquiryFileRename) {
		this.inquiryFileRename = inquiryFileRename;
	}

	// toString() - 데이터 확인용
	@Override
	public String toString() {
		return "문의하기 [번호=" + inquiryNo + ", 제목=" + inquirySubject + ", 내용="
				+ inquiryContent + ", 작성자=" + inquiryWriter + ", 작성날짜=" + iCreateDate
				+ ", 수정날짜=" + iUpdateDate + ", 파일이름=" + inquiryFilename + ", 파일리네임=" + inquiryFileRename
				+ ", 파일경로=" + inquiryFilepath + ", 파일크기=" + inquiryFilelength 
				+ ", 답변여부=" + inquiryYn + "]";
	}
	
}
