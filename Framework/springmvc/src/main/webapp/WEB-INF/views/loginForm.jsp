<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <% System.out.println("Inside JSP file");%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
     <fieldset>
     
         <legend> Employee Login</legend> 
         <!-- <form action="./login1" method="post"> -->
         <!-- <form action="./login2" method="post"> -->
         <!-- <form action="./login3" method="post"> -->
         <form action="./login4" method="post">
              <table>
              <tr>
                  <td>Employee Id</td>
                  <td>:</td>
                  <td><input type="text" name="empId"></td>
              </tr>
              <tr>
                  <td>Employee name</td>
                  <td>:</td>
                  <td><input type="text" name="name"></td>
              </tr>
              <tr>
                  <td>Password</td>
                  <td>:</td>
                  <td><input type="password" name="password"></td>
              </tr>
              <tr>
                  <td></td>
                  <td><input type="submit" value="Login"></td>
                  <td></td>
              </tr>
              </table>
         </form>   
     </fieldset>
</body>
</html>