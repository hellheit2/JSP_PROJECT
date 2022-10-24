package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.Command;
import service.DeleteImpl;
import service.GetBoardImpl;
import service.GetListImpl;
import service.InsertImpl;

import service.UpdateImpl;
import service.ViewImpl;


@WebServlet("*.do")
public class BoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doHandle(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doHandle(request, response);
	}
	
	protected void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		
		String uri = request.getRequestURI();
		String path = request.getContextPath();
		String command = uri.substring(path.length());
		
		System.out.println(command);
		
		Command service;
		
		switch (command) {
		case "/list.do":
			
				System.out.println("글 목록 처리");
				service = new GetListImpl();
				service.execute(request, response);
				
				request.getRequestDispatcher("board_list.jps").forward(request,response); // 앞페이지 이동
				
			break;
		case "/insert.do":
			service = new InsertImpl();
			service.execute(request, response);	
			response.sendRedirect("list.do");
				break;
		case "/getBoard.do":
			service = new ViewImpl(); // 조회수
			service.execute(request, response);
			
			service = new GetBoardImpl();
			service.execute(request, response);
			break;
		case "/write.do":
			
				break;
		case "/delete.do":
			service = new DeleteImpl();
			service.execute(request, response);
			
			response.sendRedirect("list.board");
				break;
		case "/update.do":
			service = new UpdateImpl();
			service.execute(request, response);
			
			response.sendRedirect("getContent.board?bon="+request.getParameter("bno"));
				break;	
		}
	}

}
