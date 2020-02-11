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
    <title>ConsumerHomePage</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="/bootstrap-4.4.1-dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="${css}/consumerHomePageHeader.css">
</head>
<body>
     <header>
         <div class ="main">
             <ul>
                <li><a href="/discomusecase/discomHomePage">Home</a></li>
                 <li><a href="./consumerDetail">My Details</a></li>
                 <li><a href="./monthlyConsumption">Monthly Consumption</a></li>
                 <li><a href="./displayBillHistorysPage">Bill History</a></li>
                 <li><a href="./displayCurrentBillPage">Current Bill</a></li>
                 <li class="active"><a href="./consumerLogout">LogOut</a></li>
             </ul>
         </div>
     </header>
    <script src="/Jquery/jquery-3.4.1.js"></script>
    <script src="/bootstrap-4.4.1-dist/js/bootstrap.min.js"></script>
</body>
</html>