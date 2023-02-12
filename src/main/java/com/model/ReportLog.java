package com.model;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Report Log Class is used to create Report Log and to
 * retrieve data from Report Log
 * 
 * @author Monte
 */

//@XmlAccessorType provides control over the default serialization 
//of properties and fields in a class.
@XmlAccessorType(XmlAccessType.FIELD)
//@XmlRootElement is used to specify the default root element
@XmlRootElement(name = "reportlog")
public class ReportLog implements Serializable {
    private int reportLogID;
    private String reportFromDate;
    private String reportToDate;
    private int numberOfBookings;
    private int revenue;
    private String createDate;

    public ReportLog() {
    }
    
    /**
     * Constructor to create Report Log
     * 
     * @param reportLogID
     * @param reportFromDate
     * @param reportToDate
     * @param numberOfBookings
     * @param revenue
     * @param createDate 
     */
    public ReportLog(int reportLogID, String reportFromDate, String reportToDate, int numberOfBookings, int revenue, String createDate) {
        this.reportLogID = reportLogID;
        this.reportFromDate = reportFromDate;
        this.reportToDate = reportToDate;
        this.numberOfBookings = numberOfBookings;
        this.revenue = revenue;
        this.createDate = createDate;
    }

    /**
     * Used in Report Log View Servlet to get Report From Date of a Report Log
     * 
     * @return 
     */
    public String getReportFromDate() {
        return reportFromDate;
    }

    /**
     * Used in Report Log View Servlet to get Report To Date of a Report Log
     * 
     * @return 
     */
    public String getReportToDate() {
        return reportToDate;
    }

    /**
     * Used in Report Log View Servlet to get Report ID of a Report Log
     * 
     * @return 
     */
    public int getReportLogID() {
        return reportLogID;
    }

    /**
     * Used in Report Log View Servlet to get Number of Bookings of a Report Log
     * 
     * @return 
     */
    public int getNumberOfBookings() {
        return numberOfBookings;
    }
    
    /**
     * Used in Report Log View Servlet to get Revenue of a Report Log
     * 
     * @return 
     */
    public int getRevenue() {
        return revenue;
    }
    
    /**
     * Used in Report Log View Servlet to get Created Date of a Report Log
     * 
     * @return 
     */
    public String getCreateDate() {
        return createDate;
    }
    
    /**
     * Used in Report Log View Servlet to Search a Report Log by ID
     * 
     * @param ID
     * @return 
     */
    public boolean matchReport(int ID){
        return this.reportLogID == ID;
    }
}