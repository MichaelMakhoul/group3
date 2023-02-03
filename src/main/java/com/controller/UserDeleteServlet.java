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
 *
 * @author 236351
 */
public class UserDeleteServlet extends HttpServlet {

//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        HttpSession session = request.getSession();
//
////        int ID = Integer.parseInt(request.getParameter("ID"));
//        User user = (User) session.getAttribute("user");
//
////        String userType = user.getType();
//        int ID = user.getID();
//
//        UserDAO userDAO = (UserDAO) session.getAttribute("userDAO");
//
////        userDAO.delete("customer", ID)
//        try {
//            userDAO.delete(userType, ID);
//        } catch (SQLException ex) {
//            Logger.getLogger(UserDeleteServlet.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
////        if (userType.equals("staff")) {
//            request.getRequestDispatcher("index.jsp").include(request, response);
////        }
//    }
}
