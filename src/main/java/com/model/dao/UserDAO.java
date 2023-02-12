package com.model.dao;

import com.model.User;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * DAO is use to do all the CRUD operation with the database
 * for Customer and Staff tables
 * 
 * @author Aiman, Antonella, Micheal
 */
public class UserDAO {

    private Statement st;
    
    public UserDAO(Connection connection) throws SQLException {
        this.st = connection.createStatement();
    }
    
    /**
     * This returns the list of Customer or Staff based on the user type
     * from the db
     * 
     * @param userType
     * @return
     * @throws SQLException 
     */
    
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
    
    /**
     * This returns the list Staff
     * from the db
     * 
     * @return
     * @throws SQLException 
     */
    
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
    
    /**
     * This function is used to create a new User(Staff or Customer)
     * in the db
     * 
     * @param userType
     * @param name
     * @param email
     * @param password
     * @param dob
     * @param phone
     * @throws SQLException 
     */    
    
    public void create(String userType, String name, String email, String password, String dob, String phone) throws SQLException {       
        String columns = "INSERT INTO tgsdb." + userType + "(name, email, password, DOB, phone)";
        String values = "VALUES('" + name + "','" + email + "','" + password + "','" + dob + "','" + phone + "')";
        st.executeUpdate(columns + values);

    }

    /**
     * This function is used to update a User(Staff or Customer)
     * in the db
     * 
     * @param userType
     * @param name
     * @param password
     * @param dob
     * @param phone
     * @param ID
     * @throws SQLException 
     */
    public void update(String userType, String name, String password, String dob, String phone, int ID) throws SQLException {
        String columns = "UPDATE tgsdb."+userType+" SET name='"+ name +"', password= '"+ password +"', DOB='"+dob+"', phone='"+phone+"' WHERE ID='"+ID+"'";
        st.executeUpdate(columns);

    }

    /**
     * This function is used to delete a User(Staff or Customer)
     * from the db
     * 
     * @param userType
     * @param ID
     * @throws SQLException 
     */
    public void delete(String userType, int ID) throws SQLException {
        String query = "DELETE FROM tgsdb." + userType + " WHERE ID='" + ID + "'";
        st.execute("SET FOREIGN_KEY_CHECKS=0");
        st.executeUpdate(query);
        st.execute("SET FOREIGN_KEY_CHECKS=1");
        
    }
    
    /**
     * This function is used to get the User(Staff, Manager or Customer)
     * based on email and password
     * 
     * @param email
     * @param password
     * @param userType
     * @return
     * @throws SQLException 
     */
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
    

    /**
     * This returns a User (Customer or Staff) based on the user type and ID
     * from the db
     * 
     * @param ID
     * @param userType
     * @return
     * @throws SQLException 
     */
    
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
    
    /**
     * This returns a User (Customer or Staff) based on the user type and email
     * from the db
     * 
     * @param email
     * @param userType
     * @return
     * @throws SQLException 
     */
    
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
