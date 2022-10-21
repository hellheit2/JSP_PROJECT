package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import util.JdbcUtility;
import vo.BoardVO;

public class BoardDataDAO {
	
	private Connection conn;
	private ResultSet rs;
	private PreparedStatement stmt;
	
	//데이터베이스
	private BoardDataDAO() {
		try {
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * public String getDate() { // 글 작성 시간 String SQL = "select now()"; try {
	 * PreparedStatement pstmt = conn.prepareStatement(SQL); rs =
	 * pstmt.executeQuery(); if (rs.next()) { return rs.getString(1); } } catch
	 * (Exception e) { e.printStackTrace(); } return ""; // 데이터베이스 오류 처리 뜰 일 없어서 공백
	 * 처리 }
	 */
	
	/*
	 * public int getNext() { // 글 번호 String SQL =
	 * "select 게시글id from from ~ order by 게시글id desc"; try { PreparedStatement pstmt
	 * = conn.prepareStatement(SQL); rs = pstmt.executeQuery(); if (rs.next()) {
	 * return rs.getInt(1) + 1; } return 1; // 첫 번째 게시물일때 1번째 게시물 } catch (Exception
	 * e) { e.printStackTrace(); } return -1; // 데이터베이스 오류 처리 > 게시물 번호로는 적절치 않아서 오류
	 * 확인 가능 }
	 */
	
	/*
	 * public int write(String a, String b, String c) { // 제목 유저아이디 컨텐츠 String SQL =
	 * "insert into ~ value (?,?,?,?,?,?)";
	 * 
	 * try {
	 * 
	 * }
	 * 
	 * catch (Exception e) { e.printStackTrace(); } return -1; // 데이터베이스 오류 처리 > 게시물
	 * 번호로는 적절치 않아서 오류 확인 가능 }
	 */
	
	private final String BOARD_INSERT = "insert into board(board_id, title, writer, "
			+ "content) values((select nvl(max(board_id), 0)+1 from board),?,?,?)";
	
	private final String BOARD_UPDATE = "update board set title=?, content=? where board_id=?";
	
	private final String BOARD_DELETE = "delete board where board_id=?";
	
	private final String BOARD_GET = "select * from board where board_id=?";
	
	private final String BOARD_LIST = "select * from board order by board_id desc";
	
	public void insertBoard(BoardVO vo) {
		System.out.println("===> JDBC로 insertBoard() 기능 처리");
		try {
			conn = JdbcUtility.getConnection();
			stmt = conn.prepareStatement(BOARD_INSERT);
			stmt.setString(1, vo.getTitle());
			stmt.setString(2, vo.getWriter());
			stmt.setString(3, vo.getContent());
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtility.close(stmt, conn);
		}
	}
	
	// 글 수정
	public void updateBoard(BoardVO vo) {
		System.out.println("===> JDBC로 updateBoard() 기능 처리");
		try {
			conn = JdbcUtility.getConnection();
			stmt = conn.prepareStatement(BOARD_UPDATE);
			stmt.setString(1, vo.getTitle());
			stmt.setString(2, vo.getContent());
			stmt.setInt(3, vo.getBoard_id());
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtility.close(stmt, conn);
		}
	}
	
	// 글 삭제
	public void deleteBoard(BoardVO vo) {
		System.out.println("===> JDBC로 deleteBoard() 기능 처리");
		try {
			conn = JdbcUtility.getConnection();
			stmt = conn.prepareStatement(BOARD_DELETE);
			stmt.setInt(1, vo.getBoard_id());
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtility.close(stmt, conn);
		}
	}
	
	// 글 상세 조회
	public BoardVO getBoard(BoardVO vo) {
		System.out.println("===> JDBC로 getBoard() 기능 처리");
		BoardVO board = null;
		try {
			conn = JdbcUtility.getConnection();
			stmt = conn.prepareStatement(BOARD_GET);
			stmt.setInt(1, vo.getBoard_id());
			rs = stmt.executeQuery();
			if(rs.next()) {
				board = new BoardVO();
				board.setBoard_id(rs.getInt("BOARD_ID"));
				board.setTitle(rs.getString("TITLE"));
				board.setWriter(rs.getString("WRITER"));
				board.setContent(rs.getString("CONTENT"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtility.close(rs, stmt, conn);
		}
		return board;
	}
	
	// 글 목록 조회
	
	public List<BoardVO> getBoardList(BoardVO vo) {
		System.out.println("===> JDBC로 getBoardList() 기능 처리");
		List<BoardVO> boardList = new ArrayList<BoardVO>();
		try {
			conn = JdbcUtility.getConnection();
			stmt = conn.prepareStatement(BOARD_LIST);
			rs = stmt.executeQuery();
			while(rs.next()) {
				BoardVO board = new BoardVO();
				board.setBoard_id(rs.getInt("BOARD_ID"));
				board.setTitle(rs.getString("TITLE"));
				board.setWriter(rs.getString("WRITER"));
				board.setContent(rs.getString("CONTENT"));
				boardList.add(board);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtility.close(rs, stmt, conn);
		}
		return boardList;
	}
	
	
	
	}


