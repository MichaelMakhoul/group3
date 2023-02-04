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
                                <li><a href="main.jsp">Main</a></li>
                                <li><a href="account.jsp" class="active">Account</a></li>                                
                                <li><a href="LogoutServlet">Logout</a></li>
                            </ul>
                        </nav>		
                    </div>				
                </div>
            </div>	  	
        </div>

        <%
            String emailView = request.getParameter("emailView");
            UserDAO userDAO = (UserDAO) session.getAttribute("userDAO");
            User user = (User) session.getAttribute("user");
            String toUpdate = (user.getType().equals("staff")) ? "customer" : "staff";

            if (emailView != null) {
                user = userDAO.getUser(emailView, toUpdate);
            }
        %>

        <div>
            <div>
                <h2>Name: <%= (user != null) ? user.getName() : ""%></h2>
                <p><br>ID :<%= (user != null) ? user.getID() : ""%></p>                           
            </div>
            <div>
                <div>
                    <h3>Information</h3>
                    <div>                        
                        <div>
                            <h4>Email</h4>
                            <p><%= (user != null) ? user.getEmail() : ""%></p>
                        </div>
                        <div>
                            <h4>DOB</h4>
                            <p><%= (user != null) ? user.getDOB() : ""%></p>
                        </div>
                        <div>
                            <h4>Phone Number</h4>
                            <p><%= (user != null) ? user.getPhone() : ""%></p>
                        </div>
                        <li><a href="UserUpdateServlet">Update</a></li>
                        <li><a href="CustomerDeleteServlet">Delete</a></li>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
