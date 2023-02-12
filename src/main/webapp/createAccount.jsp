<%-- 
    Document   : createAccount
    Created on : Jan 31, 2023, 12:36:43 AM
    Author     : 236351
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create Account</title>
        <link href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,400italic,600,700' rel='stylesheet' type='text/css'>
        <link href="https://fonts.googleapis.com/css2?family=Cinzel:wght@700&family=Nunito+Sans:wght@200&display=swap" rel="stylesheet">    
        <link href="css/templatemo-style.css" rel="stylesheet">
        <link rel="stylesheet" href="css/w3.css"> 
        <link href="css/bootstrap-datetimepicker.min.css" rel="stylesheet">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="css/style.css"> 
        <link href="css/bootstrap.min.css" rel="stylesheet">
    </head>

    <body class="tm-gray-bg">
        <%
            String message = (String) session.getAttribute("message");
            String nameError = (String) session.getAttribute("nameError");
            String emailError = (String) session.getAttribute("emailError");
            String passError = (String) session.getAttribute("passError");
            String dobError = (String) session.getAttribute("dobError");
            String phoneError = (String) session.getAttribute("phoneError");
        %>
        <section>
            <div class="tm-header">
                <div class="container py-5">
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
                                        <li><a href="main.jsp">Main</a></li>                                
                                        <li><a href="LogoutServlet">Logout</a></li>                                 
                                    </ul>
                                </nav>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class = "w3-content w3-border w3-margin-top w3-white" >
            <div class="w3-container w3-margin-top w3-border-bottom">
                <h3><b>Create New User Account</b></h3>                       
            </div>


            <div class="container-fluid"  style="font-size: large" >
                <div class="container py-3" style="margin-top: 80px" >
                    <div class="row">
                        <div class="col-lg-4">
                            <div class="card mb-4">
                                <div class="card-body text-center">
                                    <img src="img/Prof.png"class="rounded-circle img-fluid" style="width: 150px;">
                                </div>
                                <br>
                                <br>
                            </div>
                        </div>
                        <form method="POST" action="CreateAccountServlet">
                            <table style="margin-bottom: 40px; margin-top: -15px">
                                <% String color = (message != null && message.equals("User already exists")) ? "red" : "green"; %>
                                <caption><p style="color: <%= color %>; font-weight: bold"><%= (message != null) ? message : ""%></p></caption>
                                <tr><td>Name: </td><td><input style="margin: 7px 0;" type="text" name="name" placeholder="Name">
                                <p><%= (nameError != null) ? nameError : ""%></p></td></tr>

                                <tr><td>Email: </td><td><input style="margin: 7px 0;" type="email" name="email" placeholder="Email">
                                <p><%= (emailError != null) ? emailError : ""%></p></td></tr>

                                <tr><td>Password: </td><td><input style="margin: 7px 0;"type="password" name="password" placeholder="Password">
                                <p><%= (passError != null) ? passError : ""%></p></td></tr>

                                <tr><td>DOB: </td><td><input style="margin: 7px 0;" type="date" name="dob" placeholder="DOB">
                                <p ><%= (dobError != null) ? dobError : ""%></p></td></tr>

                                <tr><td>Phone: </td><td><input style="margin: 7px 0;" type="text" name="phoneNumber" placeholder="Phone Number">
                                <p><%= (phoneError != null) ? phoneError : ""%></p></td></tr>
                                <tr>
                                    <td>
                                        <br>
                                        <button type="submit" class="btn btn-primary ms-1" style="background: #519ECE; color: white">Create</button>
                                        <button type="button" class="btn btn-primary ms-1" style="background: #519ECE; color: white"><a href="main.jsp" style="color: white;">Cancel</a></button>
                                        <br>
                                    </td>
                                </tr>
                            </table>
                        </form>
                    </div>
                </div>
            </div>
        </div>              
        <%
            session.removeAttribute("message");
            session.removeAttribute("nameError");
            session.removeAttribute("emailError");
            session.removeAttribute("passError");
            session.removeAttribute("dobError");
            session.removeAttribute("phoneError");
        %>
         </section>
</body>
</html>
