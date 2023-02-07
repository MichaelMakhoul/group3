/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.model.Bookings;
import com.model.User;
import com.model.dao.BookingsDAO;
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
public class ShowBookingsServlet extends HttpServlet {

    
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
        System.out.println("com.controller.ShowBookingsServlet.doGet()");
        HttpSession session = request.getSession();
        session.removeAttribute("bookings");
        User user = (User) session.getAttribute("user");
        
        BookingsDAO bookingsDAO = (BookingsDAO) session.getAttribute("bookingsDAO");
        Bookings bookings = new Bookings();
        if(user.getType().equals("customer")){            
            bookings.setBookings(bookingsDAO.getBookingsbyCustomer(user.getID()));
        }else{
            bookings.setBookings(bookingsDAO.getCurrentBookings());
        }
        session.setAttribute("bookings", bookings);
        session.setAttribute("bookingsView","true");
        request.getRequestDispatcher("showBookings.jsp").forward(request, response);
        
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
        System.out.println("com.controller.ShowBookingsServlet.doPost()");
        //processRequest(request, response);
    }

}
