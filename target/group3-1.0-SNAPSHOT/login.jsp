<%-- 
    Document   : login
    Created on : Jan 27, 2023, 10:03:44 AM
    Author     : 236351
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <link href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,400italic,600,700' rel='stylesheet'type='text/css'>
        <link href="css/login.css" rel="stylesheet">
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/templatemo-style.css" rel="stylesheet">
        <link href="css/style.css" rel="stylesheet">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link href="https://fonts.googleapis.com/css2?family=Cinzel:wght@700&family=Nunito+Sans:wght@200&display=swap" rel="stylesheet">    
    </head>

    <body class="tm-gray-bg">
        <%
            String exist = (String) session.getAttribute("usernotexist");
            session.removeAttribute("usernotexist");
        %>
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
                                <li><a href="index.jsp">Home</a></li>
                                <li><a href="register.jsp">Register</a></li>                                
                                <li><a href="login.jsp" class="active">Login</a></li>
                            </ul>
                        </nav>
                    </div>
                </div>
            </div>
        </div>

        <div class="container">
            <p class="tip"></p>
            <div class="cont">
                    <form class="login" method="POST" action="LoginServlet">
                        <h2><label for="loginOptions">Login as:</label></h2>
                        <label>
                        <select class="dropmenu" name="loginOptions" id="loginOptions">
                            <option value="customer">Customer</option>
                            <option value="manager">Manager</option>
                            <option value="staff">Staff</option>                            
                        </select>
                        </label>
                        <label>
                        <span class="message" style="color: red; font-weight: bold"><%= (exist != null) ? exist : ""%></span>
                        <div class="login__field">
                            <label><i class="fa fa-envelope" aria-hidden="true"></i></label>
                            <input type="email" name="email" class="login__input" placeholder="Email">
                        </div>
                        <div class="login__field">
                            <label><i class="fa fa-key" aria-hidden="true"></i></label>
                            <input type="password" name="password" class="login__input" placeholder="Password">
                        </div>
                        <button class="button login__submit" style="background: #B18E72; color: white">
                            <span>Sign In Now</span>
                        </button>
                        </label>
                    </form>
                    <% exist = ""; %>
                </div>
            </div>    
    </body>
</html>
