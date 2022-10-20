package service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import util.PageRequest;
import vo.ContentVO;
import vo.PagingVO;

public class BoardService {

	
	public BoardService() {
		
	}
	
	public List<ContentVO> getListWithPaging(PageRequest pageRequest, List<ContentVO> contentList){
		
		int fromIndex = (pageRequest.getPage() - 1) * pageRequest.getSize();
		int toIndex = fromIndex + pageRequest.getSize();
		if(toIndex > contentList.size()) 
			toIndex = contentList.size();
		
		List<ContentVO> pageList = new ArrayList<>(contentList.subList(fromIndex, toIndex));
		
		
        return pageList;
    }
	

}
