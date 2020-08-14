/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Addbook;

import helper.DbConnector;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import librarymanagement.librarymanagementController;

/**
 * FXML Controller class
 *
 * @author anikd
 */
public class AddbookController implements Initializable {

    @FXML
    private AnchorPane window_addbook;
//addbook
    @FXML
    private TextField booktitle;

    @FXML
    private TextField bookid;

    @FXML
    private TextField Author;

    @FXML
    private TextField publishar;
    //addbook

//    updatebook
    @FXML
    private TextField updatebooktitle;

    @FXML
    private TextField updatebookid;

    @FXML
    private TextField updateauthor;

    @FXML
    private TextField updatepublishar;
    
    
    librarymanagementController li = new librarymanagementController();
    
    private final DbConnector dbconnect = new DbConnector();
    

    //    updatebook
    


//    deletebook

  @FXML
    private TextField deletebook;

//deletebook    
    public String b_tl, b_id, au, pb, up_au, up_pb, up_btl, up_bid, del_book;
    librarymanagementController lbcnt = new librarymanagementController();

    @FXML
    void addbook(ActionEvent event) {
        try {

            b_tl = booktitle.getText().toString();
            b_id = bookid.getText().toString();
            au = Author.getText().toString();
            pb = publishar.getText().toString();

            if (b_tl.isEmpty() || b_id.isEmpty() || au.isEmpty() || pb.isEmpty()) {
                lbcnt.alart();
            } else {
                String query = "INSERT INTO BOOKTABLE VALUES( " + b_id + ",' "+b_tl+" ',' "+au+" ',' "+pb+"', 1, '0', '0', 0, 0)";
                if( this.dbconnect.insertData(query) ){
                    li.successAlert("Book Added", "success");
                }
            }

        } catch (Exception e) {

        }

    }

    @FXML
    void upbooklist(ActionEvent event) {

        try {

            up_btl = updatebooktitle.getText().toString();
            up_bid = updatebookid.getText().toString();
            up_au = updateauthor.getText().toString();
            up_pb = updatepublishar.getText().toString();

            if (up_btl.isEmpty() || up_bid.isEmpty() || up_au.isEmpty() || up_pb.isEmpty()) {
                lbcnt.alart();
            } else {
                String query = " update BOOKTABLE set BOOKNAME = '"+ up_btl +"', BOOKAUTHOR = ' " + up_au + "', BOOKPUBLISHER = ' "+ up_pb  + "  '   where  BOOKID = "+ Integer.parseInt(up_bid);
                if( this.dbconnect.updateData(query) )
                    li.successAlert("Book", "updated");
            }
        } catch (Exception e) {

        }

    }
//    
//    
    @FXML
    void deletebookmethod(ActionEvent event) {

         try {

            del_book = deletebook.getText().toString();
           

            if (del_book.isEmpty() ) {
                lbcnt.alart();
            } else {
                String query = " DELETE FROM BOOKTABLE WHERE BOOKID = "+ Integer.parseInt(del_book);
                if( this.dbconnect.deleteData(query) )
                li.successAlert("Book", "deleted");
            }

        } catch (Exception e) {

        }
        
    }
//
    @FXML
    void back(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/librarymanagement/librarymanagement.fxml"));
        window_addbook.getChildren().addAll(root);

    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
