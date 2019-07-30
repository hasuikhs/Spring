<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>hello jsp</title>
</head>
<body>
<h3>  hello jsp</h3>
<h3> 메세지 :  ${msg}</h3>
<h4>
<a href="${pageContext.request.contextPath}/logout.do">로그아웃</a>
<a href="${pageContext.request.contextPath}/index.jsp">Home</a>

</h4>
</body>
</html>