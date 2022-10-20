<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>


<div id="join_modal">
	 <form method="post" action="/join">
	    <p>기본 정보</p>
	    <div class="form_wrap1">
	        <div class="line">
	            <label for="u_name" class="l_con">이름</label>
	            <p class="r_con"><input type="text" id="u_name" name="name" autocomplete="off"></p>
	        </div><!--line 이름-->
	        <div class="line">
	            <label for="u_id" class="l_con">아이디</label>
	            <p class="r_con"><input type="text" id="u_id" name="id" autocomplete="off"></p>
	        </div> <!--line 아이디-->
	        <div class="line">
	            <label for="u_pwd" class="l_con">비밀번호</label>
	            <p class="r_con"><input type="password" id="u_pwd" name="pwd" autocomplete="off"></p>
	        </div>
	        <div class="line">
	            <label for="u_pwd" class="l_con">비밀번호 확인</label>
	            <p class="r_con"><input type="password" id="u_cpwd" name="cpwd" autocomplete="off"></p>
	        </div>
	        <!--line 패스워드-->
	        <div class="line">
	            <label for="u_email" class="l_con">이메일</label>
	            <p class="r_con"><input type="email" id="u_email" name="email" autocomplete="off"></p>
	        </div> <!--line 이메일-->
	    </div><!--form_wrap1-->
	    <input type="submit" class="btn btn-primary form-control" value="회원가입">
	    <a class="modal_close_btn">닫기</a>
	</form>
</div><!--wrap1-->