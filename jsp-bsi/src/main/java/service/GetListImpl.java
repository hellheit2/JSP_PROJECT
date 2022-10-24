package service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BoardDataDAO;
import vo.BoardVO;

public class GetListImpl implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		BoardDataDAO dao =BoardDataDAO.getInstance();
		List<BoardVO> list =dao.getList();
		
		request.setAttribute("list", list);
		
		
		
	}

}
