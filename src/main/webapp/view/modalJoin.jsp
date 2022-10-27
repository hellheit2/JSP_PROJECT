<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>


<title>회원가입창</title>
<link rel="stylesheet" href="../assets/css/join.css">
<div id="join_modal">
    <div class="wrapper">
        <div class="title"><span>회원가입</span></div>
        <form method="post" action="/join">
            <div class="form-group">
                <label for="u_name" class="fas fa-user">이름</label>
                <input type="text" placeholder="Name" name="name" autocomplete="off" maxlength="10" required>
            </div>
            <div class="form-group">
                <label for="u_id" class="fas fa-lock">아이디</label>
                <input type="text" placeholder="Id" name="id" autocomplete="off" maxlength="10" required>
            </div>
            <div class="form-group">
                <label for="u_pwd" class="fas fa-lock">비밀번호</label>
                <input type="password" placeholder="Password" name="Pwd" autocomplete="off" maxlength="10" required>
            </div>
            <div class="form-group">
                <label for="u_pwd" class="fas fa-lock">비밀번호<br>&nbsp;&nbsp;&nbsp;확인</label>
                <input type="password" placeholder="Password" name="cpwd" autocomplete="off" maxlength="10" required>
            </div>
            <div class="form-group">
                <label for="u_email" class="fas fa-lock">이메일</label>
                <input type="email" placeholder="Email" name="email" autocomplete="off" required>
            </div>
            <div class="form-group button">
                <input type="submit" class="btn btn-primary form-control" value="가입하기">
            </div>
        </form>
        <img src="../assets/images/menu_close.png" alt="" class="modal_close_btn" width="25" height="25">
    </div>
</div>