/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package customerlist;

import helpers.DbConnect;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import static javafx.collections.FXCollections.observableList;
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
import managerui.FoodTable;
import managerui.ManageruiController;

/**
 * FXML Controller class
 *
 * @author DCL
 */
public class CustomerlistController implements Initializable {

    @FXML
    private AnchorPane customerlist;
    
    
    @FXML
    private TableView<CustomerTable> customertable;

    @FXML
    private TableColumn<CustomerTable,String> customername;

    @FXML
    private TableColumn<CustomerTable,String> customerphone;

    @FXML
    private TableColumn<CustomerTable,String> customeremail;
     ObservableList<CustomerTable> observableList = FXCollections.observableArrayList();
    
    private static final DbConnect  dbconnect= new DbConnect();

    @FXML
    void back(ActionEvent event) throws IOException {

         Parent root = FXMLLoader.load(getClass().getResource("/managerui/managerui.fxml"));
        customerlist.getChildren().add(root);
    }
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         try {
            ResultSet res = dbconnect.getValue("SELECT * FROM USER_INFO");
            
            while( res.next() ){
                observableList.add(new CustomerTable( res.getString("C_NAME"),res.getString("C_PHONE_NUMBER"),res.getString("C_EMAIL") ));
                System.out.print("Done");
            }
            
            
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ManageruiController.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
        customername.setCellValueFactory(new PropertyValueFactory<>("customername"));
        customerphone.setCellValueFactory(new PropertyValueFactory<>("customerphone"));
         customeremail.setCellValueFactory(new PropertyValueFactory<>("customeremail"));
        
        customertable.setItems(observableList);
    }

}
