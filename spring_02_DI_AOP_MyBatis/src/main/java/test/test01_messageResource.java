package test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.biz.user.service.UserService;
import spring.biz.user.vo.UserVO;

public class test01_messageResource {

	public static void main(String[] args) {
		String[] config = {"applicationContext.xml"};
		ApplicationContext context = new ClassPathXmlApplicationContext(config);
		
		UserService service = (UserService) context.getBean("userservice");
		//service.login("admin", "1234");
		UserVO vo = service.login("admin", "a1234");
		
		System.out.println(vo);
		service.getUser("admin");

		//System.out.println(context.getMessage("hello", null, Locale.ENGLISH));
		//System.out.println(context.getMessage("hello", null, Locale.KOREA));
		
		//String msg = context.getMessage("login.fail", new Object[] {"java01"}, Locale.KOREA);
		//System.out.println(msg);
	}

}
