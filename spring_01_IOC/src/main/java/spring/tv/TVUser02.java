package spring.tv;

public class TVUser02 {
	public static void main(String[] args) {
		//TV user = TVFactory.getlgTV();
		TV user = (TV) TVFactory.getBean("samsung"); // TV 캐스팅
		user.on();
		
		
	}
}
