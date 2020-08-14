/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package customerlist;

/**
 *
 * @author DCL
 */
public class CustomerTable {
    String customername,customerphone,customeremail;

    public String getCustomername() {
        return customername;
    }

    public void setCustomername(String customername) {
        this.customername = customername;
    }

    public String getCustomerphone() {
        return customerphone;
    }

    public void setCustomerphone(String customerphone) {
        this.customerphone = customerphone;
    }

    public String getCustomeremail() {
        return customeremail;
    }

    public void setCustomeremail(String customeremail) {
        this.customeremail = customeremail;
    }

    public CustomerTable(String customername, String customerphone, String customeremail) {
        this.customername = customername;
        this.customerphone = customerphone;
        this.customeremail = customeremail;
    }
    
    
}
