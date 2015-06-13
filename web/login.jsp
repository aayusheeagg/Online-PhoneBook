
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <link rel="icon" type="image/ico" href="images/logo.png"/>
        <link href="styles/mystyle.css" rel="stylesheet" type="text/css" />

    </head>
    <body>
        <div id="page">
            <img src="images/logo.png" style="height: 150px; width:100px; margin-left: 10px; "/>
            <c:if test="${(!status && !login) || (!status && login)}">
                <form action="validate?action=login" method="POST">
                    <table border="0" cellpadding="10">
                        <tbody>
                            <tr>
                                <td>User Name : </td>
                                <td><input type="text" required name="userName" value="${userName}"/></td>
                            </tr>
                            <tr>
                                <td>Password : </td>
                                <td><input type="password" required name="pass"  /></td>
                            </tr>
                            <tr>
                                <td colspan="2" align="center">
                                    <input type="submit" value="Login"/>                           
                                    <input type="button" value="Cancel" onclick="history.go(-1)" />
                                </td>
                            </tr>
                        </tbody>
                    </table>
                </form>
            </c:if>


            <c:if test="${logout && !status &&!login}">
                <h3 style="color: green">You are now logged out.</h3>
            </c:if>
            <c:if test="${status && login}">
                <h3 style="color: green">Welcome ${userName}, you are now logged in..</h3>
            </c:if>
            <c:if test="${!status && login}">
                <h3 style="color: green">Incorrect Credentials..</h3>
            </c:if>
            <c:if test="${changed}">
                <h3 style="color: green">Password Changed Successfully...</h3>
            </c:if> 
            
            



        </div>
    </body>
</html>
