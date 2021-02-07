<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% 
	out.println("Welcome, " + request.getAttribute("message"));
%>
	
<form action="calculate" method="post">
	Number1: <input type="number" name="firstNum"/>
	Number2: <input type="number" name="secondNum"/>
	<input type="submit">
</form>
	
</body>
</html>