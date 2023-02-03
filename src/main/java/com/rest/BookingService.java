
package com.rest;

import com.model.Bookings;
import com.model.dao.BookingsDAO;
import com.model.dao.SqlDBConnector;
import java.io.IOException;
import java.sql.SQLException;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

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
    
}
