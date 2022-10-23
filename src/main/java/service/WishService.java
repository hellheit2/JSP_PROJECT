package service;

import java.util.List;

import dao.UserDAO;
import vo.UserVO;

public class WishService {
	
	public void updateWishOfContent(UserVO user, String content_id, boolean status) {
		
		UserDAO userDAO = new UserDAO();
		
		if(status == true) {
			userDAO.addWishContent(user.getId(), content_id);
			System.out.println("WishService : addWish");
			List<String> wishList = userDAO.getWishListById(user.getId());
			
			user.setWishList(wishList);
			
			System.out.println(wishList.toString());
		}else {
			userDAO.deleteWishContent(content_id);
			System.out.println(user.toString());
			System.out.println("WishService : delWish");
			List<String> wishList = userDAO.getWishListById(user.getId());
			
			//최신화
			user.setWishList(wishList);
			
			System.out.println(wishList.toString());
		}
		
	}
}
