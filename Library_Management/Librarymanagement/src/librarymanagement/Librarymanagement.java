/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package librarymanagement;

import helper.DbConnect2;
import helper.DbConnector;
import java.sql.SQLException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author anikd
 */
public class Librarymanagement extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("librarymanagement.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        
//        DbConnect2 dbconnect2 = new DbConnect2();
//        dbconnect2.getconnection();
//        //boolean insert =  dbconnect2.updateData("UPDATE memberTable SET memberName = 'mkyong_new' WHERE memberID = 2");
//        //System.out.print(insert);
//        DbConnector dbconntctor = new DbConnector();
//        System.out.println(dbconntctor.none());
        
        launch(args);
    }
    
}
