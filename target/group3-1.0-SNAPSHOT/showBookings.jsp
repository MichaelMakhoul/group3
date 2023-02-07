<%-- 
    Document   : showBookings
    Created on : 05-Feb-2023, 12:15:32 PM
    Author     : 236361
--%>

<%@page import="com.model.Booking"%>
<%@page import="com.model.Bookings"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>View All Customers</title>
    <link href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,400italic,600,700' rel='stylesheet' type='text/css'>
    <link href="css/font-awesome.min.css" rel="stylesheet">
    <link href="css/bootstrap.min.css" rel="stylesheet">        
    <link href="css/flexslider.css" rel="stylesheet">
    <link href="css/templatemo-style.css" rel="stylesheet">
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">        
  </head>
  <body class="tm-gray-bg">
    <div class="tm-header">
      <div class="container">
        <div class="row">
          <div class="col-lg-6 col-md-4 col-sm-3 tm-site-name-container">
            <a href="#" class="tm-site-name">The Grand Serene</a>	
          </div>
          <div class="col-lg-6 col-md-8 col-sm-9">
            <div class="mobile-menu-icon">
              <i class="fa fa-bars"></i>
            </div>
            <nav class="tm-nav">
              <ul>
                <li><a href="main.jsp""> Main</a></li>                
                <li><a href="LogoutServlet">Logout</a></li>
              </ul>
            </nav>		
          </div>				
        </div>
      </div>	  	
    </div>
    <%
        Bookings bookings = (Bookings) session.getAttribute("bookings");        
        Boolean nobookings = false;
        if(bookings == null){ nobookings = true;}
        else if(bookings.getBookings() == null){nobookings = true;}
        else if(bookings.getBookings().isEmpty()){nobookings = true;}
    %>
    <div class = "w3-content w3-border w3-margin-top w3-white" >
      <div class="w3-container w3-margin-top w3-border-bottom">
        <h3><b>Bookings List</b></h3>
        <p> </p>
      </div>
      
      <div class="w3-container w3-margin">
        <%
        if(nobookings){        
        %>
            <h3>No Bookings have been made</h3>
        <% }else{%>
        <table class="w3-table-all w3-hoverable">
          <thead>
            <tr class='w3-light-grey'>
              <th>Booking ID</th>
              <th>Customer ID</th>
              <th>Check In</th>
              <th>Check Out</th>
              <th>Total Rooms</th>
              <th>Total Price</th>
            </tr>
          </thead>
          <% for (Booking booking : bookings.getBookings()) {%>
          <tr>
            <td> <a style="text-decoration: underline;"  href="BookingServlet?ID=<%=booking.getBookingID()%>"> <%=booking.getBookingID()%></a></td>
            <td> <%=booking.getCustomerID()%></a></td>
            <td> <%=booking.getCheckIn()%></td>
            <td> <%=booking.getCheckOut()%></td>
            <td> <%=booking.getRooms().size()%></td>
            <td> <%=booking.getTotalPrice()%></td>
          </tr>
          <%}%>
        </table>
        <%}%>
      </div>
      
    </div>
  </body>
</html>
