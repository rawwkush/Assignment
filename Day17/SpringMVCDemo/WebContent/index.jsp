<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="hi" method="post">
	Username: <input type="text" name="txtuser"/>
	Password: <input type="password" name="txtpass"/>
	<input type="submit">
</form>
<% String message=(String) request.getAttribute("message");
if(message!=null){
	out.println(message);
}
%>
<% String val =(String) request.getAttribute("value");
if(val != null){
	out.println(val);
}
%>
</body>
</html>