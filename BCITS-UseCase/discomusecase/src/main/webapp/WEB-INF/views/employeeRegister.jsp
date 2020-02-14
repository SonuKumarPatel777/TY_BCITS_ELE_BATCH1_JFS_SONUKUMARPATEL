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
     <form action="./addEmployee" id="formData" onsubmit="validation(); return false" method="post">
                <h3 style="color: red">Employee Registation(BY ADMIN ONLY)</h3>
                <input type="text" name="name" id="employeeName" placeholder="Employee Name*"><br>
                <span id="empName" style="color:red;"></span>
                <input type="number"  name="employeeId" id="empId" placeholder="Employee Id">
                <span id="empId" style="color:red;"></span>   
                <select name="region" style="width:544Px" id="empRegion">
                    <option selected disabled >select Region</option>
                    <option>Bangalore North</option>
                    <option>Bangalore South</option>
                </select>
                <span id="reg" style="color:red;"></span>
                 <br>
                <input type="text"  name="designation" id="empDesignation" placeholder="Designation *"><br>
                <span id="deg" style="color:red;"></span>
                <input type="password" name="password" id="empPassword" placeholder="Set A Password"><br>
                <span id="pwd" style="color:red;"></span>
                <input type="password" name="cnfPassword" id="empConfPassword" placeholder="Re-Enter The Password"><br><br>
                <span id="confPwd" style="color:red;"></span>
                <label><input type="checkbox" name="checkbox">By creating an account you agree to our Terms & Condition</label><br>
                <button type="submit" class="btn btn-success">SUBMIT</button>
                <button type="reset" class="btn btn-success">RESET</button>
            </form>
            <script src="${js}/employeeRegistation.js"></script>
            <script src="${js}/jquery-3.4.1.js"></script>
            <script src="${js}/bootstrap.min.js"></script>
</body>
</html>