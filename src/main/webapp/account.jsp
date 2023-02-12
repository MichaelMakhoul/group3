<%-- 
    Document   : account
    Created on : 31-Jan-2023, 5:50:15 PM
    Author     : Aiman, Antonella, Micheal
--%>

<%@page import="com.model.dao.UserDAO"%>
<%@page import="com.model.User"%>
<%@page import="com.model.Customer"%>
<%@page import="com.model.Staff"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Account</title>
        <link href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,400italic,600,700' rel='stylesheet' type='text/css'>
        <link href="https://fonts.googleapis.com/css2?family=Cinzel:wght@700&family=Nunito+Sans:wght@200&display=swap" rel="stylesheet">    
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link href="css/templatemo-style.css" rel="stylesheet">
        <link rel="stylesheet" href="css/w3.css">
        <link href="css/bootstrap-datetimepicker.min.css" rel="stylesheet">
        <link rel="stylesheet" href="css/style.css"> 
        <link href="css/bootstrap.min.css" rel="stylesheet">
    </head>
    <body class="tm-gray-bg">
        <%
            User userUpdate = (User) session.getAttribute("userUpdate");
            User currentUser = (User) session.getAttribute("user");
            User user = (userUpdate != null) ? userUpdate : currentUser;
            String userType = (String) session.getAttribute("userType");
        %>
        <div id="id01" style="z-index: 300;" class="w3-modal">
            <div class="w3-modal-content w3-card-4 w3-animate-zoom">
                <div class="w3-center"><br><span onclick="document.getElementById('id01').style.display = 'none'" class="w3-button w3-xlarge w3-hover-red w3-display-topright" title="Close Modal">&times;</span>
                </div>
                <form class="w3-container" action=<%=  (userType.equals("manager")) ? "StaffDeleteServlet" : "UserDeleteServlet"%>> 
                    <div class="w3-section"> 
                        <h2 style="text-align: center">Do you want to delete the user</h2>
                        <button class="w3-button w3-red w3-right w3-margin w3-round" type="submit">Delete</button>
                        <button onclick="document.getElementById('id01').style.display = 'none'" type="button" class="w3-button w3-dark-gray w3-round w3-right w3-margin">Cancel</button>
                    </div>
                </form>
            </div>
        </div>
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
                                <li><a href="main.jsp">Main</a></li>
                                    <% if (userType.equals("staff") && (userUpdate != null)) { %>
                                <li><a href="customers.jsp">Customers List</a></li>
                                    <% } else if (userType.equals("manager")){%>
                                <li><a href="viewAllStaff.jsp">Staff List</a></li>
                                    <% }%>                               
                                <li><a href="LogoutServlet">Logout</a></li>
                            </ul>
                        </nav>		
                    </div>				
                </div>
            </div>     
        </div>
        <div class = "w3-content w3-border w3-margin-top w3-white" >
            <div class="w3-container w3-margin-top w3-border-bottom">
                <h3><b>User Information</b></h3>                     
            </div>
            <div class="container-fluid"  style="font-size: large" >
                <div class="container py-3" style="margin-top: 80px" >
                    <div class="row">
                        <div class="col-lg-4">
                            <div class="card mb-4">
                                <div class="card-body text-center">
                                    <img src="img/Prof.png"class="rounded-circle img-fluid" style="width: 150px;">
                                    <h5 class="my-3"><br>ID :<%= (user != null) ? user.getID() : ""%></h5>
                                    <div class="d-flex justify-content-center mb-2">
                                        <button type="button" class="btn btn-primary ms-1" style="background: #519ECE; color: white" onclick="window.location = 'userUpdate.jsp';" >Update</button>
                                        <button type="button" class="btn btn-primary ms-1" style="background: #519ECE; color: white" onclick="document.getElementById('id01').style.display = 'flex'">Delete</button>
                                    </div>
                                    <br>
                                    <br>
                                    <br>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-6">
                                <div class="card mb-4 mb-md-0">
                                    <div class="card-body">
                                        <div class="col-lg-8">
                                            <div class="card mb-4">
                                                <div class="card-body">
                                                    <div class="row">
                                                        <div class="col-sm-3">
                                                            <p class="mb-0">Name</p>
                                                        </div>
                                                        <div class="col-sm-9">
                                                            <p class="text-muted mb-0"><%= (user != null) ? user.getName() : ""%></p>
                                                        </div>
                                                    </div>
                                                    <hr>
                                                    <div class="row">
                                                        <div class="col-sm-3">
                                                            <p class="mb-0">Email</p>
                                                        </div>
                                                        <div class="col-sm-9">
                                                            <p class="text-muted mb-0"><%= (user != null) ? user.getEmail() : ""%></p>
                                                        </div>
                                                    </div>
                                                    <hr>
                                                    <div class="row">
                                                        <div class="col-sm-3">
                                                            <p class="mb-0">DOB</p>
                                                        </div>
                                                        <div class="col-sm-9">
                                                            <p class="text-muted mb-0"><%= (user != null) ? user.getDOB() : ""%></p>
                                                        </div>
                                                    </div>
                                                    <hr>
                                                    <div class="row">
                                                        <div class="col-sm-3">
                                                            <p class="mb-0">Phone</p>
                                                        </div>
                                                        <div class="col-sm-9">
                                                            <p class="text-muted mb-0"><%= (user != null) ? user.getPhone() : ""%></p>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div> 
        </div>
        <script type="text/javascript" src="js/index.js"></script>
    </body>
</html>



