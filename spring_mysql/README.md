# SpringMVC + MySQL 설정 과정

- SpringMVC + MySQL + MyBatis + Log4j + lombok + HikariCP 

## 1. SpringMVC

### 1.1 프로젝트 생성

- **Spring Legacy Project** 선택

  ![image-20200111215144665](README.assets/image-20200111215144665.png)

- **Spring MVC Project**를 선택하고 프로젝트명을 적어준다.

  ![image-20200111215443732](README.assets/image-20200111215443732.png)

- 패키지명을 적고 마무리한다.

  - 패키지명은 보통 **도메인명을 뒤집어**서 한다.

  ![image-20200111215651111](README.assets/image-20200111215651111.png)

- 폴더 구조

  ![image-20200111220006759](README.assets/image-20200111220006759.png)

### 1.2 pom.xml 설정

- 현재 사용하는 jdk버전과 spring 버전을 맞춰준다.

  ```xml
  ...
  <properties>
  	<java-version>1.8</java-version>	<!-- 1.6 -> 1.8 -->
  	<org.springframework-version>5.2.2.RELEASE</org.springframework-version>
  	<org.aspectj-version>1.6.10</org.aspectj-version>
  	<org.slf4j-version>1.6.6</org.slf4j-version>
  </properties>
  ...
  <!-- 중략 -->
  ...
  <plugin>
  	<groupId>org.apache.maven.plugins</groupId>
      <artifactId>maven-compiler-plugin</artifactId>
      <version>2.5.1</version>
      <configuration>
      	<source>1.8</source>	<!-- 1.6 -> 1.8 -->
          <target>1.8</target>	<!-- 1.6 -> 1.8 -->
          <compilerArgument>-Xlint:all</compilerArgument>
          <showWarnings>true</showWarnings>
          <showDeprecation>true</showDeprecation>
      </configuration>
  </plugin>
  ...
  ```

### 1.3 오류 잡기

- 이클립스 하단의 Martkers를 보면 현재 다양한 오류들을 이클립스에서 경고를 하고있다.

  ![image-20200111221234000](README.assets/image-20200111221234000.png)

#### 1.3.1 Java Version 문제

- **프로젝트를 우클릭**하고 **Maven - Update Project...**

  ![image-20200111221601270](README.assets/image-20200111221601270.png)

- 이렇게 진행하면 java compiler와 build path version 오류는 사라진다.

  ![image-20200111221736012](README.assets/image-20200111221736012.png)

#### 1.3.2 log4j 파일 경로 문제

- 해당 오류를 **더블클릭**하면 해당 오류로 갈 수 있다.

- 수정 전

  ```xml
  <!DOCTYPE log4j:configuration PUBLIC "-//APACHE//DTD LOG4J 1.2//EN" "log4j.dtd">
  ```

- 수정 후

  ```xml
  <!DOCTYPE log4j:configuration SYSTEM "http://logging.apache.org/log4j/1.2/apidocs/org/apache/log4j/xml/doc-files/log4j.dtd">
  ```

- 이렇게 진행하면 우선 기본 Spring MVC 오류들을 해결 가능하다.

  ![image-20200111222556716](README.assets/image-20200111222556716.png)