package service;

import java.util.ArrayList;
import java.util.List;

import util.PageRequest;
import vo.ContentVO;
import vo.UserVO;

public class ListService {

	
	public ListService() {
		
	}
	
	// 전체 페이징, API로 페이지 불러올 경우 안씀
	public List<ContentVO> getListWithPaging(PageRequest pageRequest, List<ContentVO> contentList){
		
		int fromIndex = (pageRequest.getPage() - 1) * pageRequest.getSize();
		int toIndex = fromIndex + pageRequest.getSize();
		if(toIndex > contentList.size()) 
			toIndex = contentList.size();
		
		List<ContentVO> pageList = new ArrayList<>(contentList.subList(fromIndex, toIndex));
			
        return pageList;
    }
	
	public void setWishListOnPageList(UserVO user, List<ContentVO> contentList) {
		
		List<String> wishList = user.getWishList();
		
		for(ContentVO content : contentList) {
			String content_id = content.getId();
			if(wishList.contains(content_id)) {
				content.setWish(true);
			}
		}
		
	}
	

}
