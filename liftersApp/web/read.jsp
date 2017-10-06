
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Iowa City Lifters</title>
    </head>
    
    <% String table = (String) request.getAttribute("table"); %>
    
    <body>
        <h1>Iowa City Lifters</h1>
        <%= table %>
        
        <br><br>
        <a href ="add"> Add A New Lifter </a>
        
    </body>
</html>
