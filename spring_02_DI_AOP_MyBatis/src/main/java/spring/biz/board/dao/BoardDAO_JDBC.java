package spring.biz.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import Util.JDBCUtil;
import spring.biz.board.vo.BoardVO;

@Repository("jdbc1")
public class BoardDAO_JDBC implements BoardDAO {

	@Override
	public int insertBoard(BoardVO board) {
		String sql = "insert into board "
				+"(seq, title, writer, content) values((select nvl(max(seq),0)+1 from board), ?, ?, ?)";
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int row = 0;
		
		try {
			con = JDBCUtil.getConnection();
			ps = con.prepareStatement(sql);
			
			ps.setString(1, board.getTitle());
			ps.setString(2, board.getWriter());
			ps.setString(3, board.getContent());
			
			row = ps.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(con, ps, rs);
		}
		
		return row;
	}

	@Override
	public int updateBoard(BoardVO board) {
		String sql = "update board set title=?, writer=?, content=? where seq =?";
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int row = 0;
		
		try {
			con = JDBCUtil.getConnection();
			ps = con.prepareStatement(sql);
			
			ps.setString(1, board.getTitle());
			ps.setString(2, board.getWriter());
			ps.setString(3, board.getContent());
			ps.setInt(4, board.getSeq());
			
			row = ps.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(con, ps, rs);
		}
		
		return row;
	}

	@Override
	public int removeBoard(int seq) {
		String sql = "delete from board where seq = ? ";
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int row = 0;
		
		try {
			con = JDBCUtil.getConnection();
			ps = con.prepareStatement(sql);
			// ? 있다면 세팅
			ps.setInt(1, seq);
			// 실행	//결과값 핸들링
			row = ps.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(con, ps, rs);
		}
		
		return row;
	}

	@Override
	public List<BoardVO> getBoardList() {
		String sql = "select * from board";
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		BoardVO board = null;
		List<BoardVO> list = new ArrayList<BoardVO>(); // list 생성
		
		try {
			con = JDBCUtil.getConnection();
			ps = con.prepareStatement(sql);
			// ? 있다면 세팅
			
			// 실행
			rs= ps.executeQuery(); // 실행문은 rs executeQuery
						
			//결과값 핸들링
			while(rs.next()) {
				board = new BoardVO();
				
				board.setSeq(rs.getInt("seq"));
				board.setTitle(rs.getString("title"));
				board.setWriter(rs.getString("writer"));
				board.setContent(rs.getString("content"));
				board.setRegDate(rs.getDate("regdate"));
				board.setCnt(rs.getInt("cnt"));
				list.add(board);
			}		
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(con, ps, rs);
		}
		
		return list; // list 반환
	}

	@Override
	public List<BoardVO> searchBoard(String condition, String keyword) {
		String sql = "select * from board where "+condition +" like '%'||?||'%'";

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		BoardVO board = null;
		List<BoardVO> list = new ArrayList<BoardVO>();
		
		try {
			con = JDBCUtil.getConnection();
			ps = con.prepareStatement(sql);
			// ? 있다면 세팅
			ps.setString(1, keyword);
			// 실행
			rs= ps.executeQuery(); 
						
			//결과값 핸들링
			while(rs.next()) {
				board = new BoardVO();
				board.setSeq(rs.getInt("seq"));
				board.setTitle(rs.getString("title"));
				board.setWriter(rs.getString("writer"));
				board.setContent(rs.getString("content"));
				board.setRegDate(rs.getDate("regdate"));
				board.setCnt(rs.getInt("cnt"));
				list.add(board);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(con, ps, rs);
		}
		
		return list;
	}

	@Override
	public BoardVO getBoard(int seq) {
		String sql = "select * from userinfo where seq = ?";
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		BoardVO board = null;
		
		try {
			con = JDBCUtil.getConnection();
			ps = con.prepareStatement(sql);
			// ? 있다면 세팅
			ps.setInt(1, seq);
			// 실행
			rs= ps.executeQuery(); // 실행문은 rs executeQuery
						
			//결과값 핸들링
			while(rs.next()) {
				board = new BoardVO();
				board.setSeq(rs.getInt("seq"));
				board.setTitle(rs.getString("title"));
				board.setWriter(rs.getString("writer"));
				board.setContent(rs.getString("content"));
				board.setRegDate(rs.getDate("regdate"));
				board.setCnt(rs.getInt("cnt"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(con, ps, rs);
		}
		
		return board;
	}

}
