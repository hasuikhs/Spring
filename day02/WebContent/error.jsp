<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page isErrorPage="true" %> <!-- 에러를 관리하는 전용 페이지 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>error.jsp</title>
</head>
<body>
	<h2>Error Page</h2>
	<h3 style="color:red">서버 점검중입니다. 다음에 이용해 주세요.</h3>
	<%
		if(exception == null){
			exception = (Throwable)request.getAttribute("exception");
		}
	%>
	<div style="color:red"><%= exception %></div>
</body>
</html>