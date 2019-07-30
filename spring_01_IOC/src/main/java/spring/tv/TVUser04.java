package spring.tv;

import java.util.Calendar;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TVUser04 {
	public static void main(String[] args) {
		String[] config = {"applicationContext.xml"};
		//BeanFactory factory = 
		//		new XmlBeanFactory(new ClassPathResource(config));
		
		ApplicationContext applicationcontext = new ClassPathXmlApplicationContext(config);
		
		TV user = (TV) applicationcontext.getBean("lg");
		user.on();
		
		TV user2 = applicationcontext.getBean("lg",TV.class);
		user2.on();
		
		System.out.println("singletone ? " + (user == user2));
		
		Calendar now = (Calendar) applicationcontext.getBean("now");
		
	}
}
