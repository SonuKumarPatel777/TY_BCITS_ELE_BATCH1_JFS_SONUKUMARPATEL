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
    <title>Admin login</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="/bootstrap-4.4.1-dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="${css}/officerlogin.css">
</head>

<body>
  <%String errMsg = (String)request.getAttribute("errMsg"); %>
  <% if(errMsg != null && !errMsg.isEmpty()){%>
 <h2 style="color:red; margin-left: 310Px;"><%= errMsg %></h2>
 <%}%>
 <%String msg = (String)request.getAttribute("msg"); %>
  <% if(msg != null && !msg.isEmpty()){%>
 <h2 style="color:red; margin-left: 310Px;"><%= msg %></h2>
 <%}%>
    <div class="container-fluid bg">
        <div class="row">
            <div class="col-md-4 col-sm-4 col-xs-12"></div>
            <div class="col-md-4 col-sm-4 col-xs-12">
                <form action="adminLogin" id="login" method="post">
                    <h3>Admin Login</h3>
                    <img class="img rounded-circle " src="${images}/admin.png">
                    <div>
                        <label>User ID</label>
                        <input type="text" class="form-control" name="userId" placeholder=" Enter Your User ID">
                    </div>
                    <div>
                        <label>Password</label>
                        <input type="password" class="form-control" name="password" placeholder=" Enter password">
                    </div>
                    <div>
                        <label><input type="checkbox" name="checkbox">Remember me</label>
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