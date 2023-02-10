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

        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String dob = request.getParameter("dob");
        String phoneNumber = request.getParameter("phoneNumber");

        session.setAttribute("nameError", name.matches(Utils.nameRegEx) ? "" : "Incorrect name format");
        session.setAttribute("emailError", email.matches(Utils.emailRegEx) ? "" : "Incorrect email format");
        session.setAttribute("passError", password.matches(Utils.passRegEx) ? "" : "Incorrect password format");
        session.setAttribute("dobError", dob.matches(Utils.dobRegEx) ? "" : "Incorrect DOB format");
        session.setAttribute("phoneError", phoneNumber.matches(Utils.phoneRegEx) ? "" : "Incorrect phone number format");

        boolean validRegex = (name.matches(Utils.nameRegEx)
                && email.matches(Utils.emailRegEx)
                && password.matches(Utils.passRegEx)
                && dob.matches(Utils.dobRegEx)
                && phoneNumber.matches(Utils.phoneRegEx));

        UserDAO userDAO = (UserDAO) session.getAttribute("userDAO");

        String userType = (String) session.getAttribute("userType");

        System.out.println("usertype: " + userType);

        if (userType.equals("staff")) {
            if (validRegex) {
                try {
                    User customer = userDAO.getUser(email, "customer");
                    if (customer != null) {
                        session.setAttribute("message", "User already exists");
                        request.getRequestDispatcher("createAccount.jsp").include(request, response);
                    } else {

                        userDAO.create("customer", name, email, password, dob, phoneNumber);
                        session.setAttribute("message", "User created successfully");
                        request.getRequestDispatcher("createAccount.jsp").include(request, response);
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(CreateAccountServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                request.getRequestDispatcher("createAccount.jsp").include(request, response);
            }
        } else if (userType.equals("manager")) {

            if (validRegex) {
                try {
                    User staff = userDAO.getUser(email, "staff");
                    if (staff != null) {
                        session.setAttribute("message", "User already exists");
                        request.getRequestDispatcher("createAccount.jsp").include(request, response);
                    } else {

                        userDAO.create("staff", name, email, password, dob, phoneNumber);
                        session.setAttribute("message", "User created successfully");
                        request.getRequestDispatcher("createAccount.jsp").include(request, response);
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(CreateAccountServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                request.getRequestDispatcher("createAccount.jsp").include(request, response);
            }
        }
    }
}
