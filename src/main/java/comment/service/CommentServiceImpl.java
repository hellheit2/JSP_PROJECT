package comment.service;

import java.util.List;

import comment.dao.CommentDAO;
import comment.dao.CommentDAOImpl;
import comment.vo.CommentVO;
import content.vo.ContentVO;

public class CommentServiceImpl implements CommentService{

	CommentDAO commentDAO = new CommentDAOImpl();
	
	@Override
	public int insertComment(CommentVO comment) {
		return commentDAO.insertComment(comment);
	}

	@Override
	public int deleteComment(int comment_id) {
		return commentDAO.deleteComment(comment_id);
	}

	@Override
	public int updateComment(CommentVO comment) {
		return commentDAO.updateComment(comment);
	}

	@Override
	public List<CommentVO> getCommentList(String content_id) {
		return commentDAO.getCommentList(content_id);
	}

	@Override
	public CommentVO getComment(int comment_id) {
		return commentDAO.getComment(comment_id);
	}

	@Override
	public void updateLikeByUser(String user_id, int comment_id, boolean status) {
		
		int num = 0;
		num = status ? 1 : -1;
		CommentVO comment = commentDAO.getComment(comment_id);
		commentDAO.updateLike(user_id, comment_id, status);		
		commentDAO.updateLikeCount(comment, num);


	}
	
	@Override
	public List<Integer> getLikeList(String user_id){
		return commentDAO.getLikeList(user_id);
	}
	
	@Override
	public List<CommentVO> setLikeToComment(List<Integer> likeList, List<CommentVO> commentList) {
		for(CommentVO comment : commentList) {
			int conmment_id = comment.getComment_id();
			if(likeList.contains(conmment_id)) {
				comment.setIsLike(true);
			}
		}
		return null;
	}

}
