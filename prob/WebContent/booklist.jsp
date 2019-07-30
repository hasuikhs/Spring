<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> Book List el</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script>
</script>
</head>
<body>
<h2> Book List el</h2>
<h3>로그인 정보 : ${login} 
<a href="logout.do">로그아웃</a>
<a href="index.jsp">HOME</a>
</h3>
<form action="./deleteServlet.do" method="post">

	<table border="1">
		<tr><th>책번호</th><th>제목</th><th>저자</th><th>가격</th><th>출판일</th>
		<th><input type="submit"  value="삭제"></th></tr>
			<c:forEach var="book" items="${list}">
			<tr>
			<td>${book.bookno}</td><td>${book.title}</td>
			<td>${book.author}</td><td>${book.price}</td><td>${book.pubdate}</td>
			<td><input type="checkbox" name="delete" value="${book.bookno}"></td></tr>
			</c:forEach>
	</table>
</form>

</body>
</html>