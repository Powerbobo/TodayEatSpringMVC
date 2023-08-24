<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<header>
	<div id="header">
		<!-- 쿠폰 -->
		<div id="coupon">
			<p id="header-coupon">
				<a href="#">지금 첫 주문하고, 5천원 할인 쿠폰 받기</a>
			</p>
		</div>
		<!-- 로고 -->
		<div id="logo">
			<p class="header-logo">
				<a href="/index.jsp">오늘<span id="logo-layer"> 뭐 </span>먹지? </a>
			</p>
		</div>
		<!-- 네비게이션 -->
		<nav>
			<ul>
				<!-- 메뉴표 -->
				<li>
					<a class="manu" href="/WEB-INF/views/service/menu.jsp">메뉴표</a>
				</li>
				<!-- 서비스 지역 -->
				<li>
					<a class="manu" href="/WEB-INF/views/service/service_area.jsp">서비스 지역</a>
				</li>
				<!-- 이벤트 -->
				<li>
					<a class="manu" href="/WEB-INF/views/service/event.jsp">이벤트</a>
				</li>
				<!-- 문의하기 -->
				<li>
					<a class="manu" href="/inquiry/list.do">문의하기</a>
				</li>
				<!-- 공지사항 -->
				<li>
					<a class="manu" href="#">공지사항</a>
				</li>
			</ul>
		</nav>
		<!-- 로그인/회원가입 -->
		<div id="login">
		<c:if test="${ memberId eq null }">
			<a href="/member/login.do">로그인</a>
			<pre id="Space"> | </pre>
			<a href="/member/join.do">회원가입</a>
			</c:if>
		<c:if test="${ memberId ne null }">
			<!-- <small>{sessionScope.userName }님 환영합니다!</small> -->
			
			<form action="/member/myPage.do" method="post">
				<input type="hidden" name="memberId" value="${ memberId }">
				<input type="submit" id="myPageBtn" value="마이페이지">
<%-- 				<a href="/member/myPage.do?memberId=${ memberId}">마이페이지</a> --%>
			</form>
			
			
			
			<pre id="Space"> | </pre>
			<a href="/member/logout.do?memberId=${ memberId }">로그아웃</a>
		</c:if>
		</div>
	</div>
	<!-- 채팅 문의 -->
	<div class="aside">
		<div id="chat">
			<a href="#"><img class="img" src="/resources/images/chat.png" alt="문의"></a>
		</div>
	</div>
</header>