package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ViewImpl implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String board_id = request.getParameter("board_id");
		
		//쿠키 받아서 조회번호 같은지
		

	}

}
