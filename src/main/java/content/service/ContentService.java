package content.service;

import java.util.List;
import java.util.Map;

import content.vo.ContentVO;
import util.PageRequest;
import util.PageResponse;

public interface ContentService {

	
	// CRUD 기능의 메소드 구현
	// 컨텐츠 등록
	public void insertBoard(ContentVO vo);
	
	// 컨텐츠 수정
	public void updateBoard(ContentVO vo);
	
	// 컨텐츠 삭제
	public void deleteBoard(ContentVO vo);
	
	// 컨텐츠 상세 조회
	public ContentVO getContent(String content_id);
	
	// 컨텐츠 목록 조회
	public PageResponse<ContentVO> getPageContentList(int page);
	
	// 장르 목록 반환
	public Map<Integer, String> genreList(String type);
	
	// 페이지 정보에 해당하는 리스트
	public List<ContentVO> getListWithPaging(PageRequest pageRequest, List<ContentVO> contentList);
	
	// 리스트의 찜목록 여부
	public void setWishListOnPageList(List<String> wishList, List<ContentVO> contentList);
}
