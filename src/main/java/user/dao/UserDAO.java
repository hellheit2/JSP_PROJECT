package user.dao;

import java.util.List;

import user.vo.UserVO;

public interface UserDAO {

	public UserVO getUser(String id, String pwd);	

	public int addUser(UserVO user);
	
	public int delUser(UserVO user);
	
	public List<String> getWishListById(String user_id);
	
	public int addWishContent(String user_id, String content_id);
	
	public int deleteWishContent(String content_id);
}
