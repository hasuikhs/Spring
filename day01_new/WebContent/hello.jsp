<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page errorPage="error.jsp" %> <!-- 에러시 error.jsp 호출 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> </title>
</head>
<body>

<%! //선언부
	public int sum(int a, int b){
		return a+b;
	}
%> 
<h2> basic jsp</h2>
합계 : <%= sum(11, 89) %>
<%-- <%= exception %> --%>
<%
	int num = 3/0;
%>
</body>
</html>