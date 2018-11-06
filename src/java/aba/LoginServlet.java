package aba;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Abdulrahman
 */
public class LoginServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, java.io.IOException {

        try {

            GeneralBean user = new GeneralBean();
            user.setUserName(request.getParameter("username"));
            user.setPassword(request.getParameter("password"));

            user = CheckUserBean.login(user);

            if (user.isValid()) {

                HttpSession session = request.getSession(true);
                session.setAttribute("UserSession", user);
                //redirect the user to   ChooseOption.jsp    
                request.getRequestDispatcher("ChooseOption.jsp").forward(request, response);

            } else {
                response.sendRedirect("LoginFailed.jsp"); //error page 
            }
        } // error handler 
        catch (ServletException | IOException theException) {
            System.out.println(theException);
        }
    }
}
