package vo;

import java.util.Date;

public class BoardVO {
		private int board_id;// 게시글 번호
	   private int contents_id; // 영화 아이디
	   private String writer; // 작성자
	   private String title; // 게시글 제목
	   private String content; // 내용
	   private Date joinDate;
	   private String imageFileName;
	   public int getBoard_id() {
		return board_id;
	}
	public void setBoard_id(int board_id) {
		this.board_id = board_id;
	}
	public int getContents_id() {
		return contents_id;
	}
	public void setContents_id(int contents_id) {
		this.contents_id = contents_id;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getJoinDate() {
		return joinDate;
	}
	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}
	public String getImageFileName() {
		return imageFileName;
	}
	public void setImageFileName(String imageFileName) {
		this.imageFileName = imageFileName;
	}
	@Override
	public String toString() {
		return "BoardVO [board_id=" + board_id + ", contents_id=" + contents_id + ", writer=" + writer + ", title="
				+ title + ", content=" + content + ", joinDate=" + joinDate + ", imageFileName=" + imageFileName + "]";
	}
	
	 
	   
	   
	   
	
	
	
	
	
	
}
	