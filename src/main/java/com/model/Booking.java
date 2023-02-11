
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
 * Class contains the Bean for Booking Management with following fields
 *     - 'bookingID' unique Booking ID, auto generated in Database
 *     - 'customerID' ID of the Customer doing the booking 
 *     - 'checkIn' Date of Check In
 *     - 'checkOut' Date of Check Out 
 *     - 'bookingDesc' any comments to be added while booking 
 *     - 'totalPrice' Total Cost of Booking 
 *     - 'bookingDate' Date Time of Booking, auto generated in Database
 *     - 'bookingModifiedDate' Date Time of Booking Modification, auto generated in Database
 *     - 'List<Room> rooms' is the list of Rooms associated with a booking
 * 
 * Getter and setter for every field
 * Match function for fields
 * matchID - Booking ID
 * matchCustomerID - customerID
 * matchCheckIn - checkIn
 * matchCheckOut - checkOut
 * 
 * @author Shilpa
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
    
    /**
     * This constructor is used to construct the Booking Data
     * from database for Booking bean
     * 
     * @param bookingID
     * @param customerID
     * @param checkIn
     * @param checkOut
     * @param bookingDesc
     * @param totalPrice
     * @param bookingDate
     * @param bookingModifiedDate
     * @param rooms 
     */
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
