package main;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import content.dao.ContentDAO;
import content.dao.ContentDAOImpl;
import content.vo.ContentVO;
import util.PageResponse;


@WebServlet(name="homeController", value="/home")
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("home");
		
		ContentDAO tmdb = new ContentDAOImpl();
		PageResponse<ContentVO> pageInfo = tmdb.getPageContentList(1);
		
		request.setAttribute("pageInfo",pageInfo);
		
		request.getRequestDispatcher("/view/mainPage.jsp").forward(request, response);
	}

}
