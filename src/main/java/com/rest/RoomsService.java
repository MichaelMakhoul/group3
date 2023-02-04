
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
 *
 * @author 236361
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
    @Path("availRoomstype/{checkIn}/{checkOut}/{roomType}") //http://localhost:8080/group3/rest/api/customers
    @Produces(MediaType.APPLICATION_XML)
    public Rooms availRoomstype(@PathParam("checkIn") String checkIn, @PathParam("checkOut") String checkOut, @PathParam("roomType") String roomType)
            throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException, IOException {
        RoomDAO roomDAO = new RoomDAO(new SqlDBConnector().connection());
        Rooms rooms = new Rooms();
        rooms.setRooms(roomDAO.getAvailableRoomsbyType(checkIn, checkOut, roomType));        
        return rooms;
    }
    
    @GET
    @Path("availRoomstypeCount/{checkIn}/{checkOut}/{roomType}") //http://localhost:8080/group3/rest/api/customers
    @Produces(MediaType.TEXT_PLAIN)
    public String availRoomstypeCount(@PathParam("checkIn") String checkIn, @PathParam("checkOut") String checkOut, @PathParam("roomType") String roomType)
            throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException, IOException {
        RoomDAO roomDAO = new RoomDAO(new SqlDBConnector().connection());       
                
        return roomType+" available :"+roomDAO.getAvailableRoomsCountbyType(checkIn, checkOut, roomType);
    }
    
    @GET
    @Path("availrooms") //http://localhost:8080/group3/rest/api/customers
    @Produces(MediaType.APPLICATION_XML)
    public Rooms availRooms()
            throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException, IOException {
        RoomDAO roomDAO = new RoomDAO(new SqlDBConnector().connection());
        Rooms rooms = new Rooms();
        rooms.setRooms(roomDAO.getAvailableRooms(null, null));        
        return rooms;
    }

}
