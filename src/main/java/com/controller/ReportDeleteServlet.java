package com.controller;

import com.model.dao.ReportDAO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ReportDeleteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();

        //ReportLog reportLog = (ReportLog) session.getAttribute("reportLog");
        int ID = (int) (session.getAttribute("reportLogID"));
        ReportDAO reportDAO = (ReportDAO) session.getAttribute("reportDAO");

        try {
            reportDAO.delete(ID);
        } catch (SQLException ex) {
            Logger.getLogger(ReportDeleteServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

        request.getRequestDispatcher("reportView.jsp").include(request, response);
    }
}
