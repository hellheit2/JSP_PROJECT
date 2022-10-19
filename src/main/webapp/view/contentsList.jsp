<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />
<%
  request.setCharacterEncoding("UTF-8");
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>영화 목록</title>
<style>
   .cls1 {text-decoration:none;}
   .cls2{text-align:center; font-size:30px;}
   div{border:1px solid #666666;}
</style>
</head>
<body>

	<c:choose>
	  <c:when test="${contentsList == null }" >
	    <tr  height="10">
	      <td colspan="4">
	         <p align="center">
	            <b><span style="font-size:9pt;">등록된 글이 없습니다.</span></b>
	        </p>
	      </td>  
	    </tr>
	  </c:when>
	  <c:when test="${contentsList !=null }" >
	  	<c:forEach  var="content" items="${contentsList }" varStatus="contentNum" >
	    	<div>
	    		<p>${contentNum.count} 번째 반복</p>
	    		<p>${content.cno }</p>
	    		<p>${content.title }</p>
	    		<p>${content.summary }</p>
	    		<p>${content.image_path }</p>
	    		<p>${content.view_count }</p>
	    		<p>${content.rate }</p>
	    	</div>	 
	    </c:forEach>
	  </c:when>
	</c:choose>
</body>
</html>