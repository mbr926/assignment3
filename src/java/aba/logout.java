package aba;

import java.io.IOException;  
import java.io.PrintWriter;  
  
import javax.servlet.ServletException;  
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
import javax.servlet.http.HttpSession; 
/**
 *
 * @author Abdulrahman
 */
@WebServlet("/logout")


public class logout extends HttpServlet {  
        protected void doGet(HttpServletRequest request, HttpServletResponse response)  
                     
                throws ServletException, IOException {  
            response.setContentType("text/html");  
            PrintWriter out=response.getWriter();  
             // redirect the user to the login page
            request.getRequestDispatcher("index.jsp").include(request, response);  
              
            HttpSession session=request.getSession();  
            // distroy the user's session
            session.invalidate();  
              // print for a message for logged out user 
            out.print("You have logged out successfully!");  
              
            out.close();  
    }  
}  