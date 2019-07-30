<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> Book List el</title>
<script>

</script>
</head>
<body>
<h2> Book List el</h2>
	<div>
		<table border="1">
			<tr><th>책번호</th><th>제목</th><th>저자</th><th>가격</th><th>출판일</th></tr>
				<c:forEach var="book" items="${list}">
				<tr>
				<td>${book.bookno}</td><td>${book.title}</td>
				<td>${book.author}</td><td>${book.price}</td><td>${book.pubdate}</td>
				</tr>
				</c:forEach>
		</table>
	</div>	
</body>
</html>