<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
	<html>
    <!-- head -->
<%-- 	<jsp:include page="/WEB-INF/views/include/head_find.jsp"></jsp:include> --%>
	<body>
		 <!-- header -->
<%-- 		<jsp:include page="/WEB-INF/views/include/header.jsp"></jsp:include> --%>
		<main>
			<h1>회원 상세 조회</h1>
			<form action="/member/update.do" method="post">
				<fieldset>
					<legend>회원 상세정보</legend>
					<ul>
						<li>
							<label for="member-id">아이디</label>
							<span>${ member.memberId }</span>
						</li>
						<li>
							<label for="memberName">이름</label>
							<span>${ member.memberName }</span>
						</li>
						<li>
							<label for="memberPhone">전화번호</label>
							<span>${member.memberPhone }</span>
						</li>
						<li>
							<label for="memberEmail">이메일</label>
							<span>${ member.memberEmail }</span>
						</li>
						<li>
							<label for="memberAddress">주소</label>
							<span>${ member.memberAddress }</span>
						</li>
						<li>
							<label for="memberGender">성별</label>
							<span>${ member.memberGender }</span>
						</li>
						<li>
							<label for="memberBirthday">출생년도</label>
							<span>${ member.memberBirthday }</span>
						</li>
					</ul> 
					<br>
				</fieldset>
				<div>
					<br>
					<a href="/index.jsp">메인 페이지</a>
					<a href="/member/update.do?memberId=${ member.memberId }">수정하기</a>
					<a href="/member/delete.do?memberId=${ member.memberId }">탈퇴하기</a>
				</div>
			</form>
		</main>
		<!-- footer -->
<%-- 		<jsp:include page="/WEB-INF/views/include/footer.jsp"></jsp:include> --%>
		<script>
		function checkDelete() {
			const memberId = "${sessionScope.memberId}";
			if(confirm("탈퇴하시겠습니까?")){
				location.href= "/member/delete.do?memberId="+memberId;
			}
		}
		
		</script>
	</body>
</html>