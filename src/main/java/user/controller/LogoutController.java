package user.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import user.service.UserService;
import user.service.UserServiceImpl;

@WebServlet(name="logoutController", value="/logout")
public class LogoutController extends HttpServlet{

	private static final long serialVersionUID = 1L;

	UserService userService = new UserServiceImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("로그아웃");
		HttpSession session = request.getSession();
		String path = request.getContextPath();
		
		System.out.println("getContextPath : " + request.getContextPath());
		System.out.println("getRequestURI : " + request.getRequestURI());
		System.out.println("getRequestURL : " + request.getRequestURL());
		System.out.println("getServletPath : " + request.getServletPath());
		
		if(session.getAttribute("user") != null) {
			session.removeAttribute("user");
		}
		
		session.invalidate();
		
		response.sendRedirect("/home");
		

	}
	
	
	

}
