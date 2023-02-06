package com.controller;

import com.model.ReportLog;
import com.model.dao.ReportDAO;

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

public class ReportLogViewServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();

        try ( PrintWriter out = response.getWriter()) {
            //ReportLogs reportLogs = (ReportLogs) session.getAttribute("reportLogs");
            ReportDAO reportDAO = (ReportDAO) session.getAttribute("reportDAO");
            List<ReportLog> reportLogList = reportDAO.getReportLogs();
            for (ReportLog reportLog : reportLogList) {

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
                out.println("<td class=\"users_table_td\"> <a href=http://localhost:8080/group3/reportSummary.jsp?reportLogID="+ reportLog.getReportLogID() + ">" + reportLog.getReportLogID() + "</a></td>");
                //out.println("<td class=\"users_table_td\"> <a href=http://localhost:8080/group3/MainServlet?emailView="+ reportLog.getReportLogID() + "/>" + reportLog.getReportLogID() + "</a></td>");
                out.println("<td class=\"users_table_td\">" + reportLog.getReportFromDate() + "</td>");
                out.println("<td class=\"users_table_td\">" + reportLog.getReportToDate() + "</td>");
                out.println("<td class=\"users_table_td\">" + reportLog.getNumberOfBookings() + "</td>");
                out.println("<td class=\"users_table_td\">" + reportLog.getRevenue() + "</td>");
                out.println("<td class=\"users_table_td\">" + reportLog.getCreateDate() + "</td>");
                out.println("</tr>");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ReportLogViewServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}
