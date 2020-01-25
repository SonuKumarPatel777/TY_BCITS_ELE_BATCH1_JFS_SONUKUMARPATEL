<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <% String msg =(String)request.getAttribute("msg");
    String errMsg =(String)request.getAttribute("errMsg");%>
    <<jsp:include page="header.jsp"></jsp:include>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee Managemet Portal</title>
</head>
<body>
<fieldset>
		<legend>DElete Employee</legend>
		<form action="./delete">
			<label>Employee ID:</label>
			 <input type="text" name="empId" required><br>
			<input type="submit" value="Search">
		</form>
	</fieldset>
	<% if(msg != null && msg.isEmpty()) {%>
	<h3 style="color:green"><%= msg %></h3>
	<%} %>
	<% if(errMsg != null && errMsg.isEmpty()) {%>
	<h3 style="color:red"><%= errMsg %></h3>
	<%} %>
	

</body>
</html>
<jsp:include page="footer.jsp"></jsp:include>