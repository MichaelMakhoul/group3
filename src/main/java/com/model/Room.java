/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author 236351
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "room")
public class Room implements Serializable{
    private int roomID;
    private String type;
    private String image;
    private String description;
    private int price;

    public Room() {}
    
    public Room(int roomID, String type, String image, String description, int price) {
        this.roomID = roomID;
        this.type = type;
        this.image = image;
        this.description = description;
        this.price = price;
    }

    public boolean match(int roomID) {
        return this.roomID == roomID;
    }

    public boolean match(String type) {
        return this.type.equals(type);
    }
    
    public int getRoomID() {
        return roomID;
    }

    public void setRoomID(int roomID) {
        this.roomID = roomID;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
