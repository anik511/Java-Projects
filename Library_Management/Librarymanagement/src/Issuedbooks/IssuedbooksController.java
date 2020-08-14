/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Issuedbooks;

import Memberlist.MemberlistController;
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
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;


public class IssuedbooksController implements Initializable {
    
     @FXML
    private TableView<IssueTable> issueTableId;

    @FXML
    private TableColumn<IssueTable, String> bookName;

    @FXML
    private TableColumn<IssueTable, Integer> bookId;

    @FXML
    private TableColumn<IssueTable, Integer> memberId;

    @FXML
    private TableColumn<IssueTable, String> issueDate;

    @FXML
    private TableColumn<IssueTable, String> lastDate;

    @FXML
    private TableColumn<IssueTable, Integer> fine;
    
    @FXML
    private TextField Author;
    
    
    private final DbConnector dbconnect = new DbConnector();
    
    ObservableList<IssueTable> observableList = FXCollections.observableArrayList();


     @FXML
    private AnchorPane window_issuedbooklist;
     
      @FXML
    void back(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/librarymanagement/librarymanagement.fxml"));
        window_issuedbooklist.getChildren().addAll(root);

    }
     
     
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        try {
            ResultSet res = dbconnect.getValue("SELECT * FROM BOOKTABLE");
            
            while( res.next() ){
                if( res.getInt("BOOKAVAILABLE") == 0 ) 
                    observableList.add(new IssueTable( res.getInt("BOOKID"), res.getInt("MEMBERID"), 0, res.getString("BOOKNAME"), res.getString("ISSUEDATE"), "7"));
                //System.out.print("Done");
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(MemberlistController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        bookName.setCellValueFactory(new PropertyValueFactory<>("bookName"));
        bookId.setCellValueFactory(new PropertyValueFactory<>("bookId"));
        memberId.setCellValueFactory(new PropertyValueFactory<>("memberId"));
        issueDate.setCellValueFactory(new PropertyValueFactory<>("issueDate"));
        lastDate.setCellValueFactory(new PropertyValueFactory<>("lastDate"));
        fine.setCellValueFactory(new PropertyValueFactory<>("fine"));
        issueTableId.setItems(observableList);
        
    }    
    
}
