<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Session Handling Using Coockie</title>
</head>
<body>
	<form action="loginServlet" method="post">
		Username:<input type="text" name="user">
		Password:<input type="password" name="pass">
		<input type="submit" value="ok">
	</form>
	
	<%
	try{
		out.println(request.getAttribute("message"));	
	}
	catch(Exception e){
		out.println("Error");
	}
	%>
</body>
</html>