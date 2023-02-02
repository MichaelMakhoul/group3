
package com.model;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author 236361
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name ="room")
public class Room implements Serializable{
    private int roomID;
    private String roomNo;
    private String roomType;
    private String roomImageUrl;
    private String roomDesc;
    private int roomPrice;    

    public Room() {
    }

    public Room(int roomID, String roomNo, String roomType, String roomImageUrl, String roomDesc, int roomPrice) {
        this.roomID = roomID;
        this.roomNo = roomNo;
        this.roomType = roomType;
        this.roomImageUrl = roomImageUrl;
        this.roomDesc = roomDesc;
        this.roomPrice = roomPrice;
    }

    public Room(String roomType, String roomNo, String roomImageUrl, String roomDesc, int roomPrice) {
        this.roomType = roomType;
        this.roomNo = roomNo;
        this.roomImageUrl = roomImageUrl;
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

    public String getRoomImageUrl() {
        return roomImageUrl;
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

    public void setRoomImageUrl(String roomImageUrl) {
        this.roomImageUrl = roomImageUrl;
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
