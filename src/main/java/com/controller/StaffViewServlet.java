package com.controller;

import com.model.Customer;
import com.model.Customers;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
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
//            out.print("<link href=\"css/style.css\" rel=\"stylesheet\">");
            Customers customers = (Customers) session.getAttribute("customers");
            List<Customer> customersList = customers.getCustomers();
            for (Customer customer : customersList) {
//                String email = "href=http://localhost:8080/group3/rest/sqlapi/customer/" + customer.getCustomerID();
//                String email = "href=http://http://localhost:8080/group3/rest/sqlapi/customers=" + customer.getCustomerEmail() + ">";

                out.println("<style>\n"
                        + ".customers_table_tr {\n"
                        + "    transition: background 0.25s ease;\n"
                        + "}"
                        + ".customers_table_tr:hover {\n"
                        + "    background: #014055;\n"
                        + "}"
                        + ".customers_table_td {\n"
                        + "    color: #fff;\n"
                        + "    font-weight: 400;\n"
                        + "    padding: 0.65em 1em;\n"
                        + "    width: 20%;"
                        + "    text-align: center;"
                        + "}"
                        + "</style>");

                out.println("<tr class=\"customers_table_tr\">");
                out.println("<td class=\"customers_table_td\">" + customer.getCustomerID() + "</td>");
                out.println("<td class=\"customers_table_td\">" + customer.getCustomerName() + "</td>");
                out.println("<td class=\"customers_table_td\"> <a href=http://localhost:8080/group3/rest/sqlapi/customer/" + customer.getCustomerID() + "/>" + customer.getCustomerEmail() + "</a></td>");
                out.println("<td class=\"customers_table_td\">" + customer.getCustomerPhone() + "</td>");
                out.println("<td class=\"customers_table_td\">" + customer.getCustomerDOB() + "</td>");
                out.println("</tr>");
            }
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
