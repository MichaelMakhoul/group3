<%-- 
    Document   : addBooking
    Created on : 03-Feb-2023, 6:26:55 PM
    Author     : Shilpa 
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Add Booking</title>
        <link href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,400italic,600,700' rel='stylesheet' type='text/css'>
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway">
        <link href="https://fonts.googleapis.com/css2?family=Cinzel:wght@700&family=Nunito+Sans:wght@200&display=swap" rel="stylesheet">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link href="css/templatemo-style.css" rel="stylesheet">
        <link rel="stylesheet" href="css/w3.css">
        <link href="css/bootstrap-datetimepicker.min.css" rel="stylesheet">
        <link rel="stylesheet" href="css/style.css">
        <link href="css/bootstrap.min.css" rel="stylesheet">
    </head>
    <body>

        <div class="tm-header">
            <div class="nav-container">
                <div class="row">
                    <div class="col-lg-6 col-md-4 col-sm-3 tm-site-name-container">
                        <p class="tm-site-name">The Grand Serene</p>	
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
      </div>	  	
    </div>
      <%  
          Boolean available = (Boolean) session.getAttribute("available");
          Integer drQty = (Integer) session.getAttribute("drQty");
          Integer frQty = (Integer) session.getAttribute("frQty");
          Integer esQty = (Integer) session.getAttribute("esQty");
          String checkInD = (String) session.getAttribute("checkInD");
          String checkOutD = (String) session.getAttribute("checkOutD");
          String dateErr = (String) session.getAttribute("dateErr");
          String roomsErr = (String) session.getAttribute("roomsErr");
          String roomsFull = (String) session.getAttribute("roomsFull");
          session.removeAttribute("dateErr");
          session.removeAttribute("roomsErr");
          session.removeAttribute("roomsFull");       
          

      %>
    <div class="w3-content  w3-margin-top" >
      <div class="w3-container w3-margin-top w3-border-bottom" id="rooms">
        <h3><b>Add Booking</b></h3>
        <p>Make yourself at home is our slogan. We offer the best beds in the industry. Sleep well and rest well.</p>
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
    
      
      <div class="w3-row-padding w3-padding-16 w3-border-bottom">
        <form  method="POST" action="AddBookingServlet">          
          <div class="w3-col m4 w3-margin-left">
            <label><i class="fa fa-calendar-o"></i> Check In</label>
            <input class="w3-input w3-border" type="date" name="checkIn" id ="cIn"
                   value="<%= (checkInD != null) ? checkInD : "DD MM YYYY"%>" >
            
          </div>
          <div class="w3-col m4 w3-margin-left">
            <label><i class="fa fa-calendar-o"></i> Check Out</label>
            <input class="w3-input w3-border" type="date" name="checkOut" id ="cOut"
                   value="<%= (checkOutD != null) ? checkOutD : "DD MM YYYY"%>" >            
          </div>

          <div class="w3-col m3 w3-margin-left">
            <label><i class="fa fa-search"></i> Check Availability</label>
            <button class="w3-button w3-block w3-black w3-round" >Check Availability</button>
          </div>          
        </form>
      </div>

      <%if (available != null) {%>
      
      <form  method="POST" action="BookingServlet">
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
              <label class="w3-text-blue-grey" for="drQuantity"><%=drQty%> Rooms Available</label>
              <input class="w3-input w3-border w3-light-grey" type="number" id="quantity" name="drQuantity" min="0" max="<%=drQty%>"  maxlength="2" placeholder="No of rooms">
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
              <label class="w3-text-blue-grey" for="frQuantity"><%=frQty%> Rooms Available</label>
              <input class="w3-input w3-border w3-light-grey" type="number" id="quantity" name="frQuantity" min="0" max="<%=frQty%>" maxlength="2" placeholder="No of rooms">              
            </div>
          </div>
          <div class="w3-third w3-margin-bottom">
            <img src="img/suite.jpg" alt="Executive Suite" style="width:100%">
            <div class="w3-container w3-white">
              <h3>Executive Suite</h3>
              <h6 class="w3-opacity">$500</h6>
              <p>'Room can accommodate up to 6 adults. Has 3 rooms with a queen bed in each.</p>
              <p>40m<sup>2</sup></p>
              <p class="w3-large"><i class="fa fa-bath"></i> <i class="fa fa-phone"></i> <i class="fa fa-wifi"></i> <i class="fa fa-tv"></i> <i class="fa fa-glass"></i> <i class="fa fa-cutlery"></i></p>
              <br>              
              <label class="w3-text-blue-grey" for="esQuantity"><%=(esQty >1 ) ? esQty +" Rooms" : esQty +" Room"%> Available</label>
              <input class="w3-input w3-border w3-light-grey" type="number" id="quantity" name="esQuantity" min="0" max="<%=esQty%>"  maxlength="2" placeholder="No of rooms">
            </div>
          </div>              
        </div> 
        <div class="w3-row-padding w3-margin-bottom">        
          <label for="comments"><b>Comments</b></label>
            <input class="w3-input w3-border" type="text" name="comments" placeholder="Enter your comments">        
        </div>
        <div class="w3-row-padding w3-margin-bottom">        
          <div class="w3-third w3-margin-right ">
            <% if(roomsErr != null ||dateErr != null ||roomsFull != null ){%> 
            <button class="w3-button w3-black w3-block w3-round" type="submit" disabled> <i class="fa fa-calendar-plus-o"></i> Book Now</button>
            <%} else{%>
            <button class="w3-button w3-black w3-block w3-round" type="submit"> <i class="fa fa-calendar-plus-o"></i> Book Now</button>
            <%}%>
          </div>
          <div class="w3-third m2 w3-margin-right">
            <a href="main.jsp" class="w3-button w3-black w3-block w3-round"> <i class="fa fa-close"></i> Cancel</a>
          </div>          
        </div>
      </form>
      <% }%>
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
            var avail = <%=request.getSession().getAttribute("available")%>;
            var currentDate = new Date(this.value);
            currentDate.setDate(currentDate.getDate()+1);
            checkoutElem.setAttribute("min", currentDate.toYYYYMMDD());
            if(!!avail){
                this.form.submit();
            }
        };
        checkoutElem.onchange = function(){
            var avail = <%=request.getSession().getAttribute("available")%>;
            if(!!avail){
                this.form.submit();
            }
        };
    </script>
  </body>

</html>
