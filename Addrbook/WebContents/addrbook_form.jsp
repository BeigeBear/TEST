<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    errorPage="addrbook_error.jsp"
    import="com.addrbook.model.*, java.util.*" %>
    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>주소록 : 작성화면</title>
	<link rel="stylesheet" href = "addrbook.css" type="text/css" media = "screen" />
</head>

<body>
<div align="center">
	<h2>주소록 : 작성화면</h2>
	<hr>
	<a href="/Addrbook/list.do">주소록 목록으로</a><p>
	
	<form name = form1
		method = post
		action = "/Addrbook/insert.do" >
	<table border="1">
		<tr>
		<th>이름</th>
		<td><input type="text" name = "name" maxlength="15"></td>
		</tr>
		
		<tr>
		<th>이메일</th>
		<td><input type="text" name = "email" maxlength="50"></td>
		</tr>
		
		<tr>
		<th>회사</th>
		<td><input type="text" name = "comdept" maxlength="20"></td>
		</tr>
		
		<tr>
		<th>생일</th>
		<td><input type="date" name = "birth"></td>
		</tr>
		
		<tr>
		<th>전화번호</th>
		<td><input type="text" name = "tel" maxlength="20"></td>
		</tr>
		
		<tr>
		<th>메모</th>
		<td><input type="text" name = "memo"></td>
		</tr>
		
		<tr>
		<td colspan=2 align=center>
		<input type = "submit" value="저장">
		<input type = "reset" value="취소">
		</td>
		</tr>
	</table>
	</form>
</div>

</body>
</html>