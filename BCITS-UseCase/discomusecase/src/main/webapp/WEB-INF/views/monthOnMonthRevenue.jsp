<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%List<Object[]> paidAmount = (List<Object[]>)request.getAttribute("paidAmount"); %>
<%List<Object[]> notPaidAmount = (List<Object[]>)request.getAttribute("notPaidAmount"); %>
<spring:url var="css" value="/resources/css" />
<spring:url var="js" value="/resources/js" />
<spring:url var="images" value="/resources/images" />
<jsp:include page="employeeHomePage.jsp" />
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Consumer Detail</title>
</head>
<body>
	<% if((notPaidAmount != null && !notPaidAmount.isEmpty())&&
    		 (paidAmount != null && !paidAmount.isEmpty()) ){ %>

	<% double totalRevenue = 0.0;
		
		for( int i=0 ;i<paidAmount.size();i++) {
			Object[] collectedBills = paidAmount.get(i);
			
		      for( int j=0 ;j<notPaidAmount.size();j++) {
			      Object[] pendingBills = notPaidAmount.get(j);
			      
	 			if(collectedBills[1].equals(pendingBills[1])){
	 				totalRevenue = (double)collectedBills[0]+(double)pendingBills[0];
	 				%>
	<table border="1"
		style='width: 70%; margin-left: 200px; margin-top: 150px'>
		<thead style='background-color: navy; color: white'>
			<tr style="height: 35px">
				<th>Month</th>
				<th>Total Amount</th>
				<th>Total Paid Amount</th>
				<th>Total Pending Amount</th>
			</tr>
		</thead>
		<tr style="height: 35px; background-color: navy; color: white">
			<td><%=collectedBills[1]%></td>
			<td><%=totalRevenue %></td>
			<td><%=collectedBills[0]%></td>
			<td><%=pendingBills[0] %></td>
		</tr>
	</table>
	<%}    
		 }
	         } 
	} %>

	<script src="/Jquery/jquery-3.4.1.js"></script>
	<script src="/bootstrap-4.4.1-dist/js/bootstrap.min.js"></script>
</body>
</html>