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

public class ReportDAO {

    private Statement st;
    private PreparedStatement deleteReportLogSt;
    private PreparedStatement deleteReportSummarySt;
    private String deleteReportLogQuery = "DELETE FROM tgsdb.report_logs WHERE report_ID=?";
    private String deleteReportSummaryQuery = "DELETE FROM tgsdb.report_summary WHERE report_ID=?";

    public ReportDAO(Connection connection) throws SQLException {
        this.st = connection.createStatement();
        this.deleteReportLogSt = connection.prepareStatement(deleteReportLogQuery);
        this.deleteReportSummarySt = connection.prepareStatement(deleteReportSummaryQuery);
    }

    //Read all Report Logs
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

    //Read all Report Summaries
    public List<ReportSummary> getReportSummaries() throws SQLException {
        String fetch = "SELECT * FROM tgsdb.report_summary";
        ResultSet rs = st.executeQuery(fetch);
        List<ReportSummary> temp = new ArrayList<>();

        while (rs.next()) {
            int reportID = Integer.parseInt(rs.getString(1));
            int bookingID = Integer.parseInt(rs.getString(2));
            String checkIn = rs.getString(3);
            String checkOut = rs.getString(4);
            int numberOfRooms = Integer.parseInt(rs.getString(5));
            int totalPrice = Integer.parseInt(rs.getString(6));
            temp.add(new ReportSummary(reportID, bookingID, checkIn, checkOut, numberOfRooms, totalPrice));
        }
        return temp;
    }

    //Read a log by report ID
    public List<ReportLog> getReportLogs(int ID) throws SQLException {
        String fetch = "SELECT * FROM tgsdb.report_logs WHERE ID=" + ID;
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

    //Delete Report Log by ID
    public void delete(int ID) throws SQLException {
        deleteReportSummarySt.setString(1, "" + ID);
        int x = deleteReportSummarySt.executeUpdate();
        deleteReportLogSt.setString(1, "" + ID);
        int y = deleteReportLogSt.executeUpdate();
        System.out.println("Report " + ID + " has been successfully deleted");
    }

    //Create Report Log
    public void createReportLog(String fromDate, String toDate) throws SQLException {
        String qy = "INSERT INTO tgsdb.report_logs(report_from_date, report_to_date, number_of_bookings, revenue)\n"
                + "SELECT '" + fromDate + "', '" + toDate + "', count(*) ,SUM(price)\n"
                + "FROM tgsdb.booking, tgsdb.booked_rooms, tgsdb.room\n"
                + "WHERE booking.booking_ID = booked_rooms.booking_ID AND booked_rooms.room_ID = room.room_ID AND booking.check_in >= '" + fromDate + "' AND check_in <= '" + toDate + "'";
        st.executeUpdate(qy);
    }

    //Create Report Summary
    public void createReportSummary(String fromDate, String toDate) throws SQLException {
        String qy = "INSERT INTO tgsdb.report_summary(report_ID, booking_ID, check_in, check_out, number_of_rooms, total_price)\n"
                + "SELECT  report_logs.report_ID, booking.booking_ID, booking.check_in, booking.check_out, (COUNT(DISTINCT room.room_ID)) ,SUM(price)/2\n"
                + "FROM tgsdb.report_logs, tgsdb.booking, tgsdb.booked_rooms, tgsdb.room\n"
                + "WHERE booking.booking_ID = booked_rooms.booking_ID AND booked_rooms.room_ID = room.room_ID AND booking.check_in >= '" + fromDate + "' AND booking.check_in <= '" + toDate + "'\n"
                + "GROUP BY booking.booking_ID;";
        st.executeUpdate(qy);
    }

    //Show One Log with FromDate and ToDate
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
