<%@page import="com.bcits.empwebapp.beans.EmployeePrimaryInfo"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <% EmployeePrimaryInfo employeePrimaryInfo =
            (EmployeePrimaryInfo)request.getAttribute("empInfo"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<fieldset>
		<legend>Search Employee</legend>
		      <form action="./getEmp">
			  <label>Employee ID:</label> 
			<input type= "text" name="empId" required><br>
			<input type="submit" value="Search">
		</form>
	</fieldset>
	
	<h2 Style='color:green'>Search Employee </h2>
	<% if(employeePrimaryInfo != null) {%>
	     Name = <%= employeePrimaryInfo.getName() %><br>
	     Salary = <%= employeePrimaryInfo.getEmployeeSalary() %><br>
	     Designation =<%= employeePrimaryInfo.getDesignation() %><br>
	     Date Of Birth = <%= employeePrimaryInfo.getDateOfBirth() %><br>
	     Date Of Joining =<%= employeePrimaryInfo.getDateOfjoining() %><br>
	     Department Id =<%=employeePrimaryInfo.getDepartmentId() %>
	<%} else {%>
	 <h2 Style='color:red'> Employee ID not Found !!! </h2>
	<%} %>

</body>
</html>