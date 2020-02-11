<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.bcits.discomusecase.beans.BillHistoryBean"%>
<%@page import="java.util.List"%>
<%@page import="com.bcits.discomusecase.beans.EmployeeMasterBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
    <%List<BillHistoryBean> billHistoryBeansList = (List< BillHistoryBean>)request.getAttribute("billHistory"); %>  
    <spring:url var="css" value="/resources/css"/>
    <spring:url var="js" value="/resources/js"/>
    <spring:url var="images" value="/resources/images"/>
    <jsp:include page="consumerHomePage.jsp"/>
<!DOCTYPE html>

<html>
<head>
<meta charset="ISO-8859-1">
<title>Consumer Detail</title>
</head>
<body>
     <% if(billHistoryBeansList != null ){ %>
<table border ="1" style='width:70%; margin-left: 200px; margin-top: 150px'>
	     <thead style='background-color: navy; color: white'>
	         <tr style="height:35px">
	         <th>Sl.NO</th>
	         <th>Payment Amount</th>
	         <th>Payment Date</th>
	         <th>Payment Description</th>

	         </tr>
	     </thead>
	     <% int i=0;
	     for( BillHistoryBean billHistoryBean
	    		 :billHistoryBeansList){i++; %>
	      <tr style="height:35px">
	        <td><%= i %></td>
	        <td><%= billHistoryBean.getAmount() %></td>
	        <td><% SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy"); %>
              <%= formatter.format(billHistoryBean.getBiHistoryPK().getPaymentDate()) %></td>
	        <td><%= billHistoryBean.getStatus() %></td>
	         
	        </tr>
	<%} 
     }else {%>
	<h2 style="color: red">No Record To Display..</h2>
	<%} %>
    
    <script src="/Jquery/jquery-3.4.1.js"></script>
    <script src="/bootstrap-4.4.1-dist/js/bootstrap.min.js"></script>
</body>
</html>