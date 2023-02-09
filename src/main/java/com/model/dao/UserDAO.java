/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model.dao;

import com.model.User;
import java.sql.Connection;
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

    public UserDAO(Connection connection) throws SQLException {
        this.st = connection.createStatement();
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
    
    public List<User> getStaff() throws SQLException {
        String query = "SELECT * FROM tgsdb.staff";
        ResultSet rs = st.executeQuery(query);
        List<User> temp = new ArrayList<>();

        while (rs.next()) {
            int ID = Integer.parseInt(rs.getString(1));
            String name = rs.getString(2);
            String email = rs.getString(3);
            String password = rs.getString(4);
            String dob = rs.getString(5);
            String phone = rs.getString(6);
            User user = new User(ID, name, email, password, dob, phone, "staff");
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

    
    public void delete(String userType, int ID) throws SQLException {
        String query = "DELETE FROM tgsdb." + userType + " WHERE ID='" + ID + "'";
        st.execute("SET FOREIGN_KEY_CHECKS=0");
        st.executeUpdate(query);
        st.execute("SET FOREIGN_KEY_CHECKS=1");
        
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
