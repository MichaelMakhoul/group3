package com.model.dao;

import com.model.Booking;
import com.model.Room;
import com.utils.Utils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

/**
 *
 * @author 236361
 */
public class BookingsDAO {
    private RoomDAO roomDAO;

    private Statement st;
    private PreparedStatement addSt;
//    private PreparedStatement updateSt;
    private PreparedStatement deleteSt;

    private String addQy = "INSERT INTO tgsdb.booking (customer_ID, check_in, check_out, description, total_price)"
            + "VALUES (?, ?, ?, ?, ?)";

    //private String updateQy = "UPDATE tgsdb.room SET ROOM_NO=?, TYPE=?, IMAGE=?,DESCRIPTION=?, PRICE=? WHERE ROOM_ID=?";
    private String deleteQy = "DELETE FROM tgsdb.booking WHERE `BOOKING_ID`=?";

    public BookingsDAO(Connection connection) {
        try {
            roomDAO = new RoomDAO(connection);
            this.st = connection.createStatement();
            this.addSt = connection.prepareStatement(addQy, Statement.RETURN_GENERATED_KEYS);
            this.deleteSt = connection.prepareStatement(deleteQy);
        } catch (SQLException ex) {
            Logger.getLogger(BookingsDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Booking booking(int bookingID){
        Booking booking = null;
        try {
            String qy = "SELECT * FROM tgsdb.booking WHERE `booking_ID`=" + bookingID;
            ResultSet rs = st.executeQuery(qy);
            while (rs.next()) {
                int id = Integer.parseInt(rs.getString(1));
                if (id == bookingID) {                    
                    int customerID = Integer.parseInt(rs.getString(2));
                    String checkIn = rs.getString(3);
                    String checkOut = rs.getString(4);
                    String desc = rs.getString(5);
                    int totalPrice = Integer.parseInt(rs.getString(6));
                    String bookedDate = rs.getString(7);
                    String updateDate = rs.getString(8);                    
                   booking = new Booking(bookingID, customerID, checkIn, checkOut, desc, totalPrice, bookedDate, updateDate, null);
                }              
            }
            booking.setRooms(getBookedRooms(bookingID));  
        } catch (SQLException ex) {
            Logger.getLogger(BookingsDAO.class.getName()).log(Level.SEVERE, null, ex);            
        }finally{
            return booking;
        }
        
    }

    /**
     *
     * @param customerID
     * @return
     */
    public List<Booking> getBookingsbyCustomer(int customerID) {
        List<Booking> bookings = new ArrayList<>();
        try {
            String qy = "SELECT * FROM tgsdb.booking WHERE `customer_ID`=" + customerID;
            ResultSet rs = st.executeQuery(qy);
            while (rs.next()) {
                int id = Integer.parseInt(rs.getString(2));
                if (id == customerID) {
                    int bookingID = Integer.parseInt(rs.getString(1));
                    String checkIn = rs.getString(3);
                    String checkOut = rs.getString(4);
                    String desc = rs.getString(5);
                    int totalPrice = Integer.parseInt(rs.getString(6));
                    String bookedDate = rs.getString(7);
                    String updateDate = rs.getString(8);                    
                    bookings.add(new Booking(bookingID, customerID, checkIn, checkOut, desc, totalPrice, bookedDate, updateDate, null));
                }                              
            }
            for(Booking b : bookings){
                    b.setRooms(getBookedRooms(b.getBookingID()));
            }  
        } catch (SQLException ex) {
            Logger.getLogger(BookingsDAO.class.getName()).log(Level.SEVERE, null, ex);            
        }finally{
            return bookings;
        }
        
    }
    
    /**
     * 
     * @param bookingID
     * @return 
     */
    public List<Room> getBookedRooms(int bookingID) {
        List<Room> rooms = new ArrayList<>();
        try {
            String qy = "SELECT tgsdb.room.* from tgsdb.room,tgsdb.booked_rooms\n"
                    + "WHERE tgsdb.booked_rooms.room_ID=tgsdb.room.room_ID\n"
                    + "and tgsdb.booked_rooms.booking_ID=" + bookingID;
            ResultSet rs = st.executeQuery(qy);
            while (rs.next()) {
                int roomID = Integer.parseInt(rs.getString(1));
                String roomNo = rs.getString(2);
                String roomType = rs.getString(3);
                String roomImageUrl = rs.getString(4);
                String roomDesc = rs.getString(5);
                int roomPrice = Integer.parseInt(rs.getString(6));
                rooms.add(new Room(roomID, roomNo, roomType, roomImageUrl, roomDesc, roomPrice));
            }
        } catch (SQLException ex) {
            Logger.getLogger(BookingsDAO.class.getName()).log(Level.SEVERE, null, ex);            
        }finally{
            return rooms;
        }
        
    }

    
    /**
     *
     * @return
     */
    public List<Booking> getBookings() {

        List<Booking> bookings = new ArrayList<>();
        try {
            String date = LocalDate.now().toString();
            String qy = "SELECT * FROM tgsdb.booking";
            ResultSet rs = st.executeQuery(qy);
            while (rs.next()) {
                int bookingID = Integer.parseInt(rs.getString(1));
                int customerID = Integer.parseInt(rs.getString(2));
                String checkIn = rs.getString(3);
                String checkOut = rs.getString(4);
                String desc = rs.getString(5);
                int totalPrice = Integer.parseInt(rs.getString(6));
                String bookedDate = rs.getString(7);
                String updateDate = rs.getString(8);                
                bookings.add(new Booking(bookingID, customerID, checkIn, checkOut, desc, totalPrice, bookedDate, updateDate, null));
            }
            for(Booking b : bookings){
                b.setRooms(getBookedRooms(b.getBookingID()));
            }
        } catch (SQLException ex) {
            Logger.getLogger(BookingsDAO.class.getName()).log(Level.SEVERE, null, ex);            
        }finally{
            return bookings;
        }        
    }

    /**
     *
     * @return
     */
    public List<Booking> getCurrentBookings() {
        List<Booking> bookings = new ArrayList<>();
        try {
            String date = LocalDate.now().toString();
            //System.out.println("date: "+date);
            String qy = "SELECT * FROM tgsdb.booking WHERE `check_in`>'" + date+"'";
            ResultSet rs = st.executeQuery(qy);
            while (rs.next()) {
                int bookingID = Integer.parseInt(rs.getString(1));
                int customerID = Integer.parseInt(rs.getString(2));
                String checkIn = rs.getString(3);
                String checkOut = rs.getString(4);
                String desc = rs.getString(5);
                int totalPrice = Integer.parseInt(rs.getString(6));
                String bookedDate = rs.getString(7);
                String updateDate = rs.getString(8);                
                bookings.add(new Booking(bookingID, customerID, checkIn, checkOut, desc, totalPrice, bookedDate, updateDate, null));
            }
            for(Booking b : bookings){
                b.setRooms(getBookedRooms(b.getBookingID()));
            }
        } catch (SQLException ex) {
            Logger.getLogger(BookingsDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            return bookings;
        } 
    }
    
    /**
     *
     * @return
     */
    public List<Booking> getCurrentBookingsbyCustomerID(int customerID) {
        List<Booking> bookings = new ArrayList<>();
        try {
            String date = LocalDate.now().toString();
            //System.out.println("date: "+date);
            String qy = "SELECT * FROM tgsdb.booking WHERE `check_in`>'" + date+"' AND `customer_ID`=" + customerID;
            ResultSet rs = st.executeQuery(qy);
            while (rs.next()) {
                int id = Integer.parseInt(rs.getString(2));
                if(id == customerID){
                    int bookingID = Integer.parseInt(rs.getString(1));                
                    String checkIn = rs.getString(3);
                    String checkOut = rs.getString(4);
                    String desc = rs.getString(5);
                    int totalPrice = Integer.parseInt(rs.getString(6));
                    String bookedDate = rs.getString(7);
                    String updateDate = rs.getString(8);                
                    bookings.add(new Booking(bookingID, customerID, checkIn, checkOut, desc, totalPrice, bookedDate, updateDate, null));
                }
            }
            for(Booking b : bookings){
                b.setRooms(getBookedRooms(b.getBookingID()));
            }
        } catch (SQLException ex) {
            Logger.getLogger(BookingsDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            return bookings;
        }
    }
    
    /**
     * 
     * @param customerID
     * @param checkIn
     * @param checkOut
     * @param desc
     * @param totalPrice
     * @param noOfRooms 
     */
    public int addBooking(int customerID, String checkIn, String checkOut, String desc, int totalPrice, int []noOfRooms){
        System.out.println("com.model.dao.BookingsDAO.addBooking()");
        List<Room> availRooms = roomDAO.getAvailableRooms(checkIn, checkOut);
        List<Room> rooms = new ArrayList<>();
        //String []roomType = {"DELUXE_ROOM","FAMILY_ROOM","EXECUTIVE_SUITE"};   
        if(noOfRooms[0]>0){
            rooms.addAll(availRooms.stream().filter(r -> r.matchType("DELUXE_ROOM")).limit(noOfRooms[0]).collect(Collectors.toList())); 
        }
        if(noOfRooms[1]>0){
            rooms.addAll(availRooms.stream().filter(r -> r.matchType("FAMILY_ROOM")).limit(noOfRooms[1]).collect(Collectors.toList()));
        }
        if(noOfRooms[2]>0){
            rooms.addAll(availRooms.stream().filter(r -> r.matchType("EXECUTIVE_SUITE")).limit(noOfRooms[2]).collect(Collectors.toList())); 
        }
        System.out.println("checkIn "+ checkIn);
        System.out.println("checkOut "+ checkIn);
        System.out.println("noOfRooms "+ Arrays.toString(noOfRooms));
        int diff = Utils.differenceInDays(checkIn, checkOut);
        totalPrice = diff *((noOfRooms[0]* 150) + (noOfRooms[1]* 250) + (noOfRooms[2]* 500));
        return createBooking(customerID, checkIn, checkOut, desc, totalPrice, rooms);
    }
    

    /**
     *
     * @param customerID
     * @param checkIn
     * @param checkOut
     * @param rooms
     */
    private int createBooking(int customerID, String checkIn, String checkOut, String desc, int totalPrice, List<Room> rooms) {
        int bookingID = 0;
        try {
            addSt.setString(1, "" + customerID);
            addSt.setString(2, checkIn);
            addSt.setString(3, checkOut);
            addSt.setString(4, desc);
            addSt.setString(5, "" + totalPrice);
            addSt.executeUpdate();
            
            ResultSet rs = addSt.getGeneratedKeys();
            if (rs != null && rs.next()) {
                bookingID = rs.getInt(1);
                System.out.println("bookingID :" + bookingID);
            }
            if(rooms != null){
                for (Room r : rooms) {
                    String qy = "INSERT INTO tgsdb.booked_rooms (booking_ID, room_id) VALUES ('" + bookingID + "', '" + r.getRoomID() + "')";
                    st.executeUpdate(qy);
                }
            }            
        } catch (SQLException ex) {
            Logger.getLogger(BookingsDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            return bookingID;
        }        
    }
    
    /**
     * 
     * @param bookingID 
     */
    public void deleteBooking(int bookingID) {
        try {
            st.execute("SET FOREIGN_KEY_CHECKS=0");
            String qy = "DELETE FROM tgsdb.booked_rooms WHERE `BOOKING_ID`=" + bookingID;
            int row = st.executeUpdate(qy);
            System.out.println("Row " + row + " has been successflly deleted in tgsdb.booked_rooms ");
            deleteSt.setString(1, "" + bookingID);
            row = deleteSt.executeUpdate();
            System.out.println("Row " + row + " has been successflly deleted tgsdb.booking");
            st.execute("SET FOREIGN_KEY_CHECKS=1");
        } catch (SQLException ex) {
            Logger.getLogger(RoomDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * 
     * @param customerID 
     */
    public void deleteBookingbyCustomerID(int customerID){
        //only delete current Bookings
        List<Booking> bookings = getCurrentBookingsbyCustomerID(customerID);
        bookings.forEach(b -> deleteBooking(b.getBookingID()));        
    }
    
    // access room details from roomDAO
    /**
     *
     * @param roomID
     * @return
     */
    public Room getRoombyID(int roomID) {
        return roomDAO.getRoombyID(roomID);
    }

    /**
     * 
     * @param checkIn
     * @param checkOut
     * @param roomType
     * @return 
     */
    public int getAvailableRoomsCountbyType(String checkIn, String checkOut, String roomType){
        return roomDAO.getAvailableRoomsCountbyType(checkIn, checkOut, roomType);
    }
    
    /**
     * The function is used get the available rooms during the given period for particular type
     * 
     * @param checkIn
     * @param checkOut
     * @param roomType
     * @return List of rooms 
     */
    public List<Room> getAvailableRoomsbyType(String checkIn, String checkOut, String roomType){
        return roomDAO.getAvailableRoomsbyType(checkIn, checkOut, roomType);        
    }
    
    /**
     * 
     * @param checkIn
     * @param checkOut
     * @return 
     */
    public List<Room> getAvailableRooms(String checkIn, String checkOut){
        return roomDAO.getAvailableRooms(checkIn, checkOut);
    }
    

}