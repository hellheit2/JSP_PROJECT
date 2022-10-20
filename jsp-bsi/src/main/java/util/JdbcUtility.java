package util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class JdbcUtility {
	
	private static Connection conn;
	private static DataSource dataFactory;
	
	static{
		try {
			Context ctx = new InitialContext(); //톰캣 컨텍스트 객체 호출
			Context envContext = (Context)ctx.lookup("java:/comp/env");
			dataFactory = (DataSource)envContext.lookup("mariadb");
		}catch(Exception e) {
			e.printStackTrace();
		}
    }
	
	public JdbcUtility() {}
	
	public static Connection getConnection() { // Connection 객체 생성 메소드
		
		conn = null;
		try {
			System.out.println("getconnection");
			//커넥션 풀 사용 Tomcat -context.xml
//			Class.forName("org.mariadb.jdbc.Driver");
//			con = DriverManager.getConnection("jdbc:mariadb://localhost:3306/test","root","12345");
			conn = dataFactory.getConnection();
			System.out.println(conn);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return conn;
	}
	
	public static void close(PreparedStatement stmt, Connection conn) {
		if(stmt != null) {
			try {
				if(!stmt.isClosed()) stmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				stmt = null;
			}
		}
		
		if(conn != null) {
			try {
				if(!conn.isClosed()) conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				conn = null;
			}
		}
		
	}
	
	public static void close(ResultSet rs, PreparedStatement stmt, Connection conn) {
		if(rs != null) {
			try {
				if(!rs.isClosed()) rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				rs = null;
			}
		}
		
		if(stmt != null) {
			try {
				if(!stmt.isClosed()) stmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				stmt = null;
			}
		}
		
		if(conn != null) {
			try {
				if(!conn.isClosed()) conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				conn = null;
			}
		}

	

	

	

	

}
	
}
