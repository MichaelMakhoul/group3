package com.model.dao;

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
    private PreparedStatement deleteReportSt;
    private String deleteReportQuery = "DELETE FROM tgsdb.report_log WHERE ID=?";

    public ReportDAO(Connection connection) throws SQLException {
        this.st = connection.createStatement();
        this.deleteReportSt = connection.prepareStatement(deleteReportQuery);
    }

    public void create(int ID, String date) throws SQLException {
        String columns = "INSERT INTO tgsdb.report_logs (ID,DATE)";
        String values = "VALUES('" + ID + "','" + date + "')";
        st.executeUpdate(columns + values);
    }

    public ReportSummary getOneReport(int ID) throws SQLException {
        String query = "SELECT * FROM tgsdb.report_logs WHERE ID=" + ID;
        ResultSet rs = st.executeQuery(query);
        while (rs.next()) {
            int currentID = Integer.parseInt(rs.getString(1));

            if (ID == currentID) {
                String reportMonth = rs.getString(2);
                String reportDate = rs.getString(3);
                return new ReportSummary(currentID, reportMonth, reportDate);
            }
        }
        return null;
    }

    public List<ReportSummary> getReports() throws SQLException {
        String fetch = "SELECT * FROM tgsdb.report_logs";
        ResultSet rs = st.executeQuery(fetch);

        List<ReportSummary> temp = new ArrayList<>();

        while (rs.next()) {
            int reportID = Integer.parseInt(rs.getString(1));
            String reportMonth = rs.getString(2);
            String reportDate = rs.getString(3);
            temp.add(new ReportSummary(reportID, reportMonth, reportDate));
        }
        return temp;
    }

    public void delete(int ID) throws SQLException {
        deleteReportSt.setString(1, "" + ID);
        int x = deleteReportSt.executeUpdate();
        System.out.println("Report has been successflly deleted");
    }

    public ReportSummary getOneReportSummary(int ID) throws SQLException {
        String query = "SELECT * FROM tgsdb.report_summary WHERE ID=" + ID;
        ResultSet rs = st.executeQuery(query);
        while (rs.next()) {
            int currentID = Integer.parseInt(rs.getString(1));

            if (ID == currentID) {
                String reportMonth = rs.getString(2);
                String reportDate = rs.getString(3);
                return new ReportSummary(currentID, reportMonth, reportDate);
            }
        }
        return null;
    }

    public ReportSummary getOneReportBooking(String bookingFrom, String bookingTo) throws SQLException {
        String query = "SELECT * FROM tgsdb.booking WHERE MONTH( " + bookingFrom + ") = 2 OR month( " + bookingTo + " ) = 2 ";
        ResultSet rs = st.executeQuery(query);
        while (rs.next()) {
            int currentID = Integer.parseInt(rs.getString(1));

            if (ID == currentID) {
                String reportMonth = rs.getString(2);
                String reportDate = rs.getString(3);
                return new ReportSummary(currentID, reportMonth, reportDate);
            }
        }
        return null;
    }

//    public ReportSummary getBooking(String toDate, String fromDate) throws SQLException {
//        String query = "SELECT tgsdb.report_logs + tgsdb.booking.booking_ID, room_ID FROM tgsdb.booking, tgsdb.booked_rooms\n"
//                + "WHERE\n"
//                + "tgsdb.booking.booking_ID = tgsdb.booked_rooms.booking_ID\n"
//                + "AND\n"
//                + "(tgsdb.booking.check_in between '"+fromDate+" 'and '"+toDate+"' \n" 
//                + "OR tgsdb.booking.check_out between '"+fromDate+"' and '"+toDate+"' )";
//         ResultSet rs = st.executeQuery(query);
//         while (rs.next()) {
//             int bookingID = Integer.parseInt(rs.getString(1));
//             int roomID = Integer.parseInt(rs.getString(2));
//             int income = Integer.parseInt(rs.getString(3));
//             String reportMonth = rs.getString(4);
//             String reportDate = rs.getString(5);
//             return
//         }
//     }
     
}
