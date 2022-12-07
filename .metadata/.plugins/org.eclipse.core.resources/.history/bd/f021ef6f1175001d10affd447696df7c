<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" errorPage="addrbook_error.jsp" import="addrbook.*, java.util.*" %>
    
<jsp:useBean id="ab" scope="request" class="addrbook.AddrBook" />
    
<!DOCTYPE html>
<html>
<head>

<script language = JavaScript>
		function delcheck(){
			result = confirm("정말로 삭제하시겠습니까?");
			
		if(result){
			document.form1.action.value="delete";
			document.form1.submit();
		}
		else{
			return;
		}
			}

</script>


<meta charset="utf-8">
<link rel="stylesheet" href="addrbook.css" type="text/css" media="screen"/>
</head>
<title>주소록 : 수정화면</title>
<body>
<div align="center">
<h2>주소록 :수정화면</h2>
<hr>
[<a href=index.jsp>주소록 목록으로</a>]<p>
<form name=form1 method=post action=addrbook_control.jsp>
<input type=hidden name="ab_id" value="<%=ab.getAb_id()%>">
<input type=hidden name="action" value="update">

<table border="1">
	<tr>
	<th>이름</th>
	<td><input type="text" name = "ab_name" value="<%=ab.getAb_name() %>"></td>
	</tr>
	
	<tr>
	<th>email</th>
	<td><input type="text" name = "ab_email" value="<%=ab.getAb_email() %>"></td>
	</tr>
	
	<tr>
	<th>전화번호</th>
	<td><input type="text" name = "ab_tel" value="<%=ab.getAb_tel() %>"></td>
	</tr>
	
	<tr>
	<th>생일</th>
	<td><input type="date" name = "ab_birth" value="<%=ab.getAb_birth() %>"></td>
	</tr>
	
	<tr>
	<th>회사</th>
	<td><input type="text" name = "ab_comdept" value="<%=ab.getAb_comdept() %>"></td>
	</tr>
	
	<tr>
	<th>메모</th>
	<td><input type="text" name = "ab_memo" value="<%=ab.getAb_memo() %>"></td>
	</tr>
	
	<tr>
	<td colspan=2 align=center>
	<input type = "submit" value="저장">
	<input type = "reset" value="취소">
	<input type="button" value="삭제" onClick="delcheck()"></td>
	</tr>

</table>


</form>





</div>

</body>
</html>

  TCP    0.0.0.0:8080           DESKTOP-I2SNO5K:0      LISTENING       5976
    TCP    0.0.0.0:9090           DESKTOP-I2SNO5K:0      LISTENING       17492
      TCP    127.0.0.1:8005         DESKTOP-I2SNO5K:0      LISTENING       17492