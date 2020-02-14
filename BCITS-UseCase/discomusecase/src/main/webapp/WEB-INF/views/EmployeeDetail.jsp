<%@page import="com.bcits.discomusecase.beans.EmployeeMasterBean"%>
<%@page import="com.bcits.discomusecase.beans.ConsumersMasterBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <% EmployeeMasterBean empBean = (EmployeeMasterBean) session.getAttribute("loggedInEmp"); %>
    <%int numberOfConsumer = (int)request.getAttribute("numberOfConsumer"); %>
     <%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
    
    <spring:url var="css" value="/resources/css"/>
    <spring:url var="js" value="/resources/js"/>
    <spring:url var="images" value="/resources/images"/>
     <jsp:include page="employeeHomePage.jsp"/>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employee Details</title>
</head>
<body>
    <table style="font-size: 20px;margin-left: 250px; background-color: white;">
                 <tr>
                    <td></td>
                    <td><strong>Employee Details</strong></td>
                    <td></td>
                </tr>
                <tr>
                    <td><strong>Name</strong></td>
                    <td>: &nbsp;</td>
                    <td><strong><%= empBean.getName() %></strong></td>
                </tr>
                <tr>
                    <td><strong>Designation</strong></td>
                    <td>:&nbsp;</td>
                    <td><strong><%= empBean.getDesignation() %></strong></td>
                </tr>
                <tr>
                    <td><Strong>EmployeeId</Strong></td>
                    <td>:&nbsp;</td>
                    <td><strong><%= empBean.getEmployeeId() %></strong></td>
                </tr>
                <tr>
                    <td><strong>Region</strong></td>
                    <td>:&nbsp;</td>
                    <td><strong><%= empBean.getRegion() %></strong></td>
                </tr>
                <tr>
                    <td><strong>Number Of Consumer</strong></td>
                    <td>:&nbsp;</td>
                    <td><strong><%= numberOfConsumer %></strong></td>
                </tr>
                 
            </table>
   
</body>
</html>