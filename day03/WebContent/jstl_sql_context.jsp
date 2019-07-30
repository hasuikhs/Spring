<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSTL SQL Context Datasource lookup</title>
</head>
<body>

<sql:query var="rs" dataSource="jdbc/oracle">
    select * from userinfo
</sql:query>
<table border="1">
		<tr>
			<c:forEach var="columnName" items="${rs.columnNames}">
				<th><c:out value="${columnName}" /></th>
			</c:forEach>
		</tr>

		<c:forEach var="row" items="${rs.rows}">
			<tr>
				<td><c:out value="${row.userid}" /></td>
				<td><c:out value="${row.address}" /></td>
				<td><c:out value="${row.email}" /></td>
				<td><c:out value="${row.phone}" /></td>
				<td><c:out value="${row.username}" /></td>
				<td><c:out value="${row.userpwd}" /></td>
				
			</tr>
		</c:forEach>

</table>

</body>
</html>