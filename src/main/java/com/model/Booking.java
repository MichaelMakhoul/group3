
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
    private String checkIn;
    private String checkOut;
    private String bookingDesc;
    private int totalPrice;
    private String bookingDate;
    private String bookingModifiedDate;
    
    
    @XmlElementWrapper(name = "rooms")
    @XmlElement(name ="room")
    private List<Room> rooms ;

    public Booking() {
        this.rooms = new ArrayList<>();
    }

    public Booking(int bookingID, int customerID, String checkIn, String checkOut, String bookingDesc, int totalPrice, String bookingDate, String bookingModifiedDate, List<Room> rooms) {
        this.bookingID = bookingID;
        this.customerID = customerID;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.bookingDesc = bookingDesc;
        this.totalPrice = totalPrice;
        this.bookingDate = bookingDate;
        this.bookingModifiedDate = bookingModifiedDate;
        this.rooms = rooms;
    }

    

    public Booking(int customerID, String checkIn, String checkOut, String bookingDesc, int totalPrice, List<Room> rooms) {
        this.customerID = customerID;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.bookingDesc = bookingDesc;
        this.totalPrice = totalPrice;
        this.rooms = rooms;
    }
    
    public boolean matchID(int id){
        return this.bookingID == id;
    }
        
    public boolean matchCheckIn(String date){
        return this.checkIn.equals(date);
    }
    
    public boolean matchCheckOut(String date){
        return this.checkOut.equals(date);
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

    public String getCheckIn() {
        return checkIn;
    }

    public String getCheckOut() {
        return checkOut;
    }   

    public String getBookingDesc() {
        return bookingDesc;
    }

    public int getTotalPrice() {
        return totalPrice;
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

    public void setCheckIn(String checkIn) {
        this.checkIn = checkIn;
    }

    public void setCheckOut(String checkOut) {
        this.checkOut = checkOut;
    }    

    public void setBookingDesc(String bookingDesc) {
        this.bookingDesc = bookingDesc;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
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
        return "Booking" + bookingID + ", customerID=" + customerID 
                + ", checkIn=" + checkIn + ", checkOut=" + checkOut + ", bookingDesc=" 
                + bookingDesc + ", totalPrice=" + totalPrice + ", bookingDate=" + bookingDate 
                + ", bookingModifiedDate=" + bookingModifiedDate + ", rooms=" + rooms ;
    }

     
    
    
}
