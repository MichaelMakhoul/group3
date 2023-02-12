package com.controller;

import com.model.dao.ReportDAO;
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
 * Add Report Servlet is used to handle the 
 * request obtained from Add Report Page 
 * 
 * @author Monte
 */
public class AddReportLogServlet extends HttpServlet {

    /**
     * Used to add a Report Log into the Database - from User chosen To and From Date
     * 
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException 
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String reportFromDate = request.getParameter("reportFromDate");
        String reportToDate = request.getParameter("reportToDate");
        int diff = Utils.differenceInDays(reportFromDate, reportToDate);
        if (diff > 0) {
            ReportDAO reportDAO = (ReportDAO) session.getAttribute("reportDAO");
            try {
                if (reportDAO.showOne(reportFromDate, reportToDate) == null) {
                    reportDAO.createReportLog(reportFromDate, reportToDate);
                    session.setAttribute("createText", "Successfully created report.");
                } else {
                    session.setAttribute("existErr", "Report exists already");
                }
            } catch (SQLException ex) {
                Logger.getLogger(AddReportLogServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            session.setAttribute("dateErr", "Date entries are invalid. Please re-enter.");
        }
        request.getRequestDispatcher("addReportLog.jsp").forward(request, response);
    }
}
