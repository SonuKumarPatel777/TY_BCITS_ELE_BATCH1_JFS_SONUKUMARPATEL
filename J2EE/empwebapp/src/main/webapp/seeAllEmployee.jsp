<%@page import="java.util.List"%>
<%@page import="com.bcits.empwebapp.beans.EmployeePrimaryInfo"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<% List<EmployeePrimaryInfo> employeeList = (List<EmployeePrimaryInfo>)request.getAttribute("emplist"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<% if(employeeList != null) {%>
	 <table border ="1" style='width:70%'>
	     <thead style='background-color: navy; color: white'>
	         <tr style="height:35px">
	         <th>Employee ID</th>
	         <th>Name</th>
	         <th> Salary</th>
	         <th> Designation</th>
	         <th>DOB</th>
	         <th>DOJ</th>
	         <th>Mobile No.</th>
	         </tr>
	     </thead>
	     <tbody>
	     <% for (EmployeePrimaryInfo empInfo : employeeList) {%>
	        <tr style="height:35px">
	        <td><%= empInfo.getEmpId() %></td>
	        <td><%= empInfo.getName() %></td>
	        <td><%= empInfo.getEmployeeSalary() %></td>
	        <td><%= empInfo.getDesignation() %></td>
	        <td><%= empInfo.getDateOfBirth() %></td>
	         <td><%= empInfo.getDateOfjoining() %></td>
	        <td><%= empInfo.getMobileNum() %></td>
	        </tr>
	     <%} %>
	     </tbody>
	 </table>

	<%} else {%>
	 <h2 Style='color:red'> No record Present !!! </h2>
	<%} %>

</body>
</html>