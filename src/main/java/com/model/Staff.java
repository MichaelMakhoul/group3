
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
@XmlRootElement(name = "staff")
public class Staff implements Serializable{
    private int staffID;
    private String staffName;
    private String staffEmail;
    private String staffPassword;
    private String staffDOB;
    private int staffPhone;

    public Staff() {
    }
    
    public Staff(String staffName, String staffEmail, String staffPassword, String staffDOB, int staffPhone) {
        this.staffName = staffName;
        this.staffEmail = staffEmail;
        this.staffPassword = staffPassword;
        this.staffDOB = staffDOB;
        this.staffPhone = staffPhone;
    }
    
    public Staff(int staffID, String staffName, String staffEmail, String staffPassword, String staffDOB, int staffPhone) {
        this.staffID = staffID;
        this.staffName = staffName;
        this.staffEmail = staffEmail;
        this.staffPassword = staffPassword;
        this.staffDOB = staffDOB;
        this.staffPhone = staffPhone;
    }   

    public int getStaffID() {
        return staffID;
    }

    public void setStaffID(int staffID) {
        this.staffID = staffID;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public String getStaffEmail() {
        return staffEmail;
    }

    public void setStaffEmail(String staffEmail) {
        this.staffEmail = staffEmail;
    }

    public String getStaffPassword() {
        return staffPassword;
    }

    public void setStaffPassword(String staffPassword) {
        this.staffPassword = staffPassword;
    }

    public String getStaffDOB() {
        return staffDOB;
    }

    public void setStaffDOB(String staffDOB) {
        this.staffDOB = staffDOB;
    }

    public int getStaffPhone() {
        return staffPhone;
    }

    public void setStaffPhone(int staffPhone) {
        this.staffPhone = staffPhone;
    }   
    
}
