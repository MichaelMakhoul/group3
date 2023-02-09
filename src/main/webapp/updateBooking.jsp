<%-- 
    Document   : addBooking
    Created on : 03-Feb-2023, 6:26:55 PM
    Author     : 236361
--%>

<%@page import="com.model.Booking"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Update Booking</title>
    <link href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,400italic,600,700' rel='stylesheet' type='text/css'>
    <link href="css/bootstrap.min.css" rel="stylesheet">         
    <link href="css/templatemo-style.css" rel="stylesheet">
    <link rel="stylesheet" href="css/w3.css"> 
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
  </head>
  <body>

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
                <li><a href="LogoutServlet">Logout</a></li>
              </ul>
            </nav>		
          </div>				
        </div>
      </div>	  	
    </div>
      <%  
            //all to be removed in update servlet
            Integer drQty = (Integer) session.getAttribute("drQty");
            Integer frQty = (Integer) session.getAttribute("frQty");
            Integer esQty = (Integer) session.getAttribute("esQty");
            Integer drRooms = (Integer) session.getAttribute("drRooms");
            Integer frRooms = (Integer) session.getAttribute("frRooms");
            Integer esRooms = (Integer) session.getAttribute("esRooms");
            Integer drAvail = (Integer) session.getAttribute("drAvail");
            Integer frAvail = (Integer) session.getAttribute("frAvail");
            Integer esAvail = (Integer) session.getAttribute("esAvail");
            
            String checkInD = (String) session.getAttribute("checkInD");
            String checkOutD = (String) session.getAttribute("checkOutD");
            String comments = (String) session.getAttribute("comments");            
            Integer bookingID = (Integer) session.getAttribute("bookingId");
            
            String dateErr = (String) session.getAttribute("dateErr");
            String roomsErr = (String) session.getAttribute("roomsErr");
            String roomsFull = (String) session.getAttribute("roomsFull");
            session.removeAttribute("dateErr");
            session.removeAttribute("roomsErr");
            session.removeAttribute("roomsFull");
            //int rooms = booking.getRooms().size();
            //out.println("rooms : " + rooms );
            out.println("drRooms : " + drRooms );
            out.println("frRooms : " + frRooms );
            out.println("esRooms : " + esRooms );
          
          
//          out.println("checkInD : " + checkInD + " request: " + request.getParameter("checkIn"));
//          out.println("checkOutD : " + checkOutD + " request: " + request.getParameter("checkOut"));
      %>
    <div class="w3-content w3-border w3-margin-top" >
      <!--style="min-width: 25%;max-width:70%;"-->

      <div class="w3-container w3-margin-top w3-border-bottom" id="rooms">
        <h3><b>Update Booking : <%=bookingID%></b></h3>        
        <% if(roomsErr != null){%> 
          <p><span class="w3-text-red"><b><%=roomsErr%></b></span></p>
          <%}%>
          <% if(dateErr != null){%> 
          <p><span class="w3-text-red"><b><%=dateErr%><b></span></p>
          <%}%>
          <% if(roomsFull != null){%> 
          <p><span class="w3-text-red"><b><%=roomsFull%><b></span></p>
          <%}%>
      </div>
    
      <form  method="POST" action="#"> 
      <div class="w3-row-padding w3-padding-16 w3-border-bottom">
                 
          <div class="w3-col m3 w3-margin-left">
            <label><i class="fa fa-calendar-o"></i> Check In</label>
            <input class="w3-input w3-border" type="date" name="checkIn" id ="cIn"
                   value="<%= (checkInD != null) ? checkInD : "DD MM YYYY"%>" >
            
          </div>
          <div class="w3-col m3 w3-margin-left">
            <label><i class="fa fa-calendar-o"></i> Check Out</label>
            <input class="w3-input w3-border" type="date" name="checkOut" id ="cOut"
                   value="<%= (checkOutD != null) ? checkOutD : "DD MM YYYY"%>" >            
          </div>
<!--          <div class="w3-col m3 w3-margin-left">
            <label><i class="fa fa-search"></i> Check Availability</label>
            <button class="w3-button w3-block w3-black">Check Availability</button>
          </div>          -->
        <!--</form>-->
      </div>
           
      <!--<form  method="POST" action="#">-->
        <div class="w3-row-padding w3-padding-16">
          
          <div class="w3-third w3-margin-bottom">
            <img src="img/deluxe.jpg" alt="Deluxe Room" style="width:100%">
            <div class="w3-container w3-white">
              <h3>Deluxe Room</h3>
              <h6 class="w3-opacity">$150</h6>
              <p>Room can accommodate up to 2 adults </p>
              <p>15m<sup>2</sup></p>
              <br>
              <p class="w3-large"><i class="fa fa-bath"></i> <i class="fa fa-phone"></i> <i class="fa fa-wifi"></i></p>
              <br>
              <!--<button class="w3-button w3-block w3-black w3-margin-bottom">Choose Room</button>-->
              <label class="w3-blue-grey" for="drQuantity"><%=drAvail%> more Room\s more Available</label>
              <input class="w3-input w3-border w3-light-grey" type="number" onkeydown="return false" 
                     id="drQuantity" name="drQuantity" min="0" max="<%=drQty%>"  maxlength="2" placeholder="No of rooms"
                     value="<%=drRooms%>">
            </div>
          </div>
          <div class="w3-third w3-margin-bottom">
            <img src="img/family.jpg" alt="Family Room" style="width:100%">
            <div class="w3-container w3-white">
              <h3>Family Room</h3>
              <h6 class="w3-opacity">$250</h6>
              <p>Room can accommodate up to 4 adults</p>
              <p>25m<sup>2</sup></p>
              <br>
              <p class="w3-large"><i class="fa fa-bath"></i> <i class="fa fa-phone"></i> <i class="fa fa-wifi"></i> <i class="fa fa-tv"></i> <i class="fa fa-glass"></i> <i class="fa fa-cutlery"></i></p>
              <br>
              <label class="w3-blue-grey" for="frQuantity"><%=frAvail%> more Room\s Available</label>
              <input class="w3-input w3-border w3-light-grey" type="number" onkeydown= "return false"
                     id="frQuantity"  name="frQuantity" min="0" max="<%=frQty%>" maxlength="2" placeholder="No of rooms"
                     value="<%=frRooms%>" >
              <!--<button class="w3-button w3-block w3-black w3-margin-bottom">Choose Room</button>-->
            </div>
          </div>
          <div class="w3-third w3-margin-bottom">
            <img src="img/suite.jpg" alt="Executive Suite" style="width:100%">
            <div class="w3-container w3-white">
              <h3>Executive Suite</h3>
              <h6 class="w3-opacity">$500</h6>
              <p>'Room can accommodate up to 6 adults. Contains 3 bedrooms with a queen bed in each.</p>
              <p>40m<sup>2</sup></p>
              <p class="w3-large"><i class="fa fa-bath"></i> <i class="fa fa-phone"></i> <i class="fa fa-wifi"></i> <i class="fa fa-tv"></i> <i class="fa fa-glass"></i> <i class="fa fa-cutlery"></i></p>
              <br>
              <!--<button class="w3-button w3-block w3-black w3-margin-bottom">Choose Room</button>-->
              <label class="w3-blue-grey" for="esQuantity"><%=esAvail%> more Room\s Available</label>
              <input class="w3-input w3-border w3-light-grey" type="number" onkeydown="return false" 
                     id="esQuantity" name="esQuantity" min="0" max="<%=esQty%>"  maxlength="2" 
                     value="<%=esRooms%>">
            </div>
          </div>
            
        </div> 
      </form>
        <form  method="POST" action="UpdateBookingServlet">
        <div class="w3-row-padding w3-margin-bottom">        
          <label for="comments"><b>Comments</b></label>
            <input class="w3-input w3-border" type="text" name="comments" 
                   value=""<%= (comments != null) ? comments : ""%>"">        
        </div>
        
        <div class="w3-row-padding w3-margin-bottom">        
          <div class="w3-third w3-margin-right ">
            <% if(roomsErr != null ||dateErr != null ||roomsFull != null ){%> 
            <button class="w3-button w3-black w3-block" type="submit" disabled=""> Update Now</button>
            <%} else{%>
            <button class="w3-button w3-black w3-block" type="submit"> Update Now</button>
            <%}%>
          </div>
          <div class="w3-third w3-margin-right">
            <a href="bookingConfirmation.jsp" class="w3-button w3-black w3-block"> <i class="fa fa-close"></i> Cancel</a>
          </div>          
        </div>
      </form>    
      <!-- End page content -->
    </div>
    <script>
        Date.prototype.addDays = function (days) { return new Date(this.getTime() + days*24*60*60*1000); };
        Date.prototype.toYYYYMMDD = function() {
                return this.getFullYear()+"-"+ (''+(this.getMonth()+1)).padStart(2,'0')+"-"+(''+(this.getDate())).padStart(2,'0'); };
        
        var minDate =  new Date();
        minDate.setDate(minDate.getDate()+1);
        var maxDate = new Date();
        maxDate.setMonth(maxDate.getMonth()+3);
        
        var checkinElem = document.querySelector("#cIn");
        var checkoutElem = document.querySelector("#cOut");

        checkinElem.setAttribute("min", minDate.toYYYYMMDD());
        checkinElem.setAttribute("max", maxDate.toYYYYMMDD());
        minDate.setDate(minDate.getDate()+1);
        checkoutElem.setAttribute("min", minDate.toYYYYMMDD());
        checkoutElem.setAttribute("max", maxDate.toYYYYMMDD());
        
        
        checkinElem.onchange = function () {            
            var currentDate = new Date(this.value);
            currentDate.setDate(currentDate.getDate()+1);
            checkoutElem.setAttribute("min", currentDate.toYYYYMMDD());
            this.form.submit();            
        };
        checkoutElem.onchange = function(){
            this.form.submit();
        };
        
        var dlroomip = document.querySelector("#drQuantity");
        var frroomip = document.querySelector("#frQuantity");
        var esroomip = document.querySelector("#esQuantity");
        dlroomip.onchange = function(){
            this.form.submit();
        };
        frroomip.onchange = function(){
            this.form.submit();
        };
        esroomip.onchange = function(){
            this.form.submit();
        };
        
    </script>
  </body>

</html>
