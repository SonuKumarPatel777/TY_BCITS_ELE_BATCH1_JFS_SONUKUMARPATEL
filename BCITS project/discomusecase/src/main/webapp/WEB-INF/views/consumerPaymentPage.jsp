<%@page import="com.bcits.discomusecase.beans.CurrentBillBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
    <%CurrentBillBean currentBillBean= (CurrentBillBean)request.getAttribute("currentBillBean"); %>
    <spring:url var="css" value="/resources/css"/>
    <spring:url var="js" value="/resources/js"/>
    <spring:url var="images" value="/resources/images"/>
    <jsp:include page="consumerHomePage.jsp"/>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Payment Page</title>
    <link rel="stylesheet" href="${css}/consumerPaymentPage.css">
</head>

<body>
        <form action="./paymentSuccessfullPage" method="post">
                         <h2>Payment Gateway</h2>
                         <h4>Bill Amount :<%= currentBillBean.getBillAmount() %></h4>
            <table>
                <tr>
                    <td></td>
                    <td></td>
                </tr>
                <tr>
                    <td><label class="label">Card holder:</label></td>
                </tr>
                <tr>
                    <td><input type="text" class="input" name="cardHolder" id="" placeholder="Card holder Name"></td>
                </tr>

                <tr>
                    <td><label class="label">Card Number:</label></td>
                </tr>
                <tr>
                    <td><input type="text" class="input" name="cardNumber" id="" placeholder="Card Number"></td>
                </tr>
                <tr>
                    <td> <label class="label">Expiry date</label></td>
                </tr>
                <tr>
                    <td><input type="text" class="input" name="expiryDate" id="" placeholder="00 / 00"></td>
                    
                </tr>
                <tr>
                    <td><label class="label">CVC</label></td>
                </tr>
                <tr>
                    <td> <input type="text" class="input" name="cvc" id="" placeholder="000"></td>
                </tr>
                <tr>
                    <td><input type="submit" value="Pay">&nbsp;&nbsp;&nbsp;
                    <input type="reset" value="Reset"></td>
                </tr>
            </table> 

        </form>
     
</body>

</html>