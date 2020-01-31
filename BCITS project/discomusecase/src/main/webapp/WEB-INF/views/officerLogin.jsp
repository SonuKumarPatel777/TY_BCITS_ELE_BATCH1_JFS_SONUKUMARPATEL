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
                <form action="" id="login">
                    <h3>Employee Login</h3>
                    <img class="img rounded-circle " src="${images}/access-512.png">
                    <div>
                        <label>Employee ID</label>
                        <input type="text" class="form-control" name="employeeId" placeholder=" Enter Employee ID">
                    </div>
                    <div>
                        <label>Designation</label>
                        <input type="password" class="form-control" name="designation" placeholder=" Enter Designation">
                    </div>
                    <div>
                        <label><input type="checkbox" name="checkbox">Remember me</label>
                        <p>Forgot</label>&nbsp;&nbsp;<a
                            href="/cusomerForgot.html">Password</a>
                    </p>
                    </div>
                    <div>
                        <button type="submit" class="btn btn-success">SUBMIT</button>
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