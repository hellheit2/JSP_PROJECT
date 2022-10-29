package comment.dao;

import java.util.List;

import comment.vo.CommentVO;

public interface CommentDAO {

	public List<CommentVO> getCommentList(String content_id);
	
	public CommentVO getComment(int comment_id);
	
	public int insertComment(CommentVO comment);
	
	public int deleteComment(int comment_id);
	
	public int updateComment(CommentVO comment);

	public List<Integer> getLikeList(String user_id);
	
	public int updateLikeCount(CommentVO comment, int num);
	
	public int updateLike(String user_id, int comment_id, boolean status);

}
