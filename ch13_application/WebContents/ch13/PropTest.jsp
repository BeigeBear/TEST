<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>PropTest`</title>
</head>
<body>
<div align="center">
	<h2>Properties 연계</h2>
	<hr>
	버전 : ${prop.get('version') } <br>
	url : ${prop.get('url') } <br>
	user : ${prop.get('user') } <br>
	password : ${prop.get('passwd') } <br>
	
</div>
</body>
</html>