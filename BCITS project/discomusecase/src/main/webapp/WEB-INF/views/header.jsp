<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
   <spring:url var="css" value="/resources/css"/>
   <spring:url var="js" value="/resources/js"/>
   <spring:url var="images" value="/resources/images"/>
<!DOCTYPE html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Header</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="/bootstrap-4.4.1-dist/css/bootstrap.min.css">
</head>
<body>
    <nav class="navbar navbar-expand-lg navbar-light bg-dark">
            <img src="${images}/images.png" alt="" style="width:189px; height:148px; margin-left:2px;">
            </button>
            <h2 style="color:white;margin-left:40px">Bangalore Electicity Supply Company Limited</h2><br>
            <a href="/discomusecase/consumer/consumerLoginPage" style="margin-left:50px">
            <input type="button" value="Consumer Portal"></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <a href="/discomusecase/employee/employeeLogin"><input type="button" value="Employee Portal"></a>&nbsp;&nbsp;&nbsp;
            <a href="/discomusecase/discomHomePage"><input type="button" value="Home"></a>
    </nav>

    <script src="/Jquery/jquery-3.4.1.js"></script>
    <script src="/bootstrap-4.4.1-dist/js/bootstrap.min.js"></script>
</body>
</html>