<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
 <meta name="viewport" content="width=device-width, initial-scale=1">
<title>login</title>
<style>
	talbe, td{
		border: 1px solid black;
	}
	table{
		width:60%;
		height:100px;
		margin:auto;
		text-align: center;
	}
</style>
</head>
<body>
<form id="form1" name="form1" action="./login.do" method="post" onsubmit="return check()">
	<table>
		<tr>
			<td colspan="2">
			<span style="color:red">${msg}</span>
		</tr>
		<tr>
			<td>ID</td>
			<td><input type="text" id="id" name="id" required="required"></td>
		</tr>
		<tr>
			<td>PW</td>
			<td><input type="password" id="pw" name="pw" required="required" 
						pattern="^((?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[^a-zA-Z0-9]).{4,7})$"></td>
		</tr>
		<tr align="center">
			<td colspan="2">
				<input type="submit" value="로그인">
				<input type="reset" value="취소">
			</td>
		</tr>
		<tr align="center">
			<td colspan="2">
				<a href="#">회원가입</a>
			</td>
		</tr>
	</table>
</form>
</body>
</html>