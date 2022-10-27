package comment.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import comment.vo.CommentVO;

@WebServlet(name="addCommentController", value="/comment/add")
public class AddCommentController extends CommentController{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("댓글 추가");
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		System.out.println(request.getParameterNames());
		
		String userId = request.getParameter("user_id");
		String contentId = request.getParameter("content_id");
		String commentBody = request.getParameter("comment_body");
		
		CommentVO comment = new CommentVO(userId, contentId, commentBody);

		int result = commentService.insertComment(comment);
		if(result == 1) {
			System.out.println("댓글 등록 성공");
		}
		
		response.sendRedirect("/content?id=" + contentId);
	}
	
	
	

}
