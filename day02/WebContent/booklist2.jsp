<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="vo.BookVO" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> Book List</title>
<script>

</script>
</head>
<body>
<h2> Book List </h2>
	<div>
		<table border="1">
			<tr><th>책번호</th><th>제목</th><th>저자</th><th>가격</th><th>출판일</th></tr>
			<% 
				List<BookVO> list = (List<BookVO>)request.getAttribute("list");
			   for(BookVO data: list){
			%>
				<tr>
				<td><%=data.getBookno() %></td>
				<td><%=data.getTitle()  %></td>
				<td><%=data.getAuthor() %></td>
				<td><%=data.getPrice() %></td>
				<td><%=data.getPubdate() %></td>
				
				<tr>
			<%
			   }
			%>
		</table>
	</div>	
</body>
</html>