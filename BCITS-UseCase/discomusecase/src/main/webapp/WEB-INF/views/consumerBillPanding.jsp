
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.List"%>
<%@page import="com.bcits.discomusecase.beans.MonthlyConsumptionBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
	List<MonthlyConsumptionBean> monthlyConsumptionList = (List<MonthlyConsumptionBean>) request
			.getAttribute("monthlyConsumption");
%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<spring:url var="css" value="/resources/css" />
<spring:url var="js" value="/resources/js" />
<spring:url var="images" value="/resources/images" />
<jsp:include page="consumerHomePage.jsp" />
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ConsumerPandingBill</title>
</head>
<body>
	<%
		if (monthlyConsumptionList != null && !monthlyConsumptionList.isEmpty()) {
	%>
	<table border="1"
		style='width: 70%; margin-left: 200px; margin-top: 150px'>
		<thead style='background-color: navy; color: white'>
			<tr style="height: 35px">
				<th>Sl. NO.</th>
				<th>Meter Number</th>
				<th>PreviousReading</th>
				<th>CurrentReading</th>
				<th>Consumption</th>
				<th>Bill Amount</th>
				<th>Payment date</th>
				<th>Status</th>
				<th>Panding Bill</th>
			</tr>
		</thead>
		<%
			int i = 1;
				for (MonthlyConsumptionBean monthlyConsumption : monthlyConsumptionList) {
		%>
		<form action="./paymentPage">
			<input name="billAmount" type="tel"
				value="
	    		 <%=monthlyConsumption.getBillAmount()%>"
				hidden="true">
			<input name="date" type="date"
				value="
	    		 <%=monthlyConsumption.getConsumptionPk().getDate()%>"
				hidden="true">
				
			<%
				if (!monthlyConsumption.getStatus().equals("paid")) {
			%>
			<tr style="height: 35px; background-color: navy; color: white">
				<td><%=i%></td>
				<td><%=monthlyConsumption.getConsumptionPk().getMeterNumber()%></td>
				<td><%=monthlyConsumption.getPreviousReading()%></td>
				<td><%=monthlyConsumption.getCurrentReading()%></td>
				<td><%=monthlyConsumption.getConsumption()%></td>
				<td><%=monthlyConsumption.getBillAmount()%></td>
				<td>
					<%
						SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
					%>
					<%=formatter.format(monthlyConsumption.getConsumptionPk().getDate())%></td>
				<td><%=monthlyConsumption.getStatus()%></td>
				<td><input type="submit" value="Click Here To Pay Bill"></td>
			</tr>
			<%
				}
						i++;
					}
				} else {
			%>
			<h2 style="color: red">No Monthly Consumption for You :)</h2>
			<%
				}
			%>
		
	</table>

</body>
</html>