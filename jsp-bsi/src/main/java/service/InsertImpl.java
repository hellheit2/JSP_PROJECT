package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BoardDataDAO;
import vo.BoardVO;

public class InsertImpl implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String writer = request.getParameter("writer");
		String title = request.getParameter("title");
		String content = request.getParameter("content");

		System.out.println(writer+title+content);
		
		BoardDataDAO dao = BoardDataDAO.getInstance();
		dao.insertBoard(writer, title, content);
	}

}
