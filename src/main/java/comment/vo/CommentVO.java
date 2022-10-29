package comment.vo;

import java.sql.Timestamp;

public class CommentVO {

	int comment_id;
	int parent_id;
	String user_id;
	String content_id;
	String comment_body;
	Timestamp write_date;
	Timestamp update_date;
	int like;
	boolean isLike;
		
	public CommentVO() {}

	public CommentVO(int comment_id, String user_id, String content_id, String comment_body, Timestamp write_date,
			Timestamp update_date, int like) {
		super();
		this.comment_id = comment_id;
		this.user_id = user_id;
		this.content_id = content_id;
		this.comment_body = comment_body;
		this.write_date = write_date;
		this.update_date = update_date;
		this.like = like;
		this.isLike = false;
	}
	
	public int getComment_id() {
		return comment_id;
	}
	public void setComment_id(int comment_id) {
		this.comment_id = comment_id;
	}
	public int getParent_id() {
		return parent_id;
	}
	public void setParent_id(int comment_id) {
		this.parent_id = comment_id;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getContent_id() {
		return content_id;
	}
	public void setContent_id(String content_id) {
		this.content_id = content_id;
	}
	public String getComment_body() {
		return comment_body;
	}
	public void setComment_body(String comment_body) {
		this.comment_body = comment_body;
	}
	public Timestamp getWrite_date() {
		return write_date;
	}
	public void setWrite_date(Timestamp write_date) {
		this.write_date = write_date;
	}
	public Timestamp getUpdate_date() {
		return update_date;
	}
	public void setUpdate_date(Timestamp update_date) {
		this.update_date = update_date;
	}
	public int getLike() {
		return like;
	}
	public void setLike(int like) {
		this.like = like;
	}
	public boolean getIsLike() {
		return isLike;
	}
	public void setIsLike(boolean isLike) {
		this.isLike = isLike;
	}
	
	
}
