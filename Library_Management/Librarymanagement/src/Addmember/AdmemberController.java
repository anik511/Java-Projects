
package Addmember;

import helper.DbConnector;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import librarymanagement.librarymanagementController;


public class AdmemberController implements Initializable {

      @FXML
    private AnchorPane window_addmember;
      
      
      @FXML
    private TextField membername;

    @FXML
    private TextField memberid;

    @FXML
    private TextField memberphone;

    @FXML
    private TextField memberemail;

   

    @FXML
    private TextField updatemembername;

    @FXML
    private TextField updatememberid;

    @FXML
    private TextField updatememberphone;

    @FXML
    private TextField updatememberemail;

    

    @FXML
    private TextField deletemember;
    
    
    //librarymanagementController li = new librarymanagementController();
    
    private final DbConnector dbconnect = new DbConnector();
    
    
     public String m_name, m_id, m_phone, m_email, up_m_name, up_m_id, up_m_phone, up_m_email, del_member;
     
     
    private final  librarymanagementController lbcnt = new librarymanagementController();

    @FXML
    void addmember(ActionEvent event) {
        try {

            m_name = membername.getText().toString();
             m_id = memberid.getText().toString();
             m_phone = memberphone.getText().toString();
            m_email = memberemail.getText().toString();
//            System.out.println(m_name + " " + m_id + " " + m_phone + " " + m_email + "\n");
            if (m_name.isEmpty() ||  m_id.isEmpty() || m_phone.isEmpty() ||  m_email.isEmpty()) {
                lbcnt.alart();
            } else {
                //DbConnect2 dbconnect2 = new DbConnect2();
                if( validateEmail(m_email) )
                {
                    String query = "INSERT INTO membertable VALUES( " + m_id + ",' "+m_name+" ',' "+m_phone+" ',' "+m_email+"')";
                    if( this.dbconnect.insertData(query) ){
                        lbcnt.successAlert("Member Added", "success");
                    }
                    } else {
                        lbcnt.emailAlart();
                    }
            }

        } catch (Exception e) {

        }
        
    }

     @FXML
    void updatememberlist(ActionEvent event) {

        
         
        try {

            up_m_name =updatemembername.getText().toString();
            up_m_id = updatememberid.getText().toString();
            up_m_phone = updatememberphone.getText().toString();
             up_m_email = updatememberemail.getText().toString();

            if (up_m_name.isEmpty() || up_m_id.isEmpty() ||up_m_phone.isEmpty() ||   up_m_email.isEmpty()) {
                lbcnt.alart();
            } else {
                if( validateEmail(up_m_email) ){
                    this.dbconnect.updateData(" update MEMBERTABLE set MEMBERNAME = '"+ up_m_name +"', MEMBERPHONE = ' " + up_m_phone + "', MEMBEREMAIL = ' "+ up_m_email  + "  '   where  MEMBERID = "+ Integer.parseInt(up_m_id));
                    lbcnt.successAlert("Member", "updated");
                } else {
                    lbcnt.emailAlart();
                }
            }

        } catch (Exception e) {

        }
        
    }

    @FXML
    void deletemember(ActionEvent event) {

         try {

            del_member = deletemember.getText().toString();
           

            if (del_member.isEmpty() ) {
                lbcnt.alart();
            } else {
                this.dbconnect.deleteData(" DELETE FROM MEMBERTABLE WHERE MEMBERID = "+ Integer.parseInt(del_member) );
                lbcnt.successAlert("Member", "deleted");
            }

        } catch (Exception e) {

        }
        
        
    } 
      
      
      

    @FXML
    void back(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/librarymanagement/librarymanagement.fxml"));
         window_addmember.getChildren().addAll(root);
        
    }

    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    
    
    private static boolean validateEmail(String e) {

        Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        Matcher matcher = pattern.matcher(e);

        if (matcher.find() && matcher.group().equals(e)) {

            return true;
        }
        return false;
    }
    
    
}//Main Class
