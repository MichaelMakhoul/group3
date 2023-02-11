
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
 *
 * @author 236361
 */
@Path("bookingapi")
public class BookingService {
    
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
    
    @GET
    @Path("/delete/{bookingID}") //http://localhost:8080/group3/rest/bookingapi/delete/{ID}
    @Produces(MediaType.TEXT_PLAIN)
    public String deleteBooking(@PathParam("bookingID") int ID)
            throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException, IOException{
                
        BookingsDAO bookingsDAO = new BookingsDAO(new SqlDBConnector().connection());
        bookingsDAO.deleteBooking(ID);
        return "<success> Booking_"+ID+" deleted successfully</success>";
    }
    
    @GET
    @Path("/deletebyCustomer/{customerID}") //http://localhost:8080/group3/rest/bookingapi/deletebyCustomer/{ID}
    @Produces(MediaType.TEXT_PLAIN)
    public String deleteBookingbyCustomer(@PathParam("customerID") int ID)
            throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException, IOException{
                
        BookingsDAO bookingsDAO = new BookingsDAO(new SqlDBConnector().connection());
        bookingsDAO.deleteBookingbyCustomerID(ID);
        return "<success> Bookings of Customer_"+ID+" deleted successfully</success>";
        }
    
    @GET
    @Path("/booking/{bookingID}") //http://localhost:8080/group3/rest/bookingapi/booking/{bookingID}
    @Produces(MediaType.APPLICATION_XML)
    public Booking booking(@PathParam("bookingID") int ID)
            throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException, IOException{
                
        BookingsDAO bookingsDAO = new BookingsDAO(new SqlDBConnector().connection());
        
        return bookingsDAO.booking(ID);
    }
    
}
