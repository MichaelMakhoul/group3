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
 * Connects to DB for Booking Management
 * Performs the CRUD operations  
 * Tables accessed in DB
 * - booking - contains data of the bookings
 * - room - contains the data of room
 * - booked_rooms - links the bookings to their respective booked rooms
 * 
 * @author Shilpa
 */
public class BookingsDAO {
    private RoomDAO roomDAO;

    private Statement st;
    private PreparedStatement addSt;
    private PreparedStatement updateSt;
    private PreparedStatement deleteSt;

    private String addQy = "INSERT INTO tgsdb.booking (customer_ID, check_in, check_out, description, total_price)"
            + "VALUES (?, ?, ?, ?, ?)";

    private String updateQy = "UPDATE tgsdb.booking SET check_in=?, check_out=?, description=?,total_price=? WHERE BOOKING_ID=?";
    private String deleteQy = "DELETE FROM tgsdb.booking WHERE `BOOKING_ID`=?";

    public BookingsDAO(Connection connection) {
        try {
            roomDAO = new RoomDAO(connection);
            this.st = connection.createStatement();
            this.addSt = connection.prepareStatement(addQy, Statement.RETURN_GENERATED_KEYS);
            this.updateSt = connection.prepareStatement(updateQy);
            this.deleteSt = connection.prepareStatement(deleteQy);
        } catch (SQLException ex) {
            Logger.getLogger(BookingsDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Gets the booking details based on Booking ID
     * 
     * @param bookingID
     * @return Booking bean object
     */
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
            return booking;            
        }
        return booking; 
    }

    /**
     * Gets the list of bookings by Customer ID
     * 
     * @param customerID
     * @return List<Booking> 
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
            return bookings;            
        }
        return bookings;
    }
    
    /**
     * Gets the list of Rooms for the booking ID
     * 
     * @param bookingID
     * @return List<Room>
     */
    public List<Room> getBookedRooms(int bookingID) {        
        String qy = "SELECT tgsdb.room.* from tgsdb.room,tgsdb.booked_rooms\n"
                    + "WHERE tgsdb.booked_rooms.room_ID=tgsdb.room.room_ID\n"
                    + "and tgsdb.booked_rooms.booking_ID=" + bookingID;
        return roomDAO.executeQuery(qy);    
    }

    
    /**
     * Get the list all bookings (old and new)
     * 
     * @return List<Room>
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
            return bookings;
        }
        return bookings;             
    }

    /**
     * Get the list all current bookings 
     * 
     * @return List<Booking>
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
            return bookings;
        }
        return bookings;        
    }
    
    /**
     * Get the list all current bookings of customer by customerID
     * This is used when a customer is deleted
     * 
     * @return List<Booking>
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
    * Adds a booking
    * Accesses both booking and booked_room db
    *  
    * @param customerID
    * @param checkIn
    * @param checkOut
    * @param desc
    * @param noOfRooms
    * @return Booking Id
    */
    public int addBooking(int customerID, String checkIn, String checkOut, String desc, int []noOfRooms){
        System.out.println("com.model.dao.BookingsDAO.addBooking()");
        List<Room> rooms = generateRooms(checkIn, checkOut, noOfRooms);        
        int diff = Utils.differenceInDays(checkIn, checkOut);        
        int totalPrice = diff *((getRoomCountbyType(rooms,"DELUXE_ROOM")* 150) +
                            (getRoomCountbyType(rooms,"FAMILY_ROOM")* 250) + 
                            (getRoomCountbyType(rooms,"EXECUTIVE_SUITE")* 500));
        return createBooking(customerID, checkIn, checkOut, desc, totalPrice, rooms);
    }
    
    /**
     * Generates a list of rooms to add to booking
     * Accesses the room table to get the available rooms
     * and then add the required amount to the booking
     * 
     * @param checkIn
     * @param checkOut
     * @param noOfRooms
     * @return List<Room>
     */
    
    private List<Room> generateRooms(String checkIn, String checkOut,int []noOfRooms){
        List<Room> availRooms = roomDAO.getAvailableRooms(checkIn, checkOut);
        List<Room> rooms = new ArrayList<>(); 
        System.out.println("checkIn "+ checkIn);
        System.out.println("checkOut "+ checkOut);
        System.out.println("noOfRooms "+ Arrays.toString(noOfRooms));
        if(noOfRooms[0]>0){
            rooms.addAll(availRooms.stream().filter(r -> r.matchType("DELUXE_ROOM")).limit(noOfRooms[0]).collect(Collectors.toList())); 
        }
        if(noOfRooms[1]>0){
            rooms.addAll(availRooms.stream().filter(r -> r.matchType("FAMILY_ROOM")).limit(noOfRooms[1]).collect(Collectors.toList()));
        }
        if(noOfRooms[2]>0){
            rooms.addAll(availRooms.stream().filter(r -> r.matchType("EXECUTIVE_SUITE")).limit(noOfRooms[2]).collect(Collectors.toList())); 
        }        
        return rooms;
    }

    /**
     * Adds a booking
     * Accesses both booking and booked_room db
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
            addBookedRooms(bookingID, rooms);
        } catch (SQLException ex) {
            Logger.getLogger(BookingsDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            return bookingID;
        }        
    }
    
    /**
     * Populates the booked_rooms DB for with list of rooms for the given booking id
     * 
     * @param bookingID
     * @param rooms 
     */
    private void addBookedRooms(int bookingID, List<Room> rooms){
        try {
            if(rooms != null){
                for (Room r : rooms) {
                    String qy = "INSERT INTO tgsdb.booked_rooms (booking_ID, room_id) VALUES ('" + bookingID + "', '" + r.getRoomID() + "')";
                    st.executeUpdate(qy);
                }
            }            
        } catch (SQLException ex) {
            Logger.getLogger(BookingsDAO.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
    /**
     * Deletes the booking for the given booking ID
     * Access the booking table
     * 
     * @param bookingID 
     */
    public void deleteBooking(int bookingID) {
        try {
            st.execute("SET FOREIGN_KEY_CHECKS=0");
            deleteBookedRooms(bookingID);
            deleteSt.setString(1, "" + bookingID);
            int row = deleteSt.executeUpdate();
            System.out.println("Row " + row + " has been successflly deleted tgsdb.booking");
            st.execute("SET FOREIGN_KEY_CHECKS=1");
        } catch (SQLException ex) {
            Logger.getLogger(RoomDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Deletes the entries for the given booking ID
     * Access the booked_rooms table
     * 
     * @param bookingID 
     */
    private void deleteBookedRooms(int bookingID){
        try {
            String qy = "DELETE FROM tgsdb.booked_rooms WHERE `BOOKING_ID`=" + bookingID;
            int row = st.executeUpdate(qy);
            System.out.println("Row " + row + " has been successflly deleted in tgsdb.booked_rooms ");
        } catch (SQLException ex) {
            Logger.getLogger(BookingsDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Deletes all the current bookings for the given customer ID
     * Access the booking, booking table
     * 
     * @param customerID 
     */
    public void deleteBookingbyCustomerID(int customerID){
        //only delete current Bookings
        List<Booking> bookings = getCurrentBookingsbyCustomerID(customerID);
        bookings.forEach(b -> deleteBooking(b.getBookingID()));        
    }    
       
    /**
     * Updates the booking
     * 
     * @param checkIn
     * @param checkOut
     * @param desc
     * @param totalPrice
     * @param bookingID
     * @param rooms 
     */
    public void updateBooking(String checkIn, String checkOut, String desc, int totalPrice,int bookingID, int []noOfRooms){
        try {
            st.execute("SET FOREIGN_KEY_CHECKS=0");
            // first delete the rooms booked
            deleteBookedRooms(bookingID);
            // generate a list for no of rooms required
            List<Room> rooms = generateRooms(checkIn, checkOut, noOfRooms);
            //update booking and then populate the booked_rooms table
            update(checkIn, checkOut, desc, totalPrice, bookingID, rooms);
        } catch (SQLException ex) {
            Logger.getLogger(BookingsDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
    /**
     * Update query for booking
     * 
     * @param checkIn
     * @param checkOut
     * @param desc
     * @param totalPrice
     * @param bookingID
     * @param rooms 
     */
    private void update(String checkIn, String checkOut, String desc, int totalPrice,int bookingID, List<Room> rooms){
        try {           
            updateSt.setString(1, checkIn);
            updateSt.setString(2, checkOut);
            updateSt.setString(3, desc);
            updateSt.setString(4, ""+totalPrice);
            updateSt.setString(5, ""+bookingID);
            int row = updateSt.executeUpdate();
            System.out.println(row+"row has been successflly updated");
            updateBookedRooms(bookingID, rooms);
            st.execute("SET FOREIGN_KEY_CHECKS=1");
        } catch (SQLException ex) {
            Logger.getLogger(BookingsDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    /**
     * Populate the booked_rooms table after booking update
     * 
     * @param bookingID
     * @param rooms 
     */
    private void updateBookedRooms(int bookingID, List<Room> rooms){
        // to update the booking first delete the rooms and then add the rooms        
        addBookedRooms(bookingID, rooms);        
    }

    
    
    // access room details from roomDAO
    /**
     * Get Room bean object by roomID
     * 
     * @param roomID
     * @return
     */
    public Room getRoombyID(int roomID) {
        return roomDAO.getRoombyID(roomID);
    }

    /**
     * Get Count of available rooms by type
     * Required by Add Booking and Update booking features
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
     * The function is used get the available rooms for the given dates
     * 
     * @param checkIn
     * @param checkOut
     * @return 
     */
    public List<Room> getAvailableRooms(String checkIn, String checkOut){
        return roomDAO.getAvailableRooms(checkIn, checkOut);
    }
    
    /**
     * 
     * @param rooms
     * @param roomType
     * @return 
     */
    
    public int getRoomCountbyType(List<Room> rooms, String roomType){
        return roomDAO.getRoomCountbyType(rooms, roomType);
    }

}