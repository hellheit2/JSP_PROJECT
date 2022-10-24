<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<style>
        .btn {
          
            border: 0; 
            border-radius: 0; /*윤곽 0*/
            padding: 5px 10px; 
            margin: 20px 0px;
        }
	</style>

	<div class="container">
		<h3>My Web게시판</h3>

		<table class="table table-bordered">
			<thead>
				<tr>
					<th>글 번호</th>
					<th>작성자</th>
					<th>제목</th>
					<th>날짜</th>
					<th>조회수</th>
				</tr>
			</thead>
			
			<tbody>
				<c:forEach var="vo" items="${list }">
					<tr>
						<td>${vo.board_id }</td>
						<td>${vo.writer}</td>
						<td><a href="getBoard.view?board_id=${vo.board_id }">${vo.title }</a></td>
						<%-- <td><fmt:formatDate value="${vo.joinDate }" pattern="yyyy년 MM월dd일 HH시 mm분 ss초" /></td> --%>
						<%-- <td>${vo.hit }</td> --%>
					</tr>
				</c:forEach>
			</tbody>
			
			<tbody>
				<tr>
					<td colspan="5" align="center">
	               			<ul class="pagination pagination-sm">
                        		<li><a href="#">이전</a></li>
                        		<li  class="active"><a href="#">1</a></li>
                        		<li><a href="#">2</a></li>
                        		<li><a href="#">3</a></li>
                        		<li><a href="#">4</a></li>
                        		<li><a href="#">5</a></li>
                        		<li><a href="#">다음</a></li>
                    			</ul>
					<input type="button" value="글 작성" class="btn btn-default pull-right" onclick="location.href='write.do'">
					
					</td>
				</tr>
			</tbody>
		
		</table>
	</div>
</body>
</html>