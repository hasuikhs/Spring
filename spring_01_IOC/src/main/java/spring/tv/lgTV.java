package spring.tv;

public class lgTV implements TV{

	public lgTV(){
		System.out.println("lgTV() 생성");
	}
	@Override
	public void on() {
		System.out.println("lgTV on");
	}

	@Override
	public void off() {
		System.out.println("lgTV off");
	}
	public void init() {
		System.out.println("lgTV init() 초기화작업");
	}
	public void destroy() {
		System.out.println("lgTV destroy() 자원 반납...");
	}
}
