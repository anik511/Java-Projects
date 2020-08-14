/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helpers;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

/**
 *
 * @author DCL
 */
public class DbConnect {
    
    
      public void getconnection()
    {
        try
        {
          // create our mysql database connection

          String myDriver = "oracle.jdbc.driver.OracleDriver";
          String myUrl = "jdbc:oracle:thin:hr/hr@localhost:1521/orcl";
          Class.forName(myDriver);
          Connection conn = DriverManager.getConnection(myUrl);
            System.out.println("Connected");
          

          
          
        }
        catch (Exception e)
        {
          System.err.println("Not Connected! ");
          System.err.println(e.getMessage());
        }
      }


        public boolean insertData(String query){
            try
        {
          // create our mysql database connection

          String myDriver = "oracle.jdbc.driver.OracleDriver";
          String myUrl = "jdbc:oracle:thin:hr/hr@localhost:1521/orcl";
          Class.forName(myDriver);
          Connection conn = DriverManager.getConnection(myUrl);

          // create the java statement
          Statement st = conn.createStatement();

          // execute the query, and get a java resultset
          if (st.executeUpdate(query) == 1 ) {
              st.close();
              return true;
          }

          
        }
        catch (Exception e)
        {
            System.out.print(query);
        }
            return false;
    }
        
        
        
        
        public boolean deleteData(String query){
            try
        {
          // create our mysql database connection

          String myDriver = "oracle.jdbc.driver.OracleDriver";
          String myUrl = "jdbc:oracle:thin:hr/hr@localhost:1521/orcl";
          Class.forName(myDriver);
          Connection conn = DriverManager.getConnection(myUrl);

          // create the java statement
          Statement st = conn.createStatement();

          // execute the query, and get a java resultset
          if (st.executeUpdate(query) == 1 ) {
              st.close();
              return true;
          }

          
        }
        catch (Exception e)
        {
            System.out.print(query);
        }
            return false;
    }
        
        
        
        
               
        
        
        public ResultSet getValue(String query) throws ClassNotFoundException, SQLException{
            String myDriver = "oracle.jdbc.driver.OracleDriver";
            String myUrl = "jdbc:oracle:thin:hr/hr@localhost:1521/orcl";
            Class.forName(myDriver);
            Connection conn = DriverManager.getConnection(myUrl);

            // create the java statement
            Statement st = conn.createStatement();

            // execute the query, and get a java resultset
            return st.executeQuery(query);
        }

  
    
    
    
    
    
    
}
//}main
    
    
    
    
    

