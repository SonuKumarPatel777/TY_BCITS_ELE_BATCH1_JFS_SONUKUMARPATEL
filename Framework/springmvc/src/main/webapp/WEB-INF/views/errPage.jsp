<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <jsp:include page="header.jsp"></jsp:include>
    <% String errMsg = (String) request.getAttribute("errMsg"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
  <h2 style="color:red"><%= errMsg %></h2>
</body>
</html>
<jsp:include page="footer.jsp"></jsp:include>