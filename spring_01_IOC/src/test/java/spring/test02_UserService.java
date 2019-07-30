package spring;

import spring.biz.user.dao.UserDAO;
import spring.biz.user.dao.UserDAO_JDBC;
import spring.biz.user.service.UserService;
import spring.biz.user.service.UserServiceImpl;
import spring.biz.user.vo.UserVO;

public class test02_UserService {
	public static void main(String[] args) {
		
		//UserDAO_JDBC dao = new UserDAO_JDBC(); // 강력한 커플링
		UserDAO dao = new UserDAO_JDBC(); // 약한 커플링 변경 유동적
		// jdbc, spring, mybatis 으로도 가능 UserDAO를 인터페이스로 설계했기떄문에
		UserService service = new UserServiceImpl(dao);
		
		System.out.println(service.login("admin", "1234"));
		System.out.println(service.login("admin", "a1234"));
		System.out.println("-----------------------------");
		
		for(UserVO vo : service.getUserList()) {
			System.out.println(vo);
		}
	}
}
