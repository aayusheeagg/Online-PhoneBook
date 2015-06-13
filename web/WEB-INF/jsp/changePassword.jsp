<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Change Password</title>
        <link rel="icon" type="image/ico" href="images/logo.png"/>
        <link href="styles/mystyle.css" rel="stylesheet" type="text/css" />

    </head>
    <body>
        <div id="page">
            <img src="images/logo.png" style="height: 150px; width:100px; margin-left: 10px; "/>
            <form action="validate?action=changepass" method="POST">
                <table border="0" cellpadding="10">
                    <tbody>
                        <tr>
                            <td>User Name : </td>
                            <td><input type="text" required name="userName" size="30" /></td>
                        </tr>
                        <tr>
                            <td>Current Password : </td>
                            <td><input type="password" required name="currentpass" size="30" /></td>
                        </tr>
                        <tr>
                            <td>New Password : </td>
                            <td><input type="password" required name="newpass"  size="30"/></td>
                        </tr>
                        <tr>
                            <td>Confirm Password : </td>
                            <td><input type="password" required name="confirmpass"  size="30" /></td>
                        </tr> 
                        <tr>
                        <td colspan="2" align="center">
                            <input type="submit" value="Submit"/>                           
                            <input type="button" value="Reset"/>
                        </td>
                        </tr>
                    </tbody>
                </table>
            </form>

            <c:if test="${wrong}">
                <h3 style="color: green">Sorry,Password does not match.</h3>
            </c:if>     

        </div>
    </body>
</html>
