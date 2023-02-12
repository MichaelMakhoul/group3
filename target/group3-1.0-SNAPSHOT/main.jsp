<%-- 
    Document   : main
    Created on : 28-Jan-2023, 10:31:34 AM
    Author     : Aiman, Antonella, Micheal, Monte, Shilpa
--%>
<%@page import="com.model.User"%>
<%@page import="com.model.Manager"%>
<%@page import="com.model.Staff"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Main</title>
        <link href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,400italic,600,700' rel='stylesheet' type='text/css'>
        <link href="css/bootstrap.min.css" rel="stylesheet">         
        <link href="css/templatemo-style.css" rel="stylesheet">
        <link href="css/style.css" rel="stylesheet">
        <link href="css/w3.css" rel="stylesheet">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Cinzel:wght@700&family=Nunito+Sans:wght@200&display=swap" rel="stylesheet">
    </head>
    <body style="background-color: #EODDD7" >
        <%
            String userType = (String) session.getAttribute("userType");
            User user = (User) session.getAttribute("user");
            session.removeAttribute("userUpdate");           
        %>
    <div class="tm-header">
      <div class="nav-container">
        <div class="row">
          <div class="col-lg-6 col-md-4 col-sm-3 tm-site-name-container tm-site-name">
			<p style="font-family: 'Cinzel', serif; color: #565656">The Grand Serene</p>
          </div>
          <div class="col-lg-6 col-md-8 col-sm-9">
            <div class="mobile-menu-icon">
              <i class="fa fa-bars"></i>
            </div>
            <nav class="tm-nav">
              <ul>
                <li><a href="main.jsp" class="active">Main</a></li>                                                              
                  <% if (!userType.equals("manager")) { %>
                <li><a href="account.jsp">User's Profile</a></li> 
                  <% } %>
                <li><a href="LogoutServlet">Logout</a></li>
              </ul>                    

            </nav>		
          </div>				
        </div>
        <div class="w3-main" > 


            <%
                //Attributes set during booking need to be reset
                session.removeAttribute("available");
                session.removeAttribute("drQty");
                session.removeAttribute("frQty");
                session.removeAttribute("esQty");
                session.removeAttribute("checkInD");
                session.removeAttribute("checkOutD");
                session.removeAttribute("booking");
                session.removeAttribute("bookingsView");
                //booking
                //Called since values are set in RegisterServlet
                session.removeAttribute("nameError");
                session.removeAttribute("emailError");
                session.removeAttribute("passError");
                session.removeAttribute("dobError");
                session.removeAttribute("phoneError");
         

                if (userType.equals("customer")) {
            %>
            

            <div class= "w3-container w3-third w3-cell ">  
                <div class="w3-container w3-padding-16 w3-margin">
                <p style="font-weight:bold; float: right;justify-content: flex-end;font-family: 'Nunito Sans'; font-size: 22px; color: #565656">Welcome <%= (user != null) ? user.getName() : ""%></p>
            </div>
                <div class="w3-row-padding w3-padding-16 w3-margin w3-theme">
                    <div class="w3-card-4 w3-hover-sepia" style="border-radius: 3px">            
                        <a href="addBooking.jsp">
                            <div  class="w3-container w3-teal w3-text-black" style="font-family: 'Nunito Sans'; font-size: 15px; justify-content: center; text-align: center; border-radius: 3px">
                                <div class="w3-left"></div>
                                <div class="w3-right">
                                    <h3></h3>
                                </div>
                                
                                <h4>ADD YOUR BOOKING</h4>
                            </div>
                        </a>
                    </div>
                </div>

                <div class="w3-row-padding w3-padding-16 w3-margin w3-theme">
                    <div class="w3-card-4 w3-hover-sepia" style="border-radius: 3px">            
                        <a href="ShowBookingsServlet">
                            <div class="w3-container w3-teal w3-text-black" style="font-family: 'Nunito Sans'; font-size: 15px; justify-content: centre; text-align: center; border-radius: 3px">
                                <div class="w3-left"></div>
                                <div class="w3-right">
                                    <h3></h3>
                                </div>
                                
                                <h4>VIEW YOUR BOOKINGS </h4>
                            </div>
                        </a>
                    </div>
                </div>
            </div>
            <div class="w3-container w3-twothird w3-cell">
                <div class="w3-row-padding w3-padding-16 w3-margin w3-theme">
                      
                        <img src="img/customer.jpg" alt="image" style="width:100%; height: 100%">
                   
                </div>
                
            </div>


            <% } else if (userType.equals("staff")) {%>

            

            <div class= "w3-container w3-third w3-cell ">  
                   
                <div class="w3-container w3-padding-16 w3-margin">
                <p style="font-weight:bold; float: right; justify-content: flex-end;font-family: 'Nunito Sans'; font-size: 22px; color: #565656">Welcome <%= (user != null) ? user.getName() : ""%></p>
            </div>
                <div class="w3-row-padding w3-padding-16 w3-margin w3-theme">
                    <div class="w3-card-4 w3-hover-sepia" style="border-radius: 3px">              
                        <a href="createAccount.jsp">
                             <div  class="w3-container w3-teal w3-text-black" style="font-family: 'Nunito Sans'; font-size: 15px; justify-content: center; text-align: center; border-radius: 3px">
                                <div class="w3-left"></div>
                                <div class="w3-right">
                                    <h3></h3>
                                </div>
                                <div class="w3-clear"></div>
                                <h4>Create User Account</h4>
                            </div>
                        </a>
                    </div>
                </div>
                <div class="w3-row-padding w3-padding-16 w3-margin w3-theme">
                    <div class="w3-card-4 w3-hover-sepia" style="border-radius: 3px">            
                        <a href="customers.jsp">
                          <div  class="w3-container w3-teal w3-text-black" style="font-family: 'Nunito Sans'; font-size: 15px; justify-content: center; text-align: center; border-radius: 3px">
                                <div class="w3-left"></div>
                                <div class="w3-right">
                                    <h3></h3>
                                </div>
                                <div class="w3-clear"></div>
                                <h4>View Customers List</h4>
                            </div>
                        </a>
                    </div>
                </div>
               <div class="w3-row-padding w3-padding-16 w3-margin w3-theme">
                    <div class="w3-card-4 w3-hover-sepia" style="border-radius: 3px">             
                        <a href="ShowBookingsServlet">
                             <div  class="w3-container w3-teal w3-text-black" style="font-family: 'Nunito Sans'; font-size: 15px; justify-content: center; text-align: center; border-radius: 3px">
                                <div class="w3-left"></div>
                                <div class="w3-right">
                                    <h3></h3>
                                </div>
                                <div class="w3-clear"></div>
                                <h4>View Bookings List</h4>
                            </div>
                        </a>
                    </div>
                </div>
            </div>
          <div class="w3-container w3-twothird w3-cell">
                <div class="w3-row-padding w3-padding-16 w3-margin w3-theme">  
                        <img src="img/staff.jpg" alt="image" style="width:100%; height: 100%">
                    </div>
                </div>
              
            </div>

            <% } else if (userType.equals("manager")) {
            Manager manager = (Manager) session.getAttribute("manager");%>
            
            

            <div class= "w3-container w3-third w3-cell ">
                <!--<div class="w3-row-padding w3-padding-64 w3-margin w3-theme">--> 
                <div class="w3-container w3-padding-16 w3-margin">
                <p style="font-weight:bold; float: right;  justify-content: flex-end;font-family: 'Nunito Sans'; font-size: 22px; color: #565656">Welcome <%= (manager != null) ? manager.getManagerName() : ""%></p>
                </div>
             <div class="w3-row-padding w3-padding-16 w3-margin w3-theme">
                    <div class="w3-card-4 w3-hover-sepia" style="border-radius: 3px">             
                        <a href="createAccount.jsp">
                            <div  class="w3-container w3-teal w3-text-black" style="font-family: 'Nunito Sans'; font-size: 15px; justify-content: center; text-align: center; border-radius: 3px">
                                <div class="w3-left"></div>
                                <div class="w3-right">
                                    <h3></h3>
                                </div>
                                <div class="w3-clear"></div>
                                <h4>Create New Staff Account</h4>
                            </div>
                        </a>
                    </div>
                </div>
               <div class="w3-row-padding w3-padding-16 w3-margin w3-theme">
                    <div class="w3-card-4 w3-hover-sepia" style="border-radius: 3px">            
                        <a href="viewAllStaff.jsp">
                           <div  class="w3-container w3-teal w3-text-black" style="font-family: 'Nunito Sans'; font-size: 15px; justify-content: center; text-align: center; border-radius: 3px">
                                <div class="w3-left"></div>
                                <div class="w3-right">
                                    <h3></h3>
                                </div>
                                <div class="w3-clear"></div>
                                <h4>View the List of Staff</h4>
                            </div>
                        </a>
                    </div>
                </div>
               <div class="w3-row-padding w3-padding-16 w3-margin w3-theme">
                    <div class="w3-card-4 w3-hover-sepia" style="border-radius: 3px">             
                        <a href="addReportLog.jsp">
                             <div  class="w3-container w3-teal w3-text-black" style="font-family: 'Nunito Sans'; font-size: 15px; justify-content: center; text-align: center; border-radius: 3px">
                                <div class="w3-left"></div>
                                <div class="w3-right">
                                    <h3></h3>
                                </div>
                                <div class="w3-clear"></div>
                                <h4>Create Report Log</h4>
                            </div>
                        </a>
                    </div>
                </div>
              <div class="w3-row-padding w3-padding-16 w3-margin w3-theme">
                    <div class="w3-card-4 w3-hover-sepia" style="border-radius: 3px">             
                        <a href="reportView.jsp">
                           <div  class="w3-container w3-teal w3-text-black" style="font-family: 'Nunito Sans'; font-size: 15px; justify-content: center; text-align: center; border-radius: 3px">
                                <div class="w3-left"></div>
                                <div class="w3-right">
                                    <h3></h3>
                                </div>
                                <div class="w3-clear"></div>
                                <h4>View All Report Logs</h4>
                            </div>
                        </a>
                    </div>
                </div>

            </div>
            <div class="w3-container w3-twothird w3-cell">
                <div class="w3-row-padding w3-padding-16 w3-margin w3-theme">
                    <div class="w3-card-4">   
                        <img src="img/managermain2.jpg" alt="image" style="width:100%; height: 100%">
                    </div>
                </div>
                
            </div>


            <% }%>
        </div>
<script type="text/javascript" src="js/index.js"></script>
            <script type="text/javascript" src="js/jquery-1.11.2.min.js"></script>
    </body>
</html>
