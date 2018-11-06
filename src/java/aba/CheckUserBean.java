package aba;

/**
 *
 * @author Abdulrahman
 */
import java.sql.*;
// the main class for check the database for login

public class CheckUserBean {

    //ResultSet and Connection is declared to be used in the sql query

    static Connection con = null;
    static ResultSet rs = null;

    public static GeneralBean login(GeneralBean bean) {

        //preparing sql and the connection objects to be used from the connection file "config" 
        Statement stmt = null;

        String username = bean.getUsername();
        String password = bean.getPassword();
        // sql for searching for the user in the DB
        String sql
                = "select * from USERS where username='"
                + username
                + "' AND password='"
                + password
                + "'";

        try {
            //connect to DB 
            con = config.getConnection();
            stmt = con.createStatement();
            rs = stmt.executeQuery(sql);
            boolean user_login = rs.next();

            // if user does not exist set the isValid variable to false
            if (!user_login) {
                System.out.println("Sorry, You Need To Login Before Accessing The System");
                bean.setValid(false);
            } //if user exists set the isValid variable to true
            else if (user_login) {
                // getting firstName and lastName
                String firstName = rs.getString("FirstName");
                String lastName = rs.getString("LastName");
// setting the bean for firstName and lastName
                bean.setFirstName(firstName);
                bean.setLastName(lastName);
                bean.setValid(true);
            }
        } // catch erorr 
        catch (Exception ex) {
            System.out.println("Error! " + ex);
        } // exception handler
        finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (Exception e) {
                }
                rs = null;
            }

            if (stmt != null) {
                try {
                    stmt.close();
                } catch (Exception e) {
                }
                stmt = null;
            }

            if (con != null) {
                try {
                    con.close();
                } catch (Exception e) {
                }

                con = null;
            }
        }

        return bean;

    }
}
