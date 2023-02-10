/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.model.User;
import com.model.dao.UserDAO;
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
 * @author 236351
 */
public class UserAccountServlet extends HttpServlet {

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
        HttpSession session = request.getSession();

        String emailView = request.getParameter("emailView");
        UserDAO userDAO = (UserDAO) session.getAttribute("userDAO");
        User user = (User) session.getAttribute("user");
        
        session.setAttribute("emailView", emailView);
        
        String userType = (String) session.getAttribute("userType");
        
        String toUpdate = (userType.equals("staff")) ? "customer" : (userType.equals("manager")) ? "staff" : "";
        session.setAttribute("toUpdate", toUpdate);
        
        if (emailView != null) {
            try {
                if (!(toUpdate.equals("staff") || toUpdate.equals("customer"))) {
                    request.getRequestDispatcher("index.jsp").include(request, response);
                }
                User userUpdate = userDAO.getUser(emailView, toUpdate);
                userUpdate.setType(toUpdate);
                session.setAttribute("userUpdate", userUpdate);
            } catch (SQLException ex) {
                Logger.getLogger(UserAccountServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        request.getRequestDispatcher("account.jsp").include(request, response);
    }
}
