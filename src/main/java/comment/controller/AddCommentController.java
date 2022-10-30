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

/* 댓글 등록 */
@WebServlet(name="addCommentController", value="/comment/add")
public class AddCommentController extends HttpServlet{

	private static final long serialVersionUID = 1L;

	CommentService commentService = new CommentServiceImpl();
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("댓글 추가");
		
		/* 한글 깨짐 인코딩 */
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		/* 댓글 추가 객체 생성 */
		String userId = request.getParameter("user_id");
		String contentId = request.getParameter("content_id");
		String commentBody = request.getParameter("comment_body");
		
		CommentVO comment = new CommentVO();
		
		comment.setUser_id(userId);
		comment.setContent_id(contentId);
		comment.setComment_body(commentBody);
		
		/* 댓글 추가 */
		int result = commentService.insertComment(comment);
		if(result != 0) {
			System.out.println("댓글 등록 성공");
		}
		
		response.sendRedirect("/content?id=" + contentId);
	}
	
	
	

}
