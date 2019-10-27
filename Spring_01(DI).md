## Spring_01(DI)

### 1. DI_Ex(01)

- Calcul.java

  ```java
  package com.javalec.ex;
  
  public class Calcul {
  	public void add(int f, int s) {
  		System.out.println("add()");
  		int result = f + s;
  		System.out.println(f + " + " + s + " = " + result);
  	}
  	public void sub(int f, int s) {
  		System.out.println("sub()");
  		int result = f - s;
  		System.out.println(f + " - " + s + " = " + result);
  	}
  	public void mul(int f, int s) {
  		System.out.println("mul()");
  		int result = f + s;
  		System.out.println(f + " * " + s + " = " + result);
  	}
  	public void div(int f, int s) {
  		System.out.println("div()");
  		int result = f / s;
  		System.out.println(f + " / " + s + " = " + result);
  	}
  }
  ```

- MyCalcul.java

  ```java
  package com.javalec.ex;
  
  public class MyCalcul {
  	private Calcul calcul;
  	private int firstNum;
  	private int secondNum;
  	
  	public Calcul getCalcul() {
  		return calcul;
  	}
  	public void setCalcul(Calcul calcul) {
  		this.calcul = calcul;
  	}
  	public int getFirstNum() {
  		return firstNum;
  	}
  	public void setFirstNum(int firstNum) {
  		this.firstNum = firstNum;
  	}
  	public int getSecondNum() {
  		return secondNum;
  	}
  	public void setSecondNum(int secondNum) {
  		this.secondNum = secondNum;
  	}
  	
  	public void add() {
  		calcul.add(firstNum, secondNum);
  	}
  	public void sub() {
  		calcul.sub(firstNum, secondNum);
  	}
  	public void mul() {
  		calcul.mul(firstNum, secondNum);
  	}
  	public void div() {
  		calcul.div(firstNum, secondNum);
  	}
  }
  ```

- applicationContext.xml

  ```xml
  <?xml version="1.0" encoding="UTF-8"?>
  <beans xmlns="http://www.springframework.org/schema/beans"
  	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
  	xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">
  	
      <--! Calcul.java 클래스를 bean화 -->
  	<bean id="calcul" class="com.javalec.ex.Calcul"/>
  	
      <--! MyCalcul.java 클래스를 bean화, calcul 변수를 bean이 calcul인 클래스를 참조--> 
  	<bean id="mycalcul" class="com.javalec.ex.MyCalcul">
  		<property name="calcul">
  			<ref bean="calcul"/>
  		</property>
          <!-- 각 변수마다 값을 넣어줌 -->
  		<property name="firstNum" value="10"/>
  		<property name="secondNum" value="2"/>
  	</bean>	
  </beans>
  ```

- MainClass.java

  ```java
  package com.javalec.ex;
  
  import org.springframework.context.support.AbstractApplicationContext;
  import org.springframework.context.support.GenericXmlApplicationContext;
  
  public class MainClass {
  	public static void main(String[] args) {
  		String configLoc = "classpath:applicationContext.xml";
  		AbstractApplicationContext ctx = 
              					new GenericXmlApplicationContext(configLoc);
  		MyCalcul myCalcul = ctx.getBean("mycalcul", MyCalcul.class);
  		
  		myCalcul.add();
  		myCalcul.sub();
  		myCalcul.mul();
  		myCalcul.div();
  	}
  }
  ```

- 생성자를 이용한 방법

  ```java
  // 예
  // 객체 생성자
  public Student(String name, String age, String gradeNum, String classNum){
      this.name = name;
      this.age = age;
      this.gradeNum = gradeNum;
      this.classNum = classNum;
  }
  
  // applicationContext.xml
  // 생성자의 순서대로 property를 넣어준다
  <bean id="student1" class="com.javalec.ex.Student">
  	<constructor-arg>
  		<value>홍길동</value>
  	</constructor-arg>
  	<constructor-arg>
  		<value>10살</value>
  	</constructor-arg>
  	<constructor-arg>
  		<value>3학년</value>
  	</constructor-arg>
  	<constructor-arg>
  		<value>20번</value>
  	</constructor-arg>
  </bean>
  <bean id="student2" class="com.javalec.ex.Student">
  	<constructor-arg value="홍길동" />
      <constructor-arg value="9살" />
      <constructor-arg value="2학년" />
      <constructor-arg value="10번" />
  </bean>
  
  // Main Class
  	String configLoc = "classpath:applicationContext.xml";
  	AbstractApplicationContext ctx = 
              					new GenericXmlApplicationContext(configLoc);
  	Student student1 = ctx.getBean("Student1", Student.class);
  	Student student2 = ctx.getBean("Student2", Student.class);
  ```

### 2. DI_Ex(02)

```java
/* BMICalculator.java */
public class BMICalculator {
	private double lowWeight;
	private double normal;
	private double overWeight;
	private double obesity;
	
	public void bmiCalculation(double weight, double height) {
		double h = height * 0.01;
		double result = weight / (h * h);
		
		System.out.println("BMI 지수 :" + (int)result);
		
		if (result > obesity){
			System.out.println("비만 입니다.");
		} else if (result > overWeight) {
			System.out.println("과체중 입니다.");
		} else if (result > normal) {
			System.out.println("정상 입니다.");
		} else {
			System.out.println("저체중 입니다.");
		}
        
        // ... getter & setter
	}
```

```java
/* Myinfo.java */
public class Myinfo {
	private String name;
	private double height;
	private double weight;
	private ArrayList<String> hobbys;
	private BMICalculator bmiCalculator;
    
    // ... getter & setter
    
    public void bmiCalculation() {
		bmiCalculator.bmiCalculation(weight, height);
	}
	
	public void getinfo() {
		System.out.println("이름 : " + name);
		System.out.println("키 : " + height);
		System.out.println("몸무게 : " + weight);
		System.out.println("취미 : " + hobbys);
		bmiCalculation();
	}
```

```xml
<!-- applicationContext.xml -->
<bean id="bmiCalculator" class="com.javalec.ex.BMICalculator">
		<property name="lowWeight">
			<value>18.5</value>
		</property>
		<property name="normal">
			<value>23</value>
		</property>
		<property name="overWeight">
			<value>25</value>
		</property>
		<property name="obesity">
			<value>30</value>
		</property>
	</bean>

	<bean id="myinfo" class="com.javalec.ex.Myinfo">
		<property name="name">
			<value>홍길동</value>
		</property>
		<property name="height">
			<value>187</value>
		</property>
		<property name="weight">
			<value>84</value>
		</property>
		<property name="hobby">
			<list>
				<value>수영</value>
				<value>요리</value>
				<value>독서</value>
			</list>
		</property>

		<property name="bmiCalculator">
			<ref bean="bmiCalculator" />
		</property>
	</bean>
```

```java
/* MainClass.java */
// 스프링 컨테이너의 이해
public class MainClass {
	public static void main(String[] args) {

		String configLocation ="classpath:applicationContext.xml";
        		
        // 스프링 컨테이너(IOC) 의 생성
		AbstractApplicationContext ctx = 
            						new GenericXmlApplicationContext(configLocation);
		// 스프링 컨테이너에서 컴포넌트 가져옴
        Myinfo myinfo = ctx.getBean("myinfo", Myinfo.class);
		myinfo.getinfo();
		
		ctx.close();
	}
}
```

