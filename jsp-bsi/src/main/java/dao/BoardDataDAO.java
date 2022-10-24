package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.JdbcUtility;
import vo.BoardVO;

public class BoardDataDAO {
	private static BoardDataDAO instance = new BoardDataDAO();
	
	public static BoardDataDAO getInstance() {
		return instance;
	}
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
	
	
	
	private final String BOARD_INSERT = "insert into board(board_id, title, writer, "
			+ "content) values((select nvl(max(board_id), 0)+1 from board),?,?,?)";
	
	private final String BOARD_UPDATE = "update board set title=?, content=? where board_id=?";
	
	private final String BOARD_DELETE = "delete board where board_id=?";
	
	private final String BOARD_GET = "select * from board where board_id=?";
	
	private final String BOARD_LIST = "select * from board order by board_id desc";
	
	public void insertBoard(String writer, String title, String content) {
		System.out.println("===> JDBC로 insertBoard() 기능 처리");
		try {
			conn = JdbcUtility.getConnection();
			stmt = conn.prepareStatement(BOARD_INSERT);
			stmt.setString(1, writer);
			stmt.setString(2, title);
			stmt.setString(3, content);
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtility.close(stmt, conn);
		}
	}
	
	// 글 수정
	public void updateBoard(int board_id, String title, String content) {
		System.out.println("===> JDBC로 updateBoard() 기능 처리");
		try {
			conn = JdbcUtility.getConnection();
			stmt = conn.prepareStatement(BOARD_UPDATE);
			stmt.setString(1, title);
			stmt.setString(2, content);
			stmt.setInt(3, board_id);
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtility.close(stmt, conn);
		}
	}
	
	// 글 삭제
	public void deleteBoard(int board_id) {
		System.out.println("===> JDBC로 deleteBoard() 기능 처리");
		try {
			conn = JdbcUtility.getConnection();
			stmt = conn.prepareStatement(BOARD_DELETE);
			stmt.setInt(1, board_id);
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtility.close(stmt, conn);
		}
	}
	
	// 글 상세 조회
	public BoardVO getBoard(int board_id) {
		System.out.println("===> JDBC로 getBoard() 기능 처리");
		BoardVO board = null;
		try {
			conn = JdbcUtility.getConnection();
			stmt = conn.prepareStatement(BOARD_GET);
			stmt.setInt(1, board_id);
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
			JdbcUtility.close(conn, rs, stmt);
		}
		return board;
	}
	
	// 글 목록 조회
	
	public List<BoardVO> getList() {
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
			JdbcUtility.close(conn, rs, stmt);
		}
		return boardList;
	}
	
	
	
	
	}


