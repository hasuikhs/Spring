package spring.tv;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

public class TVUser03 {
	public static void main(String[] args) {
		String config = "applicationContext.xml";
		BeanFactory factory = 
				new XmlBeanFactory(new ClassPathResource(config));
		
		TV user = (TV) factory.getBean("lg");
		user.on();
		
	}
}
