package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.UserService;
import vo.UserVO;


@WebServlet(name = "loginController", value="/login")
public class Logincontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void init(ServletConfig config) throws ServletException {
		
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("로그인 서블릿");
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		String id = request.getParameter("userId"); 
		String pwd = request.getParameter("userPwd");
		
		
		UserService userService = new UserService();
		UserVO user = userService.login(id, pwd);
		
		RequestDispatcher rd = null;
		
		
		if(user!=null) {
			if(user.getUno()==1) { // 관리자
				HttpSession session = request.getSession();
				session.setAttribute("user", user);
				request.setAttribute("id", user.getId());
				System.out.println("관리자");
			}else { //일반 사용자
				HttpSession session = request.getSession();
				session.setAttribute("user", user);
				request.setAttribute("id", user.getId());
				System.out.println("일반 사용자");
				
				/* 새창으로 갈 경우*/
				/* 
				rd = request.getRequestDispatcher("/view/loginSuccess.jsp");
				rd.forward(request, response);
				*/
				response.sendRedirect("/home"); //el 문자랑 한쌍
				
			}
			System.out.println("로그인");
		}else {
			System.out.println("로그인 실패");
		}
	}

}
