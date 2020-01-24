<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<% String empId =(String)request.getAttribute("empId"); %>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h1>Employee ID <%= empId %> details...</h1>
  name= Sonu<br>
  age= 22<br>
  Designation = SSD<br>
  mobile= 7752014528<br>

</body>
</html>