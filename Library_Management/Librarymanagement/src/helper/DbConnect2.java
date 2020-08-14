/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;


import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author anikd
 */
public class DbConnect2 {
    
    public void getconnection()
    {
        try
        {
          // create our mysql database connection

          String myDriver = "com.mysql.jdbc.driver";
//          String myUrl = "jdbc:oracle:thin:hr/hr@localhost:1521/orcl";
          Class.forName(myDriver);
          Connection conn=DriverManager.getConnection(  
"jdbc:mysql://localhost:3306/librarymanagement","root","");  

          // our SQL SELECT query. 
          // if you only need a few columns, specify them by name instead of using "*"
          String query = "SELECT * FROM JOB_HISTORY";

          // create the java statement
          Statement st = conn.createStatement();

          // execute the query, and get a java resultset
          ResultSet rs = st.executeQuery(query);

          // iterate through the java resultset
          while (rs.next())
          {
            int id = rs.getInt("EMPLOYEE_ID");
           // String firstName = rs.getString("first_name");
           // String lastName = rs.getString("last_name");
            Date dateCreated = rs.getDate("START_DATE");
            //boolean isAdmin = rs.getBoolean("is_admin");
            //int numPoints = rs.getInt("num_points");

            // print the results
            System.out.format("%s, %s\n", id, dateCreated);
          }
          st.close();
        }
        catch (Exception e)
        {
          System.err.println("Got an exception! ");
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
        
        
        
        
        public boolean updateData(String query){
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

   
    
    
}//Main Class
