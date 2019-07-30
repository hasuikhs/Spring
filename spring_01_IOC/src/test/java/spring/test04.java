package spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.biz.user.service.UserService;

public class test04 {

	public static void main(String[] args) {
		
		String[] config = {"user.xml"/*,"applicationContext.xml"*/}; // user.xml 파일의 빈즈들을 불러옴
		ApplicationContext context =  
				// ApplicationContext 를 역할을 간단히 설명하자면 오브젝트 생성, 관계설정
				//, 만들어지는 방식, 자동생성, 후처리등 여러가지 일들을 한다. 
				new ClassPathXmlApplicationContext(config);
		
		UserService service = (UserService) context.getBean("userservice");
		System.out.println(service.login("admin", "a1234"));
		
		//context.getBean("lg"); // lg를 불러오기 위해서 config에 applicationContext.xml을 호출
		//System.out.println(context.getBean("user01"));
		//System.out.println(context.getBean("user02"));
		//System.out.println(context.getBean("user03"));
	}
}
