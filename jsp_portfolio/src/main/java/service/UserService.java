package service;

import dao.UserDAO;
import vo.UserVO;

public class UserService {

	
	public UserVO login(String id, String pwd) {

		UserDAO userDAO = new UserDAO();
		
		UserVO user = userDAO.login(id, pwd);
		
		return user;
	}
	
	public void join(UserVO user){
		UserDAO userDAO = new UserDAO();
		
		/* 중복 가능한지 여부 확인 코드 */
		
		System.out.println(userDAO.join(user));
	}
}
