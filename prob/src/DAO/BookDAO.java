package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Util.JDBCUtil;
import vo.BookVO;

public class BookDAO {
	public List<BookVO> bookList() {
		List<BookVO> list = new ArrayList<BookVO>();
		String sql = "select * from book order by bookno";

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			con = JDBCUtil.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				BookVO bookVO = new BookVO();
				bookVO.setBookno(rs.getInt("bookno"));
				bookVO.setTitle(rs.getString("title"));
				bookVO.setPrice(rs.getInt("price"));
				bookVO.setAuthor(rs.getString("author"));
				bookVO.setPubdate(rs.getDate("pubdate"));
				
				// 필요시 추가 로드 작업
				list.add(bookVO);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(con, ps, rs);
		}

		return list;
	}

	public int addBook(BookVO vo) throws Exception{

		String sql = "insert into book(bookno, title, author, price)\r\n"
				+ "values((select nvl(max(bookno),0)+1 from book),?,?,?)";

		Connection con = null;
		PreparedStatement ps = null;
		int row = 0;

		con = JDBCUtil.getConnection();
		ps = con.prepareStatement(sql);
		ps.setString(1, vo.getTitle());
		ps.setString(2, vo.getAuthor());
		ps.setInt(3, vo.getPrice());
		
		row = ps.executeUpdate();
		/*
		try {
			con = JDBCUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, vo.getTitle());
			ps.setString(2, vo.getAuthor());
			ps.setInt(3, vo.getPrice());
			
			row = ps.executeUpdate();
			
		} catch (Exception e) {
			e.getMessage();
		} finally {
			JDBCUtil.close(con, ps, rs);
		}
		*/
		return row;
	}

	public int removeBook(int bookno){
		String sql = "delete from book where bookno = ?";
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int row = 0;
		
		try {
			con = JDBCUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, bookno);
			row = ps.executeUpdate();
			row++;
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			JDBCUtil.close(con, ps, rs);
		}
		
		return row;
	}
}