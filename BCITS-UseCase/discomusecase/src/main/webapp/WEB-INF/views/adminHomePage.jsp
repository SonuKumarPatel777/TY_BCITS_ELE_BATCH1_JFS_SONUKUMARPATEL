<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
    
    <spring:url var="css" value="/resources/css"/>
    <spring:url var="js" value="/resources/js"/>
    <spring:url var="images" value="/resources/images"/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>AdimnHomePage</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="/bootstrap-4.4.1-dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="${css}/consumerHomePage.css">
</head>
<body>
     <header>
         <div class ="main">
             <jsp:include page="adminHeader.jsp"/>
             <marquee><h1>Welcome To Discom</h1></marquee>
         </div>
     </header>
    
  <%String errMsg = (String)request.getAttribute("errMsg"); %>
  <% if(errMsg != null && !errMsg.isEmpty()){%>
 <h2 style="color:red; margin-left: 310Px;"><%= errMsg %></h2>
 <%}%>
 <%String msg = (String)request.getAttribute("msg"); %>
  <% if(msg != null && !msg.isEmpty()){%>
 <h2 style="color:red; margin-left: 310Px;"><%= msg %></h2>
 <%}%>
    <script src="/Jquery/jquery-3.4.1.js"></script>
    <script src="/bootstrap-4.4.1-dist/js/bootstrap.min.js"></script>
</body>
</html>