package user.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import content.vo.ContentVO;
import user.service.UserService;
import user.service.UserServiceImpl;
import user.vo.UserVO;
import util.PageRequest;
import util.PageResponse;

@WebServlet(name="myPageController", value="/mypage")
public class MyPageController extends HttpServlet{

	private static final long serialVersionUID = 1L;

	UserService userService = new UserServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		HttpSession session = request.getSession();
		UserVO user = (UserVO) session.getAttribute("user");
		
		PageRequest pageRequest = new PageRequest();
		String page = request.getParameter("page");
		
		if(page == null) {
			page = "1";
		}
		pageRequest.setPage(Integer.parseInt(page));
	
		PageResponse<ContentVO> pageInfo = userService.getWishListDetail(user, pageRequest);
		
		
		try {
			request.setAttribute("pageInfo", pageInfo);
			
			RequestDispatcher dispatch = request.getRequestDispatcher("/view/myPage.jsp");
			dispatch.forward(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
}
