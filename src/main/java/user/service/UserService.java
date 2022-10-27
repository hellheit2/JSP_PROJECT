package user.service;

import user.vo.UserVO;

public interface UserService {

	public UserVO login(String id, String pwd);
	
	public void join(UserVO user);
	
	public void updateWishOfContent(UserVO user, String content_id, boolean status);
	
}
