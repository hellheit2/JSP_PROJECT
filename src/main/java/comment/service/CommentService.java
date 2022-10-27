package comment.service;

import java.util.List;

import comment.vo.CommentVO;

public interface CommentService {
	// CRUD 기능의 메소드 구현
	public int insertComment(CommentVO comment);
	
	public int deleteComment(int comment_id);
	
	public int updateComment(CommentVO comment);
	
	public List<CommentVO> getCommentList(String content_id);
	
	public CommentVO getComment(int comment_id);

}
