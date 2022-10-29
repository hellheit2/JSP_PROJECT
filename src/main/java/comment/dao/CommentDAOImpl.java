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
		String query = "select * from comment where content_id = ? order by comment_id desc;";
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
				
				CommentVO comment = new CommentVO(commentId,userId,contentId,commentBody,writeDate,updateDate,like);
				
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
				
				comment = new CommentVO(commentId,userId,contentId,commentBody,writeDate,updateDate,like);
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
		String query = "update comment "
							+ "set comment_body = ?, "
							+ "update_date = now() "
							+ "where comment_id = ?";
							
		try {
			con = JdbcUtility.getConnection();
			pstmt = con.prepareStatement(query);
			pstmt.setString(1,comment.getComment_body());
			pstmt.setInt(2,comment.getComment_id());
			System.out.println(pstmt.toString());
			cnt = pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtility.close(con,pstmt,null);
		}
		return cnt;
	}
	
	@Override
	public List<Integer> getLikeList(String user_id){
		
		List<Integer> likeList = new ArrayList<>();
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String query = "select comment_id from comment_like where user_id = ?";
		
		try {
			con = JdbcUtility.getConnection();
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, user_id);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int comment_id = rs.getInt("comment_id");
				likeList.add(comment_id);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JdbcUtility.close(con,pstmt,rs);
		}
		
		return likeList;
		
	}
	
	@Override
	public int updateLikeCount(CommentVO comment, int num) {
		Connection con = null;
		PreparedStatement pstmt = null;

		System.out.println("updateLikeCount : " + num);
		System.out.println(comment.getLike() + num);
		int cnt = 0;

		String query = "update comment "
							+ "set comment_like = ? "
							+ "where comment_id = ?";
							
		try {
			con = JdbcUtility.getConnection();
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1,comment.getLike() + num);
			pstmt.setInt(2,comment.getComment_id());
			
			System.out.println(query);
			cnt = pstmt.executeUpdate();
			
			System.out.println(cnt);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtility.close(con,pstmt,null);
		}
		
		return cnt;
		
	}
	
	@Override
	public int updateLike(String user_id, int comment_id, boolean status) {
		Connection con = null;
		PreparedStatement pstmt = null;
		int cnt = 0;
		String query = null;
		
		if(status == true) {
			System.out.println(true);
			query = "insert into comment_like (user_id, comment_id) "
					+ "values (?,?)";
		}else {
			System.out.println(false);
			query = "delete from comment_like where user_id = ? and comment_id = ? ";
		}
		
		
		try {
			con = JdbcUtility.getConnection();
			pstmt = con.prepareStatement(query);
			pstmt.setString(1,user_id);
			pstmt.setInt(2,comment_id);
			cnt = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtility.close(con,pstmt,null);
		}
		
		return cnt;
	}
	
	

	
}
