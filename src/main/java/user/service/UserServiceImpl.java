package user.service;

import java.util.ArrayList;
import java.util.List;

import content.service.ContentService;
import content.service.ContentServiceImpl;
import content.vo.ContentVO;
import user.dao.UserDAO;
import user.dao.UserDAOImpl;
import user.vo.UserVO;
import util.PageRequest;
import util.PageResponse;

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
	public PageResponse<ContentVO> getWishListDetail(UserVO user, PageRequest pageReauest) {
		
		List<String> wishList = userDAO.getWishListById(user.getId(), pageReauest);
		List<ContentVO> wishListDetail = new ArrayList<>();
		int total = userDAO.wishCount(user.getId());
		ContentService contentService = new ContentServiceImpl();
		
		for(String temp : wishList) {
			ContentVO content = contentService.getContent(temp);
			wishListDetail.add(content);
		}
		
		PageResponse<ContentVO> pageResponse = new PageResponse<ContentVO>(pageReauest, wishListDetail, total);
		
		return pageResponse;
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
