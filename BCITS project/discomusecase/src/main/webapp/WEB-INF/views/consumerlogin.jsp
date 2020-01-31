<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
    
    <spring:url var="css" value="/resources/css"/>
    <spring:url var="js" value="/resources/js"/>
    <spring:url var="images" value="/resources/images"/>
    <jsp:include page="header.jsp"/>
    
 <% String msg = (String)request.getAttribute("msg"); %>
 <% if(msg != null && !msg.isEmpty()){ %>
 <h2 style="color:green"><%= msg %></h2>
 <%} %>
 
 <%String errMsg = (String)request.getAttribute("errMsg"); %>
 <% if(errMsg != null && !errMsg.isEmpty()){ %>
 <h2 style="color:red"><%= errMsg %></h2>
 <%} %>
<!DOCTYPE html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>cusomer login</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="/bootstrap-4.4.1-dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="${css}/consumerLogin.css">
    
</head>
<body>
    
    <div class="container-fluid bg">
        <div class="row">
            <div class="col-md-4 col-sm-4 col-xs-12"></div>
            <div class="col-md-4 col-sm-4 col-xs-12">
                <form action="./consumerLogin" id="login"  method="post">
                    <h3>Consumer Login</h3>
                    <img class="img rounded-circle " src="${images}/login.png">
                    <div>
                        <label>Meter Number</label>
                        <input type="text" class="form-control" name="meterNumber" id="meterNum" placeholder=" Enter Meter Number/RR Number" >
                    </div>
                    <div>
                        <label>Password</label>
                        <input type="password" class="form-control" name="password" id ="password" placeholder=" Enter Password">
                    </div>
                    <div>
                        <label><input type="checkbox" name="checkbox">Remember me</label>
                        <p>Forgot</label>&nbsp;&nbsp;<a
                            href="#">Password</a>
                    </p>
                    </div>
                    <div>
                        <button type="submit" class="btn btn-success">SUBMIT</button>
                        <button type="reset" class="btn btn-success">RESET</button>
                    </div>
                    <div><br>
                        <p style="text-align: center;">Not a registered Consumer ?</label>&nbsp;&nbsp;<a
                                href="./consumerRegister">Register</a>
                        </p>
                    </div>
                </form>
            </div>
            <div class="col-md-4 col-sm-4 col-xs-12"></div>
        </div>

    </div>

    <script src="${js}/consumerLogin.js"></script>
    <script src="${js}/jquery-3.4.1.js"></script>
    <script src="${js}/bootstrap.min.js"></script>
</body>

</html>