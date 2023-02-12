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
 * Class allows a user (Customer or Staff)
 * - to delete his own profile
 * - to delete the information in the database
 * - to keep the data of the completed bookings
 * - to delete the future Customer bookings
 * - to redirect the User to the index page
 *
 * @author Antonella
 */
public class UserDeleteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        UserDAO userDAO = (UserDAO) session.getAttribute("userDAO");
        
        User userUpdate = (User) session.getAttribute("userUpdate");
        User currentUser = (User) session.getAttribute("user");
        User user = (userUpdate != null) ? userUpdate : currentUser;
        
        String userType = user.getType();

        if (userType != null) {
            try {
                BookingsDAO bookingsDAO = (BookingsDAO) session.getAttribute("bookingsDAO");
                bookingsDAO.deleteBookingbyCustomerID(user.getID());
                userDAO.delete(userType, user.getID());
            } catch (SQLException ex) {
                Logger.getLogger(UserDeleteServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            if(userUpdate != null) {
                session.setAttribute("deletedUser", "User '"+ user.getName() +"' was deleted successfully");
                session.removeAttribute("userUpdate");
                request.getRequestDispatcher("customers.jsp").include(request, response);
            }else {
                session.invalidate();
                request.getRequestDispatcher("index.jsp").include(request, response);
            }
        }

    }
}
