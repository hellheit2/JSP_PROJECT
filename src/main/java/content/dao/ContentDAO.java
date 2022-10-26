package content.dao;

import java.util.Map;

import content.vo.ContentVO;
import util.PageResponse;

public interface ContentDAO {
	
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
	
	
}
