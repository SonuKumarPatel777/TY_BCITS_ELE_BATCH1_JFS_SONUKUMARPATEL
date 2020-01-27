<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <jsp:include page="header.jsp"></jsp:include>
     <%String msg =(String) request.getAttribute("msg");
    String errMsg =(String) request.getAttribute("errMsg");%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
  <fieldset>
		<legend>Update Employee</legend>
		<form action="./updateEmployee" method="post">
			<table>
				<table>
			    <tr>
                  <td>Employee Id</td>
                  <td>:</td>
                  <td><input type="text" name="empId"></td>
               </tr>
			   <tr>
			     <td>name</td>
			     <td>:</td>
			     <td><input type= "text" name="name" ></td>
			  </tr>
			  <tr>
			   <td>mobileNum</td>
			   <td>:</td>
			   <td><input type= "number" name="mobileNum" ></td>
			 </tr>
			<tr>
			   <td>officalMailId</td>
			   <td>:</td>
			   <td><input type= "email" name="officalMailId" ></td>
			</tr>
			<tr>
			   <td>dateOfBirth</td>
			   <td>:</td>
			   <td><input type= "date" name="dateOfBirth" ></td>
			</tr>
			<tr>
			   <td>dateOfjoining</td>
			   <td>:</td>
			   <td><input type= "date" name="dateOfjoining" ></td>
			</tr>
			<tr>
			   <td>designation</td>
			   <td>:</td>
			   <td><input type= "text" name="designation" ></td>
			</tr>
			<tr>
			   <td>bloodGroup</td>
			   <td>:</td>
			   <td><input type= "text" name="bloodGroup" ></td>
			</tr>
			<tr>
			   <td>employeeSalary</td>
			   <td>:</td>
			   <td><input type= "number" name="employeeSalary" ></td>
			</tr>
			<tr>
			   <td>departmentId</td>
			   <td>:</td>
			   <td><input type= "number" name="departmentId" ></td>
			</tr>
			<tr>
			   <td>managerId</td>
			   <td>:</td>
			   <td><input type= "number" name="managerId" ></td>
			</tr>
			<tr>
			   <td>password</td>
			   <td>:</td>
			   <td><input type= "password" name="password" ></td>
			</tr>
				<tr>
					<td></td>
					<td><input type="submit" value="Update"></td>
					<td></td>
				</tr>

			</table>
		</form>
	</fieldset>

</body>
</html>
<% if(msg != null && !msg.isEmpty()) {%>
<h2 style="color: green"  ><%= msg %></h2>
<%} %>

<% if(errMsg != null && !errMsg.isEmpty()) {%>
<h2 style="color: red;" ><%= errMsg %></h2>
<%} %>
<jsp:include page="footer.jsp"></jsp:include>