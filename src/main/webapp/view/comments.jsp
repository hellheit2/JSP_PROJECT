<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<div id="commetListAjax">
	<ul class="comments">
		<c:set var="contentId" value="${commentList[0].content_id }" />
		<c:forEach var="commentVO" items="${commentList}">
			 <li>
		        <div class="userid">
		        	<p>${commentVO.user_id }</p>
		        	<c:if test="${commentVO.user_id == user.id }">
			        	<div class="btn_wrap">
			        		<button type="button" onclick="comment_modify(event, this);" class="comment_btn" data-comment-id="${commentVO.comment_id }" data-content="${contentId }">수정</button>
			        		<button type="button" onclick="comment_delete(event, this);" class="comment_btn" data-comment-id="${commentVO.comment_id }" data-content="${contentId }">삭제</button>
			        	</div>
		        	</c:if>
		        </div>
	        
		        <div class="user_com">            
		            <div class="comment_body">${commentVO.comment_body }</div>
		            <div class="button">
			        	<c:choose>
			        		<c:when test="${user != null }">
			        			<c:if test="${commentVO.isLike == false}">
			        				<button type="button" onclick="like_func(event, this);" class="like" data-controller="comment_like">
										<img src="../assets/images/comment_like.png" alt="좋아요" width="15" height="15" id="heart_icon" data-content=<c:out value="${commentVO.comment_id }" />>
										<span class="count">${commentVO.like }</span>
									</button>
			        			</c:if>
			        			<c:if test="${commentVO.isLike == true}">
			        				<button type="button" onclick="like_func(event, this);" class="like" data-controller="comment_like">
										<img src="../assets/images/comment_like_checked.png" alt="좋아요" width="15" height="15" id="heart_icon" data-content=<c:out value="${commentVO.comment_id }" />>
										<span class="count">${commentVO.like }</span>
									</button>
			        			</c:if>
			        		</c:when>
			        		<c:otherwise>
								<button type="button" onclick="login_need(event);" class="like">
									<img src="../assets/images/comment_like.png" alt="좋아요" width="15" height="15" id="heart_icon" data-content=<c:out value="${commentVO.comment_id }" />>
									<span class="count">${commentVO.like }</span>
								</button>
							</c:otherwise>
			        	</c:choose>
				    </div>
		        </div>
		        <span class="time">${commentVO.write_date }</span>
		        
		    </li>
		</c:forEach>
	</ul>
	
</div>
