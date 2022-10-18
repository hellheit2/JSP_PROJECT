package vo;

public class BoardDataVO {
	private int id; // 영화 아이디
	private String title; // 영화 제목
	private String original_title; // 영화 원제목
	private String overview; // 내용 요약
	private String poster_path; // 포스터(목록용)
	private String backdrop_path; // 포스터(배경용)
	private String release_date; // 개봉일
	private int genre_ids[]; // 장르
	private int vote_count; // 추천수(api)
	private float vote_average; // 추천 평균(api)
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
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
	public String getRelease_date() {
		return release_date;
	}
	public void setRelease_date(String release_date) {
		this.release_date = release_date;
	}
	public int[] getGenre_ids() {
		return genre_ids;
	}
	public void setGenre_ids(int[] genre_ids) {
		this.genre_ids = genre_ids;
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
	
	
}
