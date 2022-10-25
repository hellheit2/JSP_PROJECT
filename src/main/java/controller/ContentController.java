package controller;

import javax.servlet.http.HttpServlet;

import service.TMDBService;
import service.TMDBServiceImpl;

public class ContentController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	TMDBService tmdbService = new TMDBServiceImpl();
}
