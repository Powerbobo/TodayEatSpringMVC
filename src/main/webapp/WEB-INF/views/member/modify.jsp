<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>회원 정보 수정</title>
		<link rel="stylesheet" href="../resources/css/main.css">
	</head>
	<body>
		<h1>회원 정보 수정</h1>
		<form action="/member/update.do" method="post">
			<fieldset>
				<!-- 문제점 -->
				<!-- 1. 비밀번호 재확인 빈칸
					 2. 성별 빈칸	
				 -->
				<legend>회원 정보 수정</legend>
				<ul>
					<li>
						<label>아이디 *</label>
						<input type="text" name="memberId" value="${ member.memberId }" readonly>
					</li>
					<li>
						<label>비밀번호 *</label>
						<input type="password" name="memberPw" value="${ member.memberPw }">
					</li>
					<li>
						<label>비밀번호 재확인 *</label>
						<input type="password" name="memberPwRe" value="${ member.memberPwRe }" >
					</li>
					<li>
						<label>이름 *</label>
						<input type="text" name="memberName" value="${ member.memberName }" readonly>
					</li>
					<li>
						<label>성별</label>
						<c:if test="${ member.memberGender eq 'M' }"><span>남</span></c:if>
						<c:if test="${ member.memberGender eq 'F' }"><span>여</span></c:if>
					</li>
					<li>
						<label>이메일</label>
						<input type="text" name="memberEmail" value="${ member.memberEmail }">
					</li>
					<li>
						<label>전화번호</label>
						<input type="text" name="memberPhone" value="${ member.memberPhone }">
					</li>
					<li>
						<label>주소</label>
						<input type="text" name="memberAddress" value="${ member.memberAddress }">
					</li>
					<li>
						<label>생년월일</label>
						<input type="text" name="memberBirthday" value="${ member.memberBirthday }" readonly>
					</li>
				</ul>
			</fieldset>
			<div>
				<input type="submit" value="수정">
				<input type="reset" value="취소">
			</div>
		</form>
	</body>
</html>