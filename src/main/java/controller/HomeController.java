package controller;


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

import service.TMDBService;
import service.TMDBServiceImpl;
import util.PageResponse;
import vo.ContentVO;


@WebServlet(name="homeController", value="/home")
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("home");
		
		TMDBService tmdb = new TMDBServiceImpl();
		PageResponse<ContentVO> pageInfo = tmdb.getPageContentList(1);
		
		request.setAttribute("pageInfo",pageInfo);
		
		request.getRequestDispatcher("/view/mainPage.jsp").forward(request, response);
	}

}
