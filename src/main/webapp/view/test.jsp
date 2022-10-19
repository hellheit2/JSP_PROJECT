<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
    
<div class="modal fade" id="staticBackdrop" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h1 class="modal-title fs-5" id="staticBackdropLabel">Modal title</h1>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
        <form method="post" action="LoginAction.jsp">
		<h3>로그인 화면</h3>
		<div class="form-group">
			<input type="text" class="form-control" placeholder="아이디" name="userId" maxlength="20">
		</div>
		<div class="form-group">
			<input type="password" class="form-control" placeholder="비밀번호" name="userPwd" maxlength="20">
		</div>
		<input type="submit" class="btn btn-primary form-control" value="로그인">
	</form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
        <button type="button" class="btn btn-primary test">Understood</button>
      </div>
    </div>
  </div>
</div>