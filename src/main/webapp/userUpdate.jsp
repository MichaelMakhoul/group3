<%-- 
    Document   : userUpdate
    Created on : 04-Feb-2023, 2:32:01 PM
    Author     : 236336
--%>
<%@page import="com.model.dao.UserDAO"%>
<%@page import="com.model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Edit Profile</title>
        <link href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,400italic,600,700' rel='stylesheet' type='text/css'>
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/templatemo-style.css" rel="stylesheet">
        <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    </head>
    <body class="tm-gray-bg">                
        <%
            User user = (User) session.getAttribute("user");
            String message = (String) session.getAttribute("message");
            String nameError = (String) session.getAttribute("nameError");
            String passError = (String) session.getAttribute("passError");
            String dobError = (String) session.getAttribute("dobError");
            String phoneError = (String) session.getAttribute("phoneError");
            session.removeAttribute("nameError");
            session.removeAttribute("passError");
            session.removeAttribute("dobError");
            session.removeAttribute("phoneError");
            session.removeAttribute("message");
        %>
        <section>
            <div class="tm-header">
                <div class="container py-5">
                    <div class="tm-header">
                        <div class="container1">
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
                                            <li><a href="account.jsp">Account</a></li>
                                            <li><a href="" class="active">Edit Profile</a></li>                                
                                            <li><a href="LogoutServlet">Logout</a></li>                                 
                                        </ul>
                                    </nav>
                                </div>
                            </div>
                        </div>
                    </div>

                </div>
                <div class = "w3-content w3-border w3-margin-top w3-white" >
                    <div class="w3-container w3-margin-top w3-border-bottom">
                        <h3><b>Edit User </b></h3>                       
                    </div>
                    <div class="container-fluid"  style="font-size: large" >
                        <div class="container py-3" style="margin-top: 80px" >
                            <div class="row">
                                <div class="col-lg-4">
                                    <div class="card mb-4">
                                        <div class="card-body text-center">
                                            <img src="img/Prof.png"class="rounded-circle img-fluid" style="width: 150px;">
                                            <p class="text-muted mb-1"><br>Email :<%= (user != null) ? user.getEmail() : ""%></p>
                                            <h5 class="my-3"><br>ID :<%= (user != null) ? user.getID() : ""%></h5>
                                        </div>
                                        <br>
                                        <br>
                                    </div>
                                </div>
                                <form method="POST" action="UserUpdateServlet">
                                    <table>
                                        <caption><p><%= (message != null) ? message : ""%></p></caption>

                                        <tr><td>Name: </td><td><input type="text" name="name" value="<%= user.getName()%>" />
                                                <p><%= (nameError != null) ? nameError : ""%></p></td></tr>

                                        <tr><td>Password: </td><td><input type="password" name="password" value="<%= user.getPassword()%>" />
                                                <p><%= (passError != null) ? passError : ""%></p></td></tr>
                                        <tr><td>DOB: </td><td><input type="date" name="dob" value="<%= user.getDOB()%>"/>
                                                <p ><%= (dobError != null) ? dobError : ""%></p></td></tr>
                                        <tr><td>Phon Number: </td><td><input type="text" name="phoneNumber" value="<%= user.getPhone()%>"/>
                                                <p><%= (phoneError != null) ? phoneError : ""%></p></td></tr>
                                        <tr>

                                        <td>
                                            <br>
                                            <input class="button" type="submit" value="Update"/> 
                                        </td>
                                        </tr>
                                    </table>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>                   
            </div>

        </section>
    </body>
</html>
