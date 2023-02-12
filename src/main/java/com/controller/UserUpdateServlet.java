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
 * Class allows a user (Customer or Staff)
 * - to update his own profile
 * - to update the information in the database
 * (previous validation of each insert data with Reg Ex)
 *
 * @author Antonella
 */
public class UserUpdateServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        UserDAO userDAO = (UserDAO) session.getAttribute("userDAO");
        String submitted = request.getParameter("submitted");
        User user = (User) session.getAttribute("user");
        String userType = (String)session.getAttribute("userType");

        int ID = user.getID();
        String name = request.getParameter("name");
        String staffEmail = request.getParameter("email");
        String password = request.getParameter("password");
        String dob = request.getParameter("dob");
        String phoneNumber = request.getParameter("phoneNumber");

         //checking the RegEx for Customer and Staff
        session.setAttribute("nameError", name.matches(Utils.nameRegEx) ? "" : "Incorrect format. Use: \"[First] [Middle] [Last]\"");
        session.setAttribute("passError", password.matches(Utils.passRegEx) ? "" : "Incorrect format. Use: \"[Example123]\"");
        session.setAttribute("dobError", dob.matches(Utils.dobRegEx) && Utils.isOlderThen18(dob) ? "" : "Incorrect format. Use: \"[dd][mm][yyyy] or age >18\"");
        session.setAttribute("phoneError", phoneNumber.matches(Utils.phoneRegEx) ? "" : "Incorrect format. Use:\"[+Contry Code][Number]\"");

        boolean validRegex = (name.matches(Utils.nameRegEx) &&  
                            password.matches(Utils.passRegEx) && 
                            Utils.isOlderThen18(dob) && 
                            phoneNumber.matches(Utils.phoneRegEx));       
        

        if (validRegex) {
            try {                
                userDAO.update(userType, name, password, dob, phoneNumber, ID);
                user = userDAO.getUser(ID, userType);
                session.setAttribute("user", user);
                
                session.setAttribute("message", "User was updated successfully");
                request.getRequestDispatcher("userUpdate.jsp").include(request, response);

            } catch (SQLException ex) {
                Logger.getLogger(CreateAccountServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            request.getRequestDispatcher("userUpdate.jsp").include(request, response);
        }

    }
}
