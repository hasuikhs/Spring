# Spring Framework Annotation

- **XML : 분리**

  - 결합도를 낮추고 유지보수성을 높이기 위해 XML로 설정하였으나 XML이 너무 많아지면 오히려 유지보수성이 낮아진다.

  - **유지보수성**에 방점
  - 시스템 전체에 영향을 주고 이후에 변경 가능성이 있는 것은 xml로 설정

## @Component

- `<context:component-scan>` 태그를 추가하면 어노테이션이 적용된 클래스를 빈으로 등록
- `<context:annotation-config>`태그는 어노테이션과 관련해서 BeanPostProcessor를 함께 등록
- @Required(RequiredAnnotationPostProcessor)
- @Autowired(AutowiredAnnotationBeanPostProcessor)
- @Resourdce, @PostConstruct, @PreDestroy(CommonAnnotationBeanPostProcessor)
- @Configuration(ConfigurationClassPostProcessor)
- 그 외 Repository, Service, Controller 포함
- `<context:component-scan base-package="xxx"/>`
  - xxx 패키지 하위에 @Component로 선언된 클래스를 bean으로 자동 등록

## @Required

- Required는 필수 프로퍼티임을 명시하는 것으로 설정하지 않을 경우 빈 생성시 예외를 발생

```java
public class TestBean (
	
    @Required
    private TestDao testDao;
    
    public void setTestDao(TestDao testDao){
        this.testDao = testDao;
    }
)
```

- RequiredAnotationBeanPotsProcessor 클래스는 스프링 컨테이너에 등록된 bean 개체를 조사하여 @Required 어노테이션으로 설정되어 있는 프로퍼티의 값이 설정되어 있는지 검사한다.
- 사용하려면 `<context:annotation-config>` 태그를 사용

## @Autowired

- 의존관계를 자동설정할 때 사용하여 타입을 이용하여 의존하는 객체를 삽입

- 같은 타입의 빈이 2개 이상 존재하게 되면 예외가 발생하는데 이럴때는 @Qualifier를 사용

  ```java
  @Autowired
  @Qualifier("test")
  private Test test;
  ```

## @Qualifier

- @Autowired와 함께 사용
- @Autowired 동일 타입의 빈객체가 존재시 특정 빈을 삽입할 수 있게 설정

## @Resource

- @Autowired와 흡사하지만 @Autowired(by type), @Resource(by name)로 연결한다는 점이 다르다.
- @Resource(name="test")

## @Scope

```java
@Component
@Scope(value="prototype")
public class User(){}
```

## @PostConstruct

- 의존하는 객체를 설정한 이후에 초기화 작업을 수행하기 위해 사용. 스프링에 의해 인스턴스가 생성된 후 어노테이션이 적용된 메서드 호출

## @PreDestroy

- 컨테이너에서 객체를 제거하기 전에 해야할 작업을 수행하기 위해 사용

## @Service

- 비즈니스 로직이 들어가는 Service 빈 등록

## @Repository

- 일반적으로 DAO에 사용되며 DB Exception을 DataAccessException으로 변환

## @Controller

- Spring MVC의 Controller 클래스 선언을 단순화
- 스프링 컨트롤러, 서블릿을 상속할 필요가 없다.
- @Controller로 등록된 클래스 파일에 대한 bean을 자동으로 생성해준다.