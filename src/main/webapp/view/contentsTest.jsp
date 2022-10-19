<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>컨텐츠 리스트 테스트</title>
</head>
<script src="../assetsjs/jquery-3.6.0.min.js"></script>
<script src="../assetsjs/jquery-ui-1.10.4.custom.min.js"></script>
<style>
    .movie1{ width: 300px; height: 500px;position: relative; }
    .movie_poster img{border-radius: 20px;transition: all 0.5s; }
    .movie_poster img:hover{opacity: 0.7; cursor: pointer;}
    .plus{ position: absolute; top: 150px; left: 120px;opacity: 0;}
    .movie_poster:hover .plus {opacity: 1;}
    .movie_idx{font-size: 20px; font-weight: bold;}
    .movie_review{color: red; font-size: 20px;}
    .movie_ex1{padding-left: 10px;}
</style>
<body>
	<c:forEach var="contentVO" items="${contentList}">
	    <div class="movie1">
	        <div class="movie_poster">
	        	<c:set var="url" value="https://image.tmdb.org/t/p/w500/" />
	            <p><img src=<c:out value="${url}${contentVO.poster_path}" />
	            			 alt="#" width="300" height="400"></p>
	            <p class="plus"><img src="../assets/images/plus.png" alt="#" width="64" height="64"></p>
	        </div>
	        <div class="movie_ex1">
	            <div class="movie_idx"><c:out value="${contentVO.title }" /></div>
 	            <div class="movie_date"><c:out value="${contentVO.release_date }" /></div>
	            <div class="movie_review"><c:out value="${contentVO.vote_average }" /></div>
	        </div>
	    </div>
    </c:forEach>
    <script>
		var dateList = document.getElementsByClassName('movie_date');
		Array.from(dateList).forEach(function(date){
			date.innerHTML = date.innerHTML.slice(-4);	
		});
	</script>
</body>