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
                <!-- 아이디 찾기 -->
                <form action="/member/findIdEmail.do" method="post">
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
	                    <!-- 이메일 -->
	                    <div id="usernumber">
	                        <h3>이메일</h3>
	                        <input type="text" name="memberEmail" id="memberEmail" placeholder="이메일을 입력해주세요">
	                    </div>
	                    <!-- 인증번호 받기 (alert 창으로 아이디 띄우는 방식으로 변경)-->
	                    <div class="number">
	                        <input id="number" type="submit" value="아이디 찾기">
	                    </div>
	                </div>
                </form>
            </main>

            <footer>
                <div id="footer-layer1">
                    <!-- 고객센터 -->
                    <div class="service">
                        <h2 id="service-layer1">고객센터 : 1588-1588</h2>
                        <p id="service-layer2"><small>고객센터 운영시간 : 평일 10:00 ~ 16:00</small></p>
                    </div>
                    <!-- 회사 정보 -->
                    <div class="info">
                        <p><span>회사명 : 오늘 뭐 먹지</span></p>
                        <p>본사주소 : 서울시</p>
                        <p>물류 : 경기도</p>
                        <p>대표 : 김이름</p>
                        <p>사업자등록번호 : 000-00-00000</p>
                        <p>통신판매업신고 : 0000-서울종로-0000호</p>
                        <p>이메일 : email@email.com</p>
                    </div>
                </div>
                <div id="footer-layer2">
                    <!-- 약관 -->
                    <div id="report">
                        <ul class="report-layer">
                            <li><a href="#">회사소개</a></li>
                            <li><a href="#">이용약관</a></li>
                            <li id="secret-info"><a href="#">개인정보처리방침</a></li>
                        </ul>
                    </div>
                </div>
            </footer>
        </div>
    </body>
</html>