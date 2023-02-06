/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model.dao;

import com.model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 236351
 */
public class UserDAO {

    private Statement st;
//    private PreparedStatement getUserByIDSt;
//    private PreparedStatement createSt;
    private PreparedStatement updateSt;
//    private PreparedStatement deleteSt;

//    private String getUserByIDQy = "SELECT * FROM tgsdb.? WHERE ID=?";
//    private String createQy = "INSERT INTO tgsdb.?(name, email, password, DOB, phone)" + "VALUES(?,?,?,?,?)";
    private String updateQy = "UPDATE tgsdb.? SET name=?, password=?, DOB=?, phone=? WHERE ID=?";
//    private String deleteQy = "DELETE FROM ? WHERE ID=?";

    public UserDAO(Connection connection) throws SQLException {
        this.st = connection.createStatement();
//        this.getUserByIDSt = connection.prepareStatement(getUserByIDQy);
//        this.createSt = connection.prepareStatement(createQy);
        this.updateSt = connection.prepareStatement(updateQy);
//        this.deleteSt = connection.prepareStatement(deleteQy);
    }

    public List<User> getUsers(String userType) throws SQLException {
        String query = "SELECT * FROM tgsdb." + userType;
        ResultSet rs = st.executeQuery(query);
        List<User> temp = new ArrayList<>();

        while (rs.next()) {
            int ID = Integer.parseInt(rs.getString(1));
            String name = rs.getString(2);
            String email = rs.getString(3);
            String password = rs.getString(4);
            String dob = rs.getString(5);
            String phone = rs.getString(6);
            User user = new User(ID, name, email, password, dob, phone, userType);
            temp.add(user);
        }
        return temp;
    }

    public void create(String userType, String name, String email, String password, String dob, String phone) throws SQLException {       
        String columns = "INSERT INTO tgsdb." + userType + "(name, email, password, DOB, phone)";
        String values = "VALUES('" + name + "','" + email + "','" + password + "','" + dob + "','" + phone + "')";
        st.executeUpdate(columns + values);

    }

    public void update(String userType, String name, String password, String dob, String phone, int ID) throws SQLException {
        String columns = "UPDATE tgsdb."+userType+" SET name='"+ name +"', password= '"+ password +"', DOB='"+dob+"', phone='"+phone+"' WHERE ID='"+ID+"'";
        st.executeUpdate(columns);

    }

//    public void update(User user){
//        updateSt.setString(1, user.getType());
//        updateSt.setString(2, name);
//        updateSt.setString(3, password);
//        updateSt.setString(4, dob);
//        updateSt.setString(5, phone);
//        updateSt.setString(6, Integer.toString(ID));
//        int row = updateSt.executeUpdate();
//        System.out.println("Row " + row + " has been successflly updated");
//    }
    
    public void delete(String userType, int ID) throws SQLException {
        String query = "DELETE FROM tgsdb." + userType + " WHERE ID='" + ID + "'";
        st.execute("SET FOREIGN_KEY_CHECKS=0");
        st.executeUpdate(query);
    }

    public User login(String email, String password, String userType) throws SQLException {
        String query = "SELECT * FROM tgsdb." + userType + " WHERE EMAIL='" + email + "' AND PASSWORD='" + password + "'";
        ResultSet rs = st.executeQuery(query);
        while (rs.next()) {
            String currentEmail = rs.getString(3);
            String currentPassword = rs.getString(4);

            if (email.equals(currentEmail) && password.equals(currentPassword)) {
                int ID = Integer.parseInt(rs.getString(1));
                String name = rs.getString(2);
                String DOB = rs.getString(5);
                String phone = rs.getString(6);
                return new User(ID, name, email, password, DOB, phone, userType);
            }
        }
        return null;
    }

    public User getUser(int ID, String userType) throws SQLException {
        String query = "SELECT * FROM tgsdb." + userType + " WHERE ID='" + ID + "'";
        ResultSet rs = st.executeQuery(query);

        while (rs.next()) {
            ID = Integer.parseInt(rs.getString(1));
            String name = rs.getString(2);
            String email = rs.getString(3);
            String password = rs.getString(4);
            String dob = rs.getString(5);
            String phone = rs.getString(6);

            return new User(ID, name, email, password, dob, phone, userType);
        }
        return null;
    }

    public User getUser(String email, String userType) throws SQLException {
        String query = "SELECT * FROM tgsdb." + userType + " WHERE EMAIL='" + email + "'";
        ResultSet rs = st.executeQuery(query);
        while (rs.next()) {
            String currentEmail = rs.getString(3);

            if (email.equals(currentEmail)) {
                int ID = Integer.parseInt(rs.getString(1));
                String name = rs.getString(2);
                String password = rs.getString(4);
                String DOB = rs.getString(5);
                String phone = rs.getString(6);
                return new User(ID, name, email, password, DOB, phone, userType);
            }
        }
        return null;
    }
}