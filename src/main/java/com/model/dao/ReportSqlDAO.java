package com.model.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class ReportSqlDAO {

    private Statement st;

    public ReportSqlDAO(Connection connection) throws SQLException {
        this.st = connection.createStatement();
    }

    public void create(int ID, String text, String table) throws SQLException {
        String columns = "INSERT INTO tgsdb.report_logs (ID,TEXT)";
        String values = "VALUES('" + ID + "','" + text + "')";
        st.executeUpdate(columns + values);
    }

}
