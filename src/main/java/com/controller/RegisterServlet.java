/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.model.User;
import com.model.dao.UserDAO;
import com.utils.Utils;
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

        session.setAttribute("emailError", email.matches(Utils.emailRegEx) ? "" : "Incorrect email format");
        session.setAttribute("passError", password.matches(Utils.passRegEx) ? "" : "Incorrect password format");
        session.setAttribute("dobError", dob.matches(Utils.dobRegEx) ? "" : "Incorrect DOB format");
        session.setAttribute("phoneError", phoneNumber.matches(Utils.phoneRegEx) ? "" : "Incorrect phone number format");

        boolean validRegex = (password.matches(Utils.passRegEx) && dob.matches(Utils.dobRegEx) && phoneNumber.matches(Utils.phoneRegEx) && email.matches(Utils.emailRegEx));

//        boolean nextPage = false;
        String error = "";
        //boolean user = false;        

//        if (!email.matches(emailRegEx) || !password.matches(passRegEx)) {
          if (validRegex) {
            try {
                UserDAO userDAO = (UserDAO) session.getAttribute("userDAO");
                User user = userDAO.getUser(email, registerOptions);
                if (user != null) {
                    error = "User already exists";
                    session.setAttribute("error", error);
                    request.getRequestDispatcher("register.jsp").include(request, response);
                } else {
                    userDAO.create(name, email, password, dob, phoneNumber, registerOptions);
                    user = userDAO.getUser(email, registerOptions);
                    user.setType(registerOptions);
                    session.setAttribute("user", user);
                    request.getRequestDispatcher("main.jsp").include(request, response);
                }
            } catch (SQLException ex) {
                Logger.getLogger(RegisterServlet.class.getName()).log(Level.SEVERE, null, ex);

            }
        } //        else if (registerOptions.equals("staff")) {
        //            try {
        //                StaffDAO staffDAO = (StaffDAO) session.getAttribute("staffDAO");
        //                Staff staff = staffDAO.getStaff(email);
        //                if (staff != null) {
        //                    error = "User already exist";
        //                    session.setAttribute("error", error);
        //                    request.getRequestDispatcher("register.jsp").include(request, response);
        //                } else {
        //                    staffDAO.create(name, email, password, dob, phoneNumber);
        //                    staff = staffDAO.getStaff(email);
        //                    session.setAttribute("userType", "staff");
        //                    session.setAttribute("user", staff);
        //                    request.getRequestDispatcher("main.jsp").include(request, response);
        //                }
        //            } catch (SQLException ex) {
        //                Logger.getLogger(RegisterServlet.class.getName()).log(Level.SEVERE, null, ex);
        //            }
        //        } 
        else {
            session.setAttribute("error", error);
            request.getRequestDispatcher("register.jsp").include(request, response);
        }
    }
}
