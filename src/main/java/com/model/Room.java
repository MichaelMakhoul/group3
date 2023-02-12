
package com.model;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Class contains the Bean for Booking Management with following fields
 *     - 'roomID' unique Room ID, auto generated in Database
 *     - 'roomNo' unique room No for identification for the Users 
 *     - 'roomType' Deluxe Room , Family Room or Executive Suite
 *     - 'roomDesc' any comments to be added while booking 
 *     - 'roomPrice' Cost of Booking 
 * 
 * Getter and setter for every field
 * Match function for fields
 * matchID - roomID
 * matchType - roomType
 * 
 * @author Shilpa
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name ="room")
public class Room implements Serializable{
    private int roomID;
    private String roomNo;
    private String roomType;
    private String roomDesc;
    private int roomPrice;    

    public Room() {
    }

    public Room(int roomID, String roomNo, String roomType, String roomDesc, int roomPrice) {
        this.roomID = roomID;
        this.roomNo = roomNo;
        this.roomType = roomType;
        this.roomDesc = roomDesc;
        this.roomPrice = roomPrice;
    }

    public Room(String roomType, String roomNo, String roomDesc, int roomPrice) {
        this.roomType = roomType;
        this.roomNo = roomNo;
        this.roomDesc = roomDesc;
        this.roomPrice = roomPrice;
    }

    public boolean matchID(int id){
        return this.roomID == id;
    }
    
    public boolean matchType(String type){
        return this.roomType.equals(type);
    }
    
    public int getRoomID() {
        return roomID;
    }

    public String getRoomType() {
        return roomType;
    }

    public String getRoomDesc() {
        return roomDesc;
    }

    public int getRoomPrice() {
        return roomPrice;
    }

    public String getRoomNo() {
        return roomNo;
    }    

    public void setRoomID(int roomID) {
        this.roomID = roomID;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public void setRoomDesc(String roomDesc) {
        this.roomDesc = roomDesc;
    }

    public void setRoomPrice(int roomPrice) {
        this.roomPrice = roomPrice;
    }

    public void setRoomNo(String roomNo) {
        this.roomNo = roomNo;
    }      

    @Override
    public String toString() {
        return "Room" + roomID + ", roomNo=" + roomNo + ", roomType=" + roomType + ", roomDesc=" + roomDesc + ", roomPrice=" + roomPrice + '}';
    }
    
}
