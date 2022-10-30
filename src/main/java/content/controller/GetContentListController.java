package content.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import content.dao.ContentDAO;
import content.dao.ContentDAOImpl;
import content.service.ContentService;
import content.service.ContentServiceImpl;
import content.vo.ContentVO;
import user.vo.UserVO;
import util.PageRequest;
import util.PageResponse;


@WebServlet(name="getContentlistController", value="/list")
public class GetContentListController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	ContentService contentService = new ContentServiceImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		HttpSession session = request.getSession();
		UserVO user = (UserVO) session.getAttribute("user");
		
		String page = request.getParameter("page");
		
		if(page == null) {
			page = "1";
		}
		
		/* TMDBService tmdb = new TMDBServiceImpl(); */
		PageResponse<ContentVO> pageInfo = contentService.getPageContentList(Integer.parseInt(page));
		
		System.out.println(pageInfo.getTotalContent());
		System.out.println(user);
		//찜목록 체크
		if(user != null) {
			contentService.setWishListOnPageList(user.getWishList(), pageInfo.getPageList());
			System.out.println(pageInfo.getPageList().toString());
		}
		/*
		HttpSession session = request.getSession();
		List<ContentVO> contentList = (List) session.getAttribute("contentList");
		System.out.println("리스트 size: " + contentList.size());
		String page = request.getParameter("page");
		String size = request.getParameter("size");
		
		
		PageRequest pageRequest = new PageRequest();
		if(page != null) {
			pageRequest.setPage(Integer.parseInt(page));
		}
		if(size != null) {
			pageRequest.setSize(Integer.parseInt(size));
		}
		
		ListService ListService = new ListService();
		List<ContentVO> pageList = ListService.getListWithPaging(pageRequest,contentList);
		
		//PageResponse(PageRequest pageRequest, List<E> pageList, int total, int width)
		int total = contentList.size();
		PageResponse<ContentVO> pageResponse = new PageResponse<ContentVO>(pageRequest, pageList, total);
		
		*/
		System.out.println(pageInfo.getPageList().toString());
		
		
		try {
			request.setAttribute("pageInfo", pageInfo);
			
			RequestDispatcher dispatch = request.getRequestDispatcher("/view/contentsList.jsp");
			dispatch.forward(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request,response);
	}
	
	
	
	


}
