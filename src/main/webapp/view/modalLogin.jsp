<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<link rel="stylesheet" href="../assets/css/login.css">
<div id="login_modal">  
        <div class="wrapper">
<div class="title"><span>로그인</span></div>
<form method="post" action="<c:url value='/login' />" class="loginForm">
    <div class="form-group">
        <label class="fas fa-user"><img src="../assets/images/id.png" alt="#" width="40" height="40"></label>
        <input type="text" class="form-control" placeholder="아이디를 입력해주세요." name="userId" required>
    </div>
    <div class="form-group">
        <label class="fas fa-lock"><img src="../assets/images/pwd.png" alt="#" width="40" height="40"></label>
        <input type="password" class="form-control" placeholder="비밀번호를 입력해주세요." name="userPwd" required>
    </div>
    <div class="form-group button">
        <input type="submit" class="btn btn-primary form-control" value="로그인">
    </div>
    <div class="signup-link">회원이 아니신가요? <a href="join.html">회원가입하기</a></div>
</form>
<a><img src="../assets/images/menu_close.png" alt="#" class="modal_close_btn" width="25" height="25"></a>
</div>
</div>