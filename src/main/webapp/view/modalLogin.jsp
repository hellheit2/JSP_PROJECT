<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<div id="login_modal">
    <form method="post" action="<c:url value='/login' />">
		<h3>로그인 화면</h3>
		<div class="form-group">
			<input type="text" class="form-control" placeholder="아이디" id="u_id" name="userId" maxlength="20">
		</div>
		<div class="form-group">
			<input type="password" class="form-control" placeholder="비밀번호" id="u_pwd" name="userPwd" maxlength="20">
		</div>
		<input type="submit" class="btn btn-primary form-control" value="로그인">
	</form>
    <a class="modal_close_btn">닫기</a>
</div>
