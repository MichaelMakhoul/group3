/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.model.User;

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

/** This servlet allows the manager to delete a staff member as well as their details in the database
 *
 * @author Aiman 
 */
public class StaffDeleteServlet extends HttpServlet {
    /**
     * 
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException 
     */

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        UserDAO userDAO = (UserDAO) session.getAttribute("userDAO");
        String userType = (String) session.getAttribute("userType");
        String toUpdate = (userType.equals("staff")) ? "customer" : (userType.equals("manager")) ? "staff" : "";

        User user = (User) session.getAttribute("userUpdate");
        if (user != null) {
            try {
                userDAO.delete(toUpdate, user.getID());
            } catch (SQLException ex) {
                Logger.getLogger(StaffDeleteServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        request.getRequestDispatcher("viewAllStaff.jsp").include(request, response);

    }
}
