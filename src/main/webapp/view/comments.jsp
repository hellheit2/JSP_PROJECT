<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<div id="commetListAjax">
	<ul class="comments">
		<c:set var="contentId" value="${commentList[0].content_id }" />
		<c:forEach var="commentVO" items="${commentList}">
			 <li>
		        <div class="userid">${commentVO.user_id }</div>
		        <div class="user_com"> 
		            ${commentVO.comment_body }
		        </div>
		        <span class="time">${commentVO.write_date }</span>
		        <div class="button">
		        	<c:choose>
		        		<c:when test="${user != null }">
		        			<c:if test="${commentVO.isLike == false}">
		        				<button type="button" onclick="like_func(event, this);" class="like">
									<img src="../assets/images/comment_like.png" alt="좋아요" width="20" height="20" id="heart_icon" data-content=<c:out value="${commentVO.comment_id }" />>
									${commentVO.like }
								</button>
		        			</c:if>
		        			<c:if test="${commentVO.isLike == true}">
		        				<button type="button" onclick="like_func(event, this);" class="like">
									<img src="../assets/images/comment_like_checked.png" alt="좋아요" width="20" height="20" id="heart_icon" data-content=<c:out value="${commentVO.comment_id }" />>
									${commentVO.like }
								</button>
		        			</c:if>
		        		</c:when>
		        		<c:otherwise>
							<button type="button" onclick="login_need(event);" class="wish">
								<img src="../assets/images/comment_like.png" alt="좋아요" width="20" height="20" id="heart_icon" data-content=<c:out value="${commentVO.comment_id }" />>
								${commentVO.like }
							</button>
						</c:otherwise>
		        	</c:choose>
			    </div>
		    </li>
		</c:forEach>
	</ul>
	
</div>
