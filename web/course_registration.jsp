<%-- 
    Document   : course_registration
    Created on : Oct 29, 2018, 9:24:56 PM
    Author     : Abdulrahman
--%>

<%@ page language="java" 
         contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"
         import="aba.GeneralBean"

         %>



<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <title>Course Registration</title>
    </head>
    <body>
        <!-- getting the user bean from the class "GeneralBean" -->
        <%GeneralBean User = ((GeneralBean) (session.getAttribute("UserSession")));

            if ((session.getAttribute("UserSession") == null || session.getAttribute("UserSession").equals(""))) {
                response.sendRedirect("index.jsp");
            } else {
        %> 

        <!-- getting and printing the data  -->

        Today is: <%= java.util.Calendar.getInstance().getTime()%> <br>

        <!-- Welcome the user  -->
        Welcome <%= User.getFirstName() + " " + User.getLastName()%>! 
        <div align="center"><h3>Please select the class you would like to be enrolled in!</h3></div>
        <form action="Schedule" method="post">
            <input type="hidden" id="UID" name="UID" value="<%= User.getUsername()%>">
            <a style="text-decoration: none;" href="course_registration.jsp"><button>Register for a class</a></button>
              <a style="text-decoration: none;" href="logout"><button>Logout</a></button>
</form>

<form action="Registration" method="post">
    <div align="center">

        <select name="title">

            <option value="INFSCI2430 Social Computing"> INFSCI2430 Social Computing</option>

            <option value="INFSCI 2540 Software Engineering">INFSCI 2540 Software Engineering</option>
            <option value="INFSCI 2550 Client-Server Systems">INFSCI 2550 Client-Server Systems</option>
            <option value="INFSCI 2560 Web Technologies & Standards">INFSCI 2560 Web Technologies & Standards</option>
            <option value="INFSCI 2470 Interactive System Design">INFSCI 2470 Interactive System Design</option>
            <option value="INFSCI 2500 Data Structures">INFSCI 2500 Data Structures</option>
            <option value="INFSCI 2545 Software Quality Assurance">INFSCI 2545 Software Quality Assurance</option>
            <option value="INFSCI 2595 Machine Learning">INFSCI 2595 Machine Learning</option>
            <input type="hidden" id="UID" name="UID" value="<%= User.getUsername()%>">
            <input name="day" type="hidden" id="hidden" value="Monday">
            <input name="time" type="hidden" id="hidden" value="6-9">
            <input name="units" type="hidden" id="hidden" value=3>
            <input name="building" type="hidden" id="hidden" value="IS501"> 
            <select name="semester">
                semester <option value="Spring2018">Spring 2019</option>

            </select>
            <input type="submit" value="submit">
            </div>
            </form>
            <% }%>
            </body>
            </html>