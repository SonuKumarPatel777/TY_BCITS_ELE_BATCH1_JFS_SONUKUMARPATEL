<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <jsp:include page="index.jsp"/>
 <% String errMsg = (String) request.getAttribute("errMsg");
String msg = (String) request.getAttribute("msg");%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Spring Security Register</title>
</head>
<body>
     <fieldset>
		<legend>Register</legend>
		<form action="./register" method="post">
			<table>
			<tr>
			   <td>Employee ID</td>
			   <td>:</td>
			   <td><input type= "number" name="empId" required></td>
			</tr>
			<tr>
			   <td>Name</td>
			   <td>:</td>
			   <td><input type= "text" name="name" required></td>
			</tr>
			<tr>
			   <td>Password</td>
			   <td>:</td>
			   <td><input type= "text" name="password" required></td>
			</tr>
			<tr>
			   <td>Role</td>
			   <td>:</td>
			   <td><input type= "radio" name="role" value="ROLE_USER">User</td>
			</tr>
			<tr>
			   <td></td>
			   <td></td>
			   <td><input type= "radio" name="role" value="ROLE_ADMIN">Admin</td>
			</tr>
			
			<tr>
			   <td></td>
			   <td></td>
			   <td><input type= "submit"  value="Register"></td>
			</tr>
			</table>
		</form>
	</fieldset>
	<div align="center">
	<% if(msg != null && !msg.isEmpty()){ %>
   <h2 style="color: green;"  ><%= msg %></h2>
   <%} %>

   <% if(errMsg != null && !errMsg.isEmpty()){ %>
   <h2 style="color: red;" ><%= errMsg %></h2>
   <%} %>
	</div>
</body>
</html>