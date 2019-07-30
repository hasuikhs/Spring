package test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.biz.user.service.UserService;
import spring.biz.user.vo.UserVO;

public class Test01_MessageResouce {

	public static void main(String[] args) {
		String[] config = {"applicationContext.xml"};
		ApplicationContext context = 
				new ClassPathXmlApplicationContext(config);
		
		//System.out.println(context.getMessage("hello",null,Locale.ENGLISH));
		//System.out.println(context.getMessage("hello",null,Locale.KOREA));
		
		//String msg = context.getMessage("login.success",
				                   //     new Object[] {"java01"},
				                   //     Locale.KOREA);
		
		//System.out.println(msg);
		
        UserService service = 
        		(UserService) context.getBean("userservice");
        
        UserVO vo =  service.login("admin", "a1234");
        //service.login("admin", "1234");
        System.out.println("===================");
        System.out.println(vo);
		
	}
}
