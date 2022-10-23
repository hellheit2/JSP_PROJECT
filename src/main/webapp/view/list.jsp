<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>페이지</title>
</head>
<body>
<!-- request.setAttribute("pageInfo", pagingVO);
	request.setAttribute("pageList", pageList); -->
	
	<c:forEach var="contentVO" items="${pageInfo.pageList}">
	    <div class="movie_poster">
	        <div class="movie_wrap">
	        	<c:set var="url" value="https://image.tmdb.org/t/p/w500/" />
	            <a href="#"><img src=<c:out value="${url}${contentVO.poster_path}" />
	            			 alt="#" width="288" height="400"></a>
	            <div class="plus"><p><img src="../assets/images/plus.png" alt="#" width="64" height="64"></p></div>
	        </div>
	        <div class="movie_ex1">
	            <div class="movie_idx" title="<c:out value="${contentVO.title }" />">
	            	<c:out value="${contentVO.title }" />
	            </div>
 	            <div class="movie_date"><c:out value="${contentVO.release_date }" /></div>
	            <div class="movie_review"><c:out value="${contentVO.vote_average }" /></div>
	            <c:if test="${contentVO.wish == false}">
	            	<div><p><img src="../assets/images/wish.png" alt="#" width="64" height="64"></p></div>
	            </c:if>
	            <c:if test="${contentVO.wish == true}">
	            	<div><p><img src="../assets/images/wish_checked.png" alt="#" width="64" height="64"></p></div>
	            </c:if>
	        </div>
	    </div>
    </c:forEach>
	<div id="pagination">
		<!-- 변수 매핑 -->
		<c:set var="action" value="/board" />
		<c:set var="page" value="${pageInfo.currentPage}" />
		<c:set var="beginPage" value="${pageInfo.startPage}" />
		<c:set var="endPage" value="${pageInfo.endPage}" />
		<c:set var="totalPage" value="${pageInfo.totalPage}" />
	         
	    <!-- 처음으로 -->
		<a href="${action}?page=1">
				<span>«</span>
		</a>
		
		<!-- 이전버튼 -->
		<c:if test="${page <= 1}">
			<span>이전</span>
		</c:if>
		<c:if test="${page > 1}">
			<a href="${action}?page=${page - 1}">이전</a>
		</c:if>
	         
	         
		<!-- 넘버링버튼 for문 -->
		<c:forEach var="item" varStatus="status" begin="${beginPage}" end="${endPage}" step="1">
			<c:if test="${page == item}">
				${item}
			</c:if>
			<c:if test="${page != item}">
				<a href="${action}?page=${item}">${item}</a>
			</c:if>
		</c:forEach>
	
		<!-- 다음버튼 -->
		<c:if test="${page >= totalPage}">
			<span>다음</span>
		</c:if>
		<c:if test="${page < totalPage}">
			<a href="${action}?page=${page + 1}">다음</a>
		</c:if>
		<!-- 끝으로 -->
		<a href="${action}?page=${totalPage}">
			<span>»</span>
		</a>
	</div>
</body>
</html>