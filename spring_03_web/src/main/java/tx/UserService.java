package tx;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import spring.biz.user.dao.UserDAO;
import spring.biz.user.vo.UserVO;

@Service("txservice") // 트렌젝션
public class UserService {
	
	@Resource(name = "mybatis")
	UserDAO dao;
	
	@Transactional // 트랜젝션 처리하면, 문제 발생시 롤백이 자동으로 이뤄진다
	public void addUser(UserVO user, boolean flag) {
		dao.addUser(user);
		System.out.println(user.getUserid() + " => insert 수행" );
	
		if(flag) {
			throw new RuntimeException("문제 발생");
		}
		
		user.setUserid(user.getUserid()+"**"); // 백업
		dao.addUser(user);
		System.out.println(user.getUserid() + " => insert 수행" );
	}
	
	public void print() {
		System.out.println("********** user list **********");
		for(UserVO data :dao.getUserList()) {
			System.out.println(data);
		}
	}
}
