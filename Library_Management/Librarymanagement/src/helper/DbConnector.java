 package helper;
 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;




public class DbConnector {
    private Connection connection;
    
    /**
     * 
     */
    public DbConnector(){
        try{  
            Class.forName("com.mysql.jdbc.Driver");  
            this.connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/librarymanagement","root","");
        }catch(Exception e){ 
            System.out.println(e);
        }  
    } 
    
    
    
    /**
     *
     * @param query
     * @return
     */
    public boolean insertData(String query){
        try {
            Statement st = this.connection.createStatement();
            
            // execute the query, and get a java resultset
            if( st.executeUpdate(query) == 1 ){
               st.close();
               return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DbConnector.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    
    
    /**
     *
     * @param query
     * @return
     */
    public boolean deleteData(String query){
            try
        {
          // create the java statement
          Statement st = this.connection.createStatement();

          // execute the query, and get a java resultset
          if (st.executeUpdate(query) == 1 ) {
              st.close();
              return true;
          } 
        }catch (SQLException ex) {
            Logger.getLogger(DbConnector.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    /**
     *
     * @param query
     * @return
     */
    public boolean updateData(String query){
        try
        {
          // create the java statement
          Statement st = this.connection.createStatement();

          // execute the query, and get a java resultset
          if (st.executeUpdate(query) == 1 ) {
            st.close();
            return true;
          }
        }catch (SQLException ex) {
            Logger.getLogger(DbConnector.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
        
        
        
    public ResultSet getValue(String query) throws SQLException{
        // create the java statement
        Statement st = this.connection.createStatement();

        // execute the query, and get a java resultset
        return st.executeQuery(query);
    }
}//Main Class
