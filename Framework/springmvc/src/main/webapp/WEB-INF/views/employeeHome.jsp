<%@page import="com.bcits.springmvc.beans.EmployeeInfoBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <% EmployeeInfoBean employeeInfoBean = (EmployeeInfoBean) session.getAttribute("loggedIngInfo"); %>
    
<jsp:include page="header.jsp"></jsp:include>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
  <h1 style="color :gray;">Welcome <%= employeeInfoBean.getName() %> Home page</h1>
</body>
</html>
<jsp:include page="footer.jsp"></jsp:include>
