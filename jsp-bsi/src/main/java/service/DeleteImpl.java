package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BoardDataDAO;

public class DeleteImpl implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		int board_id = Integer.parseInt(request.getParameter("board_id"));
		BoardDataDAO.getInstance().deleteBoard(board_id);

	}

}
