package com.model;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author 236336
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "customer")
public class Customer implements Serializable {

    private int customerID;
    private String customerName;
    private String customerEmail;
    private String customerPassword;
    private String customerDOB;
    private String customerPhone;

    public Customer() {
    }

    public Customer(String customerName, String customerEmail, String customerPassword, String customerDOB, String customerPhone) {
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.customerPassword = customerPassword;
        this.customerDOB = customerDOB;
        this.customerPhone = customerPhone;
    }

    public Customer(int customerID, String customerName, String customerEmail, String customerPassword, String customerDOB, String customerPhone) {
        this.customerID = customerID;
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.customerPassword = customerPassword;
        this.customerDOB = customerDOB;
        this.customerPhone = customerPhone;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerPassword() {
        return customerPassword;
    }

    public void setCustomerPassword(String customerPassword) {
        this.customerPassword = customerPassword;
    }

    public String getCustomerDOB() {
        return customerDOB;
    }

    public void setCustomerDOB(String customerDOB) {
        this.customerDOB = customerDOB;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone (String customerPhone) {
        this.customerPhone = customerPhone;
    }
    
    public boolean match(int ID){
        return this.customerID == ID;
    }
    
    public boolean match(String email){
        return this.customerEmail.equals(email);
    }
    
    public boolean match(String email, String password){
        return this.customerEmail.equals(email) && this.customerPassword.equals(password);
    }
    
    @Override
    public String toString(){
        return customerID + "\t" + customerName + "\t" + customerEmail + "\t\t" + customerDOB + "\t\t" + customerPhone;
    }
    
}

