<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
	<!-- head -->
<%-- 	<jsp:include page="/WEB-INF/views/include/head.jsp"></jsp:include> --%>
	<body>
		<div id="container">
		<!-- header -->
<%-- 		<jsp:include page="/WEB-INF/views/include/header.jsp"></jsp:include> --%>
			<main>
				<h1>문의 상세조회</h1>
				<ul>
					<li>
						<label class="detail-list">글번호</label>
						<span>${requestScope.inquiry.inquiryNo }</span>
					</li>
					<li>
						<label class="detail-list">작성일</label>
						<span>${requestScope.inquiry.inquiryDate }</span>
					</li>
					<li>
						<label class="detail-list">글쓴이</label>
						<span>${requestScope.inquiry.inquiryWriter }</span>
					</li>
					<li>
						<label class="detail-list">제목</label>
						<span>${requestScope.inquiry.inquirySubject }</span>
					</li>
					<li>
						<div id="inquiryContent">
						<label class="detail-list">내용</label>
						<p>${ inquiry.inquiryContent }</p>
						</div>
					</li>
					<li>
						<label>답변</label>
						<p></p>
					</li>
				</ul>
				<a href="/inquiry/list.do">목록으로 이동</a>
				<a href="#">수정하기</a>
<%-- 				<a href="/inquiry/delete.do?inquiryNo=${requestScope.inquiry.inquiryNo }">삭제하기</a> --%>
				<a href="" onclick="deleteCheck();">삭제하기</a>
			</main>
			<!-- footer -->
<%-- 			<jsp:include page="/WEB-INF/views/include/footer.jsp"></jsp:include> --%>
		</div>
		<script>
			const deleteCheck = () => {
				const notcieNo = "${notice.noticeNo}";
				if(confirm("정말 삭제하시겠습니까?")){
					location.href="/notice/delete.do?noticeNO="+noticeNo;
				}
			} 
		</script>
	</body>
</html>