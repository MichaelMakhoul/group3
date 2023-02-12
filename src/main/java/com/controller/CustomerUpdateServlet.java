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
 * CustomerUpdateServlet Controller allows a staff member or a manager to update an existing user.
 * A manager can update a staff account.
 * A staff member can update a customer 
 * The controller validate the input data using regular expression,
 * and returns a proper message to notify the user what is 
 * the correct input format
 *
 * @author Aiman and Michael.
 */
public class CustomerUpdateServlet extends HttpServlet {

    /**
     * Handles the HTTP POST method.
     * 
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException
     * @throws IOException 
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();

        // Get user type and object from the session.
        User userUpdate = (User) session.getAttribute("userUpdate");
        User currentUser = (User) session.getAttribute("user");
        User user = (userUpdate != null) ? userUpdate : currentUser;
        UserDAO userDAO = (UserDAO) session.getAttribute("userDAO");

        // Captures form inputs and assign them to relevent values.
        int ID = user.getID();
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        String dob = request.getParameter("dob");
        String phoneNumber = request.getParameter("phoneNumber");

        String toUpdate = (String) session.getAttribute("toUpdate");

        // Validates user inputs using regex.
        session.setAttribute("nameError", name.matches(Utils.nameRegEx) ? "" : "Incorrect format. Use: \"[First] [Middle] [Last]\"");
        session.setAttribute("passError", password.matches(Utils.passRegEx) ? "" : "Incorrect format. Use: \"[Example123]\"");
        session.setAttribute("dobError", dob.matches(Utils.dobRegEx) ? "" : "Incorrect format. Use: \"[dd] [mm] [yyyy] or age >18\"");
        session.setAttribute("phoneError", phoneNumber.matches(Utils.phoneRegEx) ? "" : "Incorrect format. Use: \"[+Contry Code][Number]\"");

        // Checks if all values matches the correct format using appropriate regex.
        boolean validRegex = (name.matches(Utils.nameRegEx)
                && password.matches(Utils.passRegEx)
                && dob.matches(Utils.dobRegEx)
                && Utils.isOlderThen18(dob)
                && phoneNumber.matches(Utils.phoneRegEx));

        // Allows only staff members and managers to update other user's information
        if (!(toUpdate.equals("staff") || toUpdate.equals("customer"))) {
            request.getRequestDispatcher("index.jsp").include(request, response);
        }

        if (validRegex) {
            try {
                userDAO.update(toUpdate, name, password, dob, phoneNumber, ID);
                userUpdate = userDAO.getUser(ID, toUpdate);
                session.setAttribute("userUpdate", userUpdate);
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
