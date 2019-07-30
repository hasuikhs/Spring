package spring;

import org.junit.Before;
import org.junit.Test;

import spring.biz.user.dao.UserDAO;
import spring.biz.user.dao.UserDAO_JDBC;
import spring.biz.user.service.UserService;
import spring.biz.user.service.UserServiceImpl;
import spring.biz.user.vo.UserVO;

public class test03_UserService {
	UserService service;
	@Before
	public void setUp() throws Exception {
		UserDAO dao = new UserDAO_JDBC();
		service = new UserServiceImpl(dao);
	}

	@Test
	public void login() {
		System.out.println(service.login("admin", "1234"));
		System.out.println(service.login("admin", "a1234"));
	}
	//@Test
	public void list() {
		for(UserVO vo : service.getUserList()) {
			System.out.println(vo);
		}
	}
	//@Test
	public void add() {
		UserVO user = new UserVO();
		user.setUserid("java02");
		user.setUsername("홍길동");
		user.setUserpwd("1234");
		user.setPhone("02-22");
		user.setEmail("2@2.com");
		user.setAddress("서울");
		service.addUser(user);
		int row = service.addUser(user);
		System.out.println("insert => "+ row);
	}
	//@Test
	public void update() {
		UserVO user = service.getUser("java01");
		user.setUserpwd("9999");
		int row = service.updateUser(user);
		
		System.out.println("update" + row);
	}
	//@Test
	public void getUser() {
		System.out.println(service.getUser("java01"));
		
	}
	//@Test
	public void searchUser() {
		for(UserVO vo : service.searchUser("username", "길")) {
			System.out.println(vo);
		}
	}
	//@Test
	public void removeUser(){
		int row = service.removeUser("java01");
		System.out.println("removeUser "+ row);
	}
}
