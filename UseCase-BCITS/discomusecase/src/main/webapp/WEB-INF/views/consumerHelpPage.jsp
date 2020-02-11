
<%@page import="com.bcits.discomusecase.beans.CurrentBillBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     
     <%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
     <% String msg =(String) request.getAttribute("msg"); %>
    <spring:url var="css" value="/resources/css"/>
    <spring:url var="js" value="/resources/js"/>
    <spring:url var="images" value="/resources/images"/>
    <jsp:include page="consumerHomePage.jsp"/>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="/bootstrap-4.4.1-dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="${css}/officerlogin.css">
<title>Consumer Help</title>
</head>
<body>
    <div class="container-fluid bg">
        <div class="row">
            <div class="col-md-4 col-sm-4 col-xs-12"></div>
            <div class="col-md-4 col-sm-4 col-xs-12">
             
            <%if(msg != null && !msg.isEmpty()){ %>
                <strong style="font-size: 30px; margin-left: 50px; color:red;"> <%= msg %></strong>
                <%} %>
                <form action="./consumerHelp"  method="post">
                    <h3 style="margin-left: 10px;">Consumer Help</h3>
                    <img class="img rounded-circle " src="${images}/query.jpg">
                    <div>
                        <label>Account or Payment Related Queries</label>
                        <textarea rows="4" cols="50" name = "querie" placeholder="Enter text here..."></textarea>
                    </div>
                    <div>
                        <button type="submit" class="btn btn-success">CONTACT US</button>&nbsp;&nbsp;
                        <button type="reset" class="btn btn-success">RESET</button>
                    </div>
                    </div>
                </form>
            </div>
            <div class="col-md-4 col-sm-4 col-xs-12"></div>
        </div>

    </div>
   <script src="/Jquery/jquery-3.4.1.js"></script>
    <script src="/bootstrap-4.4.1-dist/js/bootstrap.min.js"></script>
</body>
</html>