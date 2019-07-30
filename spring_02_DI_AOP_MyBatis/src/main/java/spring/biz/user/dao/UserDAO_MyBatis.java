package spring.biz.user.dao;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import mappers.UserMapper;
import spring.biz.user.vo.UserVO;

@Repository("mybatis")
public class UserDAO_MyBatis implements UserDAO{

	//@Autowired
	@Inject
	SqlSession sqlSession = null;
	
	UserMapper ui = null;
	
	@Override
	public UserVO login(String id, String pw) {
		System.out.println("UserDAO_MyBatis 연동");
		UserVO vo = new UserVO();
		vo.setUserid(id);
		vo.setUserpwd(pw);
		
		UserMapper ui = sqlSession.getMapper(UserMapper.class);
		System.out.println("mybatis interface 기반 호출");
		return ui.login(vo);
		// "user.login" = user_mapper.xml의 namespace.id
		//return sqlSession.selectOne("user.login", vo);
	}

	@Override
	public int addUser(UserVO user) {
		System.out.println("UserDAO_MyBatis 연동");
		return sqlSession.insert("user.add",user);
	}

	@Override
	public UserVO getUser(String userid) {
		System.out.println("UserDAO_MyBatis 연동");
		
		return sqlSession.selectOne("user.getuser",userid);
	}

	@Override
	public List<UserVO> getUserList() {
		System.out.println("UserDAO_MyBatis 연동");
		UserMapper ui = sqlSession.getMapper(UserMapper.class);
		System.out.println("usermappers");
		return ui.list();
		//return sqlSession.selectList("user.getuserlist");
	}

	@Override
	public int updateUser(UserVO user) {
		System.out.println("UserDAO_MyBatis 연동");
		return sqlSession.update("user.update", user);
	}

	@Override
	public int removeUser(String userid) {
		System.out.println("UserDAO_MyBatis 연동");
		
		return sqlSession.delete("user.delete", userid);
	}

	@Override
	public List<UserVO> searchUser(String condition, String keyword) {
		System.out.println("UserDAO_MyBatis 연동");
		HashMap<String, String> map = new HashMap<String, String>();
		map.put(condition,keyword);
		
		return sqlSession.selectList("user.search", map);
	}
}
