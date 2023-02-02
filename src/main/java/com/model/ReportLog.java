package com.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "reportlog")
public class ReportLog implements Serializable {
    
    @XmlElement(name = "booking")
    private List<Booking> bookings = new ArrayList<>();
    private int reportLogID;
    private String reportFromDate;
    private String reportToDate;
    private int numberOfBookings;
    private int revenue;
    private String createDate;

    public ReportLog() {
    }

    public ReportLog(int reportLogID, String reportFromDate, String reportToDate, int numberOfBookings, int revenue, String createDate) {
        this.reportLogID = reportLogID;
        this.reportFromDate = reportFromDate;
        this.reportToDate = reportToDate;
        this.numberOfBookings = numberOfBookings;
        this.revenue = revenue;
        this.createDate = createDate;
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }

    public String getReportFromDate() {
        return reportFromDate;
    }

    public void setReportFromDate(String reportFromDate) {
        this.reportFromDate = reportFromDate;
    }

    public String getReportToDate() {
        return reportToDate;
    }

    public void setReportToDate(String reportToDate) {
        this.reportToDate = reportToDate;
    }

    public int getReportLogID() {
        return reportLogID;
    }

    public void setReportLogID(int reportLogID) {
        this.reportLogID = reportLogID;
    }

    public int getNumberOfBookings() {
        return numberOfBookings;
    }

    public void setNumberOfBookings(int numberOfBookings) {
        this.numberOfBookings = numberOfBookings;
    }

    public int getRevenue() {
        return revenue;
    }

    public void setRevenue(int revenue) {
        this.revenue = revenue;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }
    
    public boolean matchReport(int ID){
        return this.reportLogID == ID;
    }
}