<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../assets/css/modal_test.css">
<script src="../assetsjs/jquery-3.6.0.min.js"></script>
<script src="../assetsjs/jquery-ui-1.10.4.custom.min.js"></script>
<script src="../assets/js/modal.js"></script>

</head>
<body>

	<%@ include file = "./modalLogin.jsp" %>
	<%@ include file = "./modalJoin.jsp" %>
		
	<c:if test="${empty user}"> <!-- 해당 창으로 오게 redirect랑 한쌍 -->
		<ul class="q_join_wrap">
	        <li><button onclick="modalClick(this)" id="login">모달 로그인</button></li> 
	        <li><button onclick="modalClick(this)" id="join">모달 회원가입</button></li>
	    </ul><!--join-->
	</c:if>
</body>
</html>