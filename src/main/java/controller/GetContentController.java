package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.TMDBService;
import service.TMDBServiceImpl;
import vo.ContentVO;

@WebServlet(name="getContentController", value="/content")
public class GetContentController extends ContentController {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.removeAttribute("content");
		
		String id = request.getParameter("id");
		if(id != null) {
			TMDBService tmdbService = new TMDBServiceImpl();
			ContentVO content = tmdbService.getContent(id);
			
			request.setAttribute("content", content);
		}
		request.getRequestDispatcher("/view/content.jsp").forward(request, response);
	}
}
