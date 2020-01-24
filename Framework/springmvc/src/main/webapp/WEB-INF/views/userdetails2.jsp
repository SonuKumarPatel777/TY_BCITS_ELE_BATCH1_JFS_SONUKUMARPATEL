<%@page import="com.bcits.springmvc.beans.UserBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%UserBean userBean = (UserBean)request.getAttribute("userBean");
     String name = (String)request.getAttribute("name");%>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>User ID : <%= userBean.getEmpId()  %></h1>
<h1> Employee name :<%=  name%></h1>
<h1>Password :<%=  userBean.getPassword()%></h1>
</body>
</html>