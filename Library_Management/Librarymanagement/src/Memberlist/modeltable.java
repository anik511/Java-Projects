/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Memberlist;

/**
 *
 * @author anikd
 */
public class modeltable {
    
    String m_name,m_phone,m_email;
    int m_id;

    public String getM_name() {
        return m_name;
    }

    public void setM_name(String m_name) {
        this.m_name = m_name;
    }

    public int getM_id() {
        return m_id;
    }

    public void setM_id(int m_id) {
        this.m_id = m_id;
    }

    public String getM_phone() {
        return m_phone;
    }

    public void setM_phone(String m_phone) {
        this.m_phone = m_phone;
    }

    public String getM_email() {
        return m_email;
    }

    public void setM_email(String m_email) {
        this.m_email = m_email;
    }

    public modeltable(String m_name, int m_id, String m_phone, String m_email) {
        this.m_name = m_name;
        this.m_id = m_id;
        this.m_phone = m_phone;
        this.m_email = m_email;
    }
   
}
