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
    
    public void addAll(List<User> temp){
        this.staffs.addAll(temp);
    }
    
    public void add(User customer){
        this.staffs.add(customer);
    }
      
}
