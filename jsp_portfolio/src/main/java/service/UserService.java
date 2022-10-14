package service;

import java.sql.Connection;

import dao.UserDAO;
import util.JdbcUtility;
import vo.UserVO;

public class UserService {

	
	public UserVO login(String id, String pwd) {
		Connection con = JdbcUtility.getConnection();
		UserDAO userDAO = new UserDAO();
		
		UserVO user = userDAO.login(con, id, pwd);
		
		return user;
	}
	
	public void join(UserVO user){
		Connection con = JdbcUtility.getConnection(); 
		UserDAO userDAO = new UserDAO();
		
		System.out.println(userDAO.join(con, user));
	}
}
