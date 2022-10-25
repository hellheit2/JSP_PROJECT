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
</body>
</html>