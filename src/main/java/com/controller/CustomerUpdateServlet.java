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
public class CustomerUpdateServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();

        User userUpdate = (User) session.getAttribute("userUpdate");
        User currentUser = (User) session.getAttribute("user");
        User user = (userUpdate != null) ? userUpdate : currentUser;
        UserDAO userDAO = (UserDAO) session.getAttribute("userDAO");

//        int ID = Integer.parseInt(request.getParameter("ID"));
        int ID = user.getID();
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        String dob = request.getParameter("dob");
        String phoneNumber = request.getParameter("phoneNumber");

        String toUpdate = (String) session.getAttribute("toUpdate");

        session.setAttribute("nameError", name.matches(Utils.nameRegEx) ? "" : "Incorrect format. Use: \"[First] [Middle] [Last]\"");
        session.setAttribute("passError", password.matches(Utils.passRegEx) ? "" : "Incorrect format. Use: \"[Example123]\"");
        session.setAttribute("dobError", dob.matches(Utils.dobRegEx) ? "" : "Incorrect format. Use: \"[dd] [mm] [yyyy] or age >18\"");
        session.setAttribute("phoneError", phoneNumber.matches(Utils.phoneRegEx) ? "" : "Incorrect format. Use: \"[+Contry Code][Number]\"");

        boolean validRegex = (name.matches(Utils.nameRegEx)
                && password.matches(Utils.passRegEx)
                && dob.matches(Utils.dobRegEx)
                && phoneNumber.matches(Utils.phoneRegEx));

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
