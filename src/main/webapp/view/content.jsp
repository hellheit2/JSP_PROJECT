<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p>${content.id }</p>
	<p>${content.title }</p>
	<p>${content.original_title }</p>
	<p>${content.overview }</p>
	<p>${content.poster_path }</p>
	<p>${content.backdrop_path }</p>
	<p>${content.release_date }</p>
	<p>${content.vote_count }</p>
	<p>${content.vote_average }</p>
	<p>${content.wish }</p>
	
	<div class="review_wrap">
		<c:url var="reviewsPath" value="/reviews" />
		<form action="${reviewsPath}" method="post">
		    <textarea rows="5" name="r_content" id="r_content" placeholder="리뷰를 남겨주세요."></textarea>
		    <input type="hidden" id="contentId" name="content_id" value="${content.id }">
		    <input type="hidden" id="userId" name="user_id" value="${user.id }">
	
		    <button class="btn btn-block btn-primary" type="submit">리뷰 등록</button>
		</form>
	</div>
</body>
</html>