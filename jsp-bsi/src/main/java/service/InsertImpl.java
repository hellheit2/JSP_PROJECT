package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BoardDataDAO;
import vo.BoardVO;

public class InsertImpl implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		/*
		 * int board_id = Integer.parseInt(request.getParameter("board_id")); int
		 * contents_id = Integer.parseInt(request.getParameter("contents_id"));
		 */
		String writer = request.getParameter("writer");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		
		BoardVO vo= new BoardVO();
		vo.setWriter(writer);
		vo.setContent(content);
		vo.setTitle(title);
		/* BoardDataDAO dao = BoardDataDAO.getInstance(); */
		BoardDataDAO dao = BoardDataDAO.getInstance();
		dao.insertBoard(vo);
		System.out.println();
	}

}
