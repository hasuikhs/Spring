package spring.biz.user.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import spring.biz.user.vo.UserVO;

@Component("mybatis")
public class UserDAO_MyBatis implements UserDAO{

	@Override
	public UserVO login(String id, String pw) {
		System.out.println("UserDAO_MyBatis 연동");
		String sql = "select * from userinfo where userid=? and userpwd = ?";
		return null;
	}

	@Override
	public int addUser(UserVO user) {
		System.out.println("UserDAO_MyBatis 연동");
		String sql = "insert into userinfo "
				+ "(userid, username, userpwd, email, phone,address) values (?, ?, ?, ?, ?, ?)";
		return 0;
	}

	@Override
	public UserVO getUser(String userid) {
		System.out.println("UserDAO_MyBatis 연동");
		String sql = "select * from userinfo where userid = ?";
		return null;
	}

	@Override
	public List<UserVO> getUserList() {
		System.out.println("UserDAO_MyBatis 연동");
		String sql = "select * from userinfo ";
		return null;
	}

	@Override
	public int updateUser(UserVO user) {
		System.out.println("UserDAO_MyBatis 연동");
		String sql ="update userinfo set email=?,phone=?,address=? where userid =?";
		return 0;
	}

	@Override
	public int removeUser(String userid) {
		System.out.println("UserDAO_MyBatis 연동");
		String sql = "delete from userinfo where  userid  = ? ";
		return 0;
	}

	@Override
	public List<UserVO> searchUser(String condition, String keyword) {
		System.out.println("UserDAO_MyBatis 연동");
		String sql = "select * from userinfo where "+condition +" like '%'||?||'%'";
		return null;
	}
}
