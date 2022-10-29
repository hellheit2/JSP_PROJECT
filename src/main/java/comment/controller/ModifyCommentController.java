package comment.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import comment.service.CommentService;
import comment.service.CommentServiceImpl;
import comment.vo.CommentVO;

@WebServlet(name="modifyCommentController", value="/comment/modify")
public class ModifyCommentController extends HttpServlet{

	private static final long serialVersionUID = 1L;

	CommentService commentService = new CommentServiceImpl();
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("댓글 수정");
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		System.out.println(request.getParameter("comment-id"));
		System.out.println(request.getParameter("content-id"));
		System.out.println(request.getParameter("body"));
		
		String content_id = request.getParameter("content-id");
		int comment_id = Integer.parseInt(request.getParameter("comment-id"));
		String body = request.getParameter("body");

		CommentVO comment = new CommentVO();
		
		comment.setComment_id(comment_id);
		comment.setComment_body(body);
		
		int result = commentService.updateComment(comment);
		System.out.println(result);
		if(result != 0) {
			System.out.println("댓글 수정 성공");
		}
		
		response.sendRedirect("/content?id=" + content_id);
	}

	

}
