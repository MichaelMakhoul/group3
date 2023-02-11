
package com.controller;

import com.utils.Utils;
import com.model.Booking;
import com.model.Bookings;
import com.model.User;
import com.model.dao.BookingsDAO;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author 236361
 */
public class ShowBookingsServlet extends HttpServlet {

    
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
        System.out.println("com.controller.ShowBookingsServlet.doGet()");
        HttpSession session = request.getSession();
        session.removeAttribute("bookings");
        User user = (User) session.getAttribute("user");
        
        BookingsDAO bookingsDAO = (BookingsDAO) session.getAttribute("bookingsDAO");
        Bookings bookings = new Bookings();
        if(user != null &&user.getType().equals("customer")){            
            bookings.setBookings(bookingsDAO.getBookingsbyCustomer(user.getID()));
        }else{
            bookings.setBookings(bookingsDAO.getCurrentBookings());
        }
        session.setAttribute("bookings", bookings);
        session.setAttribute("bookingsView","true");
        request.getRequestDispatcher("showBookings.jsp").forward(request, response);
        
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("com.controller.ShowBookingsServlet.doPost()");
        //processRequest(request, response);
            response.setContentType("text/html;charset=UTF-8");
            HttpSession session = request.getSession();
            String searchValue = request.getParameter("search_value");
            String searchOptions = request.getParameter("searchOptions");
            
            User user = (User) session.getAttribute("user");
            BookingsDAO bookingsDAO = (BookingsDAO) session.getAttribute("bookingsDAO");
            Bookings bookings = new Bookings();
            List<Booking> tempBookings = null;
            
            if(user.getType().equals("customer")){            
                tempBookings = bookingsDAO.getBookingsbyCustomer(user.getID());
            }else{
                tempBookings = bookingsDAO.getCurrentBookings();
            }
            
            if(searchValue != null|| tempBookings != null || !searchValue.isBlank()){
//                searchValue = searchValue.strip();
                switch (searchOptions) {
                    case "bookingID":
                        {
                            if(searchValue.strip().matches("[0-9]+")){
                               int searchID = Integer.parseInt(searchValue.strip());
                               tempBookings = tempBookings.stream().filter(b -> b.matchID(searchID)).collect(Collectors.toList());                               
                            }else{
                               session.setAttribute("searchErr", "Enter only numbers");                               
                            }
                            
                            break;
                        }
                    case "customerID":
                        {
                            if(searchValue.strip().matches("[0-9]+")){
                               int searchID = Integer.parseInt(searchValue.strip());
                               tempBookings =tempBookings.stream().filter(b -> b.matchCustomerID(searchID)).collect(Collectors.toList());                                
                            }else{
                               session.setAttribute("searchErr", "Enter only numbers");
                               bookings.setBookings(tempBookings);
                            }                            
                            break;
                        }
                    case "checkIn":
                        if(Utils.validateDate(searchValue.strip())!= null){
                            bookings.setBookings(tempBookings.stream().filter(b -> b.matchCheckIn(searchValue)).collect(Collectors.toList()));                           
                        }else{
                            session.setAttribute("searchErr", "yyyy-mm-dd");
                        }
                        break;
                    default:
                        if(Utils.validateDate(searchValue.strip())!= null){
                            bookings.setBookings(tempBookings.stream().filter(b -> b.matchCheckOut(searchValue)).collect(Collectors.toList()));
                        }else{
                            session.setAttribute("searchErr", "yyyy-mm-dd");
                        }                        
                        break;
                }
                if(tempBookings == null || tempBookings.size() ==0){
                    session.setAttribute("searchUnsuccessfull", "No Entry Found");
                }
            }
            if(tempBookings != null){                
                bookings.setBookings(tempBookings);
            }
            
            session.setAttribute("bookings", bookings);
            session.setAttribute("bookingsView","true");
            request.getRequestDispatcher("showBookings.jsp").forward(request, response);            
        } 

}
