<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>hello.jsp</title>
</head>
<body>
	<h2>hello.jsp 페이지 입니다.</h2>
		<%
		request.setCharacterEncoding("utf-8"); // 한글 깨짐 해결 1
		response.setContentType("text/html;charset=utf-8"); 
		// 한글깨짐 해결 2; 첫줄에 있어 없어도 무관
		
		String name = request.getParameter("name");
		if(name != null){
		%>
			<h3> 당신의 성은 : <%= name.charAt(0)%> </h3>
		<%
		}
		String addr = request.getParameter("addr");
		%>
	<h3> 당신의 주소는 :<%= addr %> </h3>
</body>
</html>