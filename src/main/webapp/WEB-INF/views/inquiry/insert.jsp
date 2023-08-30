<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
	<!-- head -->
<%-- 	<jsp:include page="/WEB-INF/views/include/head.jsp"></jsp:include> --%>
	<body>
		<div id="container">
			<!-- header -->
	<%-- 	<jsp:include page="/WEB-INF/views/include/header.jsp"></jsp:include> --%>
			<main>
				<h1>문의하기 작성</h1>
				<form action="/inquiry/insert.do" method="post" enctype="multipart/form-data">
					<input type="hidden" name="inquiryWriter" value="${ memberId }">
					<ul>
						<li>
							<label>제목</label>
							<input type="text" name="inquirySubject">
						</li>
						<li>
							<label>내용</label>
							<textarea rows="30" cols="40" id="" name="inquiryContent"></textarea>
						</li>
						<li>
							<label>첨부파일</label>
							<!-- String으로 받을 수 없고, 변환작업이 필요함 -->
							<input type="file" name="uploadFile">
						</li>
					</ul>
					<div>
						<input type="submit" value="작성">
						<input type="reset" value="취소">
					</div>
				</form>
			</main>
			<!-- footer -->
<%-- 		<jsp:include page="/WEB-INF/views/include/footer.jsp"></jsp:include> --%>
		</div>
	</body>
</html>