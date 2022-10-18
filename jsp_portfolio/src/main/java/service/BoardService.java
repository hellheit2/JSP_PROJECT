package service;

import java.util.List;
import vo.ContentVO;

public class BoardService {
	TMDBService tmdbService;
	
	public BoardService() {
		tmdbService = new TMDBServiceImpl(); 
	}
	
	public List<ContentVO> listContents(){
		List<ContentVO> contentsList = tmdbService.getContentList("type","provider");
		return contentsList;
		
	}
	

}
