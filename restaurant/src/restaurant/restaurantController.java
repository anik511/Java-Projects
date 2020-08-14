/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant;

import helpers.DbConnect;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class restaurantController implements Initializable {

    @FXML
    private AnchorPane Login_ui;

    @FXML
    private TextField manager_email;

    @FXML
    private PasswordField manager_pass;

    @FXML
    private TextField customer_email;

    @FXML
    private PasswordField customer_pass;

    @FXML
    private TextField createaccount_name;

    @FXML
    private TextField createaccount_email;

    @FXML
    private TextField createaccount_phone;

    @FXML
    private PasswordField createaccount_pass;
    private static final DbConnect dbconnect = new DbConnect();

    public String m_email, m_pass, c_email, c_pass, cr_name, cr_email, cr_phone, cr_pass;

    public void alart() {
        Alert alert = new Alert(AlertType.WARNING);
        alert.setTitle("Warning ");
        alert.setHeaderText("Textfild Should Not Be Empty ");
        //alert.setContentText("Careful with the next step!");

        alert.showAndWait();
    }

    public void emailalart() {
        Alert alert = new Alert(AlertType.WARNING);
        alert.setTitle("Warning ");
        alert.setHeaderText("Worng User Name Or Password");
        //alert.setContentText("Careful with the next step!");

        alert.showAndWait();
    }

    public void ceratealart() {
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Success ");
        alert.setHeaderText("Customer Account Has Been Created");
        //alert.setContentText("Careful with the next step!");

        alert.showAndWait();
    }

    @FXML
    void managerloginmethod(ActionEvent event) throws IOException {

        try {
            m_email = manager_email.getText().toString();
            m_pass = manager_pass.getText().toString();

            if (m_email.isEmpty() || m_pass.isEmpty()) {
                alart();
            } else {
                if (m_email.equals("admin@gmail.com") && m_pass.equals("admin")) {
                    Parent root = FXMLLoader.load(getClass().getResource("/managerui/managerui.fxml"));
                    Login_ui.getChildren().add(root);
                } else {

                    emailalart();
                }
//                
            }

        } catch (Exception e) {

            alart();

        }

    }

    @FXML
    void createaccountmethod(ActionEvent event) {

        try {
            cr_name = createaccount_name.getText().toString();
            cr_email = createaccount_email.getText().toString();
            cr_phone = createaccount_phone.getText().toString();
            cr_pass = createaccount_pass.getText().toString();

            if (cr_name.isEmpty() || cr_email.isEmpty() || cr_phone.isEmpty() || cr_pass.isEmpty()) {
                alart();

            } else {

                dbconnect.insertData(" insert into USER_INFO VALUES( '" + cr_name + " ', '" + cr_email + "', '" + cr_phone + "', '" + cr_pass + "') ");
                //successAlert("Book", "issued");
                System.out.println("Done");
                ceratealart();

            }

        } catch (Exception e) {

//            alart();
        }

    }

    @FXML
    void customerloginmethod(ActionEvent event) throws IOException {

        try {
            c_email = customer_email.getText().toString();
            c_pass = customer_pass.getText().toString();

            if (c_email.isEmpty() || c_pass.isEmpty()) {
                alart();
            } else {
                ResultSet res = dbconnect.getValue("SELECT * FROM USER_INFO WHERE C_EMAIL='" + c_email + "' AND C_PASSWORD='" + c_pass + "'");

                if (res.next()) {
                    System.out.println("loged in");
                    Parent root = FXMLLoader.load(getClass().getResource("/customerui/customerui.fxml"));
                    Login_ui.getChildren().add(root);
                } else {

                    emailalart();
                }

//                while( res.next() ){
//                    System.out.println(res.getString("C_EMAIL"));
//                }
            }

        } catch (Exception e) {

        }

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
