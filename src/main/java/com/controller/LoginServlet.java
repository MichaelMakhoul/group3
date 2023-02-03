/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.model.Manager;
import com.model.User;
import com.model.dao.ManagerDAO;
import com.model.dao.UserDAO;
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
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();

        String loginOptions = request.getParameter("loginOptions");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

//        CustomerDAO customerDAO = (CustomerDAO) session.getAttribute("customerDAO");
//        StaffDAO staffDAO = (StaffDAO) session.getAttribute("staffDAO");
        UserDAO userDAO = (UserDAO) session.getAttribute("userDAO");
        ManagerDAO managerDAO = (ManagerDAO) session.getAttribute("managerDAO");

        boolean userExists = false;
        if (loginOptions.equals("customer") || loginOptions.equals("staff")) {
            User user = null;
            try {
                user = userDAO.login(email, password, loginOptions);
            } catch (SQLException ex) {
                Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
            }

            if (user != null) {
                user.setType(loginOptions);
                session.setAttribute("user", user);
                request.getRequestDispatcher("main.jsp").include(request, response);
                userExists = true;
            }
        } else if (loginOptions.equals("manager")) {
            Manager manager = null;
            try {
                manager = managerDAO.login(email, password);
            } catch (SQLException ex) {
                Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
            }

            if (manager != null) {
                session.setAttribute("userType", "manager");
                session.setAttribute("user", manager);
                request.getRequestDispatcher("main.jsp").include(request, response);
                userExists = true;
            }
        }

        if (!userExists) {
            session.setAttribute("usernotexist", "User does not exist!");
            request.getRequestDispatcher("login.jsp").include(request, response);
        }
    }
}
