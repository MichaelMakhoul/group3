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

/**
 * UserAccountServlet Controller allows a staff member to get information about
 * a specific customer. 
 * This servlet is called after a staff member clicks on a customer email 
 * from the customers list in customers.jsp page.
 * The servlet returns a customer details.
 *
 * @author Michael.
 */
public class UserAccountServlet extends HttpServlet {

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

        // Gets customer's email from the url
        String emailView = request.getParameter("emailView");
        UserDAO userDAO = (UserDAO) session.getAttribute("userDAO");

        session.setAttribute("emailView", emailView);

        // The type of the user accessing this page.
        String userType = (String) session.getAttribute("userType");

        // The type of the user to be updated.
        String toUpdate = (userType.equals("staff")) ? "customer" : (userType.equals("manager")) ? "staff" : "";
        session.setAttribute("toUpdate", toUpdate);

        if (emailView != null) {
            try {
                // Allows only staff members and managers to update other user's information
                if (!(toUpdate.equals("staff") || toUpdate.equals("customer"))) {
                    request.getRequestDispatcher("index.jsp").include(request, response);
                }
                // The user to be updated
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
