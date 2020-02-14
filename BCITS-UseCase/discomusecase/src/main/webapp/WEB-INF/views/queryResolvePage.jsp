<%@page import="com.bcits.discomusecase.beans.HelpConsumerBean"%>
<%@page import="com.bcits.discomusecase.beans.ConsumersMasterBean"%>
<%@page import="java.util.List"%>
<%@page import="com.bcits.discomusecase.beans.EmployeeMasterBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <% List<HelpConsumerBean> helpConsumerComplaintsBeanList =(List<HelpConsumerBean>)request.getAttribute("helpConsumerComplaintsBeanList"); %>
    <%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>  
    <spring:url var="css" value="/resources/css"/>
    <spring:url var="js" value="/resources/js"/>
    <spring:url var="images" value="/resources/images"/>
    <jsp:include page="employeeHomePage.jsp"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Consumer Querie</title>
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

     <% if(helpConsumerComplaintsBeanList != null && ! helpConsumerComplaintsBeanList.isEmpty() ){ %>
<table border ="1" style='width:70%; margin-left: 200px; margin-top: 200px'>
	     <thead style='background-color: navy; color: white'>
	         <tr style="height:35px">
	         <th>SL.NO.</th>
	         <th>Meter Number</th>
	         <th>Region</th>
	         <th>Querie</th>
	         <th>Responces To Consumer</th>
	         </tr>
	     </thead>
	     <% int i =1;for(HelpConsumerBean helpConsumerBean
	    		 :helpConsumerComplaintsBeanList){ %>
	    		 <form action="./employeeResponcePage">
	    		 <input name="meterNumber" type="text" value="<%=helpConsumerBean.getHelpConsumerBeanPK().getMeterNumber()%>" hidden="true">
	    		 <input name="query" type="text" value="<%=helpConsumerBean.getHelpConsumerBeanPK().getQuerie()%>" hidden="true">
	      <tr style="height:35px; background-color: navy; color: white">
	        <td><%= i %></td>
	        <td><%= helpConsumerBean.getHelpConsumerBeanPK().getMeterNumber() %></td>
	        <td><%=helpConsumerBean.getRegion() %></td>
	        <td><%=helpConsumerBean.getHelpConsumerBeanPK().getQuerie() %></td>
	        <td><input type="submit" value="Click Here To Give Responce"> 
	        </td>
	        </tr>
	        </form>
	<% i++;} 
	}else{%>
	<h2 style="color: red">No Query To Display..</h2>
	<%} %>
    
    <script src="/Jquery/jquery-3.4.1.js"></script>
    <script src="/bootstrap-4.4.1-dist/js/bootstrap.min.js"></script>
</body>
</html>