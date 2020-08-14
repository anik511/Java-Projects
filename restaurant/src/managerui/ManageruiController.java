/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerui;

import helpers.DbConnect;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import restaurant.restaurantController;

/**
 * FXML Controller class
 *
 * @author DCL
 */
public class ManageruiController implements Initializable {
    
    @FXML
    private TableView<FoodTable> foodTable;

    @FXML
    private TableColumn<FoodTable, String> foodName;

    @FXML
    private TableColumn<FoodTable, String> foodPrice;
    
    ObservableList<FoodTable> observableList = FXCollections.observableArrayList();

    private static final DbConnect  dbconnect= new DbConnect();
    
     @FXML
    private AnchorPane foodlist;
     
     restaurantController rc = new restaurantController();
     
     
     /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        try {
            ResultSet res = dbconnect.getValue("SELECT * FROM FOOD_LIST");
            
            while( res.next() ){
                observableList.add(new FoodTable( res.getString("FOOD_NAME"),res.getString("FOOD_PRICE") ));
                System.out.print("Done");
            }
            
            
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ManageruiController.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
        foodName.setCellValueFactory(new PropertyValueFactory<>("foodNME"));
        foodPrice.setCellValueFactory(new PropertyValueFactory<>("foodPrice"));
        
        foodTable.setItems(observableList);
        
    } 

    @FXML
    void add_del_but_method(ActionEvent event) throws IOException {
         Parent root = FXMLLoader.load(getClass().getResource("/addfood/addfood.fxml"));
        foodlist.getChildren().add(root);

    }

    @FXML
    void back(ActionEvent event) throws IOException {

         Parent root = FXMLLoader.load(getClass().getResource("/restaurant/restaurant.fxml"));
        foodlist.getChildren().add(root);
        
        
    }

    @FXML
    void customerlist_but_method(ActionEvent event) throws IOException {

         Parent root = FXMLLoader.load(getClass().getResource("/customerlist/customerlist.fxml"));
        foodlist.getChildren().add(root);
        
    }   
    
}
