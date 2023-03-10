package com.model.dao;

import com.model.ReportLog;
import com.model.ReportSummary;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Report DAO pattern allows data access mechanisms 
 * to change independently of the code that uses the data
 * 
 * @author Monte
 */
public class ReportDAO {

    private Statement st;
    private PreparedStatement deleteReportLogSt;
    private String deleteReportLogQuery = "DELETE FROM tgsdb.report_logs WHERE report_ID=?";

    public ReportDAO(Connection connection) throws SQLException {
        this.st = connection.createStatement();
        this.deleteReportLogSt = connection.prepareStatement(deleteReportLogQuery);
  }

    /**
     * Read all Report Logs from Database and return a List of Report Logs
     * 
     * @return
     * @throws SQLException 
     */
    public List<ReportLog> getReportLogs() throws SQLException {
        String fetch = "SELECT * FROM tgsdb.report_logs";
        ResultSet rs = st.executeQuery(fetch);
        List<ReportLog> temp = new ArrayList<>();
        while (rs.next()) {
            int reportID = Integer.parseInt(rs.getString(1));
            String reportFromDate = rs.getString(2);
            String reportToDate = rs.getString(3);
            int numberOfBookings = Integer.parseInt(rs.getString(4));
            int revenue = Integer.parseInt(rs.getString(5));
            String createDate = rs.getString(6);
            temp.add(new ReportLog(reportID, reportFromDate, reportToDate, numberOfBookings, revenue, createDate));
        }
        return temp;
    }

    /**
     * Delete Report Log from Database by ID
     * 
     * @param ID
     * @throws SQLException 
     */
    public void delete(int ID) throws SQLException {
        deleteReportLogSt.setString(1, "" + ID);
        int y = deleteReportLogSt.executeUpdate();
    }

    /**
     * Create Report Log and Save into Database - Parameters From and To Date
     * 
     * @param fromDate
     * @param toDate
     * @throws SQLException 
     */
    public void createReportLog(String fromDate, String toDate) throws SQLException {
        String qy = "INSERT INTO tgsdb.report_logs(report_from_date, report_to_date, number_of_bookings, revenue)\n"
                + "SELECT '" + fromDate + "', '" + toDate + "', count(*) , COALESCE ((SUM(price)), 0)\n"
                + "FROM tgsdb.booking, tgsdb.booked_rooms, tgsdb.room\n"
                + "WHERE booking.booking_ID = booked_rooms.booking_ID AND booked_rooms.room_ID = room.room_ID AND booking.check_in >= '" + fromDate + "' AND check_in <= '" + toDate + "'";
        st.executeUpdate(qy);
    }
    
    /**
     * Show (Select) Report Summary from a Report Log - Parameters From and To Date - returns a List of Report Summary
     * 
     * @param fromDate
     * @param toDate
     * @return
     * @throws SQLException 
     */
    public List<ReportSummary> getReportSummary(String fromDate, String toDate) throws SQLException {
        String qy = "SELECT tgsdb.booking.booking_ID,\n"
                + "booking.check_in, booking.check_out, count(booked_rooms.room_ID), booking.total_price\n"
                + "from tgsdb.booked_rooms, tgsdb.booking\n"
                + "where booked_rooms.booking_ID = booking.booking_ID and (booking.check_in between '" +fromDate+ "' and '"+toDate+"')\n"
                + "group by booking.booking_ID;";
        ResultSet rs = st.executeQuery(qy);
        List<ReportSummary> temp = new ArrayList<>();
        while (rs.next()) {           
            int bookingID = Integer.parseInt(rs.getString(1));
            String checkIn = rs.getString(2);
            String checkOut = rs.getString(3);
            int numberOfRooms = Integer.parseInt(rs.getString(4));
            int totalPrice = Integer.parseInt(rs.getString(5));
            temp.add(new ReportSummary(bookingID, checkIn, checkOut, numberOfRooms, totalPrice));
        }
        return temp;
    }
    
    /**
     * Get From Date and To Date by Report ID from a Report Log - returns a List of To and From Date
     * 
     * @param ID
     * @return
     * @throws SQLException 
     */
    public List<String> getReportDate(int ID) throws SQLException {
        String qy = "select report_logs.report_from_date, report_logs.report_to_date\n" 
                + "from tgsdb.report_logs\n" 
                + "where report_logs.report_ID = '"+ID+"';";
        ResultSet rs = st.executeQuery(qy);
        List<String> temp = new ArrayList<>();
        while (rs.next()) {
            String reportFrom = rs.getString(1);
            String reportTo = rs.getString(2);
            temp.add(reportFrom);
            temp.add(reportTo);
        }
        return temp;
    }

    /**
     * Selects one Log from Database - Parameters From and To Date - Used to Match a Report Log before creating
     * 
     * @param fromDate
     * @param toDate
     * @return
     * @throws SQLException 
     */
    public ReportLog showOne(String fromDate, String toDate) throws SQLException {
        String query = "SELECT * FROM tgsdb.report_logs WHERE report_from_date='" + fromDate + "' AND report_to_date='" + toDate + "'";
        ResultSet rs = st.executeQuery(query);
        while (rs.next()) {
            int reportLogID = Integer.parseInt(rs.getString(1));
            int numberOfBookings = Integer.parseInt(rs.getString(4));
            int revenue = Integer.parseInt(rs.getString(5));
            String createDate = rs.getString(6);
            return new ReportLog(reportLogID, fromDate, toDate, numberOfBookings, revenue, createDate);
        }
        return null;
    }
}
