package com.controller;


import com.model.ReportSummary;
import com.model.dao.ReportDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ReportSummaryViewServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();

        try ( PrintWriter out = response.getWriter()) {
            int ID = (int) (session.getAttribute("reportLogID"));

            ReportDAO reportDAO = (ReportDAO) session.getAttribute("reportDAO");
            List<String> date = new ArrayList();
            date = reportDAO.getReportDate(ID);

            List<ReportSummary> reportSummaryList = reportDAO.getReportSummary(date.get(0),date.get(1));
            if(!reportSummaryList.isEmpty()){
            for (ReportSummary reportSummary : reportSummaryList) {
//                out.println("<style>\n"
//                        + ".users_table_tr {\n"
//                        + "    transition: background 0.25s ease;\n"
//                        + "}"
//                        + ".users_table_tr:hover {\n"
//                        + "    background: #014055;\n"
//                        + "}"
//                        + ".users_table_td {\n"
//                        + "    color: #fff;\n"
//                        + "    font-weight: 400;\n"
//                        + "    padding: 0.65em 1em;\n"
//                        + "    width: 20%;"
//                        + "    text-align: center;"
//                        + "}"
//                        + "</style>");

                out.println("<tr>");
                out.println("<td>" + reportSummary.getBookingID() + "</td>");
                out.println("<td>" + reportSummary.getCheckIn() + "</td>");
                out.println("<td>" + reportSummary.getCheckOut() + "</td>");
                out.println("<td>" + reportSummary.getNumberOfRooms() + "</td>");
                out.println("<td>" + reportSummary.getTotalPrice() + "</td>");
                out.println("</tr>");
            }     
            }else{
               out.println("<td><h1 style=\" font-weight:bold;\">NOTHING </h1></td>"); 
               out.println("<td><h1 style=\" font-weight:bold;\">TO</h1></td>"); 
               out.println("<td><h1 style=\" font-weight:bold;\">DISPLAY</h1></td>");
               out.println("<td><h1 style=\" font-weight:bold;\">TABLE'S</h1></td>"); 
               out.println("<td><h1 style=\" font-weight:bold;\">EMPTY</h1></td>"); 
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
