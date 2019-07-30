package spring.biz.user.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import spring.biz.user.vo.UserVO;

@Repository("spring")
public class UserDAO_Spring implements UserDAO{
	
	@Autowired
	private JdbcTemplate template;
	
	public UserDAO_Spring(){	}
	
	@Override
	public UserVO login(String id, String pw) {
		System.out.println("UserDAO_Spring 연동");
		System.out.println(template);
		String sql = "select * from userinfo where userid=? and userpwd = ?";
		
		UserVO user = null;
		
		try {
		user = template.queryForObject(sql, // sql 호출
						new Object[] {id, pw}, // ? 세팅
						new UserRowMapper()); // 결과값 핸들링
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return user;
	}

	@Override
	public int addUser(UserVO user) {
		System.out.println("UserDAO_Spring 연동");
		String sql = "insert into userinfo "
				+ "(userid, username, userpwd, email, phone,address) values (?, ?, ?, ?, ?, ?)";
		return template.update(sql, 
				user.getUserid(), user.getUsername(), user.getUserpwd(),
				user.getEmail(), user.getPhone(), user.getAddress());
	}

	@Override
	public UserVO getUser(String userid) {
		System.out.println("UserDAO_Spring 연동");
		String sql = "select * from userinfo where userid = ?";
		UserVO vo = null;
		try {
			vo = template.queryForObject(sql,
					new Object[] {userid},
					new UserRowMapper());
		} catch(Exception e) {
			
		}
		return vo; 
	}

	@Override
	public List<UserVO> getUserList() {
		System.out.println("UserDAO_Spring 연동");
		String sql = "select * from userinfo ";
		
		return template.query(sql, new UserRowMapper());
	}

	@Override
	public int updateUser(UserVO user) {
		System.out.println("UserDAO_Spring 연동");
		String sql ="update userinfo set email=?,phone=?,address=? where userid =?";
		return template.update(sql,
						user.getEmail(), user.getPhone(), user.getAddress(), user.getUserid());
	}

	@Override
	public int removeUser(String userid) {
		System.out.println("UserDAO_Spring 연동");
		String sql = "delete from userinfo where  userid  = ? ";
		return template.update(sql, userid);
	}

	@Override
	public List<UserVO> searchUser(String condition, String keyword) {
		System.out.println("UserDAO_Spring 연동");
		//String sql = "select * from userinfo where "+condition +" like '%'||?||'%'";
		String sql = "select * from userinfo where "+condition +" like ?";
		
		//return template.query(sql, new Object[] {keyword}, new UserRowMapper()); 
		return template.query(sql, new Object[] {"%"+keyword+"%"}, new UserRowMapper()); 
	}
}



//결과값 핸들링
class UserRowMapper implements RowMapper<UserVO>{

	@Override
	public UserVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		UserVO user = new UserVO();
		user.setUserid(rs.getString("userid"));
		user.setAddress(rs.getString("address"));
		user.setEmail(rs.getString("email"));
		user.setPhone(rs.getString("phone"));
		user.setUsername(rs.getString("username"));
		user.setUserpwd(rs.getString("userpwd"));
		
		return user;
	}
	
}