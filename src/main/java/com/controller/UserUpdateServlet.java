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
 * @author 236351
 */
public class UserUpdateServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();

//        int ID = Integer.parseInt(request.getParameter("ID"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String dob = request.getParameter("dob");
        String phoneNumber = request.getParameter("phoneNumber");

        session.setAttribute("passError", password.matches(Utils.passRegEx) ? "" : "Incorrect password format");
        session.setAttribute("dobError", dob.matches(Utils.dobRegEx) ? "" : "Incorrect DOB format");
//        session.setAttribute("phoneError", phoneNumber.matches(Utils.phoneRegEx) ? "" : "Incorrect phone number format");

        boolean validRegex = (password.matches(Utils.passRegEx) && dob.matches(Utils.dobRegEx));
        
        User user = (User) session.getAttribute("user");

        String userType = user.getType();
        
        UserDAO userDAO = (UserDAO) session.getAttribute("userDAO");

        if (validRegex) {
            try {
//                User customer = userDAO.getUser(email, userType);

                int ID = user.getID();
                
                userDAO.update(userType, name, password, dob, phoneNumber, ID);
                user = userDAO.getUser(ID, userType);
                session.setAttribute("user", user);
                
                session.setAttribute("message", "User was updated successfully");
                request.getRequestDispatcher("account.jsp").include(request, response);

            } catch (SQLException ex) {
                Logger.getLogger(CreateAccountServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            request.getRequestDispatcher("account.jsp").include(request, response);
        }

    }
}
