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
 * @author 236351
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "rooms")
public class Rooms implements Serializable{
    @XmlElement(name = "room")
    private List<Room> rooms = new ArrayList();

    public Rooms() {}

    public Room getRoomByID(int ID){
        return this.rooms.stream().filter(room -> room.match(ID)).findAny().orElse(null);
    }
    
    public Room getRoomByType(String type){
        return this.rooms.stream().filter(room -> room.match(type)).findAny().orElse(null);
    }
    
    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }
}
