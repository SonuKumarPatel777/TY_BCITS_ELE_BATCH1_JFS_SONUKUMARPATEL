<%@page import="com.bcits.discomusecase.beans.ConsumersMasterBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<spring:url var="css" value="/resources/css" />
<spring:url var="js" value="/resources/js" />
<spring:url var="images" value="/resources/images" />
<jsp:include page="employeeHomePage.jsp" />
<% ConsumersMasterBean consumersMasterBean = (ConsumersMasterBean) request.getAttribute("consumerBean"); %>
<% int previousReading = (int) request.getAttribute("previousReading");%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Bill Genration</title>
<link rel="stylesheet" href="${css}/consumerPaymentPage.css">
</head>

<body>
	<form action="./generateBillForConsumer" method="post">
		<h3>Bill Generation</h3>
		<table>
			<tr>
				<td></td>
				<td></td>
			</tr>
			<tr>
				<td><label class="label">Meter Number</label></td>
			</tr>
			<tr>
				<td><input type="text" class="input" name="meterNumber" id=""
					value="<%= consumersMasterBean.getMeterNumber() %>"></td>
			</tr>

			<tr>
				<td><label class="label">Initial-Reading</label></td>
			</tr>
			<tr>
				<td><input type="text" class="input" name="previousReading" id=""
					value="<%= previousReading %>"></td>
			</tr>
			<tr>
				<td><label class="label">Final-Reading</label></td>
			</tr>
			<tr>
				<td><input type="text" class="input" name="currentReading" id=""></td>

			</tr>
			<tr>
				<td><label class="label">ConsumerType</label></td>
			</tr>
			<tr>
				<td><input type="text" class="input" name="consumerType" id=""
					value="<%= consumersMasterBean.getConsumerType() %>"></td>
			</tr>
			<tr>
				<td><label class="label">Set Due Date</label></td>
			</tr>
			<tr>
				<td><input type="date" class="input" name="dueDate" id=""></td>

			</tr>
			<tr>
				<td><input type="submit" value="Generat">&nbsp;&nbsp;&nbsp;
					<input type="reset" value="Reset"></td>
			</tr>
		</table>

	</form>

</body>

</html>