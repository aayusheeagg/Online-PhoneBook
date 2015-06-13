<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View Contacts</title>
        <link rel="icon" type="image/ico" href="images/logo.png"/>
        <link href="styles/mystyle.css" rel="stylesheet" type="text/css" />

    </head>
    <body>
        <div id="page">
            <img src="images/logo.png" style="height: 150px; width:100px; margin-left: 10px; "/>
             <c:if test="${none}">
                <h3 style="color: green">Sorry, No Contacts.</h3>
            </c:if>
            
            <h1>List of Contacts</h1>
            <form action="Contacts?action=deleteContact" method="post">
                <table border="1" width="60%" cellpadding="10">
                    <tr>
                        <th>Select</th>
                        <th>Name</th>
                        <th>Mobile Number </th>
                        <th>Email</th>
                        <th>Date Of Birth</th>
                        <th>City</th>
                        <th>Gender</th>
                        <th>Category</th>
                        <th>Edit Contact</th>
                    </tr>

                    <c:forEach items="${list}" var="array" varStatus="loopStatus" >
                        <tr>
                            <td><input type="checkbox" name="check" value="<c:out value="${array.mobileNumber}"/>"/></td>
                            <td><c:out value="${array.name}"/></td>
                            <td><c:out value="${array.mobileNumber}"/></td>
                            <td><c:out value="${array.email}"/></td>
                            <td><c:out value="${array.dateOfBirth}"/></td>
                            <td><c:out value="${array.city}"/></td>
                            <td><c:out value="${array.gender}"/></td>
                            <td><c:out value="${array.category}"/></td>
                            <td><a href="Contacts?action=editContact&mobile=${array.mobileNumber}">Edit</a></td>                     
                        </tr>
                    </c:forEach>
                </table> 
                <br/><input type="submit" value="Delete" />
            </form>
        </div>
    </body>
</html>
