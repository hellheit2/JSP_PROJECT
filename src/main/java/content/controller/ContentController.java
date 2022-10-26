package content.controller;

import javax.servlet.http.HttpServlet;

import content.service.ContentService;
import content.service.ContentServiceImpl;

public class ContentController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	ContentService contentService = new ContentServiceImpl();
}
