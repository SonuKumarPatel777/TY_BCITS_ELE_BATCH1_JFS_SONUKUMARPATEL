<%@page import="com.bcits.discomusecase.beans.CurrentBillBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
    <spring:url var="css" value="/resources/css"/>
    <spring:url var="js" value="/resources/js"/>
    <spring:url var="images" value="/resources/images"/>
    <jsp:include page="adminHomePage.jsp"/>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>TarrifChangePage</title>
    <link rel="stylesheet" href="${css}/consumerPaymentPage.css">
</head>

<body>
        <form action="./setTheTarrif" method="post">
                         <h2>Tarrif Change</h2>
                          
         <table>
                <tr>
                    <td><label class="label">Type Of Consumer :</label></td></td>
                </tr>
                <tr>
                    <td><input type="text" class="input" name="typeOfConsumer" placeholder="${typeOfConsumer}"></td>
                </tr>
                <tr>
                    <td><label class="label">Units Range:</label></td>
                </tr>
                <tr>
                    <td><input type="tel" class="input" name="unitsRange" placeholder="${unitsRange}"></td>
                </tr>

                <tr>
                    <td><label class="label">Mulitplayer Amount:</label></td>
                </tr>
                <tr>
                    <td><input type="tel" class="input" name="mulitplayerAmount"  placeholder="${mulitplayerAmount}" ></td>
                </tr>
                 <tr>
                    <td><input type="submit" value="Set">&nbsp;&nbsp;&nbsp;
                    <input type="reset" value="Reset"></td>
                </tr>
            </table> 

        </form>
     
</body>

</html>