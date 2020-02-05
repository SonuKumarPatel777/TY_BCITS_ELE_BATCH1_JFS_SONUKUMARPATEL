<%@page import="com.bcits.discomusecase.beans.ConsumersMasterBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <% ConsumersMasterBean conInfoBean = (ConsumersMasterBean) session.getAttribute("loggedInCons"); %>
     <%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
    
    <spring:url var="css" value="/resources/css"/>
    <spring:url var="js" value="/resources/js"/>
    <spring:url var="images" value="/resources/images"/>
    <jsp:include page="consumerHomePage.jsp"/>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Consumer Details</title>
</head>
<body>
    <table style="font-size: 20px;margin-left: 250px; background-color: white;">
                 <tr>
                    <td></td>
                    <td><strong>Consumer Details</strong></td>
                    <td></td>
                </tr>
                <tr>
                    <td><strong>Name</strong></td>
                    <td>: &nbsp;</td>
                    <td><strong><%= conInfoBean.getName() %></strong></td>
                </tr>
                <tr>
                    <td><strong>Meter Number</strong></td>
                    <td>:&nbsp;</td>
                    <td><strong><%= conInfoBean.getMeterNumber() %></strong></td>
                </tr>
                <tr>
                    <td><Strong>PhoneNumber</Strong></td>
                    <td>:&nbsp;</td>
                    <td><strong><%= conInfoBean.getPhoneNumber() %></strong></td>
                </tr>
                <tr>
                    <td><strong>Email</strong></td>
                    <td>:&nbsp;</td>
                    <td><strong><%= conInfoBean.getEmail() %></strong></td>
                </tr>
                <tr>
                    <td><Strong>Region</Strong></td>
                    <td>:&nbsp;</td>
                    <td><strong><%= conInfoBean.getRegion()%></strong></td>
                </tr>
                <tr>
                    <td><strong>Type Of Consumer</strong></td>
                    <td>:&nbsp;</td>
                    <td><strong><%= conInfoBean.getConsumerType() %></strong></td>
                </tr>
                 <tr>
                    <td><strong>Connection Date</strong></td>
                    <td>:&nbsp;</td>
                    <td><strong><%= conInfoBean.getDateOfConnection() %></strong></td>
                </tr>
            </table>
   
</body>
</html>