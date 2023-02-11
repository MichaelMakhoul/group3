<%-- 
    Document   : showBookings
    Created on : 05-Feb-2023, 12:15:32 PM
    Author     : 236361
--%>


<%@page import="com.model.Bookings"%>
<%@page import="javax.xml.transform.stream.StreamResult"%>
<%@page import="com.model.dao.XmlTransformer"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Bookings View</title>
    <link href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,400italic,600,700' rel='stylesheet' type='text/css'>
    <link href="css/font-awesome.min.css" rel="stylesheet">
    <link href="css/bootstrap.min.css" rel="stylesheet">        
    <link href="css/flexslider.css" rel="stylesheet">
    <link href="css/templatemo-style.css" rel="stylesheet">
    <link rel="stylesheet" href="css/w3.css">  
    <link rel="stylesheet" href="css/search.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
   	<link href="https://fonts.googleapis.com/css2?family=Cinzel:wght@700&family=Nunito+Sans:wght@200&display=swap" rel="stylesheet">
  </head>
  <body >
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
        String xslPath = application.getRealPath("/xsl/bookings.xsl");
        Bookings bookings = (Bookings) session.getAttribute("bookings");        
        Boolean nobookings = false;
        String searchErr = (String) session.getAttribute("searchErr");

        session.removeAttribute("searchErr");
        if(bookings == null){ nobookings = true;}
        else if(bookings.getBookings() == null){nobookings = true;}
        else if(bookings.getBookings().isEmpty()){nobookings = true;}
    %>
    <div class = "w3-container  w3-margin w3-white"  >
      <div class="w3-row w3-border-bottom" >
        <div class="w3-col w3-container m6 l6 w3-margin-bottom">
            <h3><b>Bookings List</b></h3>
            <p> Click on any Booking ID to check its details. </p>
        </div>
        <div class="w3-col w3-container m6 l6 search">         
            <form class="searchList" action="ShowBookingsServlet" method="POST">
              <div class="w3-row " > 
                <div class="w3-col m6 l6" style="margin-top: 5px; margin-bottom: 5px;" >  
                  <label for="searchOptions" style="padding: 13px;font-size: 17px">Search By:</label>
                  <select name="searchOptions" id="searchOptions" 
                          style="padding: 13px;font-size: 17px;border: 1px solid grey; border-radius: 5px;">
                        <option value="bookingID">Booking ID</option>
                        <option value="customerID">Customer ID</option>
                        <option value="checkIn">Check IN Date</option>
                        <option value="checkOut">Check Out Date</option>
                   </select>                    
                </div>
                <div class="w3-col m6 l6" style="margin-top: 5px; margin-bottom: 5px;" >                                    
                  <input type="text" placeholder="<%=searchErr !=null ? searchErr: "Search.."%>" name="search_value">
                  <button type="submit" class="w3-dark-gray"><i class="fa fa-search"></i></button>
                  <button type="button" class="w3-dark-gray" onclick="window.location='ShowBookingsServlet';" ><i class="fa fa-refresh"></i></button>
                </div>
              </div>
            </form>
        </div>
      </div>
      
      <div class="w3-container w3-margin-top">
        <%
        if(nobookings){        
        %>
            <h3>No Bookings have been made</h3>
        <% }else{
                XmlTransformer transformer = new XmlTransformer();
                transformer.transform(xslPath, bookings, new StreamResult(out));
           }%>
      </div>
      
    </div>
  </body>
</html>
