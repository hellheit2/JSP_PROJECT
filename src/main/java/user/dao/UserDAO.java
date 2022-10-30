package user.dao;

import java.util.List;

import user.vo.UserVO;
import util.PageRequest;

public interface UserDAO {

	// CRUD 기능의 메소드 구현
	// 회원 정보
	public UserVO getUser(String id, String pwd);	

	// 회원 등록
	public int addUser(UserVO user);
	
	// 회원 삭제
	public int delUser(UserVO user);
	
	// 찜목록 개수(페이징 시 사용)
	public int wishCount(String user_id);
	
	// 찜목록 전체
	public List<String> getWishListById(String user_id);
	
	// 찜목록 페이징
	public List<String> getWishListById(String user_id, PageRequest pageRequest);
	
	// 찜목록 추가
	public int addWishContent(String user_id, String content_id);
	
	// 찜목록 삭제
	public int deleteWishContent(String content_id);
}
