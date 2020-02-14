<%@page import="com.bcits.discomusecase.beans.ConsumersMasterBean"%>
<%@page import="java.util.List"%>
<%@page import="com.bcits.discomusecase.beans.EmployeeMasterBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
    <%List<ConsumersMasterBean> consumersMasterList = (List<ConsumersMasterBean>)request.getAttribute("consumersMasterList"); %>  
    <spring:url var="css" value="/resources/css"/>
    <spring:url var="js" value="/resources/js"/>
    <spring:url var="images" value="/resources/images"/>
    <jsp:include page="employeeHomePage.jsp"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Consumer Detail</title>
</head>
<body>
     <% if(consumersMasterList != null && !consumersMasterList.isEmpty() ){ %>
<table border ="1" style='width:70%; margin-left: 200px; margin-top: 200px'>
	     <thead style='background-color: navy; color: white'>
	         <tr style="height:35px">
	         <th>SL. NO.</th>
	         <th>Meter Number</th>
	         <th>Name</th>
	         <th>Email</th>
	         <th>Phone Number</th>
	         <th>Region</th>
	         <th>Consumer Type</th>
	         <th>Date Of Connection</th>
	         <th>House Number</th>
	         <th>Address1</th>
	         <th>Address2</th>
	         <th>City</th>
	         <th>Zip</th>
	         <th>Remove</th>
	         </tr>
	     </thead>
	     <% int i=1;for(ConsumersMasterBean consumersMasterBean
	    		 :consumersMasterList){ %>
	    <form action="./removeConsumer">
	    		 <input name="meterNumber" type="text" value="<%= consumersMasterBean.getMeterNumber() %>" hidden="true">
	      <tr style="height:35px; background-color: navy; color: white">
	        <td><%= i %></td>
	        <td><%= consumersMasterBean.getMeterNumber() %></td>
	        <td><%= consumersMasterBean.getName() %></td>
	        <td><%= consumersMasterBean.getEmail() %></td>
	        <td><%= consumersMasterBean.getPhoneNumber() %></td>
	        <td><%= consumersMasterBean.getRegion() %></td>
	         <td><%=consumersMasterBean.getConsumerType() %></td>
	        <td><%= consumersMasterBean.getDateOfConnection() %></td>
	        <td><%= consumersMasterBean.getHouseNumber() %></td>
	        <td><%= consumersMasterBean.getAddress1() %></td>
	        <td><%= consumersMasterBean.getAddress2()%></td>
	        <td><%= consumersMasterBean.getCity() %></td>
	        <td><%= consumersMasterBean.getZip() %></td>
	        <td><input type="submit" value="Click Here To Remove"> 
	        </td>
	        </tr>
	    </form>
	<% i++;} 
	}else {%>
	<h2 style="color: red">No Record To Display..</h2>
	<%} %>
    
    <script src="/Jquery/jquery-3.4.1.js"></script>
    <script src="/bootstrap-4.4.1-dist/js/bootstrap.min.js"></script>
</body>
</html>