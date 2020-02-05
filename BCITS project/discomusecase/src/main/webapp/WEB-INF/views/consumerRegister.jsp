<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
    
    <spring:url var="css" value="/resources/css"/>
    <spring:url var="js" value="/resources/js"/>
    <spring:url var="images" value="/resources/images"/>
    <jsp:include page="header.jsp"/>
<!DOCTYPE html>
 <% String errMsg = (String)request.getAttribute("msg"); %>
 <% if(errMsg != null && !errMsg.isEmpty()){ %>
 <h2 style="color:green"><%= errMsg %></h2>
 <%} %>
     
<html lang="en">
<head>
      <meta charset="UTF-8">
      <meta name="viewport" content="width=device-width, initial-scale=1.0">
      <meta http-equiv="X-UA-Compatible" content="ie=edge">
      <title>consumerRegisterPage</title>
      <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
      <link rel="stylesheet" href="/bootstrap-4.4.1-dist/css/bootstrap.min.css">
      <link rel="stylesheet" href="${css}/cusomerRegister.css">
</head>
<body>

    <div class="container-fluid bg">
        <div class="row col-md-4 col-sm-4 col-xs-12">
            <form action="./addConsumer" id="register" method="post">
                <h3>Consumer Register Here</h3>
                <input type="text" name="name" id="" placeholder="Consumer Name*"><br>
                <input type="text" name="meterNumber" id="" placeholder="Enter Meter Number/RR Number*"><br>  
                <input type="email" name="email" id="" placeholder="Email Address">
                <input type="tel" name="phoneNumber" id="" placeholder="Phone Number."><br>
                <select name="region">
                    <option selected >select Region</option>
                    <option>Bangalore North</option>
                    <option>Bangalore South</option>
                </select> 
                <select name="consumerType">
                    <option selected >Type of consumer</option>
                    <option>Residential</option>
                    <option>Commercial</option>
                    <option>Industries </option>
                </select><br>
                <input type="date"  name="dateOfConnection" id="" placeholder="Date Of Connection" >
                <input type="number"  name="houseNumber" id="" placeholder="House Number *" >
                <input type="text"  name="address1" id="" placeholder="Address Line 1"> 
                <input type="text"  name="address2" id="" placeholder="Address Line 2"><br> 
                <input type="text" name="city" id="" placeholder="City">
                <input type="text" name="zip" id="" placeholder="Zip"><br>
                <input type="password" name="password" id="" placeholder="Set A Password"><br>
                <input type="password" name="cnfPassword" id="" placeholder="Re-Enter The Password"><br><br>
                <label><input type="checkbox" name="checkbox">By creating an account you agree to our Terms & Condition</label>
                <button type="submit" class="btn btn-success">SUBMIT</button>
                <button type="reset" class="btn btn-success">RESET</button>
            </form>
        </div>
        </div>
    </div>
    <script src="/Jquery/jquery-3.4.1.js"></script>
    <script src="/bootstrap-4.4.1-dist/js/bootstrap.min.js"></script>

</body>
</html>