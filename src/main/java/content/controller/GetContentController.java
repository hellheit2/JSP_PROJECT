package content.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import content.dao.ContentDAO;
import content.dao.ContentDAOImpl;
import content.service.ContentService;
import content.service.ContentServiceImpl;
import content.vo.ContentVO;

/* 모달 창 컨텐츠 */
@WebServlet(name="getContentController", value="/content")
public class GetContentController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	ContentService contentService = new ContentServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 이전에 존재하던 컨텐츠 정보 제거
		request.removeAttribute("content");
		
		// 요청 컨텐츠 id 확인
		String id = request.getParameter("id");
		if(id != null) {
			// 요청이 있을 경우 해당 id의 컨텐츠 세팅
			ContentVO content = contentService.getContent(id);
			request.setAttribute("content", content);
		}
		request.getRequestDispatcher("/view/content.jsp").forward(request, response);
	}
}
