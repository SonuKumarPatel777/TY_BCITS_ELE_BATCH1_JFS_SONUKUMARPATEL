<%@page import="com.bcits.discomusecase.beans.ConsumersMasterBean"%>
<%@page import="java.util.List"%>
<%@page import="com.bcits.discomusecase.beans.EmployeeMasterBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
    <%List<EmployeeMasterBean> employeeMasterList = (List<EmployeeMasterBean>)request.getAttribute("employeeMasterList"); %>  
    <spring:url var="css" value="/resources/css"/>
    <spring:url var="js" value="/resources/js"/>
    <spring:url var="images" value="/resources/images"/>
    <jsp:include page="adminHomePage.jsp"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Consumer Detail</title>
</head>
<body>
     <% if(employeeMasterList != null && !employeeMasterList.isEmpty() ){ %>
<table border ="1" style='width:70%; margin-left: 200px; margin-top: 200px'>
	     <thead style='background-color: navy; color: white'>
	         <tr style="height:35px">
	         <th>Sl. NO.</th>
	         <th>Name</th>
	         <th>Employee Id</th>
	         <th>Designation</th>
	         <th>Region</th>
	         <th>Remove</th>
	         </tr>
	     </thead>
	     <%int i= 1; for(EmployeeMasterBean employeeMasterBean
	    		 :employeeMasterList){ %>
	    <form action="./removeEmployee">
	    		 <input name="employeeId" type="text" value="<%= employeeMasterBean.getEmployeeId() %>" hidden="true">
	      <tr style="height:35px">
	        <td><%= i%></td>
	        <td><%= employeeMasterBean.getName() %></td>
	        <td><%= employeeMasterBean.getEmployeeId() %></td>
	        <td><%= employeeMasterBean.getDesignation() %></td>
	        <td><%= employeeMasterBean.getRegion() %></td>
	        <td><input type="submit" value="Click Here To Remove"> 
	        </td>
	        </tr>
	    </form>
	<%i++;} 
	}else {%>
	<h2 style="color: red">No Record To Display..</h2>
	<%} %>
    
    <script src="/Jquery/jquery-3.4.1.js"></script>
    <script src="/bootstrap-4.4.1-dist/js/bootstrap.min.js"></script>
</body>
</html>