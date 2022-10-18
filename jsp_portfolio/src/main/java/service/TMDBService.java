package service;

import java.util.List;
import java.util.Map;

import vo.ContentVO;

public interface TMDBService {
	
	// CRUD 기능의 메소드 구현
	// 컨텐츠 등록
	public void insertBoard(ContentVO vo);
	
	// 컨텐츠 수정
	public void updateBoard(ContentVO vo);
	
	// 컨텐츠 삭제
	public void deleteBoard(ContentVO vo);
	
	// 컨텐츠 상세 조회
	public ContentVO getContent(ContentVO vo);
	
	// 컨텐츠 목록 조회
	public List<ContentVO> getContentList(String type, String provider);
	
	// 장르 목록 반환
	public Map<Integer, String> genreList(String type);
	
}
