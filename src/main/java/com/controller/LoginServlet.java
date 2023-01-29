/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.model.Customer;
import com.model.Manager;
import com.model.Staff;
import com.model.dao.CustomerDAO;
import com.model.dao.ManagerDAO;
import com.model.dao.StaffDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author 236336
 */
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        
        String loginOptions = request.getParameter("loginOptions");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        
//        String loginOptions = "customer";
//        String email = "jamess@gmail.com";
//        String password = "Helloworld123";

        CustomerDAO customerDAO = (CustomerDAO) session.getAttribute("customerDAO");
        StaffDAO staffDAO = (StaffDAO) session.getAttribute("staffDAO");
        ManagerDAO managerDAO = (ManagerDAO) session.getAttribute("managerDAO");

        
        boolean user = false;

        if (loginOptions.equals("customer")) {
            Customer customer = null;
            try {
                customer = customerDAO.login(email, password);
            } catch (SQLException ex) {
                Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
            }

            if (customer != null) {
                user = true;
                session.setAttribute("userType", customer);
                request.getRequestDispatcher("customerMain.jsp").include(request, response);
            }

        } else if (loginOptions.equals("staff")) {
            Staff staff = null;
            try {
                staff = staffDAO.login(email, password);
            } catch (SQLException ex) {
                Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
            }

            if (staff != null) {
                user = true;
                session.setAttribute("userType", staff);
                session.setAttribute("staff", staff);
                request.getRequestDispatcher("staffMain.jsp").include(request, response);
            }

        } else if (loginOptions.equals("manager")) {
            Manager manager = null;
            try {
                manager = managerDAO.login(email, password);
            } catch (SQLException ex) {
                Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
            }

            if (manager != null) {
                user = true;
                session.setAttribute("userType", manager);
                request.getRequestDispatcher("managerMain.jsp").include(request, response);
            }

        } else {

        }
        if(!user){
                session.setAttribute("usernotexist", "User does not exist!");
                request.getRequestDispatcher("login.jsp").include(request, response);
        }
    }
}
