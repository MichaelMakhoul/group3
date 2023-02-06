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
    </head>
    <body>
        <%
            String userType = (String) session.getAttribute("userType");
            User user = (User) session.getAttribute("user");
            session.removeAttribute("userUpdate");
        %>
        <div class="tm-header">
            <div class="container">
                <div >
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

                                <!--<img src="img/Prof.png" alt="image" class="img-responsive">-->
                                <% if (!userType.equals("manager")) { %>
                                <li class="tm-nav-right"><a href="account.jsp">User's Profile</a></li> 
                                    <% } %>
                            </ul>                    

                        </nav>		
                    </div>				
                </div>
            </div>	  	
        </div>

        <%
            if (userType.equals("customer")) {
        %>
        <h1 class="welcome_message">Welcome <%= (user != null) ? user.getName() : ""%></h1>
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
        </div>
        <% } else if (userType.equals("staff")) {%>
        <h1 class="welcome_message">Welcome <%= (user != null) ? user.getName() : ""%></h1>
        <div>
            <div class="col-lg-4 col-md-4 col-sm-6">
                <div class="tm-home-box-1 tm-home-box-1-2 tm-home-box-1-right">
                    <!--<img src="img/index-02.jpg" alt="image" class="img-responsive">-->
                    <a href="createAccount.jsp">
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
        </div>
        <% } else if (userType.equals("manager")) {
            Manager manager = (Manager) session.getAttribute("manager");%>
        <h1 class="welcome_message">Welcome <%= (manager != null) ? manager.getManagerName() : ""%></h1>
        <div>
            <div class="col-lg-4 col-md-4 col-sm-6">
                <div class="tm-home-box-1 tm-home-box-1-2 tm-home-box-1-right">
                    <!--<img src="img/index-02.jpg" alt="image" class="img-responsive">-->
                    <a href="#">
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
                    <a href="#">
                        <div class="tm-red-gradient-bg tm-city-price-container">
                            <span>View the list of staff</span>
                        </div>	
                    </a>					
                </div>				
            </div>
            <div class="col-lg-4 col-md-4 col-sm-6">
                <div class="tm-home-box-1 tm-home-box-1-2 tm-home-box-1-right">      
                          <a href="addReportLog.jsp">
                        <div class="tm-red-gradient-bg tm-city-price-container">
                            <span>Create A Report Log</span>
                        </div>	
                    </a>					
                </div>
            </div>
            <div class="col-lg-4 col-md-4 col-sm-6">
                <div class="tm-home-box-1 tm-home-box-1-2 tm-home-box-1-right">
                          <a href="reportView.jsp">
                        <div class="tm-red-gradient-bg tm-city-price-container">
                            <span>View All Report Logs</span>
                        </div>	
                    </a>					
                </div>
            </div>
        </div>
        <% }%>
    </body>
</html>
