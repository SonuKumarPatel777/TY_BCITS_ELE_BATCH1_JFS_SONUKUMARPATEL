
<%@page import="java.util.Date"%>
<%@page import="com.bcits.discomusecase.beans.CurrentBillBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
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
  <% String meterNumber = (String)request.getAttribute("meterNumber"); %>
<% Date queryDate = (Date)request.getAttribute("queryDate"); %>  
<title>Employee Response</title>
</head>
<body>
    <div class="container-fluid bg">
        <div class="row">
            <div class="col-md-4 col-sm-4 col-xs-12"></div>
            <div class="col-md-4 col-sm-4 col-xs-12">
                 <form action="./giveResponse"  method="post">
                 <input name="meterNumber" type="text" value="<%= meterNumber %>" hidden="true">
                 <input name="queryDate" type="text" value="<%= queryDate %>" hidden="true">
                    <h3 style="margin-left: 10px;">Employee Response</h3>
                    <img class="img rounded-circle " src="${images}/responce.jpg">
                    <div>
                        <label><h5>Consumer Querie</h5></label>
                        <textarea rows="4" cols="50" name = "" placeholder="${getSingleComplaint} ${errMsg}" readonly="readonly"></textarea>
                    </div>
                    
                    <div>
                        <label><h5>Employee Response</h5></label>
                        <textarea rows="4" cols="50" name = "responce" placeholder="Enter text here..."></textarea>
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