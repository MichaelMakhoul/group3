<%-- 
    Document   : bookingDetails
    Created on : 04-Feb-2023, 9:21:01 PM
    Author     : Shilpa 
--%>

<%@page import="com.model.User"%>
<%@page import="com.model.Room"%>
<%@page import="com.model.Booking"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Confirm-Booking</title>
    <link href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,400italic,600,700' rel='stylesheet' type='text/css'>
    <link href="css/bootstrap.min.css" rel="stylesheet">         
    <link href="css/templatemo-style.css" rel="stylesheet">
    
    <link rel="stylesheet" href="css/w3.css"> 
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
  </head>
  <body >
    <% 
        User user = (User) session.getAttribute("user");        
        Booking booking = (Booking)session.getAttribute("booking"); 
        String bookingsView = (String)session.getAttribute("bookingsView"); 
        String updateBooking = (String)session.getAttribute("updateBooking");
        session.removeAttribute("updateBooking");
    %>
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
                <li><a href="main.jsp" >Main</a></li>
                <% if(bookingsView != null) { %>
                <li><a href="ShowBookingsServlet" >Bookings List</a></li>
                <%}%>
                <li><a href="LogoutServlet">Logout</a></li>
              </ul>
            </nav>		
          </div>				
        </div>
      </div>	  	
    </div>
    <div class="w3-content w3-margin-top w3-white" style="min-width: 600px ;max-width:1200px;">
      <table class="w3-table">
        <tr>
        <td>
        <div class="w3-responsive" align=" center">
          <table class="w3-table w3-white">
            <tr>
              <td>
                <% if(bookingsView == null) { %>
                  <h2 style="color: #404040; font-weight: 300; margin: 0 0 12px 0; font-size: 20px; line-height: 30px;">
                    <b>Hi <%=user.getName() %>,</b>    
                   </h2>
                   <p style="color: #666666; font-weight: 400; font-size: 15px; line-height: 21px; margin-bottom: 10px">
                     Your booking request has been confirmed. Please review the details of your booking.
                   </p>
                <% }else{ %>
                       <% if(updateBooking == null) { %>
                        <h2 style="color: #404040; font-weight:700; margin: 0 0 12px 0; font-size: 25px; line-height: 30px; ">
                         Booking Details    
                        </h2>
                        <% }else{ %>
                            <h2 style="color: #404040; font-weight:700; margin: 0 0 12px 0; font-size: 25px; line-height: 30px; ">
                                Updated Booking Details    
                            </h2>
                            <p style="color: #666666; font-weight: 400; font-size: 15px; line-height: 21px; " >
                                Update has been successful.
                            </p>
                        <% }
                    }%>
                   <table class="w3-border w3-text-dark-grey w3-margin-all" width ="100%">
                      <tr class="w3-dark-gray">
                        <td style="padding:20px 20px 0px ; font-weight:700; font-size: 25px; ">
                          <i class="fa fa-braille" aria-hidden="true"></i> Booking Code: <%=booking.getBookingID() %><br>                         
                        </td>
                      </tr>
                      <tr> 
                        <td class="w3-border" style="padding:20px 20px 10px ; font-weight:700; font-size: 18px; ">
                          <i class="fa fa-bed" aria-hidden="true"></i> Rooms 
                          <p style="padding-top:0px; font-weight:700; font-size: 12px; ">
                            <table class="w3-table-all w3-border-white" style="width: 100%;">
                            <tbody>
                              <tr class="w3-dark-gray">
                                <td style=" column-span: 2; padding:20px 20px 0px 20px ;font-weight:700; font-size: 14px;">Room Number</td>
                                <td></td>
                                <td style="  padding:20px 20px 0px 30px ;font-weight:700; font-size: 14px; ">Room Type</td>
                              </tr>
                              <% for(Room room : booking.getRooms()){%>
                              <tr class="">
                                <td style=" column-span: 2; padding: 10px 10px 10px 10px ;font-weight:700; font-size: 14px; ">
                                  <%=room.getRoomNo()%></td><td>&gt;</td>
                                <td style="padding: 10px 10px 10px 10px ;font-weight:700; font-size: 14px; ">
                                  <%=room.getRoomType()%></td>
                              </tr>
                              <% } %>
                            </tbody>
                            </table>                            
                          </p>
                        </td>                           
                      </tr>
                      <tr>
                        <td class="w3-border"style="padding:20px 20px 10px ; font-weight:700; font-size: 18px; ">
                          <i class="fa fa-suitcase" aria-hidden="true"></i> Arrival
                          <table class="w3-table-all" style="width: 100%;">                            
                            <tbody>
                              <tr class="w3-dark-gray">
                                <td style=" column-span: 2; padding:20px 20px 0px 20px ; font-weight:700; font-size: 14px;">
                                  Check In</td>
                                <td></td>
                                <td style="  padding:20px 20px 0px 30px ; font-weight:700; font-size: 14px;">Check Out</td>
                              </tr>
                              <tr>
                                <td style=" column-span: 2; padding: 10px 10px 10px 10px ; font-weight:700; font-size: 18px;">
                                  <%=booking.getCheckIn()%></td><td>&gt;</td>
                                <td style="padding: 10px 10px 10px 30px ; font-weight:700; font-size: 18px; ">
                                  <%=booking.getCheckOut()%></td>
                              </tr>
                            </tbody>
                          </table>
                        </td>
                      </tr>
                      <tr>
                        <td class="w3-border">
                          <i class="fa fa-credit-card-alt" aria-hidden="true"></i> Payments
                          <table class="w3-table-all" style="width: 100%;">
                            <tbody>
                              <tr><td style="padding:20px 20px 0px 20px ; font-weight:700; font-size: 18px; ">
                                  Total Cost 
                                </td><td></td>
                                <td style="padding:20px 20px 0px 20px ; font-weight:700; font-size: 18px; ">
                                  $<%=booking.getTotalPrice()%>
                                </td>
                              </tr>
                              <tr><td style=" column-span: 2; padding:5px 20px 10px 20px ; font-weight:700; font-size: 14px;">
                                  Payment Mode </td>
                                <td></td>
                                <td style=" padding:5px 20px 10px 30px ; font-weight:700; font-size: 14px; ">
                                  Pay @ Hotel</td></tr> 
                            </tbody>
                          </table>                          
                        </td>
                      </tr>
                      <tr> <td style="padding:20px 20px 10px ; font-weight:700; font-size: 18px; ">
                          <i class="fa fa-comments" aria-hidden="true"></i> Comments
                          <p style="padding-top:0px; font-weight:700; font-size: 12px; "> <%=booking.getBookingDesc()%> </p>
                          </td>
                      </tr>
                   </table>
                   <% if(!(bookingsView != null || updateBooking != null)){ %>
                   <p style="color: #666666; font-weight: 400; font-size: 15px; line-height: 21px; margin-top: 10px" >
                     Hope you enjoyed the booking experience and will like the stay too.
                     <br>
                     Please contact the hotel for any changes to the booking.
                   </p>
                   <p style="color: #666666; font-weight: 400; font-size: 17px; line-height: 24px; margin-bottom: 6px; margin-top: 24px;" >
                     Cheers,</p>
                   <p style="color: #666666; font-weight: 400; font-size: 17px; margin-bottom: 6px; margin-top: 10px;">
                     The Grand Serene Team</p>
                   <% } %>
                    <% if(user.getType().equals("staff")){ %>
                        <div class="w3-row-padding w3-margin-top"> 
                           <div class="w3-quarter w3-margin ">
                             <a href="LoadBookingUpdateServlet" class="w3-button w3-black w3-block w3-round"> Update Booking</a>
                           </div>
                           <div class="w3-quarter w3-margin ">
                             <button onclick="document.getElementById('id01').style.display='flex'" class="w3-button w3-black w3-block w3-round"> Delete Booking</button>
                           </div>
                          <div class="w3-quarter w3-margin ">
                             <a href="ShowBookingsServlet" class="w3-button w3-black w3-block w3-round"> Bookings List</a>
                           </div>
                         </div>
                    <%} %>
              </td>
            </tr>              
          </table>              
        </div>
        </td>
        </tr>
      </table>
      <div id="id01" class="w3-modal">
        <div class="w3-modal-content w3-card-4 w3-animate-zoom" >
          <div class="w3-center"><br>
            <span onclick="document.getElementById('id01').style.display='none'" class="w3-button w3-xlarge w3-hover-red w3-display-topright" title="Close Modal">&times;</span>      
          </div>
          <form class="w3-container" action="DeleteBookingServlet">
            <div class="w3-section">
                <h2>Do you want to delete the booking</h2>
                <button class="w3-button w3-red w3-right w3-margin w3-round" type="submit">Delete</button>
                <button onclick="document.getElementById('id01').style.display='none'" type="button" class="w3-button w3-dark-gray w3-round w3-right w3-margin">Cancel</button>  
            </div>
          </form>
        </div>
      </div>
  </body>

</html>




 