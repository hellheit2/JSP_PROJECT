package content.controller;

import java.io.IOException;
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
import content.service.ContentService;
import content.service.ContentServiceImpl;
import content.vo.ContentVO;
import user.vo.UserVO;
import util.PageRequest;
import util.PageResponse;

/* 컨텐츠 리스트 */
@WebServlet(name="getContentlistController", value="/list")
public class GetContentListController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	ContentService contentService = new ContentServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/* 한글 깨짐 인코딩 */
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		/* 회원 정보 확인 */
		HttpSession session = request.getSession();
		UserVO user = (UserVO) session.getAttribute("user");
		
		String page = request.getParameter("page");
		
		// 페이지 입력 정보 없을 경우 기본값
		if(page == null) {
			page = "1";
		}
		
		// 요청 페이지 정보 설정
		PageResponse<ContentVO> pageInfo = contentService.getPageContentList(Integer.parseInt(page));

		// 찜목록 체크
		if(user != null) {
			contentService.setWishListOnPageList(user.getWishList(), pageInfo.getPageList());
		}
			
		try {
			// 페이지 정보 세팅
			request.setAttribute("pageInfo", pageInfo);
			
			RequestDispatcher dispatch = request.getRequestDispatcher("/view/contentsList.jsp");
			dispatch.forward(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}


/* api 사용하지 않고 db를 사용할 경우 페이징
HttpSession session = request.getSession();
List<ContentVO> contentList = (List) session.getAttribute("contentList");
System.out.println("리스트 size: " + contentList.size());
String page = request.getParameter("page");
String size = request.getParameter("size");


PageRequest pageRequest = new PageRequest();
if(page != null) {
	pageRequest.setPage(Integer.parseInt(page));
}
if(size != null) {
	pageRequest.setSize(Integer.parseInt(size));
}

ListService ListService = new ListService();
List<ContentVO> pageList = ListService.getListWithPaging(pageRequest,contentList);

//PageResponse(PageRequest pageRequest, List<E> pageList, int total, int width)
int total = contentList.size();
PageResponse<ContentVO> pageResponse = new PageResponse<ContentVO>(pageRequest, pageList, total);

*/