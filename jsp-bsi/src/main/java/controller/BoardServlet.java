package controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.Command;
import service.DeleteImpl;
import service.GetBoardImpl;
import service.GetListImpl;
import service.InsertImpl;
import service.UpdateImpl;
import vo.BoardVO;


@WebServlet("*.do")
public class BoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String ARTICLE_IMAGE_REPO = "..\\..\\webapp\\assets\\images";
	
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
		GetListImpl service2;
		System.out.println("dd");
		HttpSession session = request.getSession();
		
		  if(command.equals("/view/list.do")) { // 글목록 요청 // ....조회 메서드를 실행하고, 값을 가지고
		 // 화면으로 이동 
		  service2 = new GetListImpl(); 
		  List<BoardVO> list = service2.execute(request, response);
		  System.out.println("목록보기");
		  request.setAttribute("list", list);
		  // 화면에 전달할 값이 있으니 forward이동
		  System.out.println(request.getAttribute("list"));
		  request.getRequestDispatcher("board_list.jsp").forward(request, response);
		 
		  } else if(command.equals("/view/write.do")) { // 글작성 화면요청
				/*
				 * BoardVO boardVO = new BoardVO(); Map<String, String> articleMap =
				 * upload(request,response); String title = articleMap.get("title"); String
				 * content = articleMap.get("content"); String imageFileName =
				 * articleMap.get("imageFileName");
				 * 
				 * boardVO.setTitle(title); boardVO.setContent(content);
				 * boardVO.setImageFileName(imageFileName);
				 */
		  request.getRequestDispatcher("write.jsp").forward(request, response);
		  System.out.println("글쓰기"); 
		  } else if(command.equals("/view/insert.do")) { 
			  //		  글 등록 요청
		  
		  service = new InsertImpl(); 
		  service.execute(request, response);
		  
		  response.sendRedirect("list.do"); // 리다이렉트는 다시 컨트롤러를 태울때 사용합니다.
		  System.out.println("글쓰기완려"); 
		  
		  }else if(command.equals("/view/getboard.do")){
			  System.out.println("글보기1?");
		  service = new GetBoardImpl();
		  service.execute(request, response);
		  
		  request.getRequestDispatcher("board_content.jsp").forward(request, response);
		  System.out.println("글보기?");
		  
		  }else if(command.equals("/view/updateBoard.do")) {
			  System.out.println("글수정1");
			  service = new GetBoardImpl();
			  service.execute(request, response);
			  request.getRequestDispatcher("board_modify.jsp").forward(request, response);
		  }else if(command.equals("/view/update.do")){
			  service = new UpdateImpl();
			  service.execute(request, response);
			  response.sendRedirect("getboard.do?board_id="+request.getParameter("board_id"));
		  
		  }else if(command.equals("/view/deleteBoard.do")) {
			  System.out.println("삭제1");
			  service = new DeleteImpl();
			  service.execute(request, response);
			  System.out.println("삭제2");
			  response.sendRedirect("list.do");
			  System.out.println("삭제3");
		  }
		  
		  
		  		
		 
		
		
		 
	
	}
	private Map<String, String> upload(HttpServletRequest var1, HttpServletResponse var2) throws ServletException, IOException {
        throw new Error("Unresolved compilation problems: \n\tThe type String is not visible\n\tThe type String is not visible\n\tThe type String is not visible\n");
    }




}
