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
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession();
		UserVO user = (UserVO) session.getAttribute("user");
		
		String content = request.getParameter("r_content");
		String content_id = request.getParameter("content");
		String user_id = request.getParameter("user_id");
		
		System.out.println(content);
		System.out.println(content_id);
		System.out.println(user_id);


		List<CommentVO> commentList = commentService.getCommentList(content_id);
		
		for(CommentVO test : commentList) {
			System.out.println(test.toString());
		}

		
		if(user != null) {
			List<Integer> likeList = commentService.getLikeList(user.getId());
			commentService.setLikeToComment(likeList, commentList);
		}
		
		/* jquery & ajax 에서 html 형식으로 만들어서 붙일 경우*/
		// sendAsJson(response, pageResponse);
		
		request.setAttribute("commentList", commentList);
		request.getRequestDispatcher("/view/comments.jsp").forward(request, response);
		
	}

	
}
