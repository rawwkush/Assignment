<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dictionary Word:</title>
</head>
<body>
<h2>Add Word to dictionary</h2><br/>
<form action="dictionaryAddWordServlet">
	Word: <input type="text" name="txtWord"><br/>
	Meaning: <input type="text" name="txtMean"><br/>
	<input type="submit" value="Add Word to Dictionary"/>
</form>

<h2>Search Word from dictionary</h2>
<form action="FindWordFromDictionaryServlet">
	Word: <input type="text" name="txtSearchWord">
 	<input type="submit" value="Search">
</form>

<%
out.println(request.getAttribute("result"));
%>

</body>
</html>