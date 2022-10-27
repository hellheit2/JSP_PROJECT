<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="../assets/js/jquery-3.6.0.min.js"></script>
<link rel="stylesheet" href="../assets/css/reset.css">
<link rel="stylesheet" href="../assets/css/content.css">
<script>
	$(document).ready(function(){
		
		console.log("start : ");
		console.log(${content.id});
	    let commentList = getReviewList(${content.id });
	    console.log(${content.id });
	    
		
		
	  
	}); //document.ready
	function isEmpty(str){
		
		if(typeof str == "undefined" || str == null || str == "")
			return true;
		else
			return false ;
	}
	function getReviewList(contentId){
		let reviewList;
		
		console.log( '/comment/list?content='+ contentId);
		
		if(!isEmpty(contentId)){
			console.log(contentId);
			 $.ajax({
		        url: '/comment/list?content='+ contentId,
		        type: 'GET',
		        headers: {"content-type":"application/json"},
		        success : function(result){
		        	console.log(result);
		        	
		        	let wrap = $('<div>').html(result);
		        	let comments = wrap.find("div#commetListAjax").html();
		        	
		        	$("#comments_wrap").html(comments);
		        	
		            /* CommentsController jquery 쓰는거 주석 해제
		            reviewList = result.pageList;
		            reviewList.forEach(function(review){
		            	console.log(review.comment_body);
		            }); 
		            */
		        },
		        error: function() {
		            alert("error");
		        }
		    });
		}
	
		return reviewList;
		
	}
</script>
</head>
<body>

<div id="comment_wrap">
	<div class="mov_img">
		<c:set var="url" value="https://image.tmdb.org/t/p/w500/" />
		<img src="${url}${content.backdrop_path }" alt="#" width="600" height="300">
	</div>
	<div class="poster_info">
		<c:set var="url" value="https://image.tmdb.org/t/p/w500/" />
		<p class="poster_img"><img src="${url}${content.poster_path }" alt="" width="150" height="200"></p>
		<div class="mov_info">
		    <h3 class="con_title">${content.title }</h3>
		    
			<div class="summary1">
			    <span class="movie_date">${content.release_date }</span>
			    <script>
					var dateList = document.getElementsByClassName('movie_date');
					Array.from(dateList).forEach(function(date){
						date.innerHTML = date.innerHTML.slice(-4);	
					});
				</script>
				<c:forEach var="genre" items="${content.genre_list}">
					ㆍ <span>${genre}</span>
				</c:forEach> 
			</div>
			<p class="star"></p>
			<div class="summary2">
			    <span>기본정보</span><br>
			    ${content.overview}
			</div>
		</div>
	</div>

	<c:url var="commentsPath" value="/comment/add" />
	<form id="comments" method="post" action="${commentsPath}">
		<div>댓글</div>
		<input type = "text" name="comment_body" placeholder = "감상평을 남겨주세요!!">
		
		<input type="hidden" id="contentId" name="content_id" value="${content.id }">
		<input type="hidden" id="userId" name="user_id" value="${user.id }">
		<button type="submit"> 등록</button>
	 </form>
 
 	<div id="comments_wrap"></div>
 
</div>
	
	
	
</body>
</html>