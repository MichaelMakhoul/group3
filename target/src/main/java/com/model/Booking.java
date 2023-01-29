
package com.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author 236361
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "booking")
public class Booking implements Serializable{
    
    private int bookingID;
    private int customerID;
    private String bookingFrom;
    private String bookingTo;
    private String bookingDesc;
    private String bookingDate;
    private String bookingModifiedDate;
    
    @XmlElementWrapper(name = "rooms")
    @XmlElement(name ="room")
    private List<Room> rooms ;

    public Booking() {
        this.rooms = new ArrayList<>();
    }

    public Booking(int bookingID, int customerID, String bookingFrom, String bookingTo, String bookingDesc, String bookingDate, String bookingModifiedDate, List<Room> rooms) {
        this.bookingID = bookingID;
        this.customerID = customerID;
        this.bookingFrom = bookingFrom;
        this.bookingTo = bookingTo;
        this.bookingDesc = bookingDesc;
        this.bookingDate = bookingDate;
        this.bookingModifiedDate = bookingModifiedDate;
        this.rooms = rooms;
    }

    public Booking(int customerID, String bookingFrom, String bookingTo, String bookingDesc, List<Room> rooms) {
        this.customerID = customerID;
        this.bookingFrom = bookingFrom;
        this.bookingTo = bookingTo;
        this.bookingDesc = bookingDesc;
        this.rooms = rooms;
    }
    
    public boolean matchID(int id){
        return this.bookingID == id;
    }
        
    public boolean matchBookingFrom(String date){
        return this.bookingFrom.equals(date);
    }
    
    public boolean matchBookingTo(String date){
        return this.bookingTo.equals(date);
    }
    
    public boolean matchCustomerID(int id){
        return this.customerID == id;
    }
    
    public int getBookingID() {
        return bookingID;
    }

    public int getCustomerID() {
        return customerID;
    }

    public String getBookingFrom() {
        return bookingFrom;
    }

    public String getBookingTo() {
        return bookingTo;
    }

    public String getBookingDesc() {
        return bookingDesc;
    }

    public String getBookingDate() {
        return bookingDate;
    }

    public String getBookingModifiedDate() {
        return bookingModifiedDate;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setBookingID(int bookingID) {
        this.bookingID = bookingID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public void setBookingFrom(String bookingFrom) {
        this.bookingFrom = bookingFrom;
    }

    public void setBookingTo(String bookingTo) {
        this.bookingTo = bookingTo;
    }

    public void setBookingDesc(String bookingDesc) {
        this.bookingDesc = bookingDesc;
    }

    public void setBookingDate(String bookingDate) {
        this.bookingDate = bookingDate;
    }

    public void setBookingModifiedDate(String bookingModifiedDate) {
        this.bookingModifiedDate = bookingModifiedDate;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }

    @Override
    public String toString() {
        return "Booking" + bookingID + ", customerID=" + customerID + ", bookingFrom=" 
                + bookingFrom + ", bookingTo=" + bookingTo + ", bookingDesc=" + bookingDesc 
                + ", bookingDate=" + bookingDate + ", bookingModifiedDate=" + bookingModifiedDate + ", rooms=" + rooms ;
    }
    
    
    
}
