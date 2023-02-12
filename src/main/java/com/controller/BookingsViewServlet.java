/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.model.Booking;
import com.model.Bookings;
import com.model.dao.BookingsDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * This Servlet is called from bookings.xsl to retrieve the 
 * booking entry based the booking id passed as a parameter
 * -Redirects to 
 * "showBookings.jsp" on failure
 * "bookingDetails.jsp" on success
 * 
 * @author Shilpa
 */
public class BookingsViewServlet extends HttpServlet {

    
//    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        response.setContentType("text/html;charset=UTF-8");
//        HttpSession session = request.getSession();
//        Bookings bookings = (Bookings) session.getAttribute("bookings");
//        try ( PrintWriter out = response.getWriter()) {
//            out.println("<link rel=\"stylesheet\" href=\"css/w3.css\">");
//            out.println("<table class='w3-table-all w3-hoverable'>");
//            out.println("<thead>");
//            out.println("<tr class='w3-light-grey'>");
//            out.println("<th>Booking ID</th>");
//            out.println("<th>Customer ID</th>");
//            out.println("<th>Check In</th>");
//            out.println("<th>Check Out</th>");
//            out.println("<th>Total Rooms</th>");
//            out.println("<th>Total Price</th>");
//            out.println("</tr>");
//            out.println("</thead>");
//            for (Booking booking : bookings.getBookings()){
//                out.println("<tr>");
//                out.println("<td> <a href='#'>"+booking.getBookingID()+"</a></td>");                
//                out.println("<td>"+booking.getCustomerID()+"</a></td>");
//                out.println("<td>"+booking.getCheckIn()+"</td>");
//                out.println("<td>"+booking.getCheckOut()+"</td>");
//                out.println("<td>"+booking.getRooms().size()+"</td>");
//                out.println("<td>"+booking.getTotalPrice()+"</td>");                
//                out.println("</tr>");
//            }
//            out.println("</table>"); 
//        }
//    }
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     *
     * This get method is called by bookings list page.
     * This take the input of Booking Id and derives the detail of the 
     * Booking from DAO. 
     * Then this calls to show the booking details page
     * 
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
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
            request.getRequestDispatcher("bookingDetails.jsp").include(request, response);
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
        System.out.println("com.controller.BookingsViewServlet.doGet()");
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
        System.out.println("com.controller.BookingsViewServlet.doPost()");
        //processRequest(request, response);
    }

    

}
