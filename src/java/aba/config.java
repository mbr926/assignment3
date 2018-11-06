package aba;
import java.sql.*;

/**
 *
 * @author Abdulrahman
 */



public class config {

 static Connection con;
 static String url;

 public static Connection getConnection() {

  try {
   //database connection 
   String url = "jdbc:derby://localhost:1527/assignment3";

   Class.forName("org.apache.derby.jdbc.ClientDriver");

   try {
    con = DriverManager.getConnection(url, "WEB_TEC", "WEB_TEC");

    // Error handler 

   } catch (SQLException ex) {
    System.out.println("Error!" + ex);
   }
  } catch (ClassNotFoundException e) {
   System.out.println(e);
  }

  return con;
 }
}