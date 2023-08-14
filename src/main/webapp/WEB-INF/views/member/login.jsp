<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
	<!-- head -->
	<jsp:include page="/WEB-INF/views/include/head.jsp"></jsp:include>
	<body>
		<div id="container">
		<!-- header -->
		<jsp:include page="/WEB-INF/views/include/header.jsp"></jsp:include>
			<main>
				<div class="login-wrapper">
					<!-- 로그인 문구 -->
					<h2>로그인</h2>
					<form action="/member/login.do" method="post" id="login-form">
						<!-- 아이디/비밀번호 입력창 -->
						<input class="loginBtn" type="text" name="memberId" id="user-id" placeholder="아이디를 입력해주세요"> 
						<input type="password" name="memberPw" id="user-Pw" placeholder="비밀번호를 입력해주세요">
						<!-- 자동 로그인 -->
						<label for="remember-check"> <input type="checkbox" id="remember-check">
						<span>아이디 저장하기</span>
						</label>
						<!-- 아이디찾기 / 비밀번호 찾기 -->
						<p id="find">
							<a href="/member/findIdPhone.do">아이디찾기</a>|<a href="/member/findPwPhone.do">비밀번호 찾기</a>
						</p>
						<!-- 로그인 버튼 -->
						<input type="submit" value="로그인">
						<hr>
						<div id="sns-login">
							<input id="goole-login" type="submit" value="Google 로그인"><br>
							<input id="naver-login" type="submit" value="Naver 로그인"><br>
							<input id="kakao-login" type="submit" value="Kakao 로그인">
						</div>
					</form>
				</div>
			</main>
			<!-- footer -->
			<jsp:include page="/WEB-INF/views/include/footer.jsp"></jsp:include>
		</div>
	</body>
</html>