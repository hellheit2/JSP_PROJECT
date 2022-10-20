package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("*.board")
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
		
		// ..
		
		switch (command) {
		case "/목록.do":
			try {
				System.out.println("글 목록 처리");
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		case "/보기.do":
			try {
				
			} catch (Exception e) {
				e.printStackTrace();
			}	
				break;
		case "/쓰기.do":
			try {
				
			} catch (Exception e) {
				e.printStackTrace();
			}
				break;
		case "/삭제.do":
			try {
				
			} catch (Exception e) {
				e.printStackTrace();
			}	
				break;
		case "/수정.do":
			try {
				
			} catch (Exception e) {
				e.printStackTrace();
			}	
				break;	
		}
	}

}
