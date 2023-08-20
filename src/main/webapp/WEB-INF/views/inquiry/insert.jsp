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
				<form action="/inquiry/insert.do" method="post">
					<input type="hidden" name="inquiryWriter" value="${user-Id }">
					<ul>
						<li>
							<label>제목</label>
							<input type="text" id="" name="inquirySubject">
						</li>
						<li>
							<label>내용</label>
							<textarea rows="30" cols="40" id="" name="inquiryContent"></textarea>
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