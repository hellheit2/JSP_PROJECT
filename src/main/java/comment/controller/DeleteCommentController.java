package comment.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import comment.service.CommentService;
import comment.service.CommentServiceImpl;

/* 댓글 삭제 */
@WebServlet(name="deleteComentController", value="/comment/del")
public class DeleteCommentController extends HttpServlet{
	
	private static final long serialVersionUID = 1L;

	CommentService commentService = new CommentServiceImpl();
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("댓글 삭제");
		
		/* 한글 깨짐 인코딩 */
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		/* 댓글 정보 확인 */
		String content_id = request.getParameter("content-id");
		int comment_id = Integer.parseInt(request.getParameter("comment-id"));

		/* 댓글 삭제 */
		int result = commentService.deleteComment(comment_id);
		if(result != 0) {
			System.out.println("댓글 삭제 성공");
		}
		
		response.sendRedirect("/content?id=" + content_id);
	}
	
}
