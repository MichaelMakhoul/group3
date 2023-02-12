
package com.rest;

import com.model.Booking;
import com.model.Bookings;
import com.model.dao.BookingsDAO;
import com.model.dao.SqlDBConnector;
import java.io.IOException;
import java.sql.SQLException;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Web Service Module: Booking Management
 * This rest web service gives the output for Booking Feature 
 * 
 * 
 * @author Shilpa
 */
@Path("bookingapi")
public class BookingService {   
    
    /**
     * Shows all the current bookings 
     * 
     * @return
     * @throws ClassNotFoundException
     * @throws SQLException
     * @throws InstantiationException
     * @throws IllegalAccessException
     * @throws IOException 
     */    
    @GET
    @Path("/current") //http://localhost:8080/group3/rest/bookingapi/current
    @Produces(MediaType.APPLICATION_XML)
    public Bookings currentBookings()
            throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException, IOException{
        Bookings bookings = new Bookings();
        BookingsDAO bookingsDAO = new BookingsDAO(new SqlDBConnector().connection());
        bookings.setBookings(bookingsDAO.getCurrentBookings());
        return bookings;
    }
    
    /**
     * Adds a booking 
     * 
     * 
     * @param ID
     * @param checkIn
     * @param checkOut
     * @param dr - No. of Deluxe rooms
     * @param fr - No. of Family Rooms
     * @param es - No. of Executive Suites
     * @return
     * @throws ClassNotFoundException
     * @throws SQLException
     * @throws InstantiationException
     * @throws IllegalAccessException
     * @throws IOException 
     */
    @GET
    @Path("/add/{customerID}/{checkIn}/{checkOut}/{DR}-{FR}-{ES}") //http://localhost:8080/group3/rest/bookingapi/add/{customerID}/{checkIn}/{checkOut}/{DR}-{FR}-{ES}
    @Produces(MediaType.APPLICATION_XML)
    public Response addBooking(@PathParam("customerID") int ID,@PathParam("checkIn") String checkIn, @PathParam("checkOut") String checkOut,
            @PathParam("DR") int dr, @PathParam("FR") int fr,@PathParam("ES") int es)
            throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException, IOException{
        int []noOfRooms = new int[3];
        
        BookingsDAO bookingsDAO = new BookingsDAO(new SqlDBConnector().connection());
        noOfRooms[0]=dr;
        noOfRooms[1]=fr;
        noOfRooms[2]=es;
        int bookingID = bookingsDAO.addBooking(ID, checkIn, checkOut, null,noOfRooms);        
        
        return Response.status(200).entity(bookingsDAO.booking(bookingID)).build();
    }
    
    
    /**
     * Shows all the booking of a customer by Customer ID 
     * 
     * @return
     * @throws ClassNotFoundException
     * @throws SQLException
     * @throws InstantiationException
     * @throws IllegalAccessException
     * @throws IOException 
     */
    @GET
    @Path("/customer/{ID}") //http://localhost:8080/group3/rest/bookingapi/customer/{ID}
    @Produces(MediaType.APPLICATION_XML)
    public Bookings customerBookings(@PathParam("ID") int ID)
            throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException, IOException{
        Bookings bookings = new Bookings();
        BookingsDAO bookingsDAO = new BookingsDAO(new SqlDBConnector().connection());
        bookings.setBookings(bookingsDAO.getBookingsbyCustomer(ID));
        return bookings;
    }
    
    /**     
     * Shows all bookings Old and New
     * 
     * @return
     * @throws ClassNotFoundException
     * @throws SQLException
     * @throws InstantiationException
     * @throws IllegalAccessException
     * @throws IOException 
     */
    
    @GET
    @Path("/bookings") //http://localhost:8080/group3/rest/bookingapi/bookings
    @Produces(MediaType.APPLICATION_XML)
    public Bookings bookings()
            throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException, IOException{
        Bookings bookings = new Bookings();        
        BookingsDAO bookingsDAO = new BookingsDAO(new SqlDBConnector().connection());
        bookings.setBookings(bookingsDAO.getBookings());
        return bookings;
    }
    
    /**
     * Deletes the booking by booking id
     * 
     * @param ID
     * @return
     * @throws ClassNotFoundException
     * @throws SQLException
     * @throws InstantiationException
     * @throws IllegalAccessException
     * @throws IOException 
     */
    
    @GET
    @Path("/delete/{bookingID}") //http://localhost:8080/group3/rest/bookingapi/delete/{ID}
    @Produces(MediaType.TEXT_PLAIN)
    public String deleteBooking(@PathParam("bookingID") int ID)
            throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException, IOException{
                
        BookingsDAO bookingsDAO = new BookingsDAO(new SqlDBConnector().connection());
        bookingsDAO.deleteBooking(ID);
        return "<success> Booking_"+ID+" deleted successfully</success>";
    }
    
    /**
     * Deletes all the bookings for the customer
     * 
     * @param ID
     * @return
     * @throws ClassNotFoundException
     * @throws SQLException
     * @throws InstantiationException
     * @throws IllegalAccessException
     * @throws IOException 
     */
    
    @GET
    @Path("/deletebyCustomer/{customerID}") //http://localhost:8080/group3/rest/bookingapi/deletebyCustomer/{ID}
    @Produces(MediaType.TEXT_PLAIN)
    public String deleteBookingbyCustomer(@PathParam("customerID") int ID)
            throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException, IOException{
                
        BookingsDAO bookingsDAO = new BookingsDAO(new SqlDBConnector().connection());
        bookingsDAO.deleteBookingbyCustomerID(ID);
        return "<success> Bookings of Customer_"+ID+" deleted successfully</success>";
        }
    
    /**
     * Gets a booking with booking ID
     * 
     * @param ID
     * @return
     * @throws ClassNotFoundException
     * @throws SQLException
     * @throws InstantiationException
     * @throws IllegalAccessException
     * @throws IOException 
     */
    @GET
    @Path("/booking/{bookingID}") //http://localhost:8080/group3/rest/bookingapi/booking/{bookingID}
    @Produces(MediaType.APPLICATION_XML)
    public Booking booking(@PathParam("bookingID") int ID)
            throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException, IOException{
                
        BookingsDAO bookingsDAO = new BookingsDAO(new SqlDBConnector().connection());
        
        return bookingsDAO.booking(ID);
    }
    
}
