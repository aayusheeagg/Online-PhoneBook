<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add your Contact</title>
        <link rel="icon" type="image/ico" href="images/logo.png"/>
        <link href="styles/mystyle.css" rel="stylesheet" type="text/css" />

    </head>
    <body>
        <div id="page">
            <img src="images/logo.png" style="height: 150px; width:100px; margin-left: 10px; "/>
             <c:if test="${added}">
                <h3 style="color: green">Contact Added Successfully..</h3>
            </c:if>
                
            <form action="AddContact" method="POST">
                <table border="0" cellpadding="10">
                    <tbody>
                        <tr>
                            <td>Name : </td>
                            <td><input type="text" required name="name" size="30" /></td>
                        </tr>
                        <tr>
                            <td>Mobile Number : </td>
                            <td><input type="text" required name="mobile"  size="30"/></td>
                        </tr>
                        <tr>
                            <td>E-mail : </td>
                            <td><input type="text"  name="email"  size="30" /></td>
                        </tr>                        
                        <tr>
                            <td>Date Of Birth : </td>
                            <td><input type="text" name="dob" size="30" /></td>
                        </tr>
                        <tr>
                            <td>City : </td>
                            <td><input type="text"  name="city"  size="30"/></td>
                        </tr>
                        <tr>
                             <td>Gender : </td>
                             <td>
                            <input type="radio" name="gender" value="male" checked="checked" />Male
                            <input type="radio" name="gender" value="female" />Female
                             </td>
                     </tr>
                     <tr>
                         <td>Photo :</td>
                         <td><input type="file" name="photo"</td>
                     </tr>
                     <tr>
                         <td>Category :</td>
                         <td>
                    <select name="category">
                        <option>Personal</option>
                        <option>College</option>
                        <option>Family</option>
                        <option>Friends</option>
                        <option>Others</option>
                    </select>
                         </td>
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
        </div>
    </body>
</html>
