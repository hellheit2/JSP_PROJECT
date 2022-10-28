package comment.service;

import java.util.List;

import comment.vo.CommentVO;
import user.vo.UserVO;

public interface CommentService {
	// CRUD 기능의 메소드 구현
	public List<CommentVO> getCommentList(String content_id);
	
	public CommentVO getComment(int comment_id);
	
	public int insertComment(CommentVO comment);
	
	public int deleteComment(int comment_id);
	
	public int updateComment(CommentVO comment);
	
	public void updateLikeByUser(String user_id, int content_id, boolean status);
	
	public List<Integer> getLikeList(String user_id);
	
	public List<CommentVO> setLikeToComment(List<Integer> likeList, List<CommentVO> commentList);
}
