<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
    
    <spring:url var="css" value="/resources/css"/>
    <spring:url var="js" value="/resources/js"/>
    <spring:url var="images" value="/resources/images"/>
    <jsp:include page="header.jsp"/>
<!DOCTYPE html>
 
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>officer login</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="/bootstrap-4.4.1-dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="${css}/officerlogin.css">
</head>

<body>
    <div class="container-fluid bg">
        <div class="row">
            <div class="col-md-4 col-sm-4 col-xs-12"></div>
            <div class="col-md-4 col-sm-4 col-xs-12">
                <form action="./forgotPasswordSet" id="login" method="post">
                    <h3>Reset Your Password</h3>
                    <div>
                        <label>Meter Number</label>
                        <input type="text" class="form-control" name="meterNumber" placeholder=" Enter Meter Number">
                    </div>
                    <div>
                        <label>Email</label>
                        <input type="email" class="form-control" name="email" placeholder=" Enter Email">
                    </div>
                    <div>
                        <label> Set The Password</label>
                        <input type="password" class="form-control" name="password" placeholder=" Set The Password">
                    </div>
                     <div>
                        <label>Re-Enter The Password</label>
                        <input type="password" class="form-control" name="confPassword" placeholder=" Re-Enter The Password">
                        <br>
                    </div>
                    <div>
                        <button type="submit" class="btn btn-success">SET</button>
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