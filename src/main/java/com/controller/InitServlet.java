package com.controller;

import com.model.dao.BookingsDAO;
import com.model.dao.ManagerDAO;
import com.model.dao.ReportDAO;
import com.model.dao.SqlDBConnector;
import com.model.dao.UserDAO;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * - Class initializes the connection to the database 
 * - Connect the database to all the DAO
 * - Closes the connection
 *
 * @author Aiman, Antonella, Micheal, Monte, Shilpa
 */

public class InitServlet extends HttpServlet {

    private SqlDBConnector sqlDBConnector;
    private Connection connection;
    private UserDAO userDAO;
    private ManagerDAO managerDAO;
    private ReportDAO reportDAO;
    private BookingsDAO bookingsDAO;

    @Override
    public void init() {
        try {
            sqlDBConnector = new SqlDBConnector();
            connection = sqlDBConnector.connection();
            userDAO = new UserDAO(connection);
            managerDAO = new ManagerDAO(connection);
            reportDAO = new ReportDAO(connection);
            bookingsDAO = new BookingsDAO(connection);
        } catch (IOException ex) {
            Logger.getLogger(InitServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(InitServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(InitServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(InitServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(InitServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.setAttribute("managerDAO", managerDAO);
        session.setAttribute("userDAO", userDAO);
        session.setAttribute("reportDAO", reportDAO);
        session.setAttribute("bookingsDAO", bookingsDAO);

    }

    @Override
    public void destroy() {
        try {
            sqlDBConnector.closeConnection();
        } catch (SQLException ex) {
            Logger.getLogger(InitServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
