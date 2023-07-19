<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="menu.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>all registration</title>
<script>
	function confirmDelete(email) {
		if (confirm("Are you sure you want to delete this record?")) {
			window.location.href = "deleteReg?email=" + email;
			return true;
		} else {
			return false;
		}
	}
</script>
</head>
<body>
	<h2>All Registration</h2>
	<table border="1">
		<tr>
			<th>Name</th>
			<th>City</th>
			<th>Email</th>
			<th>Mobile</th>
			<th>Action</th>
			<th>Action</th>
		</tr>

		<%
		ResultSet res = (ResultSet) request.getAttribute("result");
		while (res.next()) {
		%>
		<tr>
			<td><%=res.getString(1)%></td>
			<td><%=res.getString(2)%></td>
			<td><%=res.getString(3)%></td>
			<td><%=res.getString(4)%></td>
			<%-- <td> <a href="deleteReg?email=<%=res.getString(3)%>">delete</a></td> --%>
			<td><a href="#"
				onclick="return confirmDelete('<%=res.getString(3)%>')">delete</a></td>
			<td><a
				href="updateReg?email=<%=res.getString(3)%>&mobile=<%=res.getString(4)%>">update</a></td>



		</tr>
		<%
		}
		%>
	</table>
</body>
</html>