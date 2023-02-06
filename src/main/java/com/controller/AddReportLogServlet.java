/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
 *
 * @author 236355
 */
public class AddReportLogServlet extends HttpServlet {
@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String reportFromDate = request.getParameter("reportFromDate");
        String reportToDate = request.getParameter("reportToDate");
        int diff= Utils.differenceInDays(reportFromDate, reportToDate);
        if(diff > 0){
            ReportDAO reportDAO = (ReportDAO) session.getAttribute("reportDAO");
            try {
                reportDAO.createReportLog(reportFromDate, reportToDate);
                session.setAttribute("createText", "Successfully created report.");
                //reportDAO = (ReportDAO) session.getAttribute("reportDAO");
            } catch (SQLException ex) {
                Logger.getLogger(AddReportLogServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            session.setAttribute("dateErr", "Date entries are invalid. Please re-enter.");
        }
        
        request.getRequestDispatcher("addReportLog.jsp").forward(request, response);
        
    } 
}
