package spring.biz.user.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import spring.biz.user.dao.UserDAO;
import spring.biz.user.vo.UserVO;

//@Component("userservice")
@Service("userservice")
public class UserServiceImpl implements UserService{
	//@Autowired
	//@Qualifier("jdbc")
	@Resource(name = "jdbc") // autowired qualifier 를 함께 쓰는 방법
	UserDAO dao;

	public UserServiceImpl() {	}
	public UserServiceImpl(UserDAO dao) {
		this.dao = dao;
	}
	public UserDAO getDao() {
		return dao;
	}
	public void setDao(UserDAO dao) {
		this.dao = dao;
	}

	@Override
	public UserVO login(String id, String pw) {
		return dao.login(id, pw);
	}
	@Override
	public int addUser(UserVO user) {
		return dao.addUser(user);
	}
	@Override
	public UserVO getUser(String userid) {
		return dao.getUser(userid);
	}
	@Override
	public List<UserVO> getUserList() {
		return dao.getUserList();
	}
	@Override
	public int updateUser(UserVO user) {
		return dao.updateUser(user);
	}
	@Override
	public int removeUser(String userid) {
		return dao.removeUser(userid);
	}
	@Override
	public List<UserVO> searchUser(String condition, String keyword) {
		return dao.searchUser(condition, keyword);
	}
	
		
}
