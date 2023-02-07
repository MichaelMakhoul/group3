/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author 236336
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "customers")
public class Customers implements Serializable{
    @XmlElement(name = "customer")
    private List<User> customers = new ArrayList();

    public Customers() {
    }
    
    public void add(User customer){
        this.customers.add(customer);
    }
    
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
