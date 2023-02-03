/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;


import com.model.Staff;

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
 * @author 236333
 */
public class ManagerDeleteServlet extends HttpServlet  {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        StaffDAO staffDAO = (StaffDAO) session.getAttribute("staffDAO");
        String emailView = (String) session.getAttribute("emailView");

        Staff staff = null;
        if (emailView != null) {
            try {
                staff = staffDAO.getStaff(emailView);
            } catch (SQLException ex) {
                Logger.getLogger(ManagerDeleteServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            staffDAO = (StaffDAO) session.getAttribute("user");
        }

        if (staff != null) {
            try {
                staffDAO.delete(staff.getStaffID());
            } catch (SQLException ex) {
                Logger.getLogger(ManagerDeleteServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        if (emailView != null) {
            request.getRequestDispatcher("adminView.jsp").include(request, response);
      } else {
           session.invalidate();
          request.getRequestDispatcher("index.jsp").include(request, response);
      }
  }
 
    
}
