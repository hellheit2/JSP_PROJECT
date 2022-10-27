package user.controller;

import javax.servlet.http.HttpServlet;

import user.service.UserService;
import user.service.UserServiceImpl;

public class UserController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	UserService userService = new UserServiceImpl();

	
}
