package com.controller;

import com.model.User;
import com.model.dao.BookingsDAO;
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
 * @author 236351
 */
public class UserDeleteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        UserDAO userDAO = (UserDAO) session.getAttribute("userDAO");
        User user = (User) session.getAttribute("user");
        String userType = user.getType();
        
        
        if(userType != null){
            try {
                BookingsDAO bookingsDAO = (BookingsDAO) session.getAttribute("bookingsDAO");
                bookingsDAO.deleteBookingbyCustomerID(user.getID());
                userDAO.delete(userType, user.getID());
            } catch (SQLException ex) {
                Logger.getLogger(UserDeleteServlet.class.getName()).log(Level.SEVERE, null, ex);
            }            
            session.invalidate();
            request.getRequestDispatcher("index.jsp").include(request, response);
        }
    
}
}