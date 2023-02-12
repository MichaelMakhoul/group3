package com.controller;

import com.model.ReportLog;
import com.model.dao.ReportDAO;

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
 * Report Log View Servlet is used to handle the 
 * request obtained from Report Log View Page
 * 
 * @author Monte
 */
public class ReportLogViewServlet extends HttpServlet {

     /**
     * Used to get and display List of Report Log - it is called multiple times
     * in this Servlet - for Reusability Also the ID that is displayed is a link
     * which allows the user to go to Report Summary for selected Report Log ID
     *
     * @param reportLogList
     * @param response
     */
    private void fetchList(List<ReportLog> reportLogList, HttpServletResponse response) {
        try ( PrintWriter out = response.getWriter()) {
            for (ReportLog reportLog : reportLogList) {

                out.println("<tr>");
                out.println("<td style=\" font-weight:bold;\"> <a href=http://localhost:8080/group3/reportSummary.jsp?reportLogID=" + reportLog.getReportLogID() + ">" + reportLog.getReportLogID() + "</a></td>");
                out.println("<td>" + reportLog.getReportFromDate() + "</td>");
                out.println("<td>" + reportLog.getReportToDate() + "</td>");
                out.println("<td>" + reportLog.getNumberOfBookings() + "</td>");
                out.println("<td>" + reportLog.getRevenue() + "</td>");
                out.println("<td>" + reportLog.getCreateDate() + "</td>");
                out.println("</tr>");
            }
        } catch (IOException ex) {
            Logger.getLogger(ReportLogViewServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Reads Report Logs from Database and displays a List of Report Logs
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            response.setContentType("text/html;charset=UTF-8");
            HttpSession session = request.getSession();
            ReportDAO reportDAO = (ReportDAO) session.getAttribute("reportDAO");
            List<ReportLog> reportLogList = reportDAO.getReportLogs();
            fetchList(reportLogList, response);
        } catch (SQLException ex) {
            Logger.getLogger(ReportLogViewServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Used to search for one Report Log by ID and display
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void processPostRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            response.setContentType("text/html;charset=UTF-8");
            HttpSession session = request.getSession();

            String searchValue = request.getParameter("search_value");
            ReportDAO reportDAO = (ReportDAO) session.getAttribute("reportDAO");
            List<ReportLog> reportList = reportDAO.getReportLogs();
            List<ReportLog> searchList = new ArrayList();
            if (searchValue != null) {
                int searchID = Integer.parseInt(searchValue);
                searchList.addAll(reportList.stream().filter(s -> s.matchReport(searchID)).collect(Collectors.toList()));
            }
            fetchList(searchList, response);
        } catch (SQLException ex) {
            Logger.getLogger(StaffViewServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processPostRequest(request, response);
    }
}
