package user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import content.vo.ContentVO;
import user.vo.UserVO;
import util.JdbcUtility;
import util.PageRequest;

public class UserDAOImpl implements UserDAO{

	@Override
	public UserVO getUser(String id, String pwd) {
		UserVO user = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query = "select * from user where user_id=? and pwd=?";
		try {
			con = JdbcUtility.getConnection();
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				
				String userId = rs.getString("user_id");
				String userPwd = rs.getString("pwd");
				String userName = rs.getString("name");
				String userEmail = rs.getString("email");
				Timestamp userJoinDate = rs.getTimestamp("joinDate");
				
				user = new UserVO(userId,userPwd,userName,userEmail,userJoinDate);
				
				//찜목록
				user.setWishList(getWishListById(userId));
				
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JdbcUtility.close(con,pstmt,rs);
		}
		return user;
	}


	@Override
	public int addUser(UserVO user) {
		Connection con = null;
		PreparedStatement pstmt = null;

		int cnt = 0;
		String query = "insert into user (user_id, pwd, name, email)"
				+ " values(?,?,?,?)";
		try {
			con = JdbcUtility.getConnection();
			pstmt = con.prepareStatement(query);
			pstmt.setString(1,user.getId());
			pstmt.setString(2,user.getPwd());
			pstmt.setString(3,user.getName());
			pstmt.setString(4,user.getEmail());
			cnt = pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JdbcUtility.close(con,pstmt,null);
		}
		return cnt;
	}
	
	@Override
	public int delUser(UserVO user) {
		/* 회원탈퇴 미구현 */
		return 0;
	}
	@Override
	public int wishCount(String user_id) {
		int count = 0;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String query = "select count(*) from wish where user_id = ?";
		
		try {
			con = JdbcUtility.getConnection();
			pstmt = con.prepareStatement(query);
			pstmt.setString(1,user_id);
			rs = pstmt.executeQuery();
			
			rs.next();
            return rs.getInt(1);
            
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtility.close(con,pstmt,null);
		}
		
		return count;
	}
	
	
	@Override
	public List<String> getWishListById(String user_id){
		
		List<String> wishList = new ArrayList<String>();
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String query = "select content_id from wish where user_id = ?";
		
		try {
			con = JdbcUtility.getConnection();
			pstmt = con.prepareStatement(query);
			pstmt.setString(1,user_id);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String content_id = rs.getString("content_id");
				wishList.add(content_id);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtility.close(con,pstmt,null);
		}
		
		return wishList;
				
	}
	
	@Override
	public List<String> getWishListById(String user_id, PageRequest pageRequest){
		
		List<String> wishList = new ArrayList<String>();
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String query = "select content_id from wish where user_id = ? limit ?, ?";

		int size = pageRequest.getSize();
		int from = (pageRequest.getPage() - 1) * size;
		
		try {
			con = JdbcUtility.getConnection();
			pstmt = con.prepareStatement(query);
			pstmt.setString(1,user_id);
			pstmt.setInt(2, from);
			pstmt.setInt(3, size);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String content_id = rs.getString("content_id");
				wishList.add(content_id);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtility.close(con,pstmt,null);
		}
		
		return wishList;
				
	}

	@Override
	public int addWishContent(String user_id, String content_id) {
		Connection con = null;
		PreparedStatement pstmt = null;
		int cnt = 0;
		
		String query = "insert into wish (user_id, content_id) "
				+ "values (?,?)";
		
		try {
			con = JdbcUtility.getConnection();
			pstmt = con.prepareStatement(query);
			pstmt.setString(1,user_id);
			pstmt.setString(2,content_id);
			cnt = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtility.close(con,pstmt,null);
		}
		
		return cnt;
	}
	
	@Override
	public int deleteWishContent(String content_id) {
		Connection con = null;
		PreparedStatement pstmt = null;
		int cnt = 0;
		
		String query = "delete from wish where content_id = ?";
				
		
		try {
			con = JdbcUtility.getConnection();
			pstmt = con.prepareStatement(query);
			pstmt.setString(1,content_id);
			cnt = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtility.close(con,pstmt,null);
		}
		
		return cnt;
	}
	
}
