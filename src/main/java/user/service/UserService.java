package user.service;

import content.vo.ContentVO;
import user.vo.UserVO;
import util.PageRequest;
import util.PageResponse;

public interface UserService {

	// 로그인
	public UserVO login(String id, String pwd);
	
	// 회원가입
	public void join(UserVO user);
	
	// 찜목록 상세
	public PageResponse<ContentVO> getWishListDetail(UserVO user, PageRequest pageReauest);
	
	// 찜목록 요청 최신화
	public void updateWishOfContent(UserVO user, String content_id, boolean status);
	
}
