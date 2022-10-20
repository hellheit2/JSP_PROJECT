package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.BoardService;
import util.PageRequest;
import util.PageResponse;
import vo.ContentVO;


@WebServlet(name="boardController", value="/board")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		
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
		
		BoardService boardService = new BoardService();
		List<ContentVO> pageList = boardService.getListWithPaging(pageRequest,contentList);
		
		//PageResponse(PageRequest pageRequest, List<E> pageList, int total, int width)
		int total = contentList.size();
		PageResponse<ContentVO> pageResponse = new PageResponse<ContentVO>(pageRequest, pageList, total);
		
		try {
			request.setAttribute("pageInfo", pageResponse);
			
			RequestDispatcher dispatch = request.getRequestDispatcher("/view/list.jsp");
			dispatch.forward(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request,response);
	}
	
	
	
	


}
