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
    <title>EmployeeHomePage</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="/bootstrap-4.4.1-dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="${css}/employeeHomePageHeader.css">
</head>
<body>
     <header>
         <div class ="main">
             <ul>
                <li><a href="/discomusecase/discomHomePage">Home</a></li>
                <li><a href="./employeeDetail">My Details</a></li>
                 <li><a href="./getAllConsumer">Consumer details</a></li>
                 <li><a href="./billGeneration">Bill generation</a></li>
                 <li><a href="./billHistory">Bill history</a></li>
                 <li><a href="#">Monthly Revenue</a></li>
                 <li><a href="./dispalyQueryResolvePage">View querie</a></li>
                 <li><a href="./removeAccount">Remove My Account</a></li>
                 <li class="active"><a href="./employeeLogout">LogOut</a></li>
             </ul>
         </div>
     </header>
    <script src="/Jquery/jquery-3.4.1.js"></script>
    <script src="/bootstrap-4.4.1-dist/js/bootstrap.min.js"></script>
</body>
</html>