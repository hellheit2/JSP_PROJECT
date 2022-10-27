package content.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import content.dao.ContentDAO;
import content.dao.ContentDAOImpl;
import content.vo.ContentVO;

@WebServlet(name="getContentController", value="/content")
public class GetContentController extends ContentController {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.removeAttribute("content");
		
		String id = request.getParameter("id");
		if(id != null) {
			
			ContentVO content = contentService.getContent(id);
			request.setAttribute("content", content);
		}
		request.getRequestDispatcher("/view/content.jsp").forward(request, response);
	}
}