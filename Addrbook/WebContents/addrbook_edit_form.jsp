<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="com.addrbook.model.*, java.util.*" %>
<%--     errorPage="addrbook_error.jsp" --%>
    
<jsp:useBean id="addr" scope="request" class="com.addrbook.model.AddrDto" />
<jsp:useBean id="Dao" scope="request" class="com.addrbook.model.AddrDao" />

<% addr = Dao.readById(Integer.parseInt(request.getParameter("id"))); %>
<% session.setAttribute("editId", request.getParameter("id")); %>

<!DOCTYPE html>
<html>

<head>
	<script>
		function delcheck(){
			result = confirm("정말로 삭제하시겠습니까?");
					
			if(result){
				document.location.href="/Addrbook/delete.do";
			}
			else {
				return;
			}
		}
	</script>
		
	<meta charset="UTF-8">
	<link rel="stylesheet" href="addrbook.css" type="text/css" media="screen"/>
</head>

<title>주소록 : 수정화면</title>

<body>
<div align ="center">
	<h2>주소록 : 수정화면</h2>
	<hr>
	<a href = /Addrbook/list.do >주소록 목록</a><p>
	
	<form name = form1
		method = post
		action = /Addrbook/update.do >
	
	<table border="1">
		<tr>
		<th>이름</th>
		<td><input type="text" name = "name" value="<%=addr.getName() %>" ></td>
		</tr>
		
		<tr>
		<th>이메일</th>
		<td><input type="text" name = "email" value="<%=addr.getEmail() %>" ></td>
		</tr>
		
		<tr>
		<th>회사</th>
		<td><input type="text" name = "comdept" value="<%=addr.getComdept() %>"></td>
		</tr>
		
		<tr>
		<th>생일</th>
		<td><input type="date" name = "birth" value="<%=addr.getBirth() %>"></td>
		</tr>
		
		<tr>
		<th>전화번호</th>
		<td><input type="text" name = "tel" value="<%=addr.getTel() %>"></td>
		</tr>
		
		<tr>
		<th>메모</th>
		<td><input type="text" name = "memo" value="<%=addr.getMemo() %>"></td>
		</tr>
		
		<tr>
		<td colspan=2 align=center>
		<input type ="submit" value ="저장">
		<input type ="reset"  value ="취소">
		<input type ="button" value ="삭제" onClick="delcheck()"></td>
		</tr>
	
	</table>
	</form>
</div>
</body>

</html>
