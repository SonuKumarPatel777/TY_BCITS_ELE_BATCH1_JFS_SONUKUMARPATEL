<%@page import="java.util.List"%>
<%@page import="com.bcits.springmvc.beans.EmployeeInfoBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <jsp:include page="header.jsp"></jsp:include>
 <% List<EmployeeInfoBean> empList = (List<EmployeeInfoBean>) request.getAttribute("allEmpDetails"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% if(empList != null ){ %>
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
	     <% for(EmployeeInfoBean employeeInfoBean :empList){ %>
	      <tr style="height:35px">
	        <td><%= employeeInfoBean.getEmpId() %></td>
	        <td><%= employeeInfoBean.getName() %></td>
	        <td><%= employeeInfoBean.getEmployeeSalary() %></td>
	        <td><%= employeeInfoBean.getDesignation() %></td>
	        <td><%= employeeInfoBean.getDateOfBirth() %></td>
	         <td><%=employeeInfoBean.getDateOfjoining() %></td>
	        <td><%= employeeInfoBean.getMobileNum() %></td>
	        </tr>
	<%} 
	}else {%>
	<h2 style="color: red">No Record To Display..</h2>
	<%} %>


</body>
</html>
<jsp:include page="footer.jsp"></jsp:include>