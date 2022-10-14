package util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class JdbcUtility {
	
	private static Connection con;
	private static DataSource dataFactory;
	
	static{
		try {
			Context ctx = new InitialContext();
			Context envContext = (Context)ctx.lookup("java:/comp/env");
			dataFactory = (DataSource)envContext.lookup("mariadb");
		}catch(Exception e) {
			e.printStackTrace();
		}
    }
	
	public JdbcUtility() {}
	
	public static Connection getConnection() { // Connection 객체 생성 메소드
		
		con = null;
		try {
			System.out.println("getconnection");
			//커넥션 풀 사용 Tomcat -context.xml
//			Class.forName("org.mariadb.jdbc.Driver");
//			con = DriverManager.getConnection("jdbc:mariadb://localhost:3306/test","root","12345");
			con = dataFactory.getConnection();
			System.out.println(con);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return con;
	}
	
	public static void close(Connection con, PreparedStatement pstmt, ResultSet rs) {
		try{
            if (rs != null) rs.close();
            if (pstmt != null) pstmt.close();
            if ( con != null) con.close();
        } catch (SQLException e) {
            e.getStackTrace();
        }
	}

}
