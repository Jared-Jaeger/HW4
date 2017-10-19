<%-- 
    Document   : updateForm
    Created on : Oct 19, 2017, 8:35:49 AM
    Author     : itzjs
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.Lifters"%>
<% Lifters lifter = (Lifters) request.getAttribute("lifter"); %>
        
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Lifter</title>
        <link rel="stylesheet" type="text/css" href="CSS_Formating.css"/>
    </head>
    <body>
        <div class ="centerAlign">
        <h1>Update Lifter</h1>
        <hr class="style18">
        
        <form name="updateForm" action="updateLifter" method="get">
        
            <table class = "update">
                
                <tr>
                    <td>Lifter ID:</td>
                    <td><input type="text" name="id" value="<%= lifter.getLifterID() %>" readonly/></td>
                </tr>
                
                <tr>
                    <td>Lifter Name:</td>
                    <td><input type="text" name="name" value="<%= lifter.getLifterName() %>" /></td>
                </tr>
            
                <tr>
                    <td>Lifter Age:</td>
                    <td><input type="text" name="age" value="<%= lifter.getLifterAge() %>" /></td>
                </tr>
            
                <tr>
                    <td>Lifter Weight:</td>
                    <td><input type="text" name="weight" value="<%= lifter.getLifterWeight() %>" /><td>
                </tr>
            
                <tr>
                    <td>Lifter Height:</td>
                    <td><input type="text" name="height" value="<%= lifter.getLifterHeight() %>" /></td>
                </tr>
            
                <tr>
                    <td>Lifter Class:</td>
                    <td><input type="text" name="lclass" value="<%= lifter.getLifterClass() %>" /></td>
                </tr>
            
            
            
        </table>
                <br>
        <input type="reset" name="reset" value="Clear" />
        <input type="submit" name="submit" value="Update" />
        </div>

    </body>
</html>
