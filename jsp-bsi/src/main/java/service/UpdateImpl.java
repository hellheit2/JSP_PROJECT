package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BoardDataDAO;

public class UpdateImpl implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		int board_id = Integer.parseInt(request.getParameter("board_id"));
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		BoardDataDAO.getInstance().updateBoard(board_id, title, content);

	}

}
