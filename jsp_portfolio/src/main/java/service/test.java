package service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Map;

import vo.ContentVO;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TMDBService test = new TMDBServiceImpl();
		
		Map<Integer, String> map = test.genreList("movie");
		
		List<ContentVO> list = test.getContentList("movie","8");
	}

}
