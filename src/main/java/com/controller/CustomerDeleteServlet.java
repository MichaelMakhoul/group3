package com.controller;

import com.model.Customer;
import com.model.dao.CustomerDAO;
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
public class CustomerDeleteServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();

        int ID = Integer.parseInt(request.getParameter("ID"));
        String userType = (String) session.getAttribute("userType");

        CustomerDAO customerDAO = (CustomerDAO) session.getAttribute("customerDAO");

        try {
            customerDAO.delete(ID);
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDeleteServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if (userType.equals("staff")) {
            request.getRequestDispatcher("staffMain.jsp").include(request, response);
        }
    }
}
