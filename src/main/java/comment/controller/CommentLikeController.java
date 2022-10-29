package comment.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import comment.service.CommentService;
import comment.service.CommentServiceImpl;
import user.vo.UserVO;

@WebServlet(name="commentLikeController", value="/comment_like")
public class CommentLikeController extends HttpServlet{
	
	private static final long serialVersionUID = 1L;

	CommentService commentService = new CommentServiceImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("comment_like");
		HttpSession session = request.getSession();
		UserVO user = (UserVO) session.getAttribute("user");
		
		String user_id = user.getId();
		
		int comment_id = Integer.parseInt(request.getParameter("target-id"));
		boolean status = Boolean.parseBoolean(request.getParameter("status"));
		
		commentService.updateLikeByUser(user_id, comment_id, status);
		
	}

}
