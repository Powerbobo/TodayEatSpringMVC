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
				<h1>문의 수정</h1>
				<form action="/inquiry/modify.do" method="post" enctype="multipart/form-data">
					<input type="hidden" name="inquiryWriter" value="${ inquiryWriter }">
					<input type="hidden" name="inquiryNo" value="${ inquiry.inquiryNo }">
					<input type="hidden" name="inquiryFilename" value="${ inquiry.inquiryFilename }">
					<input type="hidden" name="inquiryFileRename" value="${ inquiry.inquiryFileRename }">
					<input type="hidden" name="inquiryFilepath" value="${ inquriy.inquiryFilepath }">
					<input type="hidden" name="inquiryFilelength" value="${ inquriy.inquiryFilelength }">
					<ul>
						<li>
							<label>제목</label>
							<input type="text" name="inquirySubject" value="${ inquiry.inquirySubject }">
						</li>
						<li>
							<label>내용</label>
							<textarea rows="30" cols="40" id="" name="inquiryContent">${ inquiry.inquiryContent }</textarea>
						</li>
						<li>
							<label>첨부파일</label>
							<!-- String으로 받을 수 없고, 변환작업이 필요함 -->
							<input type="file" name="uploadFile">
						</li>
					</ul>
					<div>
						<input type="submit" value="수정">
					</div>
				</form>
			</main>
			<!-- footer -->
<%-- 		<jsp:include page="/WEB-INF/views/include/footer.jsp"></jsp:include> --%>
		</div>
	</body>
</html>