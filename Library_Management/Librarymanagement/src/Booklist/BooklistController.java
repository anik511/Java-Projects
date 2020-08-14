/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Booklist;

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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

public class BooklistController implements Initializable {
     @FXML
    private TableView<BookList> bookListTable;

    @FXML
    private TableColumn<BookList, String> bookName;

    @FXML
    private TableColumn<BookList, Integer> bookId;

    @FXML
    private TableColumn<BookList, String> author;

    @FXML
    private TableColumn<BookList, String> publisher;

    @FXML
    private TableColumn<BookList, Integer> avai;


    @FXML
    private AnchorPane window_booklist;
    
    private final DbConnector dbconnect = new DbConnector();
    
    ObservableList<BookList> observableList = FXCollections.observableArrayList();

    @FXML
    void back(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/librarymanagement/librarymanagement.fxml"));
        window_booklist.getChildren().addAll(root);

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        try {
            ResultSet res = this.dbconnect.getValue("SELECT * FROM BOOKTABLE");
            
            while( res.next() ){
                observableList.add(new BookList( res.getInt("BOOKID"), res.getInt("BOOKAVAILABLE"), res.getString("BOOKNAME"), res.getString("BOOKAUTHOR"), res.getString("BOOKPUBLISHER") ));
//                System.out.print("Done");
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(MemberlistController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        bookName.setCellValueFactory(new PropertyValueFactory<>("bookName"));
        bookId.setCellValueFactory(new PropertyValueFactory<>("bookId"));
        avai.setCellValueFactory(new PropertyValueFactory<>("avi"));
        author.setCellValueFactory(new PropertyValueFactory<>("author"));
        publisher.setCellValueFactory(new PropertyValueFactory<>("publisher"));
        bookListTable.setItems(observableList);
    }

}
