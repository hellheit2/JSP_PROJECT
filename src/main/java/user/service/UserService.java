package user.service;

import content.vo.ContentVO;
import user.vo.UserVO;
import util.PageRequest;
import util.PageResponse;

public interface UserService {

	public UserVO login(String id, String pwd);
	
	public void join(UserVO user);
	
	public PageResponse<ContentVO> getWishListDetail(UserVO user, PageRequest pageReauest);
	
	public void updateWishOfContent(UserVO user, String content_id, boolean status);
	
}
