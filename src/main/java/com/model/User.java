package com.model;

import java.io.Serializable;
import java.util.List;

/**
 * Class has field variables of a User 
 *     - 'ID' is unique User ID self generated 
 *     - 'name' is User Firstname, Middle and Lastname 
 *     - 'email' is User email address to register and login 
 *     - 'password' is User password to register and login 
 *     - 'DOB' is User dob to register
 *     - 'phone' is User Phone Number to register 
 *     - 'type' is User type to access the correct session
 *     -  
 *     -  getters and setters of every field
 *     - 
 * @author 
 */
public class User implements Serializable {

    private int ID;
    private String name;
    private String email;
    private String password;
    private String DOB;
    private String phone;
    private String type;

    public User() {}

    public User(int ID, String name, String email, String password, String DOB, String phone) {
        this.ID = ID;
        this.name = name;
        this.email = email;
        this.password = password;
        this.DOB = DOB;
        this.phone = phone;
    }
    
    public User(int ID, String name, String email, String password, String DOB, String phone, String type) {
        this.ID = ID;
        this.name = name;
        this.email = email;
        this.password = password;
        this.DOB = DOB;
        this.phone = phone;
        this.type = type;
    }

    public User(String name, String email, String password, String DOB, String phone) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.DOB = DOB;
        this.phone = phone;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDOB() {
        return DOB;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean match(int ID) {
        return this.ID == ID;
    }

    public boolean match(String email) {
        return this.email.equals(email);
    }

    public boolean match(String email, String password) {
        return this.email.equals(email) && this.password.equals(password);
    }
}
