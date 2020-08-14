/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package customerui;

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
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import managerui.ManageruiController;
import restaurant.restaurantController;

/**
 * FXML Controller class
 *
 * @author DCL
 */
public class CustomeruiController implements Initializable {

    @FXML
    private AnchorPane customerui;

    @FXML
    private ComboBox cbox;
     @FXML
    private TextField foodyouwant;
     
       @FXML
    private TableView<managerui.FoodTable> foodTable;

    @FXML
    private TableColumn<managerui.FoodTable, String> foodName;

    @FXML
    private TableColumn<managerui.FoodTable, String> foodPrice;
    
    ObservableList<managerui.FoodTable> observableList = FXCollections.observableArrayList();

    private static final DbConnect  dbconnect= new DbConnect();

    public String food_u_w;
     
    restaurantController rc = new restaurantController(); 
    
    @FXML
    void back(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("/restaurant/restaurant.fxml"));
        customerui.getChildren().add(root);

    }
    
    @FXML
    void Buy(ActionEvent event) throws IOException {
        try {
            food_u_w = foodyouwant.getText().toString();
            
            

            if (food_u_w.isEmpty() ) {
                rc.alart();
            } else {
                
//                dbconnect2.updateData(" update BOOKTABLE set MEMBERID ="+ Integer.parseInt(memberID) +",ISSUEDATE = '"+ i_date +"', LASTDATE = '5',  FINES = 0, BOOKAVAILABLE = 0 where  BOOKID = "+ Integer.parseInt(bookID) );
//                successAlert("Book", "issued");
            }

        } catch (Exception e) {

           

        }
        
        Parent root = FXMLLoader.load(getClass().getResource("/billreceipt/billreceipt.fxml"));
        Stage stage = new Stage(StageStyle.DECORATED);
        stage.setScene(new Scene(root));
        stage.show();
        
        

    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        cbox.getItems().addAll("1", "2", "3", "4", "5", "6");
        
        // TODO
        try {
            ResultSet res = dbconnect.getValue("SELECT * FROM FOOD_LIST");
            
            while( res.next() ){
                observableList.add(new managerui.FoodTable( res.getString("FOOD_NAME"),res.getString("FOOD_PRICE") ));
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
    void button(ActionEvent event) {
        if (cbox.getValue().toString() == "1") {
            System.out.println("1");
        } else if (cbox.getValue().toString() == "2") {
            System.out.println("2");
        }
         else if (cbox.getValue().toString() == "3") {
            System.out.println("3");
        }
         else if (cbox.getValue().toString() == "4") {
            System.out.println("4");
        }
         else if (cbox.getValue().toString() == "5") {
            System.out.println("5");
        }
         else if (cbox.getValue().toString() == "6") {
            System.out.println("6");
        }
        

    }

}
