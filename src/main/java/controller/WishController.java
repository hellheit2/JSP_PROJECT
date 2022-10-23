package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.WishService;
import vo.UserVO;

@WebServlet("/wish")
public class WishController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		UserVO user = (UserVO) session.getAttribute("user");
		
		String id = request.getParameter("content-id");
		boolean status = Boolean.parseBoolean(request.getParameter("status"));
		
		WishService wishService = new WishService();
		wishService.updateWishOfContent(user, id, status);
		
	}

}
