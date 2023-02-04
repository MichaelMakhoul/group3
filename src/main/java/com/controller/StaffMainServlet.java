///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.controller;
//
//import com.model.Customers;
//import com.model.Users;
//import com.model.dao.UserDAO;
//import java.io.IOException;
//import java.sql.SQLException;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
///**
// *
// * @author 236351
// */
//public class StaffMainServlet extends HttpServlet {
//
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        HttpSession session = request.getSession();
//        
////        StaffDAO staffDAO = (StaffDAO) session.getAttribute("staffDAO");
//        UserDAO userDAO = (UserDAO) session.getAttribute("userDAO");
//        try {
//            Users customers = new Users();
//            customers.addAll(userDAO.getUsers("customer"));
//            session.setAttribute("users", customers);
//            request.getRequestDispatcher("customers.jsp").include(request, response);
//        } catch (SQLException ex) {
//            Logger.getLogger(StaffMainServlet.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        
//    }
//}
