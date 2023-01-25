
package com.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "report")

public class Report implements Serializable{
    private int reportID;
    private List<Booking> bookings = new ArrayList<>();
//    private int roomID;
//    private int customerID;
    private String reportMonth;
    private String reportDate;
   
    public Report(){  
    }    

    public Report(int reportID, String reportMonth, String reportDate) {
        this.reportID = reportID;
        this.reportMonth = reportMonth;
        this.reportDate = reportDate;
    }

    public Report(int reportID, List<Booking> bookings, String reportMonth, String reportDate) {
        this.reportID = reportID;
        this.bookings = bookings;
        this.reportMonth = reportMonth;
        this.reportDate = reportDate;
    }
    
    public boolean matchReportDate(String date){
        return this.reportDate.equals(date);
    }
    
    public boolean matchReport(int ID){
        return this.reportID == ID;
    }

    public int getReportID() {
        return reportID;
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public String getReportMonth() {
        return reportMonth;
    }

    public String getReportDate() {
        return reportDate;
    }

    public void setReportID(int reportID) {
        this.reportID = reportID;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }

    public void setReportMonth(String reportMonth) {
        this.reportMonth = reportMonth;
    }

    public void setReportDate(String reportDate) {
        this.reportDate = reportDate;
    }

    @Override
    public String toString() {
        return "Report{" + "reportID=" + reportID + ", bookings=" + bookings + ", reportMonth=" + reportMonth + ", reportDate=" + reportDate + '}';
    }

    
    
}