package com.model;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Report Summary Class is used to create Report Summary and to
 * retrieve data from Report Summary
 * 
 * @author 236355
 */

//@XmlAccessorType provides control over the default serialization 
//of properties and fields in a class.
@XmlAccessorType(XmlAccessType.FIELD)
//@XmlRootElement is used to specify the default root element
@XmlRootElement(name = "reportsummary")
public class ReportSummary implements Serializable {
    private int bookingID;
    private String checkIn;
    private String checkOut;
    private int numberOfRooms;
    private int totalPrice;

    public ReportSummary() {
    }
     
    /**
     * Constructor to create Report Summary
     * 
     * @param bookingID
     * @param checkIn
     * @param checkOut
     * @param numberOfRooms
     * @param totalPrice 
     */
    public ReportSummary(int bookingID, String checkIn, String checkOut, int numberOfRooms, int totalPrice) {
        this.bookingID = bookingID;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.numberOfRooms = numberOfRooms;
        this.totalPrice = totalPrice;
    }
    
    /**
     * Constructor to create Report Summary
     * 
     * @param bookingID
     * @param checkIn
     * @param checkOut 
     */
    public ReportSummary(int bookingID, String checkIn, String checkOut) {
        this.bookingID = bookingID;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    /**
     * Used in Report Summary View Servlet to get Booking ID
     * 
     * @return 
     */
    public int getBookingID() {
        return bookingID;
    }

    /**
     * Used in Report Summary View Servlet to get Check In Date
     * 
     * @return 
     */
    public String getCheckIn() {
        return checkIn;
    }

    /**
     * Used in Report Summary View Servlet to get Check Out Date
     * 
     * @return 
     */
    public String getCheckOut() {
        return checkOut;
    }

    /**
     * Used in Report Summary View Servlet to get Number Of Rooms
     * 
     * @return 
     */
    public int getNumberOfRooms() {
        return numberOfRooms;
    }

    /**
     * Used in Report Summary View Servlet to get Total Price
     * 
     * @return 
     */
    public int getTotalPrice() {
        return totalPrice;
    }
}
