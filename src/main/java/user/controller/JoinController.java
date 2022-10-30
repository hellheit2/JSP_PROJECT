package user.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import user.service.UserService;
import user.service.UserServiceImpl;
import user.vo.UserVO;

/* 회원 가입 */
@WebServlet(name="joinController", value="/join")
public class JoinController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	UserService userService = new UserServiceImpl();

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("회원가입");
		
		/* 한글 깨짐 인코딩 */
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		// 회원 가입 정보
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		
		// UserVO 생성
		UserVO user = new UserVO(id,pwd,name,email);
		
		// 회원 등록
		userService.join(user);
		
		response.sendRedirect("/home");
		
	}

}
