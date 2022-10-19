package controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.RequestContext;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import service.BoardService;
import vo.ContentVO;


@WebServlet("/board")
public class BoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	BoardService boardService;
	
	public void init(ServletConfig config) throws ServletException {
		boardService = new BoardService();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nextPage = "";
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		String action = request.getPathInfo();
		System.out.println("action:" + action);
		try {
			
			List<ContentVO> contentsList = new ArrayList<>();
			
			if (action == null) {
				contentsList = boardService.listContents();
				request.setAttribute("contentsList", contentsList);
				nextPage = "/view/contentsList.jsp";
				
			} else if (action.equals("/contentsList.do")) {
				contentsList = boardService.listContents();
				request.setAttribute("contentsList", contentsList);
				nextPage = "/view/contentsList.jsp";
				
			} else if(action.equals("/contentsForm.do")) {
				nextPage = "/view/contentsForm.jsp";
			} else if(action.equals("/addContent.do")) {
				Map<String, String> contentMap = upload(request, response);
			}
			RequestDispatcher dispatch = request.getRequestDispatcher(nextPage);
			dispatch.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private Map<String, String> upload(HttpServletRequest request, HttpServletResponse response)	throws ServletException, IOException {
		
		Map<String, String> contentMap = new HashMap<>();
		
		String encoding = "utf-8";
		File currentDirPath = new File("C:\\file_repo");
		DiskFileItemFactory factory = new DiskFileItemFactory();
		factory.setRepository(currentDirPath);
		factory.setSizeThreshold(1024 * 1024);
		ServletFileUpload upload = new ServletFileUpload(factory);
		try {
			List<FileItem> items = upload.parseRequest((RequestContext) request);
			for (int i = 0; i < items.size(); i++) {
				FileItem fileItem = (FileItem) items.get(i);

				if (fileItem.isFormField()) {
					System.out.println(fileItem.getFieldName() + "=" + fileItem.getString(encoding));
					contentMap.put(fileItem.getFieldName(), fileItem.getString(encoding));
				} else {
					System.out.println("파라미터명:" + fileItem.getFieldName());
					System.out.println("파일명:" + fileItem.getName());
					System.out.println("파일크기:" + fileItem.getSize() + "bytes");

					if (fileItem.getSize() > 0) {
						int idx = fileItem.getName().lastIndexOf("\\");
						if (idx == -1) {
							idx = fileItem.getName().lastIndexOf("/");
						}
						String fileName = fileItem.getName().substring(idx + 1);
						File uploadFile = new File(currentDirPath + "\\" + fileName);
						fileItem.write(uploadFile);
					} // end if
				} // end if
			} // end for
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return contentMap;
	}

}
