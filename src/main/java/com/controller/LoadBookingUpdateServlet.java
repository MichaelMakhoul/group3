/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.model.Booking;
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
public class LoadBookingUpdateServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Booking booking = (Booking)session.getAttribute("booking");
        BookingsDAO bookingsDAO = (BookingsDAO) session.getAttribute("bookingsDAO");
        String checkIn = request.getParameter("checkIn");
        String checkOut = request.getParameter("checkOut");
        int drNo, frNo, esNo;
        boolean isdateChanged = false;
        
        
        if(checkIn == null || checkOut == null){
            checkIn = booking.getCheckIn();
            checkOut = booking.getCheckOut();
            drNo = bookingsDAO.getRoomCountbyType(booking.getRooms(), "DELUXE_ROOM");
            frNo = bookingsDAO.getRoomCountbyType(booking.getRooms(), "FAMILY_ROOM");
            esNo = bookingsDAO.getRoomCountbyType(booking.getRooms(), "EXECUTIVE_SUITE");
            session.setAttribute("change","true");
        }else{
            drNo = Integer.parseInt(request.getParameter("drQuantity"));
            frNo = Integer.parseInt(request.getParameter("frQuantity"));
            esNo = Integer.parseInt(request.getParameter("esQuantity"));
            if(checkIn.equals(booking.getCheckIn()) || checkOut.equals(booking.getCheckOut())
               || (Utils.startDtbefendDt(checkIn, booking.getCheckOut()) && Utils.startDtbefendDt(booking.getCheckIn(), checkIn)) 
               || (Utils.startDtbefendDt(checkOut, booking.getCheckOut()) && Utils.startDtbefendDt(booking.getCheckIn(), checkOut)) ){
                isdateChanged = false;
            }else{
                isdateChanged = true;
            }
        }
        session.setAttribute("drRooms", drNo);
        session.setAttribute("frRooms", frNo);
        session.setAttribute("esRooms", esNo);
        
        session.setAttribute("checkInD", checkIn);
        session.setAttribute("checkOutD", checkOut);
        if(Utils.startDtbefendDt(checkIn, checkOut)){    

            int drQty = bookingsDAO.getAvailableRoomsCountbyType(checkIn, checkOut, "DELUXE_ROOM");
            int frQty = bookingsDAO.getAvailableRoomsCountbyType(checkIn, checkOut, "FAMILY_ROOM");
            int esQty = bookingsDAO.getAvailableRoomsCountbyType(checkIn, checkOut, "EXECUTIVE_SUITE");
            int drAvail, frAvail, esAvail;
            String change = (String) session.getAttribute("change");
            if(!isdateChanged && change != null){ 
                session.removeAttribute("change");
                drQty = drQty + bookingsDAO.getRoomCountbyType(booking.getRooms(), "DELUXE_ROOM");
                frQty = frQty + bookingsDAO.getRoomCountbyType(booking.getRooms(), "FAMILY_ROOM");
                esQty = esQty + bookingsDAO.getRoomCountbyType(booking.getRooms(), "EXECUTIVE_SUITE");                
            }
            drAvail = drQty - drNo;
            frAvail = frQty - frNo;
            esAvail = esQty - esNo;
            
            if(drAvail <0 || frAvail < 0 || esAvail < 0 ){ 
                session.setAttribute("roomsFull", "Adequate rooms aren't available. Please choose other dates "
                        + "or reduce the rooms"); 
            } 
            
            session.setAttribute("drQty", drQty);
            session.setAttribute("frQty", frQty);
            session.setAttribute("esQty", esQty);
            //rooms available to book
            session.setAttribute("drAvail", drAvail);
            session.setAttribute("frAvail", frAvail);
            session.setAttribute("esAvail", esAvail);
            
        }else{
            session.setAttribute("dateErr", "Date entries are invalid. Please re-enter.");
        }
        // get booking details
        session.setAttribute("bookingId", booking.getBookingID());
        
        session.setAttribute("comments", booking.getBookingDesc());
        request.getRequestDispatcher("updateBooking.jsp").forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
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
        processRequest(request, response);
    }

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
        processRequest(request, response);
    }

   
}
