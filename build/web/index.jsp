<%-- 
    Document   : index
    Created on : Oct 28, 2018, 4:26:05 PM
    Author     : Abdulrahman
--%>

<%@ page language="java" 
         contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"
         %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login to the Registration System</title>
    </head>

    <body>
        <br><br><h3><center> WELCOME TO COURSE REGISTRATION! </center></h3>
        <form action="LoginServlet" ><center>

                <input name="username" type="text" title="username" placeholder="Username" />
                <br>
                <input name="password" type="password" title="password" placeholder="Password" />
                <br>
                <input type="submit" value="Submit">			

            </center></form>
    </body>
</html>
