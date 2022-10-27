<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%-- <%@ include file="//" %> --%>

<div align="center" class="div_center">

	<h3>게시글 내용 보기</h3>
	<hr>
	<table border="1" width="500">
		<tr>
			<td width="20%">글번호</td>
			<td width="30%">${vo.board_id }</td>
			
			
		</tr>
		<tr>
			<td width="20%">작성자</td>
			<td width="30%">${vo.writer }</td>
			
			<td width="20%">작성일</td>
			<td width="30%"><fmt:formatDate value="${vo.joinDate }" pattern="yyyy년MM월dd일" /></td>
		</tr>
		
		<tr>
			<td width="20%">글제목</td>
			<td colspan="3" width="30%">${vo.title }</td>
		</tr>
		<tr>
			<td width="20%">글내용</td>
			<td colspan="3" width="30%" height="120px">${vo.content }</td>
		</tr>
		
		<tr>
			<td colspan="4" align="center">
				<input type="button" value="목록" onclick="location.href='list.do'">&nbsp;&nbsp;
				<input type="button" value="수정" onclick="location.href='updateBoard.do?board_id=${vo.board_id}'">&nbsp;&nbsp;
				<input type="button" value="삭제" onclick="location.href='deleteBoard.do?board_id=${vo.board_id}'">&nbsp;&nbsp;
			</td>
		</tr>
	</table>
	
</div>

<%-- <%@ include file="../include/footer.jsp" %> --%>