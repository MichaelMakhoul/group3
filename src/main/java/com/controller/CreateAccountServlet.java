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
 *
 * @author 236351
 */
public class CreateAccountServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();

        String name = request.getParameter("create_name");
        String email = request.getParameter("create_email");
        String password = request.getParameter("create_password");
        String dob = request.getParameter("create_dob");
        String phoneNumber = request.getParameter("create_phoneNumber");

        session.setAttribute("emailError", email.matches(Utils.emailRegEx) ? "" : "Incorrect email format");
        session.setAttribute("passError", password.matches(Utils.passRegEx) ? "" : "Incorrect password format");
        session.setAttribute("dobError", dob.matches(Utils.dobRegEx) ? "" : "Incorrect DOB format");
//        session.setAttribute("phoneError", phoneNumber.matches(Utils.phoneRegEx) ? "" : "Incorrect phone number format");

        boolean validRegex = (email.matches(Utils.emailRegEx) && password.matches(Utils.passRegEx) && dob.matches(Utils.dobRegEx));

        UserDAO customerDAO = (UserDAO) session.getAttribute("customerDAO");

        String userType = (String) session.getAttribute("userType");

        if (userType.equals("staff")) {
            if (validRegex) {
                try {
                    User customer = customerDAO.getUser(email, "customer");
                    if (customer != null) {
                        session.setAttribute("message", "Customer already exists");
                        request.getRequestDispatcher("createAccount.jsp").include(request, response);
                    } else {

                        customerDAO.create(userType, name, email, password, dob, phoneNumber);
                        session.setAttribute("message", "Customer created successfully");
                        request.getRequestDispatcher("createAccount.jsp").include(request, response);
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(CreateAccountServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                request.getRequestDispatcher("createAccount.jsp").include(request, response);
            }
        } else if (userType.equals("manager")) {

        }

    }
}
