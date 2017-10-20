<%-- 
    Document   : add
    Created on : Oct 6, 2017, 11:31:46 AM
    Author     : itzjs
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add A New Lifter</title>
        <link rel="stylesheet" type="text/css" href="css/CSS_Formating.css"/>
    </head>
    <body>
        <div class="wrap">

            <%@ include file="includes/header.jsp" %>
            <%@ include file="includes/menu.jsp" %>

            <div class="main">

                <h1>Add A New Lifter</h1>

                <form name="addForm" action="addLifter" method="get">

                    <label>Lifter Name:</label>
                    <input type="text" name="name" value="" />
                    <br>

                    <label>Lifter Age:</label>
                    <input type="text" name="age" value="" />
                    <br>

                    <label>Lifter Weight:</label>
                    <input type="text" name="weight" value="" />
                    <br>

                    <label>Lifter Height:</label>
                    <input type="text" name="height" value="" />
                    <br>

                    <label>Lifter Class:</label>
                    <input type="text" name="lclass" value="" />
                    <br>

                    <input type="submit" name="submit" value="Submit" />


            </div>
            <%@ include file="includes/footer.jsp" %>
        </div>
    </body>
</html>
