<%-- 
    Document   : managerMain
    Created on : 28-Jan-2023, 10:31:34 AM
    Author     : 236333
--%>

<%@page import="com.model.Manager"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Manager Main</title>
        <link href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,400italic,600,700' rel='stylesheet' type='text/css'>
        <link href="css/font-awesome.min.css" rel="stylesheet">
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/bootstrap-datetimepicker.min.css" rel="stylesheet">  
        <link href="css/flexslider.css" rel="stylesheet">
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
                                <li><a href="managerMain.jsp" class="active">Manager Main</a></li>                                                              
                                <li><a href="LogoutServlet">Logout</a></li>
                            </ul>
                        </nav>		
                    </div>				
                </div>
            </div>	  	
        </div>
        <% Manager manager = (Manager) session.getAttribute("userType");%>
        <h1 class="welcome_message">Welcome <%= manager.getManagerName()%></h1>
        <div>
        <div class="col-lg-4 col-md-4 col-sm-6">
            <div class="tm-home-box-1 tm-home-box-1-2 tm-home-box-1-right">
                
                <a href="viewAllStaff.jsp">
                    <div class="tm-red-gradient-bg tm-city-price-container">
                        <span>View All Staff</span>
                    </div>	
                </a>					
            </div>				
        </div>
        <div class="col-lg-4 col-md-4 col-sm-6">
            <div class="tm-home-box-1 tm-home-box-1-2 tm-home-box-1-right">               
                <a href="addStaff.jsp">
                    <div class="tm-red-gradient-bg tm-city-price-container">
                        <span>Add new staff member</span>
                    </div>	
                </a>					
            </div>				
        </div>
        
        </div>
    </body>
</html>