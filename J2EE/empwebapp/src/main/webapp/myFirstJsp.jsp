<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%!
     private int a= 10;
    public void setA(int a){
    	this.a=a;
    }
    public int getA(){
    	return a;
    }
    public String name= "Seema";
     public String getName(){
    	 return name;
     }
     public String getName(String name){
    	 return name;
     }
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
     <h1 style='color:green'>Welcome  to JSP...</h1>
     
     a= <%= a %><br>
     a= <%= getA() %><br>
     <%setA(100); %>
     a= <%= getA() %><br> <br>
     Name = <%= name %><br>
     name= <%= getName() %><br>
     name= <%= getName("Dinga") %><br><br>
     
     <% for(int i=0;i<5;i++) { %>
     <%= getName() %><br>
     <%} %>

</body>
</html>
<!-- Forward -->
<%-- <jsp:forward page="./date.html"/> --%><%-- Static resource --%>
<%-- <jsp:forward page="./currentDate"/> --%><%-- dynamic resource --%>
<%-- <jsp:forward page="./searchEmp?empId=1245"/> --%>
<%-- <jsp:forward page="./searchEmp">
<jsp:param  name="empId" value="1245"/>
</jsp:forward> --%> 

<!--include  -->
<%-- <jsp:include page="/date.html"/> --%><%-- Static resource --%>
<%-- <jsp:include page="/currentDate"/> --%><%-- dynamic resource --%>
<%-- <jsp:include page="/searchEmp?empId=1245"/> --%>
<%-- <jsp:include page="/searchEmp">
<jsp:param  name="empId" value="1245"/>
</jsp:forward> --%> 

<%-- <%@ include file="date.html"%> --%>
 
 












