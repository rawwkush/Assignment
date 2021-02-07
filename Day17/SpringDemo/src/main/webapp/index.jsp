<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>Employee Details</h2><br/>
	<form action="add" method="post">
		Id:<input type="text" name="id"/><br/>
		Name:<input type="text" name="name"/><br/>
		Salary:<input type="text" name="salary"/><br/>
		<input type="submit" value="Add">
		<input formaction="delete" formmethod="get" type="submit" value="Delete">
		<input formaction="update" formmethod="get" type="submit" value="Update">
		<input formaction="getemp" formmethod="get" type="submit" value="getEmployee">
		<input formaction="getall" formmethod="get" type="submit" value="All Employee"> 
	</form>
</body>
</html>