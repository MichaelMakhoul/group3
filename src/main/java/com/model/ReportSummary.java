package com.model;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "reportsummary")
public class ReportSummary implements Serializable {

    private int reportID;
    private int bookingID;
    private String checkIn;
    private String checkOut;
    private int numberOfRooms;
    private int totalPrice;

    public ReportSummary() {
    }

    public ReportSummary(int bookingID, String checkIn, String checkOut, int numberOfRooms, int totalPrice) {
        this.bookingID = bookingID;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.numberOfRooms = numberOfRooms;
        this.totalPrice = totalPrice;
    }
    
    public ReportSummary(int reportID, int bookingID, String checkIn, String checkOut, int numberOfRooms, int totalPrice) {
        this.reportID = reportID;
        this.bookingID = bookingID;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.numberOfRooms = numberOfRooms;
        this.totalPrice = totalPrice;
    }

    public ReportSummary(int bookingID, String checkIn, String checkOut) {
        this.bookingID = bookingID;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    public int getBookingID() {
        return bookingID;
    }

    public String getCheckIn() {
        return checkIn;
    }

    public String getCheckOut() {
        return checkOut;
    }

    public int getNumberOfRooms() {
        return numberOfRooms;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public int getReportID() {
        return reportID;
    }

    public void setReportID(int reportID) {
        this.reportID = reportID;
    }

    public void setBookingID(int bookingID) {
        this.bookingID = bookingID;
    }

    public void setCheckIn(String checkIn) {
        this.checkIn = checkIn;
    }

    public void setCheckOut(String checkOut) {
        this.checkOut = checkOut;
    }

    public void setNumberOfRooms(int numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public boolean matchReport(int ID) {
        return this.reportID == ID;
    }
}
