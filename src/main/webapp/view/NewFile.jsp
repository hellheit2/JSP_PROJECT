<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.dep1 {
   width: 200px;
   height: 200px;
   display: block;
   background-color: #dcdcdc;
}
.dep2 {
   width: 100px;
   height: 100px;
   display: block;
   margin: 3px auto;
   background-color: #ececec;
}
button {
   display: block;
   margin: 0 auto;
}
</style>
<script type="text/javascript">
var doDep1 = function(event, id) {
	   alert('Clicked dep1' + id);
	}
	var doDep2 = function(event) {
	   alert('Clicked dep2');
	}
	var doDep3 = function(event) {
	   event.stopPropagation();
	   alert('Clicked dep3');
	}
	</script>
</head>
<body>

<c:set var="id" value="15" />
<div class="dep1" onclick="doDep1(event, ${id});">
   dep1
   <div class="dep2" onclick="doDep2(event);">
      dep2<br /><br />
      <a href="javascript:void(0);" onclick="doDep3(event);">dep3</a>
   </div>
</div> 
</body>
</html>