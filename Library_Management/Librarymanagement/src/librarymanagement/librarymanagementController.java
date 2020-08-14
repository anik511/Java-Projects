/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package librarymanagement;

import helper.DbConnector;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author anikd
 */
public class librarymanagementController implements Initializable {

    @FXML
    private TextField bookid;

    @FXML
    private TextField memberid;

    @FXML
    private DatePicker issuedate;

    @FXML
    private TextField book_ren_sub;

    @FXML
    private AnchorPane window_homepage;
    
    private final DbConnector dbconnect = new DbConnector();

    public String bookID, memberID, i_date, b_r_s ;

    public void alart() {
        Alert alert = new Alert(AlertType.WARNING);
        alert.setTitle("Warning ");
        alert.setHeaderText("Textfild Should Not Be Empty ");
        //alert.setContentText("Careful with the next step!");

        alert.showAndWait();
    }
    
    public void emailAlart() {
        Alert alert = new Alert(AlertType.WARNING);
        alert.setTitle("Warning ");
        alert.setHeaderText("Enter a valid E-mail ");
        //alert.setContentText("Careful with the next step!");

        alert.showAndWait();
    }
    
    public void successAlert(String value, String type) {
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("CONFIRMATION ");
        alert.setHeaderText(value +" "+ type + " Successfully");
        //alert.setContentText("Careful with the next step!");

        alert.showAndWait();
    }

    @FXML
    void issuebook(ActionEvent event) throws IOException {
        try {
            bookID = bookid.getText().toString();
            memberID = memberid.getText().toString();
            i_date = issuedate.getValue().toString();

            if (bookID.isEmpty() || memberID.isEmpty() || i_date.isEmpty()) {
                alart();
            } else {
                
                dbconnect.updateData(" update BOOKTABLE set MEMBERID ="+ Integer.parseInt(memberID) +",ISSUEDATE = '"+ i_date +"', LASTDATE = '5',  FINES = 0, BOOKAVAILABLE = 0 where  BOOKID = "+ Integer.parseInt(bookID) );
                successAlert("Book", "issued");
            }

        } catch (Exception e) {

            alart();

        }
        Parent root = FXMLLoader.load(getClass().getResource("/librarymanagement/librarymanagement.fxml"));
        window_homepage.getChildren().addAll(root);

    }
    
    
    @FXML
    void renewbook(ActionEvent event) {

         try {

            b_r_s = book_ren_sub.getText().toString();
           

            if ( b_r_s .isEmpty() ) {
                alart();
            } else {
                //DbConnect2 dbconnect2 = new DbConnect2();
                dbconnect.updateData(" update BOOKTABLE set LASTDATE = 10 where BOOKID = "+ Integer.parseInt(b_r_s) );
                successAlert("Book", "renewed");
            }

        } catch (Exception e) {

        }
        
    }

    @FXML
    void submission(ActionEvent event) {

         try {

            b_r_s = book_ren_sub.getText().toString();
           

            if ( b_r_s .isEmpty() ) {
                alart();
            } else {
                //DbConnect2 dbconnect2 = new DbConnect2();
                dbconnect.updateData(" update BOOKTABLE set BOOKAVAILABLE = 1 where BOOKID = "+ Integer.parseInt(b_r_s) );
                successAlert("Book", "submited");
            }

        } catch (Exception e) {

        }
        
        
    }
    
    
    

    @FXML
    void methodaddbook(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("/Addbook/Addbook.fxml"));
        window_homepage.getChildren().addAll(root);
    }

    @FXML
    void methodaddmember(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/Addmember/Admember.fxml"));
        window_homepage.getChildren().addAll(root);
    }

    @FXML
    void methodbooklist(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/Booklist/Booklist.fxml"));
        window_homepage.getChildren().addAll(root);
    }

    @FXML
    void methodmemberlist(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/Memberlist/Memberlist.fxml"));
        window_homepage.getChildren().addAll(root);
    }

    @FXML
    void methodissuedbooklist(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/Issuedbooks/Issuedbooks.fxml"));
        window_homepage.getChildren().addAll(root);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
    
    private static String toString(String date){
        char[] dateArray = date.toCharArray();
        char[] yearArray = new char[4];
        char[] monthArray = new char[4];
        char[] dayArray = new char[4];
        String year, month, day;
        int j;
        
        for(int i = 0; i <= 3; ++i)yearArray[i] = dateArray[i];
        int i;
        for(i = 5, j = 0; i <= 6; ++i, j++)monthArray[j] = dateArray[i];
        for(i = 8, j = 0; i <= 9; ++i, j++)dayArray[j] = dateArray[i];
        
        //String.valueOf(charArray);
        day = String.valueOf(dayArray);
        month = String.valueOf(monthArray);
        year = String.valueOf(yearArray);
       
        
        return (day + "/" + month + "/"+year);
    }
    

}
