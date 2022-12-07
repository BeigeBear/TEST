<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CH14: 404-error.jsp</title>
</head>
<body>
<div align="center">
	<h2>ch14 : 404-error.jsp</h2>
	<hr>
	
	<table>
		<tr style="width: 100%; background-color: aqua; ">
			<td>요청하신 파일을 찾을 수 없습니다.<br>
			URL 주소를 다시 한 번 확인해주세요!!</td>
		</tr>
		<tr>
			<td>${now}<p>
			요청실패 URI : ${pageContext.errorData.requestURI}<br>
			상태 코드 : ${pageContext.errorData.statusCode}<br>
			</td>
		</tr>		
	</table>
</div>
</body>

</html>