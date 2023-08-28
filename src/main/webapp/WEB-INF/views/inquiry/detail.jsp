<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="ko">
	<!-- head -->
<%-- 	<jsp:include page="/WEB-INF/views/include/head.jsp"></jsp:include> --%>
	<body>
		<div id="container">
		<!-- header -->
<%-- 		<jsp:include page="/WEB-INF/views/include/header.jsp"></jsp:include> --%>
			<main>
				<h1>문의 상세 조회</h1>
				<ul>
					<li>
						<label class="detail-list">글번호</label>
						<span>${requestScope.inquiry.inquiryNo }</span>
					</li>
					<li>
						<label class="detail-list">작성일</label>
						<%-- <span>${requestScope.inquiry.iCreateDate }</span> --%>
						<span><fmt:formatDate pattern="YYYY-MM-dd" value="${ inquiry.iCreateDate }"/></span>
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
						<span>${ inquiry.inquiryContent }</span>
						</div>
					</li>
					<li>
						<label>첨부파일</label>
						<img alt="첨부파일" src="../resources/nuploadFiles/${ inquiry.inquiryFilename }">
						<!-- 하이퍼링크로 이미지 다운받게끔 할 수도 있음 -->
						<a href="../resources/iuploadFiles/${ inquiry.inquiryFileRename }" download>${ inquiry.inquiryFilename }</a>
					</li>
				</ul>
				<div>
	<!-- 				<a href="/inquiry/list.do">목록으로 이동</a> -->
	<!-- 				<a href="#">수정하기</a> -->
	<!-- 				<a href="" onclick="deleteCheck();">삭제하기</a> -->
					<button type="button" onclick="showModifyPage();">수정하기</button>
	<!-- 				<input type="button" value="삭제하기"> -->
					<button type="button" onclick="deleteCheck();">삭제하기</button>
					<button type="button" onclick="showListPage();">목록</button>
				</div>
				<!-- 댓글 등록 -->
				<br>
				<form action="/reply/add.kh" method="post">
					<!-- 사용자가 알 필요는 없지만 데이터 불러오기 위해서 작성 -->
					
				</form>
			</main>
			<!-- footer -->
<%-- 			<jsp:include page="/WEB-INF/views/include/footer.jsp"></jsp:include> --%>
		</div>
		<script>
			function showModifyPage() {
				const inquiryNo = "${ inquiry.inquiryNo }";
				location.href="/inquiry/modify.do?inquiryNo=" + inquiryNo;
			}
			
			function showListPage() {
				location.href="/inquiry/list.do"
			}
			
			const deleteCheck = () => {
				const inquiryNo = "${ inquiry.inquiryNo }";
				if(confirm("정말 삭제하시겠습니까?")){
					location.href="/inquiry/delete.do?inquiryNo="+inquiryNo;
				}
			} 
		</script>
	</body>
</html>