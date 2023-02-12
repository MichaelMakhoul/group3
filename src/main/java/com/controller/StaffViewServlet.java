package com.controller;

import com.model.User;
import com.model.dao.UserDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * StaffViewServlet Controller allows a staff member to get a list of all existing customers.
 * The controller servlet returns a list of customers into HTML format to customers.jsp page
 * The list contains a clickable link "the user's email" that allows the staff member
 * to a certain customer's information.
 * The servlet support a search method by email and ID.
 * 
 * @author Michael.
 */
public class StaffViewServlet extends HttpServlet {

    /**
     * Fetches customers details from a list of customers `usersList' into a table body format.
     * To be used inside processRequest and processPostRequest methods.
     * 
     * @param usersList a list of customers.
     * @param response 
     */
    private void fetchList(List<User> usersList, HttpServletResponse response) {
        try ( PrintWriter out = response.getWriter()) {
            out.println("<link rel=\"stylesheet\" href=\"css/w3.css\">");
            for (User user : usersList) {
                out.println("<tr>");
                out.println("<td>" + user.getID() + "</td>");
                out.println("<td>" + user.getName() + "</td>");
                out.println("<td> <a href=http://localhost:8080/group3/UserAccountServlet?emailView=" + user.getEmail() + ">" + user.getEmail() + "</a></td>");
                out.println("<td>" + user.getPhone() + "</td>");
                out.println("<td>" + user.getDOB() + "</td>");
                out.println("</tr>");
            }
        } catch (IOException ex) {
            Logger.getLogger(StaffViewServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Creates and populates a list of all customers and fetch the data using `fetchList' method.
     * Used inside the doGet method.
     * 
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException
     * @throws IOException 
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            response.setContentType("text/html;charset=UTF-8");
            HttpSession session = request.getSession();

            UserDAO userDAO = (UserDAO) session.getAttribute("userDAO");
            List<User> usersList = userDAO.getUsers("customer");

            fetchList(usersList, response);

        } catch (SQLException ex) {
            Logger.getLogger(StaffViewServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Creates and populates a list of particular customers based on the `searchValue' and fetch the data using `fetchList' method.
     * Used inside the doPost method.
     * 
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException
     * @throws IOException 
     */
    protected void processPostRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            response.setContentType("text/html;charset=UTF-8");
            HttpSession session = request.getSession();

            String searchValue = request.getParameter("search_value");
            String searchOptions = request.getParameter("searchOptions");

            session.setAttribute("search_value", searchValue);

            UserDAO userDAO = (UserDAO) session.getAttribute("userDAO");

            List<User> usersList = userDAO.getUsers("customer");
            List<User> searchList = new ArrayList();

            if (searchValue != null) {
                if (searchOptions.equals("ID")) {
                    int searchID = Integer.parseInt(searchValue);
                    searchList.addAll(usersList.stream().filter(s -> s.match(searchID)).collect(Collectors.toList()));
                } else {
                    searchList.addAll(usersList.stream().filter(s -> s.getEmail().contains(searchValue)).collect(Collectors.toList()));
                }
            }

            fetchList(searchList, response);

        } catch (SQLException ex) {
            Logger.getLogger(StaffViewServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     * 
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException 
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processPostRequest(request, response);
    }
}
