<%@page import="com.bcits.springmvc.beans.EmployeeInfoBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
	<% EmployeeInfoBean employeeInfoBean = (EmployeeInfoBean)request.getAttribute("employeeInfoBean");
	 String errMsg = (String)request.getAttribute("errMsg");%>
	  
	<jsp:include page="header.jsp"></jsp:include>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<fieldset>
		<legend>Search Employee</legend>
		<form action="./search">
			<label>Employee ID:</label>
			 <input type="text" name="empId" required><br>
			<input type="submit" value="Search">
		</form>
	</fieldset>
	<% if(errMsg != null && !errMsg.isEmpty()) {%>
	<h3 style="color:red"><%= errMsg %></h3>
	<%} %>
	
	<% if(employeeInfoBean != null){%>
	    <table border ="1" style='width:70%'>
	     <thead style='background-color: navy; color: white'>
	         <tr style="height:35px">
	         <th>Employee ID</th>
	         <th>Name</th>
	         <th>Salary</th>
	         <th>Designation</th>
	         <th>DOB</th>
	         <th>DOJ</th>
	         <th>Mobile No.</th>
	         </tr>
	     </thead>
	      <tr style="height:35px">
	        <td><%= employeeInfoBean.getEmpId() %></td>
	        <td><%= employeeInfoBean.getName() %></td>
	        <td><%= employeeInfoBean.getEmployeeSalary() %></td>
	        <td><%= employeeInfoBean.getDesignation() %></td>
	        <td><%= employeeInfoBean.getDateOfBirth() %></td>
	         <td><%=employeeInfoBean.getDateOfjoining() %></td>
	        <td><%= employeeInfoBean.getMobileNum() %></td>
	        </tr>
	<%} %>

</body>
</html>

<jsp:include page="footer.jsp"></jsp:include>