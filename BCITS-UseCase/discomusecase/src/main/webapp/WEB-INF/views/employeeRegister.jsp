<%@page import="com.bcits.discomusecase.beans.AdminMasterBean"%>
<%@page import="com.bcits.discomusecase.beans.ConsumersMasterBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
    
    <spring:url var="css" value="/resources/css"/>
    <spring:url var="js" value="/resources/js"/>
    <spring:url var="images" value="/resources/images"/>
    <jsp:include page="adminHomePage.jsp"/>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>AdminDetails</title>
<link rel="stylesheet" href="${css}/cusomerRegister.css">
</head>
<body>
     <form action="./addEmployee" id="register" method="post">
                <h3 style="color: red">Employee Registation(BY ADMIN ONLY)</h3>
                <input type="text" name="name"  placeholder="Employee Name*"><br>
                <input type="number"  name="employeeId"  placeholder="Employee Id">   
                <select name="region" style="width:544Px">
                    <option selected >select Region</option>
                    <option>Bangalore North</option>
                    <option>Bangalore South</option>
                </select> 
                 <br>
                <input type="text"  name="designation" id="" placeholder="Designation *"><br>
                <input type="password" name="password" id="" placeholder="Set A Password"><br>
                <input type="password" name="cnfPassword" id="" placeholder="Re-Enter The Password"><br><br>
                <label><input type="checkbox" name="checkbox">By creating an account you agree to our Terms & Condition</label><br>
                <button type="submit" class="btn btn-success">SUBMIT</button>
                <button type="reset" class="btn btn-success">RESET</button>
            </form>
</body>
</html>