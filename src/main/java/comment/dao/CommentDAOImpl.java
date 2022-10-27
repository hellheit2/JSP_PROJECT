package comment.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import comment.vo.CommentVO;
import user.vo.UserVO;
import util.JdbcUtility;

public class CommentDAOImpl implements CommentDAO{

	@Override
	public List<CommentVO> getCommentList(String content_id) {
		List<CommentVO> commentList = new ArrayList<>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query = "select * from comment where content_id = ?";
		try {
			con = JdbcUtility.getConnection();
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, content_id);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				
				int commentId = rs.getInt("comment_id");
				String userId = rs.getString("user_id");
				String contentId = rs.getString("content_id");
				String commentBody = rs.getString("comment_body");
				Timestamp writeDate = rs.getTimestamp("write_date");
				Timestamp updateDate = rs.getTimestamp("update_date");
				int like = rs.getInt("comment_like");
				int dislike = rs.getInt("comment_dislike");
				
				CommentVO comment = new CommentVO(commentId,userId,contentId,commentBody,writeDate,updateDate,like,dislike);
				
				commentList.add(comment);
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JdbcUtility.close(con,pstmt,rs);
		}
		
		return commentList;
	}

	@Override
	public CommentVO getComment(int comment_id) {
		CommentVO comment = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query = "select * from comment where comment_id = ?";
		try {
			con = JdbcUtility.getConnection();
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, comment_id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				
				int commentId = rs.getInt("comment_id");
				String userId = rs.getString("user_id");
				String contentId = rs.getString("content_id");
				String commentBody = rs.getString("comment_body");
				Timestamp writeDate = rs.getTimestamp("write_date");
				Timestamp updateDate = rs.getTimestamp("update_date");
				int like = rs.getInt("comment_like");
				int dislike = rs.getInt("comment_dislike");
				
				comment = new CommentVO(commentId,userId,contentId,commentBody,writeDate,updateDate,like,dislike);
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JdbcUtility.close(con,pstmt,rs);
		}
		
		return comment;
	}
	
	@Override
	public int insertComment(CommentVO comment) {
		Connection con = null;
		PreparedStatement pstmt = null;

		int cnt = 0;
		String query = "insert into comment (user_id, content_id, comment_body)"
				+ " values(?,?,?)";
		try {
			con = JdbcUtility.getConnection();
			pstmt = con.prepareStatement(query);
			pstmt.setString(1,comment.getUser_id());
			pstmt.setString(2,comment.getContent_id());
			pstmt.setString(3,comment.getComment_body());
			cnt = pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtility.close(con,pstmt,null);
		}
		return cnt;
		
	}

	@Override
	public int deleteComment(int comment_id) {
		Connection con = null;
		PreparedStatement pstmt = null;

		int cnt = 0;
		String query = "delete from comment where comment_id = ?";
		try {
			con = JdbcUtility.getConnection();
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1,comment_id);
			cnt = pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtility.close(con,pstmt,null);
		}
		return cnt;
	}

	@Override
	public int updateComment(CommentVO comment) {
		Connection con = null;
		PreparedStatement pstmt = null;

		int cnt = 0;
		String query = "update comment"
							+ "set comment_body = ?"
							+ "update_date = sysdate"
							+ "where comment_id = ?";
							
		try {
			con = JdbcUtility.getConnection();
			pstmt = con.prepareStatement(query);
			pstmt.setString(1,comment.getComment_body());
			pstmt.setString(1,comment.getContent_id());
			cnt = pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtility.close(con,pstmt,null);
		}
		return cnt;
	}
	

	
}
