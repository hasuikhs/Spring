# Spring_02(Life Cycle)

- 스프링 컨테이너 생명 주기

```java
// 스프링 컨테이너 생성
GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();

// 스프링 컨테이너 설정
ctx.load("classpath:applicationContext.xml");
ctx.refresh();

// 스프링 컨테이너 사용
Student student = ctx.getBean("student", Student.class);
System.out.println("이름 : " + student.getName());

// 스프링 컨테이너 종료
ctx.close();
```

- 스프링 빈 생명 주기

  - `ctx.refresh()` 를 진행 할때 `afterPropertiesSet()`이라는 메서드가 실행된다.
  - `ctx.close()` 의 경우 컨테이너가 소멸하는 단계이다.
    - 컨테이너가 소멸하면, 빈은 자동으로 소멸된다.
    - 빈만 소멸 시키려면 , `student.destroy()`를 이용하자.

  ```java
  // 위의 메서드들을 사용하려면
  // 빈 초기화 인터페이스 IntializingBean
  public class Student implements InitializingBean{
      ...
      @Override
      public void afterPropertiesSet() throws Exception{
          System.out.println("afterPropertiesSet()");
      }
  }
  // 빈 종료 인터페이스 DisposableBean
  public class Student implements DisposalbleBean{
      ...
      @Override
      public void destroy() throws Exception{
          System.out.println("destroy()");
      }
  }
  ```

  - 두 가지를 같이 implements 받을 수도 있다.

- `@PostConstruct`, `@PreDestroy` 어노테이션 사용하기

  - 위 처럼 implements를 하지 않고 어노테이션으로도 빈의 생성과 파괴를 할 수 있다.

  ```java
  @PostConstruct
  public void initMethod(){
      ...
  }
  
  @PreDestroy
  public void destroyMethod(){
      ...
  }
  ```

  