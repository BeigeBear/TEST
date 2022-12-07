<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    errorPage="addrbook_error.jsp" 
    import="com.addrbook.model.*, java.util.*" %>
     
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="addrbook.css" type="text/css" media = "screen" />
	<title>주소록 : 목록</title>
</head>

<body>
<div align = "center">
	<h2>주소록 : 목록</h2>
	<hr>
	<a href = addrbook_form.jsp >주소록 등록</a><p>
	
	<form>
	<table border="1">
		<tr bgcolor="#99CCFF">
			<tr>
			<th>번호</th>
			<th>이름</th>
			<th>전화번호</th>
			<th>생일</th>
			<th>회사</th>
			<th>메모</th>
			<th>비고</th>
			</tr>
			
			<%
				ArrayList<AddrDto> List = (ArrayList<AddrDto>) request.getAttribute("addrList");
				if(List != null) {
					for(AddrDto addr : List) {
			 %>
				<tr>
					<td><%= addr.getId() %> </td>
					<td> <%=addr.getEmail() %> </td>
					<td> <%=addr.getComdept() %> </td>
					<td> <%=addr.getBirth() %> </td>
					<td> <%=addr.getTel() %> </td>
					<td> <%=addr.getMemo() %> </td>
					<td> <a href="addrbook_edit_form.jsp?id=<%=addr.getId() %>" >수정</a></td>
				</tr>
			<%
					}
				}
			%>
	</table>2
	</form>
		
</div>
</body>

</html>