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
        String staffEmail = request.getParameter("email");
        String password = request.getParameter("password");
        String dob = request.getParameter("dob");
        String phoneNumber = request.getParameter("phoneNumber");
        
        session.setAttribute("nameError", name.matches(Utils.nameRegEx) ? "" : "\"[First] [Middle] [Last]\"");
        session.setAttribute("passError", password.matches(Utils.passRegEx) ? "" : "\"[Example123]\"");
        session.setAttribute("dobError", dob.matches(Utils.dobRegEx) && Utils.isOlderThen18(dob) ? "" : "\"[dd] [mm] [yyyy] or age <18\"");
        session.setAttribute("phoneError", phoneNumber.matches(Utils.phoneRegEx) ? "" : "\"[+Contry Code] [Number]\"");
        
        boolean validRegex= false;
        
 
        if(registerOptions.equals("customer")){
            session.setAttribute("emailError", email.matches(Utils.emailRegEx) ? "" : "\"[example@example.com]\"");
            validRegex = (name.matches(Utils.nameRegEx) && email.matches(Utils.emailRegEx) && password.matches(Utils.passRegEx) && Utils.isOlderThen18(dob) && phoneNumber.matches(Utils.phoneRegEx));
        }else{
            session.setAttribute("emailError", staffEmail.matches(Utils.staffEmailRegEx) ? "" : "\"[example@tgsstaff.com]\"");
            validRegex = (name.matches(Utils.nameRegEx) && staffEmail.matches(Utils.staffEmailRegEx) && password.matches(Utils.passRegEx) && Utils.isOlderThen18(dob)&& phoneNumber.matches(Utils.phoneRegEx));
        }
        
        String error = "";        

          if (validRegex) {
            try {
                UserDAO userDAO = (UserDAO) session.getAttribute("userDAO");
                User user = userDAO.getUser(email, registerOptions);
                if (user != null) {
                    error = "User already exists";
                    session.setAttribute("error", error);
                    request.getRequestDispatcher("register.jsp").include(request, response);
                } else {
                    userDAO.create(registerOptions,name, email, password, dob, phoneNumber);
                    user = userDAO.getUser(email, registerOptions);
                    user.setType(registerOptions);
                    session.setAttribute("userType", registerOptions);  
                    session.setAttribute("user", user);
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
