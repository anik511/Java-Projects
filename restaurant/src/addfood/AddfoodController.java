/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package addfood;

import helpers.DbConnect;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import restaurant.restaurantController;

/**
 * FXML Controller class
 *
 * @author DCL
 */
public class AddfoodController implements Initializable {

    private static final DbConnect  dbconnect= new DbConnect();
    
    
    @FXML
    private AnchorPane add_delete_ui;

    @FXML
    private TextField add_foodname;

    @FXML
    private TextField add_foodprice;

    @FXML
    private TextField delete_food;
    
    restaurantController rc = new restaurantController();
    
    public String add_fn,add_fp,del_fn;

    @FXML
    void add_food_method(ActionEvent event) {
        
        try {
            add_fn = add_foodname.getText().toString();
            add_fp = add_foodprice.getText().toString();
            

            if (add_fn.isEmpty() || add_fp.isEmpty()) {
               rc.alart();
            } else {
                
                dbconnect.insertData(" INSERT INTO FOOD_LIST VALUES( '"+ add_fn +" ', '" + add_fp +"') " );
                
                System.out.println("Done");
            }

        } catch (Exception e) {

            

        }

    }

    @FXML
    void back_method(ActionEvent event) throws IOException {

        
         Parent root = FXMLLoader.load(getClass().getResource("/managerui/managerui.fxml"));
        add_delete_ui.getChildren().add(root);
        
    }

    @FXML
    void delete_food_method(ActionEvent event) throws SQLException {
        
        try {
            del_fn = delete_food.getText().toString();
           
            

            if (del_fn.isEmpty() ) {
               rc.alart();
            } else {
                
                
                
                if(dbconnect.deleteData("DELETE FROM FOOD_LIST WHERE FOOD_NAME='" + del_fn + "'" ))
                {
                    System.out.println("Donerryrr4");
                }
                else{
                    System.out.println("not deleted");
                }
                
//                
            }

        } catch (Exception e) {
            System.out.println(e);

            

        }

    }
    
    
    
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
