<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <% String msg = (String)request.getAttribute("msg");
     String errmsg = (String)request.getAttribute("errmsg");%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
      <a href="./createCookie">Click Here</a> To Create Cookie <br>
      <a href="./readCookie">Click Here</a> To Read Cookie
      
      <%if(msg != null && !msg.isEmpty()) { %>
      <h1 style="color:green"><%= msg %></h1>
      <%} %>
      
      <%if(errmsg != null && !errmsg.isEmpty()) { %>
      <h1 style="color:red"><%= errmsg %></h1>
      <%} %>
</body>
</html>