package spring.tv;

public class samsungTV implements TV{

	public samsungTV() {
		System.out.println("samsungTV() 생성");
	}
	@Override
	public void on() {
		System.out.println("samsungTV on");
	}

	@Override
	public void off() {
		System.out.println("samsungTV off");
	}

}
