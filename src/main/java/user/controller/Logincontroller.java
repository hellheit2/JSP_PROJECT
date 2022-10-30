package user.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import user.service.UserService;
import user.service.UserServiceImpl;
import user.vo.UserVO;

/* 로그인 */
@WebServlet(name = "loginController", value="/login")
public class Logincontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	UserService userService = new UserServiceImpl();

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("로그인");
		
		/* 한글 깨짐 인코딩 */
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		/* 로그인 정보 확인 */
		String id = request.getParameter("userId"); 
		String pwd = request.getParameter("userPwd");
		
		/* 로그인 */
		UserVO user = userService.login(id, pwd);
		
		if(user!=null) {
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			request.setAttribute("id", user.getId());
		}
		
		response.sendRedirect("/home");
	}

}
