<%@page import="com.bcits.discomusecase.beans.AdminMasterBean"%>
<%@page import="com.bcits.discomusecase.beans.ConsumersMasterBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%AdminMasterBean adminMasterBean = (AdminMasterBean)session.getAttribute("loggedInAdmin");%>
     <%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
    
    <spring:url var="css" value="/resources/css"/>
    <spring:url var="js" value="/resources/js"/>
    <spring:url var="images" value="/resources/images"/>
    <jsp:include page="adminHomePage.jsp"/>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>AdminDetails</title>
</head>
<body>
    <table style="font-size: 20px;margin-left: 290px; background-color: white;">
                 <tr>
                    <td><strong>Admin Details:-</strong></td>
                    <td></td>
                </tr>
                <tr>
                    <td><strong>Name:</strong></td>
                    <td><strong><%= adminMasterBean.getName() %></strong></td>
                </tr>
                <tr>
                    <td><strong>User ID:</strong></td>
                     
                    <td><strong><%= adminMasterBean.getUserId()%></strong></td>
                </tr>
                <tr>
                    <td><Strong>Admin ID:</Strong></td>
                     
                    <td><strong><%=adminMasterBean.getAdminId() %></strong></td>
                </tr>
                <tr>
                    <td><strong>Email:</strong></td>
                    <td><strong><%= adminMasterBean.getEmail() %></strong></td>
                </tr>
            </table>
</body>
</html>