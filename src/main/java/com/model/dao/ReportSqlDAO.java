package com.model.dao;

import com.model.Report;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ReportSqlDAO {

    private Statement st;
    private PreparedStatement deleteReportSt;
    private String deleteReportQuery = "DELETE FROM tgsdb.report_log WHERE ID=?";
    

    public ReportSqlDAO(Connection connection) throws SQLException {
        this.st = connection.createStatement();
        this.deleteReportSt = connection.prepareStatement(deleteReportQuery);  
    }

    public void create(int ID, String date) throws SQLException {
        String columns = "INSERT INTO tgsdb.report_logs (ID,DATE)";
        String values = "VALUES('" + ID + "','" + date + "')";
        st.executeUpdate(columns + values);
    }

    public Report getOneReport(int ID) throws SQLException {
        String query = "SELECT * FROM tgsdb.report_logs WHERE ID=" + ID;
        ResultSet rs = st.executeQuery(query);
        while (rs.next()) {
            int currentID = Integer.parseInt(rs.getString(1));

            if (ID == currentID) {
                String reportMonth = rs.getString(2);
                String reportDate = rs.getString(3);
                return new Report(currentID, reportMonth, reportDate);
            }
        }
        return null;
    }

    public List<Report> getReports() throws SQLException {
        String fetch = "SELECT * FROM tgsdb.report_logs";
        ResultSet rs = st.executeQuery(fetch);

        List<Report> temp = new ArrayList<>();

        while (rs.next()) {
            int reportID = Integer.parseInt(rs.getString(1));
            String reportMonth = rs.getString(2);
            String reportDate = rs.getString(3);
            temp.add(new Report(reportID, reportMonth, reportDate));
        }
        return temp;
    }

    public void delete(int ID) throws SQLException{
        deleteReportSt.setString(1, ""+ID);
        int x = deleteReportSt.executeUpdate();        
        System.out.println("Report has been successflly deleted");
    }
}
