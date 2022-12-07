<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ch14:error-ch14.jsp</title>
</head>

<jsp:useBean id="now" class="java.util.Date" />

<body>
<div align="center">
	<h2>ch14 : error_ch14.jsp</h2>
	<hr>
	
	<table>
		<tr style="width: 100%; background-color: aqua;">
			<td>관리자에게 문의해주세요.<br>
				빠른 시일 내에 복구하겠습니다.</td>
		</tr>
		<tr>
			<td>${now}<p>
				요청 실패 URI : ${pageContext.errorData.requestURI}<br>
				상태 코드 : ${pageContext.errorData.statusCode}<br>
				예외 유형 : ${pageContext.errorData.throwable}</p>
			</td>
		</tr>
	</table>
</div>
</body>
</html>