///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
package com.controller;

import com.model.Manager;
import com.model.dao.ManagerDAO;
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
 * @author 236333
 */
public class ManagerMainServlet extends HttpServlet {
     @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();

        ManagerDAO managerDAO = (ManagerDAO) session.getAttribute("managerDAO");
        String emailView = request.getParameter("emailView");

        Manager manager = null;
        if (emailView != null) {
            try {
                manager = managerDAO.getManager(emailView);
                session.setAttribute("emailView", emailView);
            } catch (SQLException ex) {
                Logger.getLogger(ManagerMainServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            manager = (Manager) session.getAttribute("user");
        }
        session.setAttribute("manager", manager);
        request.getRequestDispatcher("account.jsp").include(request, response);
    }
}

    

