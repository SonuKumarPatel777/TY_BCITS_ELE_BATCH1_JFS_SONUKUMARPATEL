<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <jsp:include page="header.jsp"></jsp:include>
    <% String errMsg = (String) request.getAttribute("errMsg");
String msg = (String) request.getAttribute("msg");%>

<% if(msg != null && !msg.isEmpty()){ %>
<h2 style="color: green;"  ><%= msg %></h2>
<%} %>

<% if(errMsg != null && !errMsg.isEmpty()){ %>
<h2 style="color: red;" ><%= errMsg %></h2>
<%} %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<fieldset>
		<legend>Add Employee</legend>
		<form action="./addEmployee" method="post">
			<table>
			<tr>
			   <td>empId</td>
			   <td>:</td>
			   <td><input type= "number" name="empId" required></td>
			</tr>
			<tr>
			   <td>name</td>
			   <td>:</td>
			   <td><input type= "text" name="name" required></td>
			</tr>
			<tr>
			   <td>mobileNum</td>
			   <td>:</td>
			   <td><input type= "number" name="mobileNum" required></td>
			</tr>
			<tr>
			   <td>officalMailId</td>
			   <td>:</td>
			   <td><input type= "email" name="officalMailId" required></td>
			</tr>
			<tr>
			   <td>dateOfBirth</td>
			   <td>:</td>
			   <td><input type= "date" name="dateOfBirth" required></td>
			</tr>
			<tr>
			   <td>dateOfjoining</td>
			   <td>:</td>
			   <td><input type= "date" name="dateOfjoining" required></td>
			</tr>
			<tr>
			   <td>designation</td>
			   <td>:</td>
			   <td><input type= "text" name="designation" required></td>
			</tr>
			<tr>
			   <td>bloodGroup</td>
			   <td>:</td>
			   <td><input type= "text" name="bloodGroup" required></td>
			</tr>
			<tr>
			   <td>employeeSalary</td>
			   <td>:</td>
			   <td><input type= "number" name="employeeSalary" required></td>
			</tr>
			<tr>
			   <td>departmentId</td>
			   <td>:</td>
			   <td><input type= "number" name="departmentId" required></td>
			</tr>
			<tr>
			   <td>managerId</td>
			   <td>:</td>
			   <td><input type= "number" name="managerId" required></td>
			</tr>
			<tr>
			   <td>password</td>
			   <td>:</td>
			   <td><input type= "password" name="password" required></td>
			</tr>
			<tr>
			   <td>Re Enter password</td>
			   <td>:</td>
			   <td><input type= "password" name="confpassword" required></td>
			</tr>
			<tr>
			   <td></td>
			   <td><input type="submit" value="ADD"></td>
			   <td></td>
			</tr>
			</table>
		</form>
	</fieldset>

</body>
</html>

<jsp:include page="footer.jsp"></jsp:include>