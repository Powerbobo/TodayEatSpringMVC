<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
	<!-- head -->
	<jsp:include page="/WEB-INF/views/include/head_join.jsp"></jsp:include>
    <body>
        <div id="container">
         <!-- header -->
		<jsp:include page="/WEB-INF/views/include/header.jsp"></jsp:include>
            <main>
                <!-- 회원가입 -->
                <form action="/member/join.do" method="post">
	                <div class="join">
	                    <h2>회원가입</h2>
	                    <hr>
	                    <!-- 아이디 입력 -->
	                    <div class="join-info" id="join-id">
	                        <span>아이디 </span>
	                        <input class="joinInfo" type="text" name="joinId" id="joinId" placeholder="아이디를 입력하세요.">
	                    </div>
	                    <!-- 비밀번호 입력 -->
	                    <div class="join-info" id="join-pw">
	                        <span>비밀번호 </span>
	                        <input class="joinInfo" type="password" name="joinPw" id="joinPw1" placeholder="비밀번호를 입력하세요.">
	                    </div>
	                    <!-- 비밀번호 재입력 -->
	                    <div class="join-info" id="join-pwRe">
	                        <span>비밀번호 확인 </span>
	                        <input class="joinInfo" type="password" name="joinPwRe" id="joinPwRe" placeholder="비밀번호를 한번 더 입력하세요.">
	                    </div>
	                    <!-- 이름 입력 -->
	                    <div class="join-info" id="join-name">
	                        <span>이름 </span>
	                        <input class="joinInfo" type="text" name="joinName" id="joinName" placeholder="이름을 입력하세요.">
	                    </div>
	                    <!-- 전화번호 입력 -->
	                    <div class="join-info" id="join-phone">
	                        <span>휴대폰 </span>
	                        <input class="joinInfo" type="text" name="joinPhone" id="joinPhone" placeholder="전화번호를 입력하세요.">
	                    </div>
	                    <!-- 이메일 입력 -->
	                    <div class="join-info" id="join-email">
	                        <span>이메일 </span>
	                        <input class="joinInfo" type="text" name="joinEmail" id="joinEmail" placeholder="이메일을 입력하세요.">
	                    </div>
	                    <!-- 주소 입력 -->
	                    <div class="join-info" id="join-addr">
	                        <span>주소 </span>
	                        <input class="joinInfo" type="text" name="joinAddr" id="joinAddr" placeholder="주소를 입력하세요.">
	                    </div>
	                    <!-- 성별 선택 -->
	                    <div class="join-info" id="join-gen">
	                        <span>성별 </span>
	                        <input type="radio" name="gender" id="gender"> 
	                        <label for="genMen">남자</label>
	                        <input type="radio" name="gender" id="gender"> 
	                        <label for="genWom">여자</label>
	                    </div>
	                    <!-- 생년월일 입력 -->
	                    <div class="join-info" id="join-bir">
	                        <span>생일 </span>
	                        <input class="joinInfo" type="date" name="joinBir" id="joinBir">
	                    </div>
	                    <hr>
	                    <!-- 가입완료 버튼 -->
	                    <div class="join-info" id="join-end">
	                        <input type="submit" value="가입하기">
	                    </div>
	                </div>
                </form>
            </main>
			<!-- footer -->
			<jsp:include page="/WEB-INF/views/include/footer.jsp"></jsp:include>
        </div>
    </body>
</html>