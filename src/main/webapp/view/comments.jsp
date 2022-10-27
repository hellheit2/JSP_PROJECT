<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<div id="commetListAjax">
	<ul class="comments">
		<c:forEach var="commentVO" items="${pageInfo.pageList}">
			 <li>
		        <div class="userid">${commentVO.user_id }</div>
		        <div class="user_com"> 
		            ${commentVO.comment_body }
		        </div>
		        <span class="time">${commentVO.write_date }</span>
		        <div class="button">
		        <button>
		            <img src = '../assets/images/review_good.png' width="20"> ${commentVO.like }
		        </button>
		        <button>
		            <img src = '../assets/images/bad_review_icon.png' width="20"> ${commentVO.dislike }
		        </button>
		    </div>
		    </li>
		</c:forEach>
		   
	</ul>
</div>