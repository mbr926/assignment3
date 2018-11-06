package aba;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 *
 * @author Abdulrahman
 */

@WebServlet("/Schedule")
public class Schedule extends HttpServlet {

    //declaring variables and objects for sql and connection 
    Connection connection = null;
    ResultSet rs = null;
    PreparedStatement preparedStatement = null;
    String sql = null;
    String url = null;
    String username = null;
    String password = null;

    @Override
    public void init(ServletConfig config) throws ServletException {

        url = "jdbc:derby://localhost:1527/assignment3";
        username = "WEB_TEC";
        password = "WEB_TEC";

        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();

            connection = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException e) {
        }
        System.out.println("Error!");

    }

    @Override
    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {

        doPost(request, response);

    }

    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        // getting UID from the previous page
        String USID = request.getParameter("UID");

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
// sql statement
        sql = "select * from course where UID='" + USID + "' ";
        try {

            preparedStatement = connection.prepareStatement(sql);
            rs = preparedStatement.executeQuery();
            // printing the result of the student's schedule
            out.println("<html><body><h4> Today is:" + java.util.Calendar.getInstance().getTime() + "</h4><center><h2>Your Schedule: </h2></center>");
            out.println("<hr></br><center><table cellspacing='1' cellpadding='3' border='2'>");
            out.println("<tr>");
            out.println("<td><b>Course name</b></td>");
            out.println("<td><b>Semester</b></td>");
            out.println("<td><b>Credit units</b></td>");
            out.println("<td><b>Bulding</b></td>");
            out.println("<td><b>Day</b></td>");
            out.println("<td><b>Time</b></td>");

            out.println("</tr>");

            while (rs.next()) {
                // getting and printing the result of the student's schedule from DB

                out.println("<tr>");
                out.println("<td>" + rs.getString(1) + "</td>");
                out.println("<td>" + rs.getString(2) + "</td>");
                out.println("<td>" + rs.getInt(3) + "</td>");
                out.println("<td>" + rs.getString(4) + "</td>");
                out.println("<td>" + rs.getString(5) + "</td>");
                out.println("<td>" + rs.getString(6) + "</td>");
                out.println("</tr>");

            }
            out.println("</table></center></br></body></html>");

        } catch (SQLException e) {
            System.out.println("Error!" + e);

        }

    }

    @Override
    public void destroy() {
        try {
            rs.close();
            preparedStatement.close();
        } catch (SQLException e) {

            e.printStackTrace();
        }

    }

}
