/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.model.dao.CustomerDAO;
import com.model.dao.ManagerDAO;
import com.model.dao.SqlDBConnector;
import com.model.dao.StaffDAO;
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
 *
 * @author 236351
 */
public class InitServlet extends HttpServlet {
private SqlDBConnector sqlDBConnector;
    private Connection connection;
    private CustomerDAO customerDAO;
    private ManagerDAO managerDAO;
    private StaffDAO staffDAO;

 

    @Override
    public void init() {
        try {
            sqlDBConnector = new SqlDBConnector();
            connection = sqlDBConnector.connection();
            customerDAO= new CustomerDAO(connection);
            managerDAO= new ManagerDAO(connection);
            staffDAO= new StaffDAO(connection);
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
        HttpSession session = request.getSession();
        session.setAttribute("customerDAO", customerDAO);
        session.setAttribute("managerDAO", managerDAO);
        session.setAttribute("staffDAO", staffDAO);
        
    }

 

    /**
     * 
     */
    @Override
    public void destroy() {
        try {
            sqlDBConnector.closeConnection();
        } catch (SQLException ex) {
            Logger.getLogger(InitServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
