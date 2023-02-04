<%-- 
    Document   : customerMain
    Created on : 28-Jan-2023, 10:31:34 AM
    Author     : 236336
--%>
<%@page import="com.model.Manager"%>
<%@page import="com.model.Customer"%>
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
                                <li><a href="index.jsp">Home</a></li>
                                <li><a href="main.jsp" class="active">Main</a></li>                                                              
                                <li><a href="LogoutServlet">Logout</a></li>
                            </ul>
                        </nav>		
                    </div>				
                </div>
            </div>	  	
        </div>
        <% String userType = (String) session.getAttribute("userType");
            if (userType.equals("customer")) { %>
        <% Customer customer = (Customer) session.getAttribute("user");%>
        <h1 class="welcome_message">Welcome <%= (customer != null) ? customer.getCustomerName() : ""%></h1>
        <div>
            <div class="col-lg-4 col-md-4 col-sm-6">
                <div class="tm-home-box-1 tm-home-box-1-2 tm-home-box-1-right">
                    <!--<img src="img/index-02.jpg" alt="image" class="img-responsive">-->
                    <a href="#">
                        <div class="tm-red-gradient-bg tm-city-price-container">
                            <span>Make your booking</span>
                            <!--                        <span>$4,200</span>-->
                        </div>	
                    </a>					
                </div>				
            </div>
            <div class="col-lg-4 col-md-4 col-sm-6">
                <div class="tm-home-box-1 tm-home-box-1-2 tm-home-box-1-right">
                    <!--<img src="img/index-02.jpg" alt="image" class="img-responsive">-->
                    <a href="#">
                        <div class="tm-red-gradient-bg tm-city-price-container">
                            <span>View your bookings</span>
                            <!--                        <span>$4,200</span>-->
                        </div>	
                    </a>					
                </div>				
            </div>
            <div class="col-lg-4 col-md-4 col-sm-6">
                <div class="tm-home-box-1 tm-home-box-1-2 tm-home-box-1-right">
                    <img src="img/Prof.png" alt="image" class="img-responsive">
                    <a href="#">
                        <div class="tm-red-gradient-bg tm-city-price-container">
                            <!--                        <span>User's Profile</span>-->
                            <span><li><a href="account.jsp">User's Profile</a></li></span>
                        </div>	
                    </a>					
                </div>				
            </div>
        </div>
        <% } else if (userType.equals("staff")) { %>
        <% Staff staff = (Staff) session.getAttribute("user");%>
        <h1 class="welcome_message">Welcome <%= (staff != null) ? staff.getStaffName() : ""%></h1>
        <div>
            <div class="col-lg-4 col-md-4 col-sm-6">
                <div class="tm-home-box-1 tm-home-box-1-2 tm-home-box-1-right">
                    <!--<img src="img/index-02.jpg" alt="image" class="img-responsive">-->
                    <a href="#">
                        <div class="tm-red-gradient-bg tm-city-price-container">
                            <span>Create a New Customer Account</span>
                            <!--                        <span>$4,200</span>-->
                        </div>	
                    </a>					
                </div>				
            </div>
            <div class="col-lg-4 col-md-4 col-sm-6">
                <div class="tm-home-box-1 tm-home-box-1-2 tm-home-box-1-right">
                    <!--<img src="img/index-02.jpg" alt="image" class="img-responsive">-->
                    <a href="customers.jsp">
                        <div class="tm-red-gradient-bg tm-city-price-container">
                            <span>View the list of customers</span>
                            <!--                        <span>$4,200</span>-->
                        </div>	
                    </a>					
                </div>				
            </div>
            <div class="col-lg-4 col-md-4 col-sm-6">
                <div class="tm-home-box-1 tm-home-box-1-2 tm-home-box-1-right">
                    <img src="img/Prof.png" alt="image" class="img-responsive">
                    <div class="tm-red-gradient-bg tm-city-price-container">
                        <span><li><a href="account.jsp">User's Profile</a></li></span>
                    </div>	
                </div>				
            </div>
        </div>
        <% } else if (userType.equals("manager")) { %>
        <% Manager manager = (Manager) session.getAttribute("user");%>
        <h1 class="welcome_message">Welcome <%= (manager != null) ? manager.getManagerName() : ""%></h1>
        <div>
            <div class="col-lg-4 col-md-4 col-sm-6">
                <div class="tm-home-box-1 tm-home-box-1-2 tm-home-box-1-right">
                    <!--<img src="img/index-02.jpg" alt="image" class="img-responsive">-->
                    <a href="addStaff.jsp">
                        <div class="tm-red-gradient-bg tm-city-price-container">
                            <span>Create a New Staff Account</span>
                            <!--                        <span>$4,200</span>-->
                        </div>	
                    </a>					
                </div>				
            </div>
            <div class="col-lg-4 col-md-4 col-sm-6">
                <div class="tm-home-box-1 tm-home-box-1-2 tm-home-box-1-right">
                    <!--<img src="img/index-02.jpg" alt="image" class="img-responsive">-->
                    <a href="viewAllStaff.jsp">
                        <div class="tm-red-gradient-bg tm-city-price-container">
                            <span>View the list of staff</span>
                        </div>	
                    </a>					
                </div>				
            </div>
        </div>
        <% }%>
    </body>
</html>
