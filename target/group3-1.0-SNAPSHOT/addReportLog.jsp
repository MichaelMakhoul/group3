<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Create Report Log</title>
    <link href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,400italic,600,700' rel='stylesheet' type='text/css'>
    <link href="css/bootstrap.min.css" rel="stylesheet">         
    <link href="css/templatemo-style.css" rel="stylesheet">
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
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
                <li><a href="main.jsp" >Manager Main</a></li>                                                              
                <li><a href="LogoutServlet">Logout</a></li>
              </ul>
            </nav>		
          </div>				
        </div>
      </div>	  	
    </div>
      <%  
          String reportFromDate = (String) session.getAttribute("reportFromDate");
          String reportToDate = (String) session.getAttribute("reportToDate");
          String dateErr = (String) session.getAttribute("dateErr");
          String createText = (String) session.getAttribute("createText");
          session.removeAttribute("dateErr");
          session.removeAttribute("createText");
      %>
    <div class="w3-content w3-border w3-margin-top" >
      <!--style="min-width: 25%;max-width:70%;"-->

      <div class="w3-container w3-margin-top w3-border-bottom" id="rooms">
        <h3><b>Create Report Log</b></h3>
        <% if(createText != null){%> 
          <p><span class="w3-text-red"><b><%=createText%><b></span></p>
          <%}%>
         <% if(dateErr != null){%> 
          <p><span class="w3-text-red"><b><%=dateErr%><b></span></p>
          <%}%>
      </div>
    
      
      <div class="w3-row-padding w3-padding-16 w3-border-bottom">
        <form  method="POST" action="AddReportLogServlet">
          <div class="w3-col m3 w3-margin-left">
            <label><i class="fa fa-calendar-o"></i> Report From</label>
            <input class="w3-input w3-border" type="date" name="reportFromDate" id ="cIn"
                   value="<%= (reportFromDate != null) ? reportFromDate : "DD MM YYYY"%>" >
            
          </div>
          <div class="w3-col m3 w3-margin-left">
            <label><i class="fa fa-calendar-o"></i> Report To</label>
            <input class="w3-input w3-border" type="date" name="reportToDate" id ="cOut"
                   value="<%= (reportToDate != null) ? reportToDate : "DD MM YYYY"%>" >            
          
        <div class="w3-row-padding w3-margin-bottom">        
          <div class="w3-third w3-margin-right ">
            <button class="w3-button w3-black w3-block" type="submit"> <i class="fa fa-calendar-plus-o"></i> Create Log</button>
          </div>
          <div class="w3-third m2 w3-margin-right">
            <a href="main.jsp" class="w3-button w3-black w3-block"> <i class="fa fa-close"></i> Cancel</a>
          </div>          
        </div>
        </form>
      </div>

      <!-- End page content -->
    </div>
    <script>
        Date.prototype.addDays = function (days) { return new Date(this.getTime() + days*24*60*60*1000); }
        Date.prototype.toYYYYMMDD = function() {
                return this.getFullYear()+"-"+ (''+(this.getMonth()+1)).padStart(2,'0')+"-"+(''+(this.getDate())).padStart(2,'0'); }
        
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
        }        

    </script>
  </body>

</html>
