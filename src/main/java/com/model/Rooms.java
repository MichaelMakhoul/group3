
package com.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Class contains list of Room Objects the Room Bean 
 * Used by Rooms WebService
 * Getters and Setters for list of Room Objects
 * 
 * @author Shilpa
 */

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "rooms")
public class Rooms implements Serializable {
    
    @XmlElement(name = "room")
    private List<Room> rooms = new ArrayList<>();

    public Rooms() {
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }    
    
    
}
