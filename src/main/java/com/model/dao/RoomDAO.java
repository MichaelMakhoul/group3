
package com.model.dao;

import com.model.Room;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

/**
 *
 * @author 236361
 */
public class RoomDAO {
    
    private Statement st;
    private PreparedStatement createSt;
    private PreparedStatement updateSt;
    private PreparedStatement deleteSt;
    
    private String createQy = "INSERT INTO tgsdb.room (room_No,type,image,description, price)"
                               +"VALUES(?,?,?,?,?)";
    private String updateQy = "UPDATE tgsdb.room SET ROOM_NO=?, TYPE=?, IMAGE=?,DESCRIPTION=?, PRICE=? WHERE ROOM_ID=?";
    private String deleteQy = "DELETE FROM tgsdb.room WHERE ROOM_ID=?";

    public RoomDAO(Connection connection) throws SQLException {
        this.st = connection.createStatement(); 
        this.createSt = connection.prepareStatement(createQy);
        this.updateSt = connection.prepareStatement(updateQy);
        this.deleteSt = connection.prepareStatement(deleteQy);
    }
    
    public int getAvailableRoomsCountbyType(String checkIn, String checkOut, String roomType){
        List<Room> rooms = getAvailableRooms(checkIn, checkOut);
        return (int)rooms.stream().filter(room -> room.matchType(roomType)).count();
    }
    public List<Room> getAvailableRoomsbyType(String checkIn, String checkOut, String roomType){
        System.out.println("com.model.dao.RoomDAO.getAvailableRoomsbyType()" );
        System.out.println("checkIn:"+ checkIn);
        System.out.println("checkOut:"+ checkOut);
        System.out.println("roomType:"+ roomType);
        List<Room> rooms = getAvailableRooms(checkIn, checkOut);
        List<Room> temp = rooms.stream().filter(room -> room.matchType(roomType)).collect(Collectors.toList());
        temp.forEach(r -> System.out.println(r));
        return temp;
    }
    
    public List<Room> getAvailableRooms(String checkIn, String checkOut){
       List<Room> rooms = new ArrayList<>();
        String query = "SELECT * FROM tgsdb.room\n" +
                        "WHERE room_ID NOT IN(\n" +
                        "SELECT room_ID FROM tgsdb.booking, tgsdb.booked_rooms\n" +
                        "WHERE\n" +
                        " tgsdb.booking.booking_ID = tgsdb.booked_rooms.booking_ID\n" +
                        "AND\n" +
                        "(tgsdb.booking.check_in between '"+checkIn+"' and '"+checkOut+"' \n" +
                        "OR tgsdb.booking.check_out between '"+checkIn+"' and '"+checkOut+"' ))";
        
        try {
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                int roomID = Integer.parseInt(rs.getString(1));
                String roomNo = rs.getString(2);
                String roomType = rs.getString(3);
                String roomImageUrl = rs.getString(4);
                String roomDesc = rs.getString(5); 
                int roomPrice = Integer.parseInt(rs.getString(6));
                rooms.add(new Room(roomID, roomNo, roomType, roomImageUrl, roomDesc, roomPrice));
            }
        } catch (SQLException ex) {
            Logger.getLogger(RoomDAO.class.getName()).log(Level.SEVERE, null, ex);
            return rooms;
        } 
        System.out.println("com.model.dao.RoomDAO.getAvailableRooms()");
        rooms.forEach(r -> System.out.println(r));
        return rooms;  
    }
    
   public List<Room> getBookedRooms(String checkIn, String checkOut)
   {
        List<Room> rooms = new ArrayList<>();
        String query = "SELECT * FROM tgsdb.room" +
                        "WHERE room_ID "
                        + "IN"
                        + "(SELECT room_ID FROM tgsdb.booking, tgsdb.booked_rooms" +
                        "WHERE" +
                        " tgsdb.booking.booking_ID = tgsdb.booked_rooms.booking_ID" +
                        "AND" +
                        "(tgsdb.booking.check_in between '"+checkIn+"' and '"+checkOut+"' " +
                        "OR tgsdb.booking.check_out between '"+checkIn+"' and '"+checkOut+"' ))";
        
        try {
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                int roomID = Integer.parseInt(rs.getString(1));
                String roomNo = rs.getString(2);
                String roomType = rs.getString(3);
                String roomImageUrl = rs.getString(4);
                String roomDesc = rs.getString(5); 
                int roomPrice = Integer.parseInt(rs.getString(6));
                rooms.add(new Room(roomID, roomNo, roomType, roomImageUrl, roomDesc, roomPrice));
            }
        } catch (SQLException ex) {
            Logger.getLogger(RoomDAO.class.getName()).log(Level.SEVERE, null, ex);
            return rooms;
        }        
        return rooms;       
   }
   
   public List<Room> getallRooms(){
       List<Room> rooms = new ArrayList<>();
       String query = "SELECT * FROM tgsdb.room";        
        try {
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                int roomID = Integer.parseInt(rs.getString(1));
                String roomNo = rs.getString(2);
                String roomType = rs.getString(3);
                String roomImageUrl = rs.getString(4);
                String roomDesc = rs.getString(5); 
                int roomPrice = Integer.parseInt(rs.getString(6));
                rooms.add(new Room(roomID, roomNo, roomType, roomImageUrl, roomDesc, roomPrice));
            }
        } catch (SQLException ex) {
            Logger.getLogger(RoomDAO.class.getName()).log(Level.SEVERE, null, ex);
            return rooms;
        }        
        return rooms; 
   }
   
   
   
   public void addRoom(String roomNo, String roomType, String roomImageUrl, String roomDesc, int roomPrice){
        try {
            createSt.setString(1, roomNo);
            createSt.setString(2, roomType);
            createSt.setString(3, roomImageUrl);
            createSt.setString(4, roomDesc);
            createSt.setString(5, ""+roomPrice);
            createSt.executeUpdate();             
        } catch (SQLException ex) {
            Logger.getLogger(RoomDAO.class.getName()).log(Level.SEVERE, null, ex);
        }        
   }

   public void updateRoom(String roomNo, String roomType, String roomImageUrl, String roomDesc, int roomPrice){
        try {
            updateSt.setString(1, roomNo);
            updateSt.setString(2, roomType);
            updateSt.setString(3, roomImageUrl);
            updateSt.setString(4, roomDesc);
            updateSt.setString(5, ""+roomPrice);
            int row = updateSt.executeUpdate();
            System.out.println("Row "+row+" has been successflly updated");           
        } catch (SQLException ex) {
            Logger.getLogger(RoomDAO.class.getName()).log(Level.SEVERE, null, ex);
        }        
   }
   
   public void delete(int roomID) {
        try {
            st.execute("SET FOREIGN_KEY_CHECKS=0");
            deleteSt.setString(1, ""+roomID);
            int row = deleteSt.executeUpdate();
            System.out.println("Row "+row+" has been successflly deleted");
            st.execute("SET FOREIGN_KEY_CHECKS=1");
        } catch (SQLException ex) {
            Logger.getLogger(RoomDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   
}
