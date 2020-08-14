/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Memberlist;

import helper.DbConnector;
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


public class MemberlistController implements Initializable {
    
    @FXML
    private TableView<modeltable> membertable;

    @FXML
    private TableColumn<modeltable, String> membername;

    @FXML
    private TableColumn<modeltable, String> memberid;

    @FXML
    private TableColumn<modeltable, String> phonenum;

    @FXML
    private TableColumn<modeltable, String> email;
    
    @FXML
    private AnchorPane window_Memberlist;
    
    private final DbConnector dbconnect = new DbConnector();
    
    ObservableList<modeltable> observableList = FXCollections.observableArrayList();
   
    
     @FXML
    void back(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/librarymanagement/librarymanagement.fxml"));
        window_Memberlist.getChildren().addAll(root);

    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
        try {
            ResultSet res = this.dbconnect.getValue("SELECT * FROM MEMBERTABLE");
            
            while( res.next() ){
                observableList.add(new modeltable( res.getString("MEMBERNAME"), res.getInt("MEMBERID"), res.getString("MEMBERPHONE"), res.getString("MEMBEREMAIL") ));
                System.out.print("Done");
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(MemberlistController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        membername.setCellValueFactory(new PropertyValueFactory<>("m_name"));
        memberid.setCellValueFactory(new PropertyValueFactory<>("m_id"));
        phonenum.setCellValueFactory(new PropertyValueFactory<>("m_phone"));
        email.setCellValueFactory(new PropertyValueFactory<>("m_email"));
        membertable.setItems(observableList);
        
    }    
    
}
