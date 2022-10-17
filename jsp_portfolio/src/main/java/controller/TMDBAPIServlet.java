package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import vo.ContentVO;


@WebServlet("/tmdb")
public class TMDBAPIServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	public void init(ServletConfig config) throws ServletException {
	
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doHandle(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doHandle(request, response);
	}
	protected void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset-UTF-8");
		
		try {
			String type = "movie";
			String key = "5cf3fb46e228d63ef250b0c89399e2b8";
		    String provider = "8";
		    String page  = "1";
	
			StringBuilder urlBuilder = new StringBuilder("https://api.themoviedb.org/3/discover/"); // url
			urlBuilder.append(URLEncoder.encode(type,"UTF-8")); // 카테고리
			urlBuilder.append("?api_key=" +  URLEncoder.encode(key,"UTF-8") ); // 인증키
			urlBuilder.append("&with_watch_providers=" + URLEncoder.encode(provider,"UTF-8")); // 서비스 플랫폼 tmdb oas 참고
			urlBuilder.append("&watch_region=KR&language=ko&page=" + URLEncoder.encode(page,"UTF-8")); // page
	
			
			URL url = new URL(urlBuilder.toString());
			
			BufferedReader bf;
	
			bf = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));
	
			String result = bf.readLine();
	
			JSONParser jsonParser = new JSONParser();
			JSONObject jsonObject = (JSONObject) jsonParser.parse(result);
			JSONArray list = (JSONArray) jsonObject.get("results");
			
			System.out.println(list.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}


}
