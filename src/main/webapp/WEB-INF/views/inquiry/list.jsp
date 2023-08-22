<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="ko">
	<!-- head -->
	<jsp:include page="/WEB-INF/views/include/head_inquiry.jsp"></jsp:include>
    <body>
        <div id="container">
	        <!-- header -->
			<jsp:include page="/WEB-INF/views/include/header.jsp"></jsp:include>
            <main>
            <div>
            	<button onclick="ClickRegister();" type="button" id="inquiryBtn">1:1문의 등록하기</button>
            </div>
	            <c:if test="${ memberId eq null }">
	            	<script>
		            	alert("로그인을 해주세요");
		    			location.href = "/member/login.do";
	            	</script>
	            </c:if>
	            <c:if test="${ memberId ne null }">
	                <div id="inquiry">
	                    <!-- 문의 목록 -->
	                    <div id="list"><span>문의 목록</span></div>
	                    <!-- 문의 등록하기 -->
	                    <hr>
	                    <div>
	                        <table>
	                        	<thead>
	                         		<tr>
	                         			<!-- *************** 테이블 제목 *************** -->
	                            		<th class="list-layer">번호</th>
	                         	    	<th class="list-layer">제목</th>
	                          	     	<th class="list-layer">문의 날짜</th>
	                         	    	<th class="list-layer">파일 여부</th>
	                         	    	<th class="list-layer">답변 여부</th>
	                       	    	</tr>
	                    	    </thead>
	                    	    <tbody>
	                    	    	<!-- *************** 테이블 내용 *************** -->
	                    	    	<c:forEach var="inquiry" items="${ iList }" varStatus="i">
		                        		<tr>
		                          		 	<td class="number">${ inquiry.inquiryNo }</td>
		                        			<td class="title"><a href="/inquiry/detail.do?inquiryNo=${ inquiry.inquiryNo }">${ inquiry.inquirySubject }</a></td>
		                          		 	<td class="date">
		                          		 		<fmt:formatDate pattern="YYYY-MM-dd" value="${ inquiry.iCreateDate }"/>
		                          		 	</td>
		                          		 	<td class="answer">
		                          		 		<c:if test="${ !empty inquiry.inquiryFilename }">O</c:if>
		                          		 		<c:if test="${ empty inquiry.inquiryFilename }">X</c:if>
		                          		 	</td>
		                       				<td class="answer">${ inquiry.inquiryYn }</td>
		                          		</tr>
	                          		</c:forEach>
	                        	</tbody>
	                        	<tfoot>
	                        		<!-- *************** 테이블 네비게이션 *************** -->
	                        		<tr align="center">
	                        			<td colspan="5">
	                        				<c:forEach begin="${ pInfo.startNavi }" end="${ pInfo.endNavi }" var="p">
	                        					<!-- var : 변수명, value : url -->
	                        					<c:url var="pageUrl" value="/inquiry/list.do">
	                        						<!-- 쿼리 스트링 -->
	                        						<c:param name="page" value="${ p }"></c:param>
	                        					</c:url>
	                        					<a href="${ pageUrl }">${ p }</a>&nbsp;
	                        				</c:forEach>
	                        			</td>
	                        		</tr>
	                        		<tr>
	                        			<!-- *************** 테이블 검색 옵션 *************** -->
	                        			<td colspan="5">
	                        			<form action="/inquiry/search.do" method="get">
	                        				<select name="searchCondition">
	                        					<option value="all">전체</option>
	                        					<option value="title">제목</option>
	                        					<option value="content">내용</option>
	                        				</select>
	                        				<input type="text" name="searchKeyword" placeholder="검색어를 이용하세요">
	                        				<input type="submit" value="검색">
	                        			</form>
	                        		</tr>
	                        	</tfoot>
	                        </table>
	                    </div>
	                </div>
	            </c:if>
            </main>
			<!-- footer -->
			<jsp:include page="/WEB-INF/views/include/footer.jsp"></jsp:include>
        </div>
        <script>
        	function ClickRegister() {
        		location.href = "/inquiry/insert.do";
        	}
        </script>
    </body>
</html>