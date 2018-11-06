package aba;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Abdulrahman
 */
@WebServlet(name = "Registration", urlPatterns = {
    "/Registration"
})
public class Registration extends HttpServlet {

    static Connection con = null;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=windows-1256");
        PrintWriter out = response.getWriter();

        GeneralBean user = new GeneralBean();
        user.setUserName(request.getParameter("username"));
        user.setPassword(request.getParameter("password"));

        //getParameter to get the values from the previous page
        String username = request.getParameter("UID");
        String title = request.getParameter("title");
        String semester = request.getParameter("semester");
        String day = request.getParameter("day");
        String time = request.getParameter("time");
        String units = request.getParameter("units");
        String building = request.getParameter("building");

        try {
            // connect to DB
            con = config.getConnection();

            PreparedStatement statement = con.prepareStatement // insert statemene the "course" table the information of the class to the databse
                    ("INSERT INTO course (title, semester,UID, day,time, units,building) VALUES (?,?,?,?,?,?,?)");

            //insert the "course" table the information of the class to the databse
            statement.setString(1, title);
            statement.setString(2, semester);
            statement.setString(3, username);
            statement.setString(4, day);
            statement.setString(5, time);
            statement.setString(6, units);
            statement.setString(7, building);
            int i = statement.executeUpdate();

            if (i > 0) {
                out.println("<br><br><h3><center>You are sucessfully registered for the class!</center></h3>");
            } else {
                out.println("Error!");
            }
        } catch (Exception se) {
            System.out.println("Error!" + se);
        }

    }

}
