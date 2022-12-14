package content.vo;

import java.util.Date;
import java.util.List;

public class ContentVO {
	
	private String id;					// 영화 아이디
	private String title; 				// 영화 제목
	private String original_title; 		// 영화 원제목
	private String overview; 			// 내용 요약
	private String poster_path; 		// 포스터(목록용)
	private String backdrop_path;	 	// 포스터(배경용)
	private Date release_date;  		// 개봉일
	private List<String> genre_list; 	// 장르
	private int vote_count;				// 추천 수(api)
	private float vote_average; 		// 추천 평균(api)
	private boolean wish; 				// 찜하기
	
	public ContentVO() {};
	
	

	public ContentVO(String id, String title, String original_title, String overview, String poster_path,
			String backdrop_path, Date release_date, List<String> genre_list, int vote_count, float vote_average) {
		super();
		this.id = id;
		this.title = title;
		this.original_title = original_title;
		this.overview = overview;
		this.poster_path = poster_path;
		this.backdrop_path = backdrop_path;
		this.release_date = release_date;
		this.genre_list = genre_list;
		this.vote_count = vote_count;
		this.vote_average = vote_average;
		this.wish = false;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getOriginal_title() {
		return original_title;
	}

	public void setOriginal_title(String original_title) {
		this.original_title = original_title;
	}

	public String getOverview() {
		return overview;
	}

	public void setOverview(String overview) {
		this.overview = overview;
	}

	public String getPoster_path() {
		return poster_path;
	}

	public void setPoster_path(String poster_path) {
		this.poster_path = poster_path;
	}

	public String getBackdrop_path() {
		return backdrop_path;
	}

	public void setBackdrop_path(String backdrop_path) {
		this.backdrop_path = backdrop_path;
	}

	public Date getRelease_date() {
		return release_date;
	}

	public void setRelease_date(Date date) {
		this.release_date = date;
	}

	public List<String> getGenre_list() {
		return genre_list;
	}

	public void setGenre_list(List<String> genre_ids) {
		this.genre_list = genre_ids;
	}

	public int getVote_count() {
		return vote_count;
	}

	public void setVote_count(int vote_count) {
		this.vote_count = vote_count;
	}

	public float getVote_average() {
		return vote_average;
	}

	public void setVote_average(float vote_average) {
		this.vote_average = vote_average;
	}
	
	public boolean isWish() {
		return wish;
	}

	public void setWish(boolean wish) {
		this.wish = wish;
	}



	@Override
	public String toString() {
		return "ContentVO [id=" + id + ", title=" + title + ", original_title=" + original_title + ", overview="
				+ overview + ", poster_path=" + poster_path + ", backdrop_path=" + backdrop_path + ", release_date="
				+ release_date + ", genre_ids=" + genre_list + ", vote_count=" + vote_count + ", vote_average="
				+ vote_average + ", wish=" + wish + "]";
	}



	
	
	
	
}
