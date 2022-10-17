package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.JdbcUtility;
import vo.ContentVO;


public class MovieBoardDAO {
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;

	public List<ContentVO> selectAllContents() {
		List<ContentVO> contentsList = new ArrayList<>();
		
		con = null;
		pstmt = null;
		rs = null;
		String query = "SELECT cno,title,summary,image_path,view_count,rate" 
	             + " from contents";
		
		
		//  /assets/images/MyImg.jpg
		try {
			
			con = JdbcUtility.getConnection();
			pstmt = con.prepareStatement(query);
			
			System.out.println(query);
			pstmt = con.prepareStatement(query);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				int contentsNO = rs.getInt("cno");
				String title = rs.getString("title");
				String summary = rs.getString("summary");
				String imagePath = rs.getString("image_path");
				int viewCount = rs.getInt("view_count");
				float rate = rs.getFloat("rate");
				
				ContentVO contents = new ContentVO(contentsNO,title,summary,imagePath,viewCount,rate);
				
				contentsList.add(contents);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtility.close(con,pstmt,rs);
		}
		return contentsList;
	}


	public void insertNewContents(ContentVO content) {
		con = null;
		pstmt = null;
		rs = null;
		
		try {
			con = JdbcUtility.getConnection();
			
			String title = content.getTitle();
			String summary = content.getSummary();
			String imagePath = content.getImage_path();
			int viewCount = content.getView_count();
			float rate = content.getRate();
			
			String query = "insert into contents (title, summary, image_path, view_count, rate) "
					+ "values ('Movie1','Movie1 text','/assets/images/MyImg.jpg', 3, 3.5)";

			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtility.close(con,pstmt,rs);
		}
		
	}
	
}
