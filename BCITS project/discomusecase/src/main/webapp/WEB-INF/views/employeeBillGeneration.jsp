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
<% String msg = (String)request.getAttribute("msg"); %>
<% String errMsg = (String)request.getAttribute("errMsg"); %>

<% if(errMsg != null && !errMsg.isEmpty()) {%>
	<h3 style="color:red"><%= errMsg %></h3>
	<%} %>
	
<% if(msg != null && !msg.isEmpty()) {%>
	<h3 style="color:red"><%= msg %></h3>
	<%} %>

     <% if(consumersMasterList != null ){ %>
<table border ="1" style='width:70%; margin-left: 200px; margin-top: 200px'>
	     <thead style='background-color: navy; color: white'>
	         <tr style="height:35px">
	         <th>Meter Number</th>
	         <th>Name</th>
	         <th>Email</th>
	         <th>Phone Number</th>
	         <th>Region</th>
	         <th>Consumer Type</th>
	         <th>Bill Generation</th>
	         </tr>
	     </thead>
	     <% for(ConsumersMasterBean consumersMasterBean
	    		 :consumersMasterList){ %>
	    		 <form action="./currentBillPageGen">
	    		 <input name="meterNumber" type="text" value="<%= consumersMasterBean.getMeterNumber() %>" hidden="true">
	      <tr style="height:35px">
	        <td><%= consumersMasterBean.getMeterNumber() %></td>
	        <td><%= consumersMasterBean.getName() %></td>
	        <td><%= consumersMasterBean.getEmail() %></td>
	        <td><%= consumersMasterBean.getPhoneNumber() %></td>
	        <td><%= consumersMasterBean.getRegion() %></td>
	        <td><%=consumersMasterBean.getConsumerType() %></td>
	        <td><input type="submit" value="Click Here To Generated Bill"> 
	        </td>
	        </tr>
	        </form>
	<%} 
	}else{%>
	<%} %>
    
    <script src="/Jquery/jquery-3.4.1.js"></script>
    <script src="/bootstrap-4.4.1-dist/js/bootstrap.min.js"></script>
</body>
</html>