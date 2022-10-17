package service;

import java.util.List;

import dao.MovieBoardDAO;
import vo.ContentVO;

public class BoardService {
	MovieBoardDAO movieBoardDAO;
	
	public BoardService() {
		movieBoardDAO = new MovieBoardDAO();
	}
	
	public List<ContentVO> listContents(){
		List<ContentVO> contentsList = movieBoardDAO.selectAllContents();
		return contentsList;
		
	}
	
	public void addContent(ContentVO content) {
		movieBoardDAO.insertNewContents(content);
		
	}

}
