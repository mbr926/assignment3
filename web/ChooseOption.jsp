<%-- 
    Document   : ChooseOption
    Created on : Nov 2, 2018, 2:44:49 PM
    Author     : Abdulrahman
--%>

<%@ page language="java" 
         contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"
         import="aba.GeneralBean"
         import="aba.Schedule"

         %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <title>Course Registration</title>
    </head>
    <body>
<!-- getting the user bean from the class "GeneralBean" -->

        <% GeneralBean User = ((GeneralBean) (session.getAttribute("UserSession")));

            if ((session.getAttribute("UserSession") == null || session.getAttribute("UserSession").equals(""))) {
                request.getRequestDispatcher("index.jsp").include(request, response);
                out.print("No User Session! You Need to Login Before Registering a Class!");
            } else {

        %> 
        Today is: <%= java.util.Calendar.getInstance().getTime()%> <br>
        Welcome Back <%= User.getFirstName() + " " + User.getLastName()%>! 
        <div align="center"><h3>Please select The Transaction You Want To Perform!</h3></div> <br> <hr>
    <center><form action="Schedule" method="post" >
            <input type="submit" style="text-decoration: none; width:200px;" value="Go to My Shdeule"><hr>


            <input type="hidden" id="UID" name="UID" value="<%= User.getUsername()%>">


        </form></center>
    <center> <a href="course_registration.jsp"><button style="text-decoration: none;  width:200px;">Register for a class</button></a></center> <hr>
    <center><a href="logout"><button style="text-decoration: none;  width:200px;">Logout</button></a></center><hr>

</body>
<% }%>
</html>



