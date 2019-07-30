package spring.biz.user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import Util.JDBCUtil;
import spring.biz.user.vo.UserVO;

@Repository("jdbc")
public class UserDAO_JDBC implements UserDAO{

	@Override
	public UserVO login(String id, String pw) {
		System.out.println("UserDAO_JDBC 연동");
		String sql = "select * from userinfo where userid=? and userpwd = ?";
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		UserVO vo = null;
				
		try {
			con = JDBCUtil.getConnection();
			ps = con.prepareStatement(sql);
			
			// ? 있다면 세팅
			ps.setString(1, id);
			ps.setString(2, pw);
			
			// 실행
			rs= ps.executeQuery(); // 실행문은 rs executeQuery
			
			//결과값 핸들링
			while(rs.next()) { 
				vo = new UserVO();
				vo.setUserid(rs.getString("userid"));
				vo.setPhone(rs.getString("phone"));
				vo.setAddress(rs.getString("address"));
				vo.setEmail(rs.getString("email"));
				vo.setUsername(rs.getString("username"));
				vo.setUserpwd(rs.getString("userpwd"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(con, ps, rs);
		}
		
		return vo;
	}

	@Override
	public int addUser(UserVO user) {
		System.out.println("UserDAO_JDBC 연동");
		String sql = "insert into userinfo "
				+ "(userid, username, userpwd, email, phone,address) values (?, ?, ?, ?, ?, ?)";
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int row = 0;
		
		try {
			con = JDBCUtil.getConnection();
			ps = con.prepareStatement(sql);
			// ? 있다면 세팅
			ps.setString(1, user.getUserid());
			ps.setString(2, user.getUsername());
			ps.setString(3, user.getUserpwd());
			ps.setString(4, user.getEmail());
			ps.setString(5, user.getPhone());
			ps.setString(6, user.getAddress());
			// 실행 //결과값 핸들링
			row = ps.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(con, ps, rs);
		}
		
		return row;
	}

	@Override
	public UserVO getUser(String userid) {
		System.out.println("UserDAO_JDBC 연동");
		String sql = "select * from userinfo where userid = ?";
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		UserVO vo = null;
		
		try {
			con = JDBCUtil.getConnection();
			ps = con.prepareStatement(sql);
			// ? 있다면 세팅
			ps.setString(1, userid);
			// 실행
			rs= ps.executeQuery(); // 실행문은 rs executeQuery
						
			//결과값 핸들링
			while(rs.next()) {
				vo = new UserVO();
				vo.setUserid(rs.getString("userid"));
				vo.setPhone(rs.getString("phone"));
				vo.setAddress(rs.getString("address"));
				vo.setEmail(rs.getString("email"));
				vo.setUsername(rs.getString("username"));
				vo.setUserpwd(rs.getString("userpwd"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(con, ps, rs);
		}
		
		return vo;
	}

	@Override
	public List<UserVO> getUserList() {
		System.out.println("UserDAO_JDBC 연동");
		String sql = "select * from userinfo ";
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		UserVO vo = null;
		List<UserVO> list = new ArrayList<UserVO>(); // list 생성
		
		try {
			con = JDBCUtil.getConnection();
			ps = con.prepareStatement(sql);
			// ? 있다면 세팅
			
			// 실행
			rs= ps.executeQuery(); // 실행문은 rs executeQuery
						
			//결과값 핸들링
			while(rs.next()) {
				vo = new UserVO();
				vo.setUserid(rs.getString("userid"));
				vo.setPhone(rs.getString("phone"));
				vo.setAddress(rs.getString("address"));
				vo.setEmail(rs.getString("email"));
				vo.setUsername(rs.getString("username"));
				vo.setUserpwd(rs.getString("userpwd"));
				list.add(vo); // list에 만들어진 객체 vo를 넣음
			}		
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(con, ps, rs);
		}
		
		return list; // list 반환
	}

	@Override
	public int updateUser(UserVO user) {
		System.out.println("UserDAO_JDBC 연동");
		String sql ="update userinfo set email=?,phone=?,address=? where userid =?";
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int row = 0;
		
		try {
			con = JDBCUtil.getConnection();
			ps = con.prepareStatement(sql);
			// ? 있다면 세팅
			ps.setString(1, user.getEmail());
			ps.setString(2, user.getPhone());
			ps.setString(3, user.getAddress());
			ps.setString(4, user.getUserid());
			// 실행
			//결과값 핸들링
			row = ps.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(con, ps, rs);
		}
		
		return row;
	}

	@Override
	public int removeUser(String userid) {
		System.out.println("UserDAO_JDBC 연동");
		String sql = "delete from userinfo where  userid  = ? ";
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int row = 0;
		
		try {
			con = JDBCUtil.getConnection();
			ps = con.prepareStatement(sql);
			// ? 있다면 세팅
			ps.setString(1, userid);
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
	public List<UserVO> searchUser(String condition, String keyword) {
		System.out.println("UserDAO_JDBC 연동");
		String sql = "select * from userinfo where "+condition +" like '%'||?||'%'";
		/*
		String sql1 = "select * from userinfo where username like '%'||?||'%'";
		String sql2 = "select * from userinfo where email like '%'||?||'%'";
		String sql3 = "select * from userinfo where userid like '%'||?||'%'";
		*/
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		UserVO vo = null;
		List<UserVO> list = new ArrayList<UserVO>();
		
		try {
			con = JDBCUtil.getConnection();
			ps = con.prepareStatement(sql);
			// ? 있다면 세팅
			ps.setString(1, keyword);
			// 실행
			rs= ps.executeQuery(); // 실행문은 rs executeQuery
						
			//결과값 핸들링
			while(rs.next()) {
				vo = new UserVO();
				vo.setUserid(rs.getString("userid"));
				vo.setPhone(rs.getString("phone"));
				vo.setAddress(rs.getString("address"));
				vo.setEmail(rs.getString("email"));
				vo.setUsername(rs.getString("username"));
				vo.setUserpwd(rs.getString("userpwd"));
				list.add(vo);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(con, ps, rs);
		}
		
		return list;
	}
}
