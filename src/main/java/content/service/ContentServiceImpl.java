package content.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import content.dao.ContentDAO;
import content.dao.ContentDAOImpl;
import content.vo.ContentVO;
import util.PageRequest;
import util.PageResponse;

public class ContentServiceImpl implements ContentService {

	ContentDAO tmdbDAO = new ContentDAOImpl();
	@Override
	public void insertBoard(ContentVO vo) {
		/* API 연동으로 대체 */
	}

	@Override
	public void updateBoard(ContentVO vo) {
		/* API 연동으로 대체 */
	}

	@Override
	public void deleteBoard(ContentVO vo) {
		/* API 연동으로 대체 */
	}

	@Override
	public ContentVO getContent(String content_id) {
		return tmdbDAO.getContent(content_id);
	}

	@Override
	public PageResponse<ContentVO> getPageContentList(int page) {
		return tmdbDAO.getPageContentList(page);
	}

	@Override
	public Map<Integer, String> genreList(String type) {
		return tmdbDAO.genreList(type);
	}
	
	
	// 전체 페이징, API로 페이지 불러올 경우 안씀
	@Override
	public List<ContentVO> getListWithPaging(PageRequest pageRequest, List<ContentVO> contentList){
		
		int fromIndex = (pageRequest.getPage() - 1) * pageRequest.getSize();
		int toIndex = fromIndex + pageRequest.getSize();
		if(toIndex > contentList.size()) 
			toIndex = contentList.size();
		
		List<ContentVO> pageList = new ArrayList<>(contentList.subList(fromIndex, toIndex));
			
        return pageList;
    }
	
	// 페이지 요청 결과의 컨텐츠에 찜목록 여부 설정
	@Override
	public void setWishListOnPageList(List<String> wishList, List<ContentVO> contentList) {
		
		for(ContentVO content : contentList) {
			String content_id = content.getId();
			if(wishList.contains(content_id)) {
				content.setWish(true);
			}
		}
		
	}

	
	

}
