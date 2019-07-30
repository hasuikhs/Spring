package spring.tv;

public class TVUser01 {
	public static void main(String[] args) {
		TV user = new lgTV();
		user.on();
		
		user = new samsungTV();
		user.on();
	}
}
