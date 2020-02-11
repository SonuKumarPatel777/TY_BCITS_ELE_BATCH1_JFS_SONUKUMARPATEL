
<%@page import="com.bcits.discomusecase.beans.CurrentBillBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <% CurrentBillBean currentBillBean = (CurrentBillBean)request.getAttribute("currentBill"); %>
     <%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
    
    <spring:url var="css" value="/resources/css"/>
    <spring:url var="js" value="/resources/js"/>
    <spring:url var="images" value="/resources/images"/>
    <jsp:include page="consumerHomePage.jsp"/>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Consumer Bill</title>
</head>
<body>
    <table style="font-size: 20px;background-color: white; margin-left: 250px;">
                 <tr>
                    <td></td>
                    <td><strong>MonthlyConsumption</strong></td>
                    <td></td>
                </tr>
                <tr>
                <tr>
                    <td><strong>Meter Number</strong></td>
                    <td>:&nbsp;</td>
                    <td><strong><%= currentBillBean.getMeterNumber() %></strong></td>
                </tr>
                <tr>
                    <td><strong>PreviousReading</strong></td>
                    <td>:&nbsp;</td>
                    <td><strong><%= currentBillBean.getPreviousReading() %></strong></td>
                </tr>
                <tr>
                    <td><Strong>CurrentReading</Strong></td>
                    <td>:&nbsp;</td>
                    <td><strong><%= currentBillBean.getCurrentReading() %></strong></td>
                </tr>
                    <td><strong>Consumption</strong></td>
                    <td>: &nbsp;</td>
                    <td><strong><%= currentBillBean.getConsumption() %></strong></td>
                </tr>
                </tr>
                    <td><strong>Bill Amount</strong></td>
                    <td>: &nbsp;</td>
                    <td><strong><%= currentBillBean.getBillAmount() %></strong></td>
                </tr>
                 </tr>
                    <td><strong>Due Date</strong></td>
                    <td>: &nbsp;</td>
                    <td><strong><%= currentBillBean.getDueDate()%></strong></td>
                </tr>
                </tr>
                    <td><strong></strong></td>
                    <td> <a href="./consumerPaymentPage">
                    <input type="button" value="Online Payment" style="background-color:green;margin-top: 10px"></a></td>
                    <td></td>
                </tr>
            </table>
   
</body>
</html>