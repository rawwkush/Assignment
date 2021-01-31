<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="/WEB-INF/myFile.tld" prefix="my"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form>
		<input type="number" name="data"/><br/>
		<input type="submit"/>
	</form>
	
	<%! String s="0";
	%>
	<%
		s=request.getParameter("data");
	if(s==null){
		s="0";
	}
	%>
	
	<my:hello message="<%=s%>"></my:hello>
</body>
</html>