/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.model.Booking;
import com.model.User;
import com.model.dao.BookingsDAO;
import com.utils.Utils;
import java.io.IOException;
import java.io.PrintWriter;
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
public class UpdateBookingServlet extends HttpServlet {

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
        session.setAttribute("updateBooking", "true");
        int id = booking.getBookingID();
        String checkIn = (String) session.getAttribute("checkInD");
        String checkOut = (String) session.getAttribute("checkOutD");
//        
//        String drNo = request.getParameter("drQuantity");
//        String frNo = request.getParameter("frQuantity");
//        String esNo = request.getParameter("esQuantity");
        
        if(!Utils.startDtbefendDt(checkIn, checkOut)){
            session.setAttribute("dateErr", "CheckOut should occur later than CheckIn");
            request.getRequestDispatcher("LoadBookingUpdateServlet").include(request, response);
        }else {            
            Integer dr = (Integer) session.getAttribute("drRooms");
            Integer fr = (Integer) session.getAttribute("frRooms");
            Integer es = (Integer) session.getAttribute("esRooms");
            if(dr==0 && fr==0 && es==0){
            session.setAttribute("roomsErr", "Please choose a room");
            request.getRequestDispatcher("LoadBookingUpdateServlet").include(request, response);
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
                bookingsDAO.updateBooking(checkIn, checkOut,comments,totalPrice,id,noOfRooms);
                booking = bookingsDAO.booking(id);
                session.setAttribute("booking", booking);
                
                session.removeAttribute("drRooms");
                session.removeAttribute("frRooms");
                session.removeAttribute("esRooms");
                session.removeAttribute("drQty");
                session.removeAttribute("frQty");
                session.removeAttribute("esQty");
                session.removeAttribute("drAvail");
                session.removeAttribute("frAvail");
                session.removeAttribute("esAvail");
                
                session.removeAttribute("checkInD");
                session.removeAttribute("checkOutD");
                session.removeAttribute("comments");
                session.removeAttribute("bookingID");
                
                request.getRequestDispatcher("bookingConfirmation.jsp").forward(request, response);
            }
        }
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
        System.out.println("com.controller.UpdateBookingServlet.doGet()");
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
        System.out.println("com.controller.UpdateBookingServlet.doPost()");
        processRequest(request, response);
    }


}
