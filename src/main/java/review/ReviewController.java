package review;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="reviewController", value="/review")
public class ReviewController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String content = request.getParameter("r_content");
		String content_id = request.getParameter("content_id");
		String user_id = request.getParameter("user_id");
		
		System.out.println(content);
		System.out.println(content_id);
		System.out.println(user_id);
	}

	
}
