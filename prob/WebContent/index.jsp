<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>menu 클릭하세요</h2>
	<ul>
		<c:if test="${empty login}">
			<li><a href="./login.jsp">로그인</a></li>
		</c:if>
		<c:if test="${!empty login}">
			<li><a href="./logout.do">로그아웃</a></li>
			<li><a href="./bookform.html">도서등록</a></li>
			<li><a href="./list.do">도서목록</a></li>
		</c:if>
	</ul>
</body>
</html>