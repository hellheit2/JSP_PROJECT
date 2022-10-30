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
import user.vo.UserVO;

/* 찜목록 */
@WebServlet("/wish")
public class WishController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	UserService userService = new UserServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 사용자 확인
		HttpSession session = request.getSession();
		UserVO user = (UserVO) session.getAttribute("user");
		
		String id = request.getParameter("target-id");
		boolean status = Boolean.parseBoolean(request.getParameter("status"));
		
		// 찜목록 요청 최신화
		userService.updateWishOfContent(user, id, status);
		
	}

}
