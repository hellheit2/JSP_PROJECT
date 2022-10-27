package comment.service;

import java.util.List;

import comment.dao.CommentDAO;
import comment.dao.CommentDAOImpl;
import comment.vo.CommentVO;

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

}
