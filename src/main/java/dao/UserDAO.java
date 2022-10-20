package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import util.JdbcUtility;
import vo.UserVO;

public class UserDAO {

	public UserVO login(String id, String pwd) {
		UserVO user = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query = "select * from user where id=? and pwd=?";
		try {
			con = JdbcUtility.getConnection();
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				
				int userNo = rs.getInt("uno");
				String userId = rs.getString("id");
				String userPwd = rs.getString("pwd");
				String userName = rs.getString("name");
				String userEmail = rs.getString("email");
				Timestamp userJoinDate = rs.getTimestamp("joinDate");
				
				user = new UserVO(userNo,userId,userPwd,userName,userEmail,userJoinDate);
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JdbcUtility.close(con,pstmt,rs);
		}
		return user;
	}
	

	public int join(UserVO user) {
		Connection con = null;
		PreparedStatement pstmt = null;

		int cnt = 0;
		String query = "insert into user (id, pwd, name, email)"
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
		}finally {
			JdbcUtility.close(con,pstmt,null);
		}
		return cnt;
	}
	
}
