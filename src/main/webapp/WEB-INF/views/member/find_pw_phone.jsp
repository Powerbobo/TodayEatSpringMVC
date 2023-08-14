<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
	<!-- head -->
	<jsp:include page="/WEB-INF/views/include/head_find.jsp"></jsp:include>
    <body>
        <div id="container">
            <!-- header -->
			<jsp:include page="/WEB-INF/views/include/header.jsp"></jsp:include>
            <main>
            	<form action="/member/findPwPhone.do" method="post">
		            <!-- 비밀번호 찾기 -->
		            <div class="findPw">
		                <h2>비밀번호 찾기</h2>
		                <div id="choiceWay">
		                    <!-- 휴대폰 인증 -->
		                    <div id="phoneCer">
		                        <a href="/member/findPwPhone.do"><h3>휴대폰 인증</h3></a>
		                    </div>
		                    <!-- 이메일 인증 -->
		                    <div id="emailCer">
		                        <a href="/member/findPwEmail.do"><h3>이메일 인증</h3></a>
		                    </div>
		                    <hr>
		                </div>
		                <!-- 이름 -->
		                <div id="userName">
		                    <h3>이름</h3>
		                    <input type="text" name="memberName" id="memberName" placeholder="이름을 입력해주세요">
		                </div>
		                <!-- 휴대폰 인증 -->
		                <div id="usernumber">
		                    <h3>휴대폰 번호</h3>
		                    <input type="text" name="memberPhone" id="memberPhone" placeholder="이메일을 입력해주세요">
		                </div>
		                <!-- 인증번호 받기 (alert창으로 비밀번호 띄우는것으로 대체 -->
		                <div class="number">
		                    <input id="number" type="submit" value="비밀번호 찾기">
		                </div>
		            </div>
	            </form>
            </main>
            <!-- footer -->
			<jsp:include page="/WEB-INF/views/include/footer.jsp"></jsp:include>
        </div>
    </body>
</html>