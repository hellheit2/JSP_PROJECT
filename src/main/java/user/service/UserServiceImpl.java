package user.service;

import java.util.List;

import user.dao.UserDAO;
import user.dao.UserDAOImpl;
import user.vo.UserVO;

public class UserServiceImpl implements UserService{

	UserDAO userDAO = new UserDAOImpl();
	
	@Override
	public UserVO login(String id, String pwd) {

		UserVO user = userDAO.getUser(id, pwd);
	
		return user;
	}
	
	@Override
	public void join(UserVO user){
		
		/* 중복 가능한지 여부 확인 코드 */
		
		System.out.println(userDAO.addUser(user));
	}

	@Override
	public void updateWishOfContent(UserVO user, String content_id, boolean status) {
		
		UserDAOImpl userDAO = new UserDAOImpl();
		
		if(status == true) {
			userDAO.addWishContent(user.getId(), content_id);
			System.out.println("WishService : addWish");
			List<String> wishList = userDAO.getWishListById(user.getId());
			
			user.setWishList(wishList);
			
			System.out.println(wishList.toString());
		}else {
			userDAO.deleteWishContent(content_id);
			System.out.println("WishService : delWish");
			List<String> wishList = userDAO.getWishListById(user.getId());
			
			//최신화
			user.setWishList(wishList);
			
			System.out.println(wishList.toString());
		}
		
	}
}
