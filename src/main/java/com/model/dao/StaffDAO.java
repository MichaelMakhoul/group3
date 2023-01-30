/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model.dao;


import com.model.Staff;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author 236336
 */
public class StaffDAO {
    private Statement st;
    private PreparedStatement createSt;
    private PreparedStatement updateSt;
    private PreparedStatement deleteSt;

    private String createQy = "INSERT INTO tgsdb.staff(name, email, password, DOB, customer_phone)" + "VALUES(?,?,?,?,?)";
    private String updateQy = "UPDATE tgsdb.staff SET name=?, password=?, DOB=?, customer_phone=? WHERE ID=?";
    private String deleteQy = "DELETE FROM tgsdb.staff WHERE ID=?";

    public StaffDAO(Connection connection) throws SQLException {
        this.st = connection.createStatement();
        this.createSt = connection.prepareStatement(createQy);
        this.updateSt = connection.prepareStatement(updateQy);
        this.deleteSt = connection.prepareStatement(deleteQy);
    }
    
        public void create(String name, String email, String password, String dob, String customerPhone) throws SQLException {
        createSt.setString(1, name);
        createSt.setString(2, email);
        createSt.setString(3, password);
        createSt.setString(4, dob);
        createSt.setString(5, customerPhone);
        createSt.executeUpdate();
    }

    public void update(String name, String password, String dob, String customerPhone, int ID) throws SQLException {
        updateSt.setString(1, name);
        updateSt.setString(2, password);
        updateSt.setString(3, dob);
        updateSt.setString(4, customerPhone);
        updateSt.setString(4, Integer.toString(ID));
        int row = updateSt.executeUpdate();
        System.out.println("Row " + row + " has been successflly updated");
    }
    
    public void delete(int ID) throws SQLException {
        deleteSt.setString(1, "" + ID);
        int row = deleteSt.executeUpdate();
        System.out.println("Row " + row + " has been successflly deleted");
    }
    
        public  Staff login(String email, String password) throws SQLException {
        String query = "SELECT * FROM tgsdb.staff WHERE EMAIL='" + email + "' AND PASSWORD='" + password + "'";
        ResultSet rs = st.executeQuery(query);
        while (rs.next()) {
            String currentEmail = rs.getString(3);
            String currentPassword = rs.getString(4);

            if (email.equals(currentEmail) && password.equals(currentPassword)) {
                int ID = Integer.parseInt(rs.getString(1));
                String name = rs.getString(2);
                String DOB = rs.getString(5);
                String customerPhone = rs.getString(6);
                return new Staff(ID, name, email, password, DOB, customerPhone);
            }
        }
        return null;
    }
        
      public Staff getStaff(String email) throws SQLException{
       String query = "SELECT * FROM tgsdb.customer WHERE EMAIL='" + email + "'";
       ResultSet rs = st.executeQuery(query);
        while (rs.next()) {
            String currentEmail = rs.getString(3);

            if (email.equals(currentEmail)) {
                int ID = Integer.parseInt(rs.getString(1));
                String name = rs.getString(2);
                String password = rs.getString(4);
                String DOB = rs.getString(5);
                String customerPhone = rs.getString(6);
                return new Staff(ID, name, email, password, DOB, customerPhone);
            }
        }
        return null;
    }
}
