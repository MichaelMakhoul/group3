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
 *
 * @author 236361
 */

public class BookingServlet extends HttpServlet {

    /**
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
        
        if(!Utils.startDtbefendDt(checkIn, checkOut)){
            session.setAttribute("dateErr", "CheckOut should occur later than CheckIn");
            request.getRequestDispatcher("addBooking.jsp").include(request, response);
        }
        else if (drNo.isBlank() && frNo.isBlank() && esNo.isBlank()) {
            session.setAttribute("roomsErr", "Please choose a room");
            request.getRequestDispatcher("addBooking.jsp").include(request, response);
        }else {            
            Integer dr = Integer.parseInt((drNo.isBlank()) ? "0" : drNo );
            Integer fr = Integer.parseInt((frNo.isBlank()) ? "0" : frNo );
            Integer es = Integer.parseInt((esNo.isBlank()) ? "0" : esNo );
            if(dr==0 && fr==0 && es==0){
            session.setAttribute("roomsErr", "Please choose a room");
            request.getRequestDispatcher("addBooking.jsp").include(request, response);
            }else{
                String comments = request.getParameter("comments");
                int[] noOfRooms = new int[3];
                noOfRooms[0] = dr;
                noOfRooms[1] = fr;
                noOfRooms[2] = es;

                System.out.println("checkIn "+ checkIn);
                System.out.println("checkOut "+ checkOut);
                System.out.println("noOfRooms "+ Arrays.toString(noOfRooms));
                int diff = Utils.differenceInDays(checkIn, checkOut);
                int totalPrice = diff *((noOfRooms[0]* 150) + (noOfRooms[1]* 250) + (noOfRooms[2]* 500));
                Integer bookingID = bookingsDAO.addBooking(customer.getID(), checkIn, checkOut, comments, totalPrice, noOfRooms);
                Booking booking = bookingsDAO.booking(bookingID);
                session.setAttribute("booking", booking);

                session.removeAttribute("available");
                session.removeAttribute("drQty");
                session.removeAttribute("frQty");
                session.removeAttribute("esQty");
                session.removeAttribute("checkInD");
                session.removeAttribute("checkOutD");
                request.getRequestDispatcher("bookingConfirmation.jsp").forward(request, response);
            }
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
        HttpSession session = request.getSession();
        session.removeAttribute("booking");
        BookingsDAO bookingsDAO = (BookingsDAO) session.getAttribute("bookingsDAO");
        String id = (request.getParameter("ID"));
        if(id == null){
            session.setAttribute("bookingIDErr", "Unable to access booking details. Please retry!!");
            request.getRequestDispatcher("showBookings.jsp").include(request, response);
        }
        else{
            int bookingID = Integer.parseInt(id);
            Booking booking = bookingsDAO.booking(bookingID);
            session.setAttribute("booking", booking);
            request.getRequestDispatcher("bookingConfirmation.jsp").include(request, response);
        }
    }

}
