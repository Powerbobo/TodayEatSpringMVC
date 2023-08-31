<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="ko">
<!-- head -->
<%-- <jsp:include page="/WEB-INF/views/include/head_inquiry_detail.jsp"></jsp:include> --%>

	<head>
		<meta charset="UTF-8">
		<title>문의 상세 조회</title>
		<link rel="stylesheet" href="../resources/css/inquiry_detail.css">
	</head>
	<body>
		<div id="container">
			<!-- header -->
<%-- 			<jsp:include page="/WEB-INF/views/include/header.jsp"></jsp:include> --%>
				<main>
					<h1>문의 상세 조회</h1>
					<div id="showInquiry">
						<ul>
							<li>
								<label class="detail-list">글번호</label>
								<span>${requestScope.inquiry.inquiryNo }</span>
							</li>
							<li>
								<label class="detail-list">작성일</label>
								<%-- <span>${requestScope.inquiry.iCreateDate }</span> --%>
									<span>
										<fmt:formatDate pattern="YYYY-MM-dd" value="${ inquiry.iCreateDate }" />
									</span>
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
								<img alt="첨부파일" src="../resources/iuploadFiles/${ inquiry.inquiryFilename }">
								<!-- 하이퍼링크로 이미지 다운받게끔 할 수도 있음 -->
								<a href="../resources/iuploadFiles/${ inquiry.inquiryFileRename }" download>${ inquiry.inquiryFilename }</a>
							</li>
						</ul>
						<div>
							<button type="button" onclick="showModifyPage();">수정하기</button>
							<!-- <input type="button" value="삭제하기"> -->
							<button type="button" onclick="deleteCheck();">삭제하기</button>
							<button type="button" onclick="showListPage();">목록</button>
							<c:if test="${ memberId eq 'admin' }">
								<c:if test="${ answer eq null }">
									<button type="button" onclick="showAnswerForm();">답변</button>
								</c:if>
							</c:if>
						</div>
						<div>
						</div>
						<!-- 댓글 등록 -->
						<br>
						<form action="/answer/add.do" method="post" id="HiddenAnswer">
							<!-- 사용자가 알 필요는 없지만 데이터 불러오기 위해서 작성 -->
							<input type="hidden" name="ansInquiryNo" value="${ inquiry.inquiryNo }">
							<input type="hidden" name="answerWriter" value="${ memberId }">
							<input type="hidden" name="inquirtWriter" value="${ memberId }">
							<table>
								<tr>
									<td>
										<textarea rows="3" cols="55" name="answerContent"></textarea>
									</td>
									<td>
										<input type="submit" value="등록">
									</td>
								</tr>
							</table>
						</form>
						<!-- 댓글 목록 -->
						<br>
						<c:if test="${answer ne null }">
							<table width="500" border="1">
								<colgroup>
									<col width=15%>
									<col width="65%">
									<col width="20%">
								</colgroup>
								<tr>
									<td>${ answer.answerWriter }</td>
									<td>${ answer.answerContent }</td>
									<td>${ answer.aCreateDate }</td>
								</tr>
								<tr id="answerModifyForm" style="display:none;">
									<!-- ===== html 방식 ===== -->
<!-- 									<form actrion="/answer/update.do" method="post"> -->
<%-- 										<input type="hidden" name="answerNo" value="${ answer.answerNo }"> --%>
<%-- 										<input type="hidden" name="ansInquiryNo" value="${ answer.ansInquiryNo }"> --%>
<%-- 										<td colspan="2"><input type="text" size="50" name="answerContent" value="${ answer.answerContent }"></td> --%>
<!-- 										<td><input type="button" value="완료"></td> -->
									<!-- ===== DOM 방식 ===== -->
									<td colspan="2"><input id="answerContent" type="text" size="50" name="answerContent" value="${ answer.answerContent }"></td>
									<td><input type="button" onclick="modifyAnswer(this, '${ answer.answerNo }', '${ answer.ansInquiryNo }');" value="완료"></td>
<!-- 									</form> -->
								</tr>
							</table>
							<c:if test="${ memberId eq 'admin' }">
								<br>
								<button type="button" onclick="showModifyAnswer(this);">수정하기</button>
								<button type="button" onclick="deleteAnswer();">삭제하기</button>
							</c:if>
						</c:if>
					</div>
				</main>
				<!-- footer -->
				<%-- <jsp:include page="/WEB-INF/views/include/footer.jsp"></jsp:include> --%>
		</div>
		<script>
			//  ============================ 댓글 ============================
			// 답글 창 보이기
			function showAnswerForm() {
				const hiddenAnswerForm = document.getElementById("HiddenAnswer");
				if (hiddenAnswerForm) {
					hiddenAnswerForm.style.display = "block"; // 또는 원하는 디스플레이 값
				}
			}
			
			// 답글 수정 창 보이기
			function showModifyAnswer() {
				document.querySelector("#answerModifyForm").style.display = "";
			}
			
			// 답글 수정하기
			function modifyAnswer(obj, answerNo, ansInquiryNo) {
				
				// obj.parentElement.parentElement.nextElementSibling.style.display = "";
				
				const form = document.createElement("form");
				form.action = "/answer/update.do";
				form.method = "post"
				
				const input1 = document.createElement("input");
				input1.type = "hidden";
				input1.value = answerNo;
				input1.name = "answerNo";
				
				const input2 = document.createElement("input");
				input2.type = "hidden";
				input2.value = ansInquiryNo;
				input2.name = "ansInquiryNo";
				
				const input3 = document.createElement("input");
				input3.type = "text";
				input3.value = obj.parentElement.previousElementSibling.childNodes[0].value;
				input3.name = "answerContent";
				
				form.appendChild(input1);
				form.appendChild(input2);
				form.appendChild(input3);
				
				document.body.appendChild(form);
				form.submit();
			}
			// 답글 삭제하기
			function deleteAnswer() {
				
			}
			//  =========================== 게시글 ===========================
			function showModifyPage() {
				const inquiryNo = "${ inquiry.inquiryNo }";
				location.href = "/inquiry/modify.do?inquiryNo=" + inquiryNo;
			}

			function showListPage() {
				location.href = "/inquiry/list.do"
			}

			const deleteCheck = () => {
				const inquiryNo = "${ inquiry.inquiryNo }";
				if (confirm("정말 삭제하시겠습니까?")) {
					location.href = "/inquiry/delete.do?inquiryNo=" + inquiryNo;
				}
			} 
		</script>
	</body>
</html>