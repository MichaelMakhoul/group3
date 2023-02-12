<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%-- 
    Document   : addReportLog
    Created on : 04-Feb-2023, 2:32:01 PM
    Author     : Monte
--%>

<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Create Report Log</title>
        <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link href="https://fonts.googleapis.com/css2?family=Cinzel:wght@700&family=Nunito+Sans:wght@200&display=swap" rel="stylesheet">    
        <link href="css/templatemo-style.css" rel="stylesheet">
        <link href="css/w3.css" rel="stylesheet">
        <link href="css/bootstrap.min.css" rel="stylesheet">         
        <link href="css/style.css" rel="stylesheet">
    </head>
    <body>

        <div class="tm-header">
            <div class="nav-container">
                <div class="row">
                    <div class="col-lg-6 col-md-4 col-sm-3 tm-site-name-container">
                        <p class="tm-site-name"> The Grand Serene</p>	
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
          String reportFromDate = (String) session.getAttribute("reportFromDate");
          String reportToDate = (String) session.getAttribute("reportToDate");
          String dateErr = (String) session.getAttribute("dateErr");
          String existErr = (String) session.getAttribute("existErr");
          String createText = (String) session.getAttribute("createText");
          session.removeAttribute("dateErr");
          session.removeAttribute("createText");
          session.removeAttribute("existErr");
      %>
      
      
    <div class="w3-content w3-border w3-margin-top" >
      <div class="w3-container w3-margin-top w3-border-bottom" id="rooms">
        <h3><b>Create Report Log</b></h3>
        <% if(createText != null){%>
          <p><span class="w3-text-green"><b><%=createText%><b></span></p>
                          
          <%}%>
          
         <% if(dateErr != null){%> 
          <p><span class="w3-text-red"><b><%=dateErr%><b></span></p>
                          
          <%}%>
          
          <% if(existErr != null){%> 
          <p><span class="w3-text-red"><b><%=existErr%><b></span></p>
                          
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
          </div>
           <div class="w3-third w3-margin-right ">
           <br>
           <button style="margin: 6.5px" class="w3-button w3-round w3-black w3-block" type="submit"> <i class="fa fa-calendar-plus-o"></i> Create Log</button>
          </div>
        <div class="w3-row-padding w3-margin-bottom">
        </div>
        </form>
      </div>
    </div>     
    <script>
        Date.prototype.toYYYYMMDD = function() {
                return this.getFullYear()+"-"+ (''+(this.getMonth()+1)).padStart(2,'0')+"-"+(''+(this.getDate())).padStart(2,'0'); };
        
        var maxDate = new Date();
        maxDate.setMonth(maxDate.getMonth()+3);
        
        var checkinElem = document.querySelector("#cIn");
        var checkoutElem = document.querySelector("#cOut");

        checkinElem.setAttribute("min", "2000-01-01");
        checkinElem.setAttribute("max", maxDate.toYYYYMMDD());
        checkoutElem.setAttribute("min", "2000-01-02");
        checkoutElem.setAttribute("max", maxDate.toYYYYMMDD());

        checkinElem.onchange = function () {
            var currentDate = new Date(this.value);
            currentDate.setDate(currentDate.getDate()+1);
            checkoutElem.setAttribute("min", currentDate.toYYYYMMDD());           
        } ;
    </script>
  </body>
</html>
