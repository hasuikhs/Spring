# Spring in VS Code

> https://myjamong.tistory.com/123?category=835076
>
> https://myjamong.tistory.com/155


## 0. 사전 작업
### 0.1 메이븐 설치

- Binary zip archive 파일 [다운로드](https://maven.apache.org/download.cgi#) 

- 적절한 위치에 압축 해제

- 환경 변수 설정

  - 새로 만들기

    ![image-20200629213903831](Spring_in_VS_Code.assets/image-20200629213903831.png)

  - 새 시스템 변수

    ![image-20200629214110801](Spring_in_VS_Code.assets/image-20200629214110801.png)

  - 시스템 변수 목록에서 **Path**를 찾아 클릭하고 **편집**

  - 변수 값 맨 앞 부분에 `%MAVEN_HOME%bin;` 추가

    ![image-20200629214543107](Spring_in_VS_Code.assets/image-20200629214543107.png)

  - 확인

    ```bash
    $ mvn -version
    
    Apache Maven 3.6.3 (cecedd343002696d0abb50b32b541b8a6ba2883f)
    Maven home: C:\Users\STU\Documents\Dev\apache-maven-3.6.3\bin\..
    Java version: 1.8.0_211, vendor: Oracle Corporation, runtime: C:\Program Files\Java\jdk1.8.0_211\jre
    Default locale: ko_KR, platform encoding: MS949
    OS name: "windows 10", version: "10.0", arch: "amd64", family: "windows"
    ```

### 0.2 Tomcat 설치

- [다운로드](https://tomcat.apache.org/download-90.cgi)

- VS Code 좌측 하단에 TOMCAT SERVERS

  ![image-20200629221316336](Spring_in_VS_Code.assets/image-20200629221316336.png)

- 지정 후

  ![image-20200629221341225](Spring_in_VS_Code.assets/image-20200629221341225.png)

- 서버 동작 확인

  - 우클릭 후 Start

  ![image-20200629221507908](Spring_in_VS_Code.assets/image-20200629221507908.png)

## 1. 확장 프로그램 설치

- Checkstyle for Java
- Java Dependency Viewer
- Java Extension Pack
- JavaScript (ES6) code snippets
- Maven for Java
- Tomat for Java
- Spring Initializr Java Support
- Spring boot Extension Pack

## 2. 프로젝트 생성

- `f1`을 눌러 spring initializr 검색 - maven or gradle 선택

  - 기본적으로 `Spring Boot DevTools`와 `Spring Web` 선택해야 웹 어플리케이션 프로젝트 시작 가능

- pom.xml에서 dependency 추가

  ```xml
  <dependency>
  	<groupId>org.apache.tomcat.embed</groupId>
      <artifactId>tomcat-embed-jasper</artifactId>
  </dependency>
  ```

- application.properties 내 다음 코드 추가

  - `server.servlet.context-path`로 프로젝트의 기본 루트 설정

  ```
  server.servlet.context-path=/<prj-name>
  
  spring.mvc.view.prefix=/WEB-INF/jsp/
  spring.mvc.view.suffix=.jsp
  ```

- view(jsp) 추가

  - `\src\main` 내에 `\WEB-INF\jsp`를 추가

- HelloController.java 생성 후 아래 코드 입력

  ```java
  import org.springframework.stereotype.Controller; 
  import org.springframework.web.bind.annotation.RequestMapping; 
  import org.springframework.web.bind.annotation.RequestMethod; 
  import org.springframework.web.bind.annotation.ResponseBody; 
  import org.springframework.web.servlet.ModelAndView; 
  @Controller 
  public class HelloController {
      @RequestMapping("/") 
      @ResponseBody 
      public String index() { 
          return "Hello, Spring"; 
      } 
  }
  ```

  