<%@page import="com.bcits.springsecuritymvc.beans.EmpInfoBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <jsp:include page="header.jsp"/>
          <% List<EmpInfoBean>  empInfoBeanList= (List<EmpInfoBean>) request.getAttribute("empInfoBeanList"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Get All Employees</title>
</head>
<body>
    <%if(empInfoBeanList != null) {%>
       <table>
            <thead>
			<tr style="background: navy; color:white;">
			   <td>Employee ID</td>
			   <td>Name</td>
			   <td>Password</td>
			   <td>Role</td>
			    
			</tr>
			</thead>
			 <tbody>
			   <% for(EmpInfoBean empInfoBean:empInfoBeanList ) {%>
			   <tr>
			   <td><%= empInfoBean.getEmpId()%></td>
			   <td><%= empInfoBean.getName()%></td>
			   <td><%= empInfoBean.getPassword()%></td>
			   <td><%= empInfoBean.getRole()%></td>
			 </tr>
			 <%} %>
			 </tbody>
			</table>
    <%} else{%>
       <h3 style="color: red">Employee ID Not Found !!!</h3>
    <%} %>
</body>
</html>