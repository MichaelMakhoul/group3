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
    </head>
    <body class="tm-gray-bg">                
        <%
            User userUpdate = (User) session.getAttribute("userUpdate");
            User currentUser = (User) session.getAttribute("user");
            User user = (userUpdate != null) ? userUpdate : currentUser;
            
            String emailView = (String) session.getAttribute("emailView");

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
        <div class="tm-header">
            <div class="container1">
                <div class="row">
                    <div class="col-lg-6 col-md-4 col-sm-3 tm-site-name-container">                        	
                        <p style="font-family: 'Cinzel', serif;font-size:230%; color: #565656">The Grand Serene</p>
                    </div>
                    <div class="col-lg-6 col-md-8 col-sm-9">
                        <div class="mobile-menu-icon">
                            <i class="fa fa-bars"></i>
                        </div>
                        <nav class="tm-nav">
                            <ul>
                                <li><a href="index.jsp">Home</a></li>
                                <li><a href="account.jsp">Account</a></li>
                                <li><a href="" class="active">Edit Profile</a></li>                                
                                <li><a href="LogoutServlet">Logout</a></li>                                 
                            </ul>
                        </nav>
                    </div>
                </div>
            </div>
        </div>        
        <div>
            <form method="POST" action=<%= (emailView != null) ? "CustomerUpdateServlet" : "UserUpdateServlet"%>>
                <table>
                    <caption>Edit User <p><%= (message != null) ? message : ""%></p></caption>
                    <tr><td>ID: </td><td><input type="text" name="ID" value="<%= user.getID()%>" readonly="true" /></td></tr>
                    <tr><td>Name: </td><td><input type="text" name="name" value="<%= user.getName()%>" />
                            <p><%= (nameError != null) ? nameError : ""%></p></td></tr>
                    <tr><td>Email: </td><td><input type="text" name="email" value="<%= user.getEmail()%>" readonly="true"/></td></tr>
                    <tr><td>Password: </td><td><input type="password" name="password" value="<%= user.getPassword()%>" />
                            <p><%= (passError != null) ? passError : ""%></p></td></tr>
                    <tr><td>DOB: </td><td><input type="date" name="dob" value="<%= user.getDOB()%>"/>
                            <p ><%= (dobError != null) ? dobError : ""%></p></td></tr>
                    <tr><td>Phon Number: </td><td><input type="text" name="phoneNumber" value="<%= user.getPhone()%>"/>
                            <p><%= (phoneError != null) ? phoneError : ""%></p></td></tr>
                    <tr>
                        <td>
                            <input class="button" type="submit" value="Update"/> 
                        </td>
                    </tr>
                </table>
            </form>
        </div>
    </body>
</html>
