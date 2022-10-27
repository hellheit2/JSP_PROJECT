package comment.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import comment.vo.CommentVO;
import util.PageRequest;
import util.PageResponse;

@WebServlet(name="getCommentController", value="/comment/list")
public class GetCommentListController extends CommentController {

	private static final long serialVersionUID = 1L;

	
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
		
		String page = request.getParameter("page");
		String size = request.getParameter("size");
		
		if(page == null) {
			page = "1";
		}
		
		PageRequest pageRequest = new PageRequest();
		if(page != null) {
			pageRequest.setPage(Integer.parseInt(page));
		}
		if(size != null) {
			pageRequest.setSize(Integer.parseInt(size));
		}
		
		int total = commentList.size();
		PageResponse<CommentVO> pageResponse = new PageResponse<CommentVO>(pageRequest, commentList, total);
		
		
		/* jquery & ajax 에서 html 형식으로 만들어서 붙일 경우*/
		// sendAsJson(response, pageResponse);
		
		request.setAttribute("pageInfo", pageResponse);
		request.getRequestDispatcher("/view/comments.jsp").forward(request, response);
		
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
}
