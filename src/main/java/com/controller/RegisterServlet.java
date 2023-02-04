/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.model.Customer;
import com.model.Staff;
import com.model.dao.CustomerDAO;
import com.model.dao.StaffDAO;
import java.io.IOException;
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
public class RegisterServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();

        String registerOptions = request.getParameter("registerOptions");
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String dob = request.getParameter("dob");
        String phoneNumber = request.getParameter("phoneNumber");
        
        session.setAttribute("nameError", name.matches(Utils.nameRegEx) ? "" : "Incorrect name format");
        session.setAttribute("emailError", email.matches(Utils.emailRegEx) ? "" : "Incorrect email format");
        session.setAttribute("passError", password.matches(Utils.passRegEx) ? "" : "Incorrect password format");
        session.setAttribute("dobError", dob.matches(Utils.dobRegEx) ? "" : "Incorrect DOB format");
        session.setAttribute("phoneError", phoneNumber.matches(Utils.phoneRegEx) ? "" : "Incorrect phone number format");

        boolean validRegex = (name.matches(Utils.nameRegEx) && email.matches(Utils.emailRegEx) && password.matches(Utils.passRegEx) && dob.matches(Utils.dobRegEx) && phoneNumber.matches(Utils.phoneRegEx));

        String error = "";        

          if (validRegex) {
            try {
                CustomerDAO customerDAO = (CustomerDAO) session.getAttribute("customerDAO");
                Customer customer = customerDAO.getCustomer(email);
                if (customer != null) {
                    error = "User already exists";
                    session.setAttribute("error", error);
                    request.getRequestDispatcher("register.jsp").include(request, response);
                } else {
                    customerDAO.create(name, email, password, dob, phoneNumber);
                    customer = customerDAO.getCustomer(email);
                    session.setAttribute("userType", "customer");
                    session.setAttribute("user", customer);
                    request.getRequestDispatcher("main.jsp").include(request, response);
                }
            } catch (SQLException ex) {
                Logger.getLogger(RegisterServlet.class.getName()).log(Level.SEVERE, null, ex);

            }
        }else {
            session.setAttribute("error", error);
            request.getRequestDispatcher("register.jsp").include(request, response);
        }
    }
}
