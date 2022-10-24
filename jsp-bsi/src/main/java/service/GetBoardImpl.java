package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BoardDataDAO;
import vo.BoardVO;

public class GetBoardImpl implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		int board_id = Integer.parseInt(request.getParameter("board_id"));
		
		BoardDataDAO dao = BoardDataDAO.getInstance();
		BoardVO vo = dao.getBoard(board_id);

		request.setAttribute("vo", vo);

	}

}
