package comment.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import comment.service.CommentService;
import comment.service.CommentServiceImpl;
import comment.vo.CommentVO;
import user.vo.UserVO;
import util.PageRequest;
import util.PageResponse;

@WebServlet(name="getCommentController", value="/comment/list")
public class GetCommentListController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	CommentService commentService = new CommentServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("댓글 리스트 확인");
		
		/* 한글 깨짐 인코딩 */
		request.setCharacterEncoding("UTF-8");
		
		/* 회원 정보 확인 */
		HttpSession session = request.getSession();
		UserVO user = (UserVO) session.getAttribute("user");
		
		/* 대상 컨텐츠 정보 확인 */
		String content_id = request.getParameter("content");
		
		/* 컨텐츠 댓글 리스트 */
		List<CommentVO> commentList = commentService.getCommentList(content_id);
		
		/* 로그인 상태일 경우 */
		if(user != null) {
			/* 회원이 좋아요 한 댓글 상태 최신화 */
			List<Integer> likeList = commentService.getLikeList(user.getId());
			commentService.setLikeToComment(likeList, commentList);
		}
		
		
		request.setAttribute("commentList", commentList);
		request.getRequestDispatcher("/view/comments.jsp").forward(request, response);
		
	}

}

/* jquery & ajax 에서 html 형식으로 만들어서 붙일 경우*/
/* 
private Gson gson = new Gson();

private void sendAsJson(HttpServletResponse response, Object obj) throws IOException {
	response.setContentType("application/json; charset=UTF-8");
	
	String json = gson.toJson(obj);
	
	PrintWriter out = response.getWriter();
	
	out.print(json);
	out.flush();
}
*/

/* jquery & ajax 에서 html 형식으로 만들어서 붙일 경우 (doGet)*/
// sendAsJson(response, pageResponse);
