<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>Result</h2>
<%
	String val = (String) request.getAttribute("result");
	
	if(val!=null){
		out.println(val);	
	}	
%>
</body>
</html>