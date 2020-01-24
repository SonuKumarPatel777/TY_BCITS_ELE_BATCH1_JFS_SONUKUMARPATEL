<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%int empid = (Integer)request.getAttribute("empId"); 
      String password = (String)request.getAttribute("pwd");
    %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>User ID : <%= empid %></h1>
<h1>Password :<%=password %></h1>
</body>
</html>