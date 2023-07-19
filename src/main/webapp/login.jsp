<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>login</title>
<link rel="stylesheet" href="style.css">
</head>
<body>
<h2>Login here...</h2>
<form action="verifylogin" method="post">

<b>Username :</b> <input type="text" name="email"/> <br>
 <b>Password :</b> <input type="password" name="password"/><br>
 <input type="submit" value="login"/>
</form>
<%
if(request.getAttribute("error") != null){
out.println(request.getAttribute("error"));
}
%>
</body>
</html>