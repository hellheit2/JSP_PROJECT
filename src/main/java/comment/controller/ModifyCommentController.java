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

/* 댓글 수정 */
@WebServlet(name="modifyCommentController", value="/comment/modify")
public class ModifyCommentController extends HttpServlet{

	private static final long serialVersionUID = 1L;

	CommentService commentService = new CommentServiceImpl();
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("댓글 수정");
		
		/* 한글 깨짐 인코딩 */
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");

		/* 수정 댓글 정보 확인 */
		String content_id = request.getParameter("content-id");
		int comment_id = Integer.parseInt(request.getParameter("comment-id"));
		String body = request.getParameter("body");

		/* 수정 댓글 객체 생성 */
		CommentVO comment = new CommentVO();
		
		comment.setComment_id(comment_id);
		comment.setComment_body(body);
		
		/* 댓글 수정 */
		int result = commentService.updateComment(comment);
		if(result != 0) {
			System.out.println("댓글 수정 성공");
		}
		
		response.sendRedirect("/content?id=" + content_id);
	}

	

}
