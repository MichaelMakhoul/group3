package com.controller;

import com.model.Booking;
import com.model.User;
import com.model.dao.BookingsDAO;
import com.utils.Utils;
import java.io.IOException;
import java.util.Arrays;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * This servlet is used by addBooking.jsp page.
 * - Posting data to the Database by adding a booking
 * - Retrieves the Booking ID for the added booking in
 *   DB and stores it in an attribute for usage
 * - Checks the validity of Booking entries - No. of Room\s 
 *   Date validated in AddBooking 
 * - Redirects to
 *  "addBooking.jsp" in case of any error
 *  "bookingDetails.jsp" for confirmation of Booking
 * 
 * @author Shilpa Guruswamy
 */

public class BookingServlet extends HttpServlet {

    /**
     * This POST request is called when a Booking is added.
     * It validates the entries and then calls the DAO to 
     * add an entry to Database.
     * It then dispatches to Booking confirmation page
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("com.controller.BookingServlet.doPost()");
        HttpSession session = request.getSession();
        String checkIn = (String) session.getAttribute("checkInD");
        String checkOut = (String) session.getAttribute("checkOutD");
        BookingsDAO bookingsDAO = (BookingsDAO) session.getAttribute("bookingsDAO");
        User customer = (User) session.getAttribute("user");
        String drNo = request.getParameter("drQuantity");
        String frNo = request.getParameter("frQuantity");
        String esNo = request.getParameter("esQuantity");
        boolean error = false;
        
        //Checks whether checkin date occurs before checkout
        if(!Utils.startDtbefendDt(checkIn, checkOut)){
            session.setAttribute("dateErr", "CheckOut should occur later than CheckIn. Please re-enter");
            error = true;            
        }else if (drNo.isBlank() && frNo.isBlank() && esNo.isBlank()) {
            // checks if atleast 1 room is chosen
            session.setAttribute("roomsErr", "Please choose a room");
            error = true;            
        }else if((!drNo.isBlank() &&!drNo.matches("([0-9]|10)")) ||
               (!frNo.isBlank() && !frNo.matches("[0-7]") )||
               (!esNo.isBlank() && !esNo.matches("[0-3]"))){
            //checks for the validity of the room entry
            session.setAttribute("roomsErr", "Room required are more than available rooms. Please re-enter.");
            error = true;            
        }else {            
            Integer dr = Integer.parseInt((drNo.isBlank()) ? "0" : drNo );
            Integer fr = Integer.parseInt((frNo.isBlank()) ? "0" : frNo );
            Integer es = Integer.parseInt((esNo.isBlank()) ? "0" : esNo );
            Integer drQty = (Integer) session.getAttribute("drQty");
            Integer frQty = (Integer) session.getAttribute("frQty");
            Integer esQty = (Integer) session.getAttribute("esQty");
            if(dr==0 && fr==0 && es==0){
                // checks if atleast 1 room is chosen
                session.setAttribute("roomsErr", "Please choose a room");                
                error = true;
            }else if(dr> drQty || fr >frQty || es>esQty){
                session.setAttribute("roomsErr", "Room entries are invalid. Please re-enter.");
                error = true;
            }else{
                String comments = request.getParameter("comments");
                int[] noOfRooms = new int[3];
                noOfRooms[0] = dr;
                noOfRooms[1] = fr;
                noOfRooms[2] = es;

                System.out.println("checkIn "+ checkIn);
                System.out.println("checkOut "+ checkOut);
                System.out.println("noOfRooms "+ Arrays.toString(noOfRooms));
                
                Integer bookingID = bookingsDAO.addBooking(customer.getID(), checkIn, checkOut, comments, noOfRooms);
                Booking booking = bookingsDAO.booking(bookingID);
                session.setAttribute("booking", booking);

                session.removeAttribute("available");
                session.removeAttribute("drQty");
                session.removeAttribute("frQty");
                session.removeAttribute("esQty");                
                
            }
        }
        if(error){
            request.getRequestDispatcher("addBooking.jsp").include(request, response);
        }else{
            request.getRequestDispatcher("bookingDetails.jsp").forward(request, response);
        }
    }
     
    /**
     * Handles the HTTP <code>GET</code> method.
     *  
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("com.controller.BookingServlet.doGet()");
        
    }

}
