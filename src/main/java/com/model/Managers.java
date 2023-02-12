package com.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/** This class contains the list of managers as field
 * It contains a function to login the manager, match the manager email, match the ID.
 *
 * @author Aiman
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "managers")
public class Managers implements Serializable{
    @XmlElement(name = "manager")
    private List<Manager> managers = new ArrayList<>();
    
    public Managers() {  }
    
    public Manager loginManager(String managerEmail, String password){
        return this.managers.stream().filter(manager -> manager.login(managerEmail, password)).findAny().orElse(null);
    }
    
    public Manager manager(String managerEmail){
        return this.managers.stream().filter(manager -> manager.match(managerEmail)).findAny().orElse(null);
    }
    
    public Manager manager(int managerID){
        return this.managers.stream().filter(manager -> manager.match(managerID)).findAny().orElse(null);
    }

    public List<Manager> getManagers() {
        return managers;
    }

    public void setManagers(List<Manager> managers) {
        this.managers = managers;
    }    
    
}
