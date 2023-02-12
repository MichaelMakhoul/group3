
package com.rest;

import com.model.Rooms;
import com.model.dao.RoomDAO;
import com.model.dao.SqlDBConnector;
import java.io.IOException;
import java.sql.SQLException;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Web Service for Room Bean accessed from Room Database table 
 * 
 * @author Shilpa
 */
@Path("roomapi")
public class RoomsService {
    
    @GET
    @Path("rooms") //http://localhost:8080/group3/rest/roomapi/rooms
    @Produces(MediaType.APPLICATION_XML)
    public Rooms rooms() 
            throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException, IOException {
        RoomDAO roomDAO = new RoomDAO(new SqlDBConnector().connection());
        Rooms rooms = new Rooms();
        rooms.setRooms(roomDAO.getallRooms());        
        return rooms;
    }
    
    @GET
    @Path("availRoomstype/{checkIn}/{checkOut}/{roomType}") //http://localhost:8080/group3/rest/roomapi/availRoomstype/2023-03-09/2023-03-12/DELUXE_ROOM
    @Produces(MediaType.APPLICATION_XML)
    public Rooms availRoomstype(@PathParam("checkIn") String checkIn, @PathParam("checkOut") String checkOut, @PathParam("roomType") String roomType)
            throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException, IOException {
        RoomDAO roomDAO = new RoomDAO(new SqlDBConnector().connection());
        Rooms rooms = new Rooms();
        rooms.setRooms(roomDAO.getAvailableRoomsbyType(checkIn, checkOut, roomType));        
        return rooms;
    }
    
    @GET
    @Path("availRoomstypeCount/{checkIn}/{checkOut}/{roomType}") //http://localhost:8080/group3/rest/roomapi/availRoomstypeCount/2023-03-09/2023-03-12/DELUXE_ROOM
    @Produces(MediaType.TEXT_PLAIN)
    public String availRoomstypeCount(@PathParam("checkIn") String checkIn, @PathParam("checkOut") String checkOut, @PathParam("roomType") String roomType)
            throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException, IOException {
        RoomDAO roomDAO = new RoomDAO(new SqlDBConnector().connection());       
                
        return roomType+" available :"+roomDAO.getAvailableRoomsCountbyType(checkIn, checkOut, roomType);
    }
    
    @GET
    @Path("availRooms/{checkIn}/{checkOut}") //http://localhost:8080/group3/rest/roomapi/availRooms/2023-03-09/2023-03-12
    @Produces(MediaType.APPLICATION_XML)
    public Rooms availRooms(@PathParam("checkIn") String checkIn, @PathParam("checkOut") String checkOut)
            throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException, IOException {
        RoomDAO roomDAO = new RoomDAO(new SqlDBConnector().connection());
        Rooms rooms = new Rooms();
        rooms.setRooms(roomDAO.getAvailableRooms(checkIn, checkOut));        
        return rooms;
    }

}
