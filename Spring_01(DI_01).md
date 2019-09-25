## Spring_01(DI_01)

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

  

