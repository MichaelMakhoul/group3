package com.model.dao;

import com.model.Booking;
import com.model.Room;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 236361
 */
public class BookingsDAO {

    private Statement st;
    private PreparedStatement addSt;
//    private PreparedStatement updateSt;
    private PreparedStatement deleteSt;

    private String addQy = "INSERT INTO tgsdb.booking (customer_ID, check_in, check_out, description, total_price)"
            + "VALUES (?, ?, ?, ?, ?)";

    private String updateQy = "UPDATE tgsdb.room SET ROOM_NO=?, TYPE=?, IMAGE=?,DESCRIPTION=?, PRICE=? WHERE ROOM_ID=?";
    private String deleteQy = "DELETE FROM tgsdb.booking WHERE `BOOKING_ID`=?";

    public BookingsDAO(Connection connection) {
        try {
            this.st = connection.createStatement();
            this.addSt = connection.prepareStatement(addQy, Statement.RETURN_GENERATED_KEYS);
            this.deleteSt = connection.prepareStatement(deleteQy);
        } catch (SQLException ex) {
            Logger.getLogger(BookingsDAO.class.getName()).log(Level.SEVERE, null, ex);
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
                for(Booking b : bookings){
                    b.setRooms(getBookedRooms(b.getBookingID()));
                }                
            }
        } catch (SQLException ex) {
            Logger.getLogger(BookingsDAO.class.getName()).log(Level.SEVERE, null, ex);
            return bookings;
        }
        return bookings;
    }
    

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
            return rooms;
        }
        return rooms;
    }

    /**
     *
     * @param roomID
     * @return
     */
    public Room getRoombyID(int roomID) {
        String qy = "SELECT * FROM tgsdb.room where `room_ID`=" + roomID;
        try {
            ResultSet rs = st.executeQuery(qy);
            while (rs.next()) {
                int id = Integer.parseInt(rs.getString(1));
                if (id == roomID) {
                    String roomNo = rs.getString(2);
                    String roomType = rs.getString(3);
                    String roomImageUrl = rs.getString(4);
                    String roomDesc = rs.getString(5);
                    int roomPrice = Integer.parseInt(rs.getString(6));
                    return new Room(roomID, roomNo, roomType, roomImageUrl, roomDesc, roomPrice);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(RoomDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        return null;
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
            return bookings;
        }
        return bookings;
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
            return bookings;
        }
        return bookings;
    }

    /**
     *
     * @param customerID
     * @param checkIn
     * @param checkOut
     * @param rooms
     */
    public void addBooking(int customerID, String checkIn, String checkOut, String desc, int totalPrice, List<Room> rooms) {
        try {
            addSt.setString(1, "" + customerID);
            addSt.setString(2, checkIn);
            addSt.setString(3, checkOut);
            addSt.setString(4, desc);
            addSt.setString(5, "" + totalPrice);
            addSt.executeUpdate();
            int bookingID = 0;
            ResultSet rs = addSt.getGeneratedKeys();
            if (rs != null && rs.next()) {
                bookingID = rs.getInt(1);
                System.out.println("bookingID :" + bookingID);
            }
            for (Room r : rooms) {
                String qy = "INSERT INTO tgsdb.booked_rooms (booking_ID, room_id) VALUES ('" + bookingID + "', '" + r.getRoomID() + "')";
                st.executeUpdate(qy);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BookingsDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

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

}
