//package com.model.dao;
//
//import com.model.User;
//import java.sql.Statement;
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;
//
///**
// *
// * @author 236336
// */
//public class CustomerDAO {
//
//    private Statement st;
//    private PreparedStatement getCustomerByIDSt;
//    private PreparedStatement createSt;
//    private PreparedStatement updateSt;
//    private PreparedStatement deleteSt;
//
//    private String getCustomerByIDQy = "SELECT * FROM tgsdb.customer WHERE customer_ID=?";
//    private String createQy = "INSERT INTO tgsdb.customer(name, email, password, DOB, customer_phone)" + "VALUES(?,?,?,?,?)";
//    private String updateQy = "UPDATE tgsdb.customer SET name=?, password=?, DOB=?, customer_phone=? WHERE customer_ID=?";
//    private String deleteQy = "DELETE FROM tgsdb.customer WHERE customer_ID=?";
//
//    public CustomerDAO(Connection connection) throws SQLException {
//        this.st = connection.createStatement();
//        this.getCustomerByIDSt = connection.prepareStatement(getCustomerByIDQy);
//        this.createSt = connection.prepareStatement(createQy);
//        this.updateSt = connection.prepareStatement(updateQy);
//        this.deleteSt = connection.prepareStatement(deleteQy);
//    }
//
//    //Read Query - Read All
//    public List<User> getCustomers() throws SQLException {
//        String query = "SELECT * FROM tgsdb.customer";
//        ResultSet rs = st.executeQuery(query);
//        List<User> temp = new ArrayList<>();
//
//        while (rs.next()) {
//            int ID = Integer.parseInt(rs.getString(1));
//            String name = rs.getString(2);
//            String email = rs.getString(3);
//            String password = rs.getString(4);
//            String dob = rs.getString(5);
//            String phone = rs.getString(6);
//            User user = new User(ID, name, email, password, dob, phone, "customer");
//            temp.add(user);
//        }
//        return temp;
//    }
//
//    public void create(String name, String email, String password, String dob, String customerPhone) throws SQLException {
//        createSt.setString(1, name);
//        createSt.setString(2, email);
//        createSt.setString(3, password);
//        createSt.setString(4, dob);
//        createSt.setString(5, customerPhone);
//        createSt.executeUpdate();
//    }
//
//    public void update(String name, String password, String dob, String customerPhone, int ID) throws SQLException {
//        updateSt.setString(1, name);
//        updateSt.setString(2, password);
//        updateSt.setString(3, dob);
//        updateSt.setString(4, customerPhone);
//        updateSt.setString(5, Integer.toString(ID));
//        int row = updateSt.executeUpdate();
//        System.out.println("Row " + row + " has been successflly updated");
//    }
//
//    public void delete(int ID) throws SQLException {
//        deleteSt.setString(1, "" + ID);
//        int row = deleteSt.executeUpdate();
//        System.out.println("Row " + row + " has been successflly deleted");
//    }
//
//    public User login(String email, String password, String type) throws SQLException {
//        String query = "SELECT * FROM tgsdb."+type+" WHERE EMAIL='" + email + "' AND PASSWORD='" + password + "'";
//        ResultSet rs = st.executeQuery(query);
//        while (rs.next()) {
//            String currentEmail = rs.getString(3);
//            String currentPassword = rs.getString(4);
//
//            if (email.equals(currentEmail) && password.equals(currentPassword)) {
//                int ID = Integer.parseInt(rs.getString(1));
//                String name = rs.getString(2);
//                String DOB = rs.getString(5);
//                String customerPhone = rs.getString(6);
//                return new User(ID, name, email, password, DOB, customerPhone, "customer");
//            }
//        }
//        return null;
//    }
//
//    public User getCustomer(int ID) throws SQLException {
//        getCustomerByIDSt.setString(1, "" + ID);
//        ResultSet rs = getCustomerByIDSt.executeQuery();
//
//        while (rs.next()) {
//            ID = Integer.parseInt(rs.getString(1));
//            String name = rs.getString(2);
//            String email = rs.getString(3);
//            String password = rs.getString(4);
//            String dob = rs.getString(5);
//            String phone = rs.getString(5);
//            
//            return new User(ID, name, email, password, dob, phone, "customer");
//        
//        }
//
//        return null;
//    }
//
//    public User getCustomer(String email) throws SQLException {
//        String query = "SELECT * FROM tgsdb.customer WHERE EMAIL='" + email + "'";
//        ResultSet rs = st.executeQuery(query);
//        while (rs.next()) {
//            String currentEmail = rs.getString(3);
//
//            if (email.equals(currentEmail)) {
//                int ID = Integer.parseInt(rs.getString(1));
//                String name = rs.getString(2);
//                String password = rs.getString(4);
//                String DOB = rs.getString(5);
//                String customerPhone = rs.getString(6);
//                return new User(ID, name, email, password, DOB, customerPhone, "customer");
//            }
//        }
//        return null;
//    }
//}
