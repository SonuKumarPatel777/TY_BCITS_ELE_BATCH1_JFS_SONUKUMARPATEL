<%@page import="com.bcits.discomusecase.beans.CurrentBillBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
    <%Double currentBill= (Double)request.getAttribute("currentBill"); %>
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
                         <h4>Bill Amount :<%= currentBill %></h4>
            <table>
                <tr>
                    <td></td>
                    <td></td>
                </tr>
                <tr>
                    <td><label class="label">Card holder:</label></td>
                </tr>
                <tr>
                    <td><input type="text" class="input" name="cardHolder" id="cardHolder" onkeypress="return (event.charCode > 64 && 
                        event.charCode < 91) || (event.charCode > 96 && event.charCode < 123) || event.charCode != 8"  placeholder="Card holder Name" ></td>
                </tr>

                <tr>
                    <td><label class="label">Card Number:</label></td>
                </tr>
                <tr>
                    <td><input type="text" class="input" name="cardNumber" id="cardNumber" onkeypress="return (event.charCode >= 48 &&
                        event.charCode <= 57)" maxlength="16" placeholder="Card Number" ></td>
                </tr>
                <tr>
                    <td> <label class="label">Expiry date</label></td>
                </tr>
                <tr>
                    <td><input type="text"  class="input" oninput="expiryDateValidation()" name="expiryDate" id="expiryDate" placeholder="00 / 00" ></td>
                   
                </tr>
                <tr>
                    <td><label class="label">CVC</label></td>
                </tr>
                <tr>
                    <td> <input type="text" class="input" maxlength="3" onkeypress="return (event.charCode >= 48 &&
                        event.charCode <= 57)" name="cvc" id="" placeholder="000" ></td>
                </tr>
                <tr>
                    <td><input type="submit" value="Pay">&nbsp;&nbsp;&nbsp;
                    <input type="reset" value="Reset"></td>
                </tr>
            </table>

        </form>

        <!-- javascript -->
        <Script>
            

            function expiryDateValidation() {
                    var x = document.getElementById("expiryDate").value;
                    var y = "";
                    for(var i = 0;i<=(x.toString().length - 1);i++){
                        if(x.charAt(i) != '/' && !(isNaN(x.charAt(i)))){
                            y= y + x.charAt(i);
                        }
                    }
                    console.log(y,y.length)
                    if(y.length == 0){
                        x=y;
                        document.getElementById("expiryDate").value = x;
                    }else if(y.length == 1){
                        x=y;
                        document.getElementById("expiryDate").value = x;
                    }else if(y.length == 2){
                        x=y;
                        document.getElementById("expiryDate").value = x;
                    }else if(y.length == 3){
                        x= y.charAt(0)+y.charAt(1)+'/'+y.charAt(2);
                        document.getElementById("expiryDate").value = x;
                    }else{
                        x= y.charAt(0)+y.charAt(1)+'/'+y.charAt(2)+ y.charAt(3);
                        document.getElementById("expiryDate").value = x;
                    }
            }
        </Script>
     <script src="${js}/jquery-3.4.1.js"></script>
    <script src="${js}/bootstrap.min.js"></script>
</body>

</html>