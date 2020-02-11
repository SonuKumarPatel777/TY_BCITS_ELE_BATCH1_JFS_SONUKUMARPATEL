<%@page import="com.bcits.discomusecase.beans.TarrifMasterBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%List<TarrifMasterBean> tarrifMasterList = (List<TarrifMasterBean>)request.getAttribute("tarrifMasterList");%>
     <%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
    
    <spring:url var="css" value="/resources/css"/>
    <spring:url var="js" value="/resources/js"/>
    <spring:url var="images" value="/resources/images"/>
    <jsp:include page="adminHomePage.jsp"/>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>TarrifDetails</title>
</head>
<body>
      <% if(tarrifMasterList != null && !tarrifMasterList.isEmpty()  ){ %>
<table border ="1" style='width:70%; margin-left: 200px; margin-top: 70px'>
	     <thead style='background-color: navy; color: white'>
	         <tr style="height:35px">
	         <th>Sl. NO.</th>
	         <th>Type Of Consumer</th>
	         <th>Units Range</th>
	         <th>Mulitplayer Amount</th>
	         <th>Tarrif Change</th>
	         </tr>
	     </thead>
	     <% int i=1;
	     for( TarrifMasterBean tarrifMasterBean
	    		 :tarrifMasterList){ %>
	          <form action="./tarrifChange">
	    		 <input name="typeOfConsumer" type="text" value="<%= tarrifMasterBean.getTarrifMasterPK().getTypeOfConsumer() %>" hidden="true">
	    		 <input name="unitsRange" type="text" value="<%= tarrifMasterBean.getTarrifMasterPK().getUnitsRange() %>" hidden="true">
	        <tr style="height:35px">
	        <td><%= i %></td>
	        <td><%= tarrifMasterBean.getTarrifMasterPK().getTypeOfConsumer() %></td>
	        <td><%= tarrifMasterBean.getTarrifMasterPK().getUnitsRange() %></td>
	        <td><%= tarrifMasterBean.getMulitplayerAmount()%></td>
	        <td><input type="submit" value="Click Here To Change Tarrif"></td> 
	        </tr>
	     </form>
	<%i++;} 
     }else {%>
	<h2 style="color: red">No Tarrif :)</h2>
	<%} %>
   </table>
</body>
</html>