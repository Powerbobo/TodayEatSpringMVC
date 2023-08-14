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
							<input type="text" id="memberId" name="memberId" value="${member.memberId}" readonly> <!-- 기능을 위한 id, 쿼리스트링 생성을 위한 name -->
						</li>
						<li>
							<label for="memberPw">비밀번호</label>
							<input type="password" id="memberPw" name="memberPw" value="${member.memberId}" >
						</li>
						<li>
							<label for="memberPw">비밀번호 확인</label>
							<input type="password" id="memberPwRe" name="memberPwRe" value="${member.memberId}" >
						</li>
						<li>
							<label for="memberName">이름</label>
							<input type="text" id="memberName" name="memberName" value="${member.memberName}" readonly>
						</li>
						<li>
							<label for="memberPhone">전화번호</label>
							<input type="text" id="memberPhone" name="memberPhone" value="${member.memberPhone}">
						</li>
						<li>
							<label for="memberEmail">이메일</label>
							<input type="text" id="memberEmail" name="memberEmail" value="${member.memberEmail}">
						</li>
						<li>
							<label for="memberAddress">주소</label>
							<input type="text" id="memberAddress" name="memberAddress" value="${member.memberAddress}">
						</li>
						<li>
							<label for="memberGender">성별</label>
							<!-- 선택했던 radio 버튼 유지  -->
							 남<input type="radio" id="memberGender" name="memberGender" value="남" <c:if test="${ member.memberGender eq '남' }">checked</c:if>>
							 여<input type="radio" id="memberGender" name="memberGender" value="여" <c:if test="${ member.memberGender eq '여' }">checked</c:if>>
						</li>
						<li>
							<label for="memberBirthday">출생년도</label>
							<input type="text" id="memberBirthday" name="memberBirthday" value="${member.memberBirthday}" readonly>
						</li>
					</ul> 
					<br>
				</fieldset>
				<div>
					<br>
					<a href="/index.jsp">메인 페이지</a>
					<button type="submit">수정하기</button>
					<a href="javascrip:void(0)" onclick="checkDelete();">탈퇴하기</a>
		<%-- 		<a onclick="checkDelete()" href="/member/delete.do?memberId=${ sessionScope.memberId }">탈퇴하기</a> --%>
		<!-- 		<button>탈퇴하기</button> -->
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