<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
	<!-- head -->
	<jsp:include page="/WEB-INF/views/include/head_index.jsp"></jsp:include>
	<body>
		<div id="container">
		<!-- header -->
		<jsp:include page="/WEB-INF/views/include/header.jsp"></jsp:include>
			<main>
				<!-- 롤링 배너 -->
				<div id="main-banner">
					<div id="banner">
						<a href="#"><img src="/resources/images/banner1.png" alt="배너1" width="1903px"></a>
					</div>
				</div>
				<div id="banner-right">
					<a href="#"><img class="banner-icon" src="/resources/images/right.png" alt="배너 오른쪽 화살표"></a>
				</div>
				<div id="banner-left">
					<a href="#"><img class="banner-icon" src="/resources/images/left.png" alt="배너 오른쪽 화살표"></a>
				</div>
				<div id="main-why">
					<!--- 홍보 문구 --->
					<div class="why-layer1">
						<h1 class="main-text1">나가긴 귀찮고 가격은 비싸서</h1>
						<h1 class="main-text1">.</h1>
						<h1 class="main-text1">.</h1>
						<h1 class="main-text1">.</h1>
						<h1 class="main-text1"> 오늘 <span id="main-text-what">뭐</span> 먹지?</h1>
					</div>
					<div class="why-layer2">
						<p class="main-text2">매일 점심을 고민하는 직장인을 위해서!</p>
						<p class="main-text2">직장인의 최대 고민을</p>
						<p class="main-text2">해결해 드려요!</p>
					</div>
				</div>
				<div id="main-shipping">
					<img id="shipping-photo" src="/resources/images/free.png" alt="배달" width="600px">
					<div id="sipping-text">
						<p class="sipping-text-layer1">1인분도</p>
						<p class="sipping-text-layer1">무료배달</p>
					</div>
				</div>
				<!-- 리뷰 이벤트 -->
				<section id="review">
					<img id="review-back" src="/resources/images/review_banner.png" alt="리뷰배경">
				</section>
			</main>
			<!-- footer -->
			<jsp:include page="/WEB-INF/views/include/footer.jsp"></jsp:include>
		</div>
	</body>
</html>