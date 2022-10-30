package comment.dao;

import java.util.List;

import comment.vo.CommentVO;

public interface CommentDAO {
	// CRUD 기능의 메소드 구현
	// 댓글 목록
	public List<CommentVO> getCommentList(String content_id);
	
	// 댓글 상세
	public CommentVO getComment(int comment_id);
	
	// 댓글 추가
	public int insertComment(CommentVO comment);
	
	// 댓글 삭제
	public int deleteComment(int comment_id);
	
	// 댓글 수정
	public int updateComment(CommentVO comment);

	// 좋아요 리스트
	public List<Integer> getLikeList(String user_id);
	
	// 좋아요 수 카운트
	public int updateLikeCount(CommentVO comment, int num);
	
	// 좋아요 상태 최신화
	public int updateLike(String user_id, int comment_id, boolean status);

}
