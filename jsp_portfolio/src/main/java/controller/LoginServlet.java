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


@WebServlet("/login.do")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void init(ServletConfig config) throws ServletException {
		
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("로그인 서블릿");
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
				rd = request.getRequestDispatcher("");
			}else { //일반 사용자
				HttpSession session = request.getSession();
				session.setAttribute("user", user);
				request.setAttribute("id", user.getId());
				rd = request.getRequestDispatcher("");
			}
			System.out.println("로그인");
		}else {
			request.setAttribute("msg", "로그인 실패");
			request.setAttribute("loc", "/");
			rd = request.getRequestDispatcher("");
		}
		
	
		rd.forward(request, response);
	}

}
