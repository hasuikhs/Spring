package spring.tv;

public class TVFactory {
	public static TV getlgTV(){
		return new lgTV();
	}
	public static TV getsamsungTV(){
		return new samsungTV();
	}
	
	public static Object getBean(String beanname){
		if(beanname.equals("samsung")){
			return new samsungTV();
		} else {
			return new lgTV();
		}
	}
}
