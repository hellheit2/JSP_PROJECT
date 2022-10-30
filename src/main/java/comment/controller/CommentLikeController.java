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

/* 댓글 좋아요 */
@WebServlet(name="commentLikeController", value="/comment_like")
public class CommentLikeController extends HttpServlet{
	
	private static final long serialVersionUID = 1L;

	CommentService commentService = new CommentServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("좋아요");
		
		/* 회원 정보 및 좋아요 여부 확인*/
		HttpSession session = request.getSession();
		UserVO user = (UserVO) session.getAttribute("user");
		
		String user_id = user.getId();
		
		int comment_id = Integer.parseInt(request.getParameter("target-id"));
		boolean status = Boolean.parseBoolean(request.getParameter("status"));
		
		/* 좋아요 상태 업데이트 */
		commentService.updateLikeByUser(user_id, comment_id, status);
		
	}

}
