package com.controller;

import com.model.Customer;
import com.model.Customers;
import com.model.User;
import com.model.Users;
import com.model.dao.UserDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
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
public class StaffViewServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();

        try ( PrintWriter out = response.getWriter()) {
//            Users users = (Users) session.getAttribute("customers");
            UserDAO userDAO = (UserDAO) session.getAttribute("userDAO");
//            Users users = 
            List<User> usersList = userDAO.getUsers("customer");
            for (User user : usersList) {

                out.println("<style>\n"
                        + ".users_table_tr {\n"
                        + "    transition: background 0.25s ease;\n"
                        + "}"
                        + ".users_table_tr:hover {\n"
                        + "    background: #014055;\n"
                        + "}"
                        + ".users_table_td {\n"
                        + "    color: #fff;\n"
                        + "    font-weight: 400;\n"
                        + "    padding: 0.65em 1em;\n"
                        + "    width: 20%;"
                        + "    text-align: center;"
                        + "}"
                        + "</style>");

                out.println("<tr class=\"users_table_tr\">");
                out.println("<td class=\"users_table_td\">" + user.getID() + "</td>");
                out.println("<td class=\"users_table_td\">" + user.getName() + "</td>");        
                out.println("<td class=\"users_table_td\"> <a href=http://localhost:8080/group3/MainServlet?emailView="+ user.getEmail() + "/>" + user.getEmail() + "</a></td>");
                out.println("<td class=\"users_table_td\">" + user.getPhone() + "</td>");
                out.println("<td class=\"users_table_td\">" + user.getDOB() + "</td>");
                out.println("</tr>");
            }
        } catch (SQLException ex) {
            Logger.getLogger(StaffViewServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
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
        processRequest(request, response);
    }
}
