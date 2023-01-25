
package com.model;

import java.io.Serializable;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "report")

public class Report implements Serializable{
    private int reportID;
    private int bookingID;
    private int roomID;
    private int customerID;
    private int reportMonth;
    private String reportDate;
   
    public Report(){  
    }    

    public Report(int reportID, int bookingID, int roomID, int customerID) {
        this.reportID = reportID;
        this.bookingID = bookingID;
        this.roomID = roomID;
        this.customerID = customerID;
    }

    public Report(int reportID, int bookingID, int roomID, int customerID, int reportMonth, String reportDate) {
        this.reportID = reportID;
        this.bookingID = bookingID;
        this.roomID = roomID;
        this.customerID = customerID;
        this.reportMonth = reportMonth;
        this.reportDate = reportDate;
    }

    public int getReportID() {
        return reportID;
    }

    public int getBookingID() {
        return bookingID;
    }

    public int getRoomID() {
        return roomID;
    }

    public int getCustomerID() {
        return customerID;
    }

    public int getReportMonth() {
        return reportMonth;
    }

    public String getReportDate() {
        return reportDate;
    }

    public void setReportID(int reportID) {
        this.reportID = reportID;
    }

    public void setBookingID(int bookingID) {
        this.bookingID = bookingID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public void setReportMonth(int reportMonth) {
        this.reportMonth = reportMonth;
    }

    public void setReportDate(String reportDate) {
        this.reportDate = reportDate;
    }

    public void setRoomID(int roomID) {
        this.roomID = roomID;
    }
}
    