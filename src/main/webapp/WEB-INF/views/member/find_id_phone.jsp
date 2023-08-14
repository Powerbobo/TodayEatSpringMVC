<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html lang="ko">
	<!-- head -->
	<jsp:include page="/WEB-INF/views/include/head_find.jsp"></jsp:include>
    <body>
        <div id="container">
            <!-- header -->
			<jsp:include page="/WEB-INF/views/include/header.jsp"></jsp:include>
            <main>
                <!-- 아이디 찾기 -->
                <form action="/member/findIdPhone.do" method="post">
	                <div class="findId">
	                    <h2>아이디 찾기</h2>
	                    <div id="choiceWay">
	                        <!-- 휴대폰 인증 -->
	                        <div id="phoneCer">
	                            <a href="/member/findIdPhone.do"><h3>휴대폰 인증</h3></a>
	                        </div>
	                        <!-- 이메일 인증 -->
	                        <div id="emailCer">
	                            <a href="/member/findIdEmail.do"><h3>이메일 인증</h3></a>
	                        </div>
	                        <hr>
	                    </div>
	                    <!-- 이름 -->
	                    <div id="userName">
	                        <h3>이름</h3>
	                        <input type="text" name="memberName" id="memberName" placeholder="이름을 입력해주세요">
	                    </div>
	                    <!-- 연락처 -->
	                    <div id="usernumber">
	                        <h3>휴대폰 번호</h3>
	                        <input type="text" name="memberPhone" id="memberPhone" placeholder="연락처를 입력해주세요">
	                    </div>
	                    <!-- 인증번호 받기 (alert창에 아이디 띄우는것으로 대체)-->
	                    <div class="number">
	                        <input id="number" type="submit" value="아이디 찾기">
	                    </div>
	                </div>
                </form>
            </main>
  			<!-- footer -->
			<jsp:include page="/WEB-INF/views/include/footer.jsp"></jsp:include>
        </div>
    </body>
</html>