package com.model;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/** This class is the manager bean  for loading the manager data from the manager table in the database
 *
 * @author Aiman
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "manager")
public class Manager implements Serializable {

    private int managerID;
    private String managerName;
    private String managerEmail;
    private String managerPassword;
    private String managerDOB;

    public Manager() {
    }

    public Manager(int managerID, String managerName, String managerEmail, String managerPassword, String managerDOB) {
        this.managerID = managerID;
        this.managerName = managerName;
        this.managerEmail = managerEmail;
        this.managerPassword = managerPassword;
        this.managerDOB = managerDOB;
    }

    public Manager(String managerName, String managerEmail, String managerPassword, String managerDOB) {
        this.managerName = managerName;
        this.managerEmail = managerEmail;
        this.managerPassword = managerPassword;
        this.managerDOB = managerDOB;
    }

    public boolean login(String managerEmail, String managerPassword) {
        return this.managerEmail.equals(managerEmail) && this.managerPassword.equals(managerPassword);
    }

    public boolean match(int managerID) {
        return this.managerID == managerID;
    }

    public boolean match(String managerEmail) {
        return this.managerEmail.equals(managerEmail);
    }

    public boolean match(Manager other) {
        return this.managerID == other.managerID;
    }

    public int getManagerID() {
        return managerID;
    }

    public void setManagerID(int managerID) {
        this.managerID = managerID;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public String getManagerEmail() {
        return managerEmail;
    }

    public String getManagerPassword() {
        return managerPassword;
    }

    public String getManagerDOB() {
        return managerDOB;
    }

    public void setManagerEmail(String managerEmail) {
        this.managerEmail = managerEmail;
    }

    public void setManagerPassword(String managerPassword) {
        this.managerPassword = managerPassword;
    }

    public void setManagerDOB(String managerDOB) {
        this.managerDOB = managerDOB;
    }
    
    

}
