<%-- 
    Document   : account
    Created on : 31-Jan-2023, 5:50:15 PM
    Author     : 236336
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
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/templatemo-style.css" rel="stylesheet">
        <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">  
    </head>
    <body class="tm-gray-bg">
        <section>
            <div class="tm-header">
                <div class="container py-5">
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
                                    <li><a href="main.jsp">Main</a></li>
                                    <li><a href="account.jsp" class="active">Account</a></li>                                
                                    <li><a href="LogoutServlet">Logout</a></li>
                                </ul>
                            </nav>		
                        </div>				
                    </div>

                </div>        
                <div class = "w3-content w3-border w3-margin-top w3-white" >
                    <div class="w3-container w3-margin-top w3-border-bottom">
                        <h3><b>User Information</b></h3>                       
                        <body>

                            <%
                                User userUpdate = (User) session.getAttribute("userUpdate");
                                User currentUser = (User) session.getAttribute("user");
                                User user = (userUpdate != null) ? userUpdate : currentUser;
                                String userType = (String) session.getAttribute("userType");
                            %>

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
                                                    <li><a href="main.jsp">Main</a></li>
                                                    <li><a href="account.jsp" class="active">Account</a></li>                                
                                                    <li><a href="LogoutServlet">Logout</a></li>
                                                </ul>
                                            </nav>		
                                        </div>				
                                    </div>
                                </div>	  	
                            </div>
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
                                                <button type="button" class="btn btn-outline-primary ms-1"><a href="userUpdate.jsp">Update</a></button>
                                                    <% if (userType == "manager") { %>
                                                <button type="button" class="btn btn-outline-primary ms-1"><a href="StaffDeleteServlet">Delete</a></button>
                                                <% } else { %>
                                                <button type="button" class="btn btn-outline-primary ms-1"><a href="UserDeleteServlet">Delete</a></button>
                                                <% }%>

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
            </div>

        </div>

    </section>                    

</body>
</html>



