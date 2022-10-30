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

/* 마이페이지 */
@WebServlet(name="myPageController", value="/mypage")
public class MyPageController extends HttpServlet{

	private static final long serialVersionUID = 1L;

	UserService userService = new UserServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/* 한글 깨짐 인코딩 */
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		// 회원 정보 확인
		HttpSession session = request.getSession();
		UserVO user = (UserVO) session.getAttribute("user");
		
		// 찜목록 페이징
		PageRequest pageRequest = new PageRequest();
		String page = request.getParameter("page");
		
		// 페이지 정보 없을 시 기본값
		if(page == null) {
			page = "1";
		}
		pageRequest.setPage(Integer.parseInt(page));
	
		// 찜목록 상세
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
