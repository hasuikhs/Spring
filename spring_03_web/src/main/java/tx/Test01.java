package tx;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.biz.user.vo.UserVO;

public class Test01 {

	public static void main(String[] args) {
		String[] config = {"applicationContext.xml"};
		ApplicationContext context = new  ClassPathXmlApplicationContext(config);
		
		UserService service = (UserService) context.getBean("txservice");
		
		UserVO vo = new UserVO("jjava01", "짜바", "1aA!", "e@e.com", "02-000-0000", "서울");
		service.addUser(vo, true);
		service.print();
	}

}
