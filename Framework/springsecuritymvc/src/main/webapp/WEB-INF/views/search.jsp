<%@page import="com.bcits.springsecuritymvc.beans.EmpInfoBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <jsp:include page="header.jsp"/>
    <% EmpInfoBean  empInfoBean= (EmpInfoBean) request.getAttribute("empInfoBean"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
   <div align ="center">
   <fieldset style="width: 60%">
   <legend> Search Employee</legend>
   <form action="./getEmployee">
   Employee ID :&nbsp;&nbsp; <input type= "number" name="empId" required><br>
   <input type= "submit"  value="search">
   </form>
   </fieldset>
   </div>
   <%if(empInfoBean != null) {%>
       <table>
            <thead>
			<tr style="background: navy; color:white;">
			   <td>Employee ID</td>
			   <td>Name</td>
			   <td>Password</td>
			   <td>Role</td>
			    
			</tr>
			</thead>
			<tr>
			   <td><%= empInfoBean.getEmpId()%></td>
			   <td><%= empInfoBean.getName()%></td>
			   <td><%= empInfoBean.getPassword()%></td>
			   <td><%= empInfoBean.getRole()%></td>
			 </tr>
			</table>
    <%} else{%>
       <h3 style="color: red">Employee ID Not Found !!!</h3>
    <%} %>
</body>
</html>