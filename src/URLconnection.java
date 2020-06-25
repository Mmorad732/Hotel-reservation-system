import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class URLconnection  {
        // make an object from connection
          Connection conn = null;
                 
        URLconnection(){
              
              try {
                  // Database parameters
                  String url       = "jdbc:mysql://remotemysql.com/mpphqgmgXW";
                  String user      = "mpphqgmgXW";
                  String password  = "H2ZxFQAqm3";
                  conn = DriverManager.getConnection(url, user, password);
              } catch (SQLException ex) {
                  Logger.getLogger(URLconnection.class.getName()).log(Level.SEVERE, null, ex);
              }
        }
            //returns connection with database to be used in other classes
       Connection getconnection(){
       return conn ;
       }
       
         
}