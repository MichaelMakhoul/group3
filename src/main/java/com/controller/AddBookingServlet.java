
package com.controller;

import com.model.dao.BookingsDAO;
import com.utils.Utils;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author 236361
 */
public class AddBookingServlet extends HttpServlet {

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
        HttpSession session = request.getSession();
        String checkIn = request.getParameter("checkIn");
        String checkOut = request.getParameter("checkOut");
        session.setAttribute("checkInD", checkIn);
        session.setAttribute("checkOutD", checkOut);
        if(checkIn == null || checkOut == null || 
                Utils.validateDate(checkIn) == null ||
                Utils.validateDate(checkOut) == null){
            session.setAttribute("dateErr", "Date entries are invalid. Please re-enter.");
        }else if(Utils.startDtbefendDt(checkIn, checkOut)){
            BookingsDAO bookingsDAO = (BookingsDAO) session.getAttribute("bookingsDAO");
            session.setAttribute("available", true);       

            Integer drQty = bookingsDAO.getAvailableRoomsCountbyType(checkIn, checkOut, "DELUXE_ROOM");
            Integer frQty = bookingsDAO.getAvailableRoomsCountbyType(checkIn, checkOut, "FAMILY_ROOM");
            Integer esQty = bookingsDAO.getAvailableRoomsCountbyType(checkIn, checkOut, "EXECUTIVE_SUITE");
            if(drQty ==0 && frQty == 0 && esQty == 0 ){ 
                session.setAttribute("roomsFull", "All the rooms are booked. Please choose other dates"); 
            } 
            session.setAttribute("drQty", drQty);
            session.setAttribute("frQty", frQty);
            session.setAttribute("esQty", esQty);
            
        }else{
            session.setAttribute("dateErr", "Checkin date cannot be later than CheckOut. Please re-enter.");
        }
        
        request.getRequestDispatcher("addBooking.jsp").forward(request, response);
    } 
}
