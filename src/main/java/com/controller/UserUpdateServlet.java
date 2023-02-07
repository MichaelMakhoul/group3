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
        UserDAO userDAO = (UserDAO) session.getAttribute("userDAO");
        String submitted = request.getParameter("submitted");
        User user = (User) session.getAttribute("user");
        String userType = user.getType();

        int ID = user.getID();
        String name = request.getParameter("name");
        String staffEmail = request.getParameter("email");
        String password = request.getParameter("password");
        String dob = request.getParameter("dob");
        String phoneNumber = request.getParameter("phoneNumber");

        session.setAttribute("nameError", name.matches(Utils.nameRegEx) ? "" : "Incorrect format enter \"[First] [Middle] [Last]\"");
        session.setAttribute("passError", password.matches(Utils.passRegEx) ? "" : "Incorrect format enter \"[Example123]\"");
        session.setAttribute("dobError", dob.matches(Utils.dobRegEx) && Utils.isOlderThen18(dob) ? "" : "Incorrect format enter \"[dd] [mm] [yyyy] or age <18\"");
        session.setAttribute("phoneError", phoneNumber.matches(Utils.phoneRegEx) ? "" : "Incorrect format enter \"[+Contry Code] [Number]\"");

        boolean validRegex = (name.matches(Utils.nameRegEx) &&  
                            password.matches(Utils.passRegEx) && 
                            Utils.isOlderThen18(dob) && 
                            phoneNumber.matches(Utils.phoneRegEx));       
        

        if (validRegex) {
            try {                
                userDAO.update(userType, name, password, dob, phoneNumber, ID);
                user = userDAO.getUser(ID, userType);
                session.setAttribute("user", user);
                
                session.setAttribute("message", "User was updated successfully");
                request.getRequestDispatcher("userUpdate.jsp").include(request, response);

            } catch (SQLException ex) {
                Logger.getLogger(CreateAccountServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            request.getRequestDispatcher("userUpdate.jsp").include(request, response);
        }

    }
}
