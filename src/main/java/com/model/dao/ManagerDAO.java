/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model.dao;

import com.model.Manager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 236333
 */
public class ManagerDAO {
    private Statement st;
    private PreparedStatement updateSt;
    private String updateQuery = "UPDATE tgsdb.manager SET NAME=?, PASSWORD=?, DOB=? WHERE ID=?";
    private PreparedStatement deleteSt;
    private String deleteQuery = "DELETE FROM tgsdb.manager WHERE ID=?";

    public ManagerDAO(Connection connection) throws SQLException {
        this.st = connection.createStatement();
        this.updateSt = connection.prepareStatement(updateQuery);
        this.deleteSt = connection.prepareStatement(deleteQuery);
    }

    //Create Query
    public void create(String managerName, String managerEmail, String managerPassword, String managerDOB) throws SQLException {
        String columns = "INSERT INTO tgsdb.manager(NAME,EMAIL,PASSWORD,DOB)";
        String values = "VALUES('" + managerName + "','" + managerEmail + "','" + managerPassword + "','" + managerDOB + "')";
        st.executeUpdate(columns + values);
    }

    //Read Query - Read One
    public Manager getManager(int managerID) throws SQLException {
        String query = "SELECT * FROM tgsdb.admins WHERE ID=" + managerID;
        ResultSet rs = st.executeQuery(query);
        
        while (rs.next()) {
            int currentID = Integer.parseInt(rs.getString(1));

            if (managerID == currentID) {
                String managerName = rs.getString(2);
                String managerEmail = rs.getString(3);
                String managerPassword = rs.getString(4);
                String managerDOB= rs.getString(5);
                return new Manager(managerID, managerName, managerEmail, managerPassword, managerDOB);
            }
        }
        return null;
    }
    
        //Read Query - Read One
    public Manager getManager(String managerEmail) throws SQLException {
        String query = "SELECT * FROM tgsdb.manager WHERE EMAIL='" + managerEmail+"'";
        ResultSet rs = st.executeQuery(query);
        while (rs.next()) {
            String currentEmail = rs.getString(3);

            if (managerEmail.equals(currentEmail)) {
                int managerID = Integer.parseInt(rs.getString(1));
                String managerName = rs.getString(2);
                
                String managerPassword = rs.getString(4);
                String managerDOB = rs.getString(5);
                return new Manager(managerID, managerName, managerEmail, managerPassword, managerDOB);
            }
        }
        return null;
    }
    
     //Read Query - Read One by Email and Password
    public Manager login(String managerEmail, String managerPassword) throws SQLException {
        String query = "SELECT * FROM tgsdb.manager WHERE EMAIL='"+ managerEmail+"' AND PASSWORD='"+managerPassword+"'";
        ResultSet rs = st.executeQuery(query);
        while (rs.next()) {
            String currentEmail = rs.getString(3);
            String currentPassword = rs.getString(4);

            if (managerEmail.equals(currentEmail)&&managerPassword.equals(currentPassword)) {
                int managerID = Integer.parseInt(rs.getString(1));
                String managerName = rs.getString(2);               
                String managerDOB = rs.getString(5);
                return new Manager(managerID, managerName, managerEmail, managerPassword, managerDOB);
            }
        }
        return null;
    }

    //Read Query - Read All
    public List<Manager> getManagers() throws SQLException {
        String query = "SELECT * FROM tgsdb.admins";
        ResultSet rs = st.executeQuery(query);
        List<Manager> temp = new ArrayList<>();
        
        while (rs.next()) {
            int managerID = Integer.parseInt(rs.getString(1));
            String managerName = rs.getString(2);
            String managerEmail = rs.getString(3);
            String managerPassword = rs.getString(4);
            String managerDOB = rs.getString(5);
           temp.add(new Manager(managerID, managerName, managerEmail, managerPassword, managerDOB));
        }    
        return temp;
    }
    
    //Update Query (Name, Password) by ID
    public void update(String managerName, String managerPassword, String managerDOB, int managerID) throws SQLException{
        updateSt.setString(1, managerName);
        updateSt.setString(2, managerPassword);
        updateSt.setString(3, managerDOB);
        updateSt.setString(4, Integer.toString(managerID));
        int row = updateSt.executeUpdate();
        System.out.println("Row "+row+" has been successflly updated");
    }
   
    //Delete Query - by ID
    public void delete(int ID) throws SQLException{
        deleteSt.setString(1, ""+ID);
        int row = deleteSt.executeUpdate();
        System.out.println("Row "+row+" has been successflly deleted");
    }
}
    
    

