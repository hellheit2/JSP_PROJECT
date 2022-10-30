package comment.service;

import java.util.List;

import comment.vo.CommentVO;
import user.vo.UserVO;

public interface CommentService {
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
	
	// 회원 좋아요 결과 최신화
	public void updateLikeByUser(String user_id, int content_id, boolean status);
	
	// 좋아요 리스트
	public List<Integer> getLikeList(String user_id);
	
	// 댓글 목록에 좋아요 상태 체크
	public List<CommentVO> setLikeToComment(List<Integer> likeList, List<CommentVO> commentList);
}
