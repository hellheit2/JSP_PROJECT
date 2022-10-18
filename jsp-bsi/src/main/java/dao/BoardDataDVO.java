package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class BoardDataDVO {
	
	private Connection conn;
	private ResultSet rs;
	//d
	
	public String getDate() { // 글 작성 시간
		String SQL = "select now()";
		try {
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				return rs.getString(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ""; // 데이터베이스 오류 처리 뜰 일 없어서 공백 처리
	}
	
	public int getNext() { // 글 번호
		String SQL = "select 게시글id from from ~ order by 게시글id desc";
		try {
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				return rs.getInt(1) + 1;
			}
			return 1; // 첫 번째 게시물일때 1번째 게시물
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1; // 데이터베이스 오류 처리 > 게시물 번호로는 적절치 않아서 오류 확인 가능
	}
	
	public int write(String a, String b, String c) { // 제목 유저아이디 컨텐츠
		String SQL = "insert into ~ value (?,?,?,?,?,?)";
		
			try {
				
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			return -1; // 데이터베이스 오류 처리 > 게시물 번호로는 적절치 않아서 오류 확인 가능
		}
	}

}
