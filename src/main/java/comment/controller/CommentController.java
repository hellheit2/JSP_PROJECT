package comment.controller;

import javax.servlet.http.HttpServlet;

import comment.service.CommentService;
import comment.service.CommentServiceImpl;

public class CommentController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	CommentService commentService = new CommentServiceImpl();
	
}
