package content.dao;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLEncoder;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import content.vo.ContentVO;
import util.PageRequest;
import util.PageResponse;

public class ContentDAOImpl implements ContentDAO {

	// API KEY
	private static final String API_KEY = "5cf3fb46e228d63ef250b0c89399e2b8";
	
	public static Map<Integer, String> genreMap = null;
	
	// 장르 맵(Map) 세팅
	public ContentDAOImpl() {
		if(genreMap == null) {
			genreMap = genreList("movie");
		}
	}
	
	@Override
	public void insertBoard(ContentVO vo) {
		/* api 사용 */
	}

	@Override
	public void updateBoard(ContentVO vo) {
		/* api 사용 */
	}

	@Override
	public void deleteBoard(ContentVO vo) {
		/* api 사용 */
	}

	@Override
	public ContentVO getContent(String content_id) {
		
		// 리턴 객체
		ContentVO content = new ContentVO();
		
		// 날짜 표현 형식 지정
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		
		try {
			
			StringBuilder urlBuilder = new StringBuilder("https://api.themoviedb.org/3/movie/");	 // 공통 url
			urlBuilder.append(URLEncoder.encode(content_id,"UTF-8")); 								 // 영화 아이디
			urlBuilder.append("?api_key=" +  URLEncoder.encode(API_KEY,"UTF-8") ); 					 // 인증키
			urlBuilder.append("&watch_region=KR&language=ko&include_image_language=ko,null"); 		 // 언어
			
			// 요청 url
			URL url = new URL(urlBuilder.toString());

			// 요청 결과
			BufferedReader bf = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));
			String result = bf.readLine();
			
			// 결과 json 파싱
			JSONParser jsonParser = new JSONParser();
			JSONObject jsonObject = (JSONObject) jsonParser.parse(result);
			
			// ContentVO에 json 정보 세팅
			content.setId(jsonObject.get("id").toString());
			content.setTitle(jsonObject.get("title").toString());
			content.setOriginal_title(jsonObject.get("original_title").toString());
			content.setOverview(jsonObject.get("overview").toString());
			content.setVote_count(Integer.parseInt(jsonObject.get("vote_count").toString()));
			content.setVote_average(Float.parseFloat(jsonObject.get("vote_average").toString()));
			
			// 개봉 일자 정보 확인 후 set
			if (jsonObject.get("release_date") == null ||
					jsonObject.get("release_date").equals("")) {
				String today = dateFormat.format(new Date());
				content.setRelease_date(dateFormat.parse(today));
			} else {
				content.setRelease_date(dateFormat.parse(jsonObject.get("release_date").toString()));
			}
			// poster_path 정보 확인 후 set
			if(jsonObject.get("poster_path") == null || 
					jsonObject.get("poster_path").toString().equals("")) {
				content.setPoster_path("");
			}else {
				content.setPoster_path(jsonObject.get("poster_path").toString());
			}
			
			// backdrop_path 정보 확인 후 set
			if(jsonObject.get("backdrop_path") == null ||
					jsonObject.get("backdrop_path").toString().equals("")) {
				content.setBackdrop_path("");
			}else {
				content.setBackdrop_path(jsonObject.get("backdrop_path").toString());
			}
			
			
			
			List<String> genreList = new ArrayList<String>();
			// 장르 id를 List<String> 형태로 저장 → 장르 비교를 위한 작업
			JSONArray genre_list = (JSONArray) jsonObject.get("genres");
			if(genre_list != null) {
				for (int k = 0; k < genre_list.size(); k++) {
					JSONObject genre = (JSONObject) genre_list.get(k);
					String genreStr = genreMap.get(Integer.parseInt(genre.get("id").toString()));		
					genreList.add(genreStr);
				}
			}
			
			// 장르 set
			content.setGenre_list(genreList);			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return content;
	}
	
	
	@Override
	public PageResponse<ContentVO> getPageContentList(int page) {
		
		List<ContentVO> contentList = new ArrayList<>();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		
		int totalResult = 0;
		try {
			String type_temp = "movie";
		    String provider_temp = "8";
		    
			StringBuilder urlBuilder = new StringBuilder("https://api.themoviedb.org/3/discover/"); 	// 공통 url
			urlBuilder.append(URLEncoder.encode(type_temp,"UTF-8")); 									// 카테고리
			urlBuilder.append("?api_key=" +  URLEncoder.encode(API_KEY,"UTF-8") ); 						// 인증키
			urlBuilder.append("&with_watch_providers=" + URLEncoder.encode(provider_temp,"UTF-8"));		// 서비스 플랫폼
			urlBuilder.append("&watch_region=KR&language=ko&include_image_language=ko,null"); 			// 언어
			urlBuilder.append("&page=" + page); 														// page
			
			// 요청 url
			URL url = new URL(urlBuilder.toString());

			// 요청 결과
			BufferedReader bf = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));
			String result = bf.readLine();
			
			// 결과 json 파싱
			JSONParser jsonParser = new JSONParser();
			JSONObject jsonObject = (JSONObject) jsonParser.parse(result);
			
			// 요청 결과 중 results key값의 value가 영화 목록
			JSONArray jsonArray = (JSONArray) jsonObject.get("results");

			// 요청 결과 총 컨텐츠 수
			totalResult = Integer.parseInt(jsonObject.get("total_results").toString());
			
			// 페이지의 컨텐츠 요소
			for (int i = 0; i < jsonArray.size(); i++) {
				
				// json 파싱 결과의 배열 내부의 각 영화에 해당하는 json 재파싱
				ContentVO temp = new ContentVO();
				JSONObject content = (JSONObject) jsonArray.get(i);

				// ContentVO에 json 정보 세팅
				temp.setId(content.get("id").toString());
				temp.setTitle(content.get("title").toString());
				temp.setOriginal_title(content.get("original_title").toString());
				temp.setOverview(content.get("overview").toString());
				temp.setVote_count(Integer.parseInt(content.get("vote_count").toString()));
				temp.setVote_average(Float.parseFloat(content.get("vote_average").toString()));
				
				// 개봉 일자 정보 확인 후 set
				if (content.get("release_date") == null ||
						content.get("release_date").equals("")) {
					String today = dateFormat.format(new Date());
					temp.setRelease_date(dateFormat.parse(today));
				} else {
					temp.setRelease_date(dateFormat.parse(content.get("release_date").toString()));
				}
				
				// poster_path 정보 확인 후 set
				if(content.get("poster_path") == null || 
						 content.get("poster_path").toString().equals("")) {
					temp.setPoster_path("");
				}else {
					temp.setPoster_path(content.get("poster_path").toString());
				}
				
				// backdrop_path 정보 확인 후 set
				if(content.get("backdrop_path") == null ||
						 content.get("backdrop_path").toString().equals("")) {
					temp.setBackdrop_path("");
				}else {
					temp.setBackdrop_path(content.get("backdrop_path").toString());
				}
				
				
				List<String> genreList = new ArrayList<String>();
				// 장르 id를 List<String> 형태로 저장 → 장르 비교를 위한 작업
				JSONArray genre_list = (JSONArray) content.get("genre_ids");
				for (int k = 0; k < genre_list.size(); k++) {
					String genreStr = genreMap.get(Integer.parseInt(String.valueOf(genre_list.get(k))));
							
					genreList.add(genreStr);
				}
				
				temp.setGenre_list(genreList);
			
				contentList.add(temp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// 페이지 요청 정보 설정
		PageRequest pageRequest = new PageRequest();
		pageRequest.setPage(page);
		
		// 페이징 결과
		PageResponse<ContentVO> pageResponse = new PageResponse<ContentVO>(pageRequest, contentList, totalResult);
		
		return pageResponse;
	}

	@Override
	public Map<Integer, String> genreList(String type) {
		
		Map<Integer, String> genres = new HashMap<Integer, String>();
		
		try {
			String temp_type = "movie";
			
			StringBuilder urlBuilder = new StringBuilder("https://api.themoviedb.org/3/genre/"); 	// url
			urlBuilder.append(URLEncoder.encode(temp_type,"UTF-8") + "/list"); 						// 카테고리
			urlBuilder.append("?api_key=" +  URLEncoder.encode(API_KEY,"UTF-8") ); 					// 인증키
			urlBuilder.append("&language=ko"); 														// 언어
	
			// 요청 url
			URL url = new URL(urlBuilder.toString());
			
			// 요청 결과
			BufferedReader bf = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));
			String result = bf.readLine();
			
			// 결과 json 파싱
			JSONParser jsonParser = new JSONParser();
			JSONObject jsonObject = (JSONObject) jsonParser.parse(result);

			JSONArray genre_list = (JSONArray) jsonObject.get("genres");
			
			// 장르 id, 장르명 Map 형태로 저장
			for (int i = 0; i < genre_list.size(); i++) {
				JSONObject genre = (JSONObject) genre_list.get(i);
				// 장르 {id:name}
				int id = Integer.parseInt(String.valueOf(genre.get("id")));
				String name = String.valueOf(genre.get("name"));
				
				genres.put(id, name);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return genres;
	}

}
