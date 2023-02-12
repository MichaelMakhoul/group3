package com.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Class that contains the list of Users as field
 * A function to add a Staff member to the bean
 * A function to add a List of Staff to the bean
 * Contains getter and setter of the list
 * 
 * @author Aiman, Antonella
 */

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "staffs")
public class Staffs implements Serializable{
    @XmlElement(name = "staff")
    private List<User> staffs = new ArrayList();

    public Staffs() {
    }

    public List<User> getStaffs() {
        return staffs;
    }

    public void setStaffs(List<User> staffs) {
        this.staffs = staffs;
    }
    
    //use for web service
    public void addAll(List<User> temp){
        this.staffs.addAll(temp);
    }
    
    //use for web service
    public void add(User customer){
        this.staffs.add(customer);
    }
      
}
