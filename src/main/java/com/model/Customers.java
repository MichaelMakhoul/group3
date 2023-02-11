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
 * A function to add a Customer to the bean
 * A function to add a List of Customers to the bean
 * Contains getter and setter of the list
 * 
 * @author Antonella, Micheal
 */

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "customers")
public class Customers implements Serializable{
    @XmlElement(name = "customer")
    private List<User> customers = new ArrayList();

    public Customers() {
    }
    
    //use for web service
    public void add(User customer){
        this.customers.add(customer);
    }
    
    //use for web service
    public void addAll(List<User> temp){
        this.customers.addAll(temp);
    }

    public List<User> getCustomers() {
        return customers;
    }

    public void setCustomers(List<User> customers) {
        this.customers = customers;
    }
    
}
