
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
 * @author 236361
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "bookings")
public class Bookings implements Serializable {
    
    @XmlElement(name = "booking")
    private List<Booking> bookings = new ArrayList<>();

    public Bookings() {        
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }    
    
    public Booking booking(int bookingID){
        
       return this.bookings.stream().filter(b -> b.matchID(bookingID)).findAny().orElse(null);
    }   
    
    
    
}
