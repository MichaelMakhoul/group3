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
        <title>Login</title>
        <link href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,400italic,600,700' rel='stylesheet'
              type='text/css'>
        <link href="css/font-awesome.min.css" rel="stylesheet">
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/bootstrap-datetimepicker.min.css" rel="stylesheet">
        <link href="css/flexslider.css" rel="stylesheet">
        <link href="css/templatemo-style.css" rel="stylesheet">
        <link href="css/login.css" rel="stylesheet">
    </head>

    <body class="tm-gray-bg">
        <%
            String exist = (String) session.getAttribute("usernotexist");
            session.removeAttribute("usernotexist");
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
                                <li><a href="register.jsp">Register</a></li>                                
                                <li><a href="login.jsp" class="active">Login</a></li>
                            </ul>
                        </nav>
                    </div>
                </div>
            </div>
        </div>

        <div class="container">
            <div class="screen">
                <div class="screen__content">
                    <form class="login" method="POST" action="LoginServlet">
                        <label for="loginOptions">Login as:</label>
                        <select name="loginOptions" id="loginOptions">
                            <option value="manager">Manager</option>
                            <option value="staff">Staff</option>
                            <option value="customer">Customer</option>
                        </select>
                        <span class="message"><%= (exist != null) ? exist : ""%></span>
                        <div class="login__field">
                            <i class="login__icon fas fa-user"></i>
                            <input type="text" name="email" class="login__input" placeholder="User name / Email">
                        </div>
                        <div class="login__field">
                            <i class="login__icon fas fa-lock"></i>
                            <input type="password" name="password" class="login__input" placeholder="Password">
                        </div>
                        <button class="button login__submit">
                            <span class="button__text">Log In Now</span>
                            <i class="button__icon fas fa-chevron-right"></i>
                        </button>
                    </form>
                    <div class="social-login">
                        <h3>log in via</h3>
                        <div class="social-icons">
                            <a href="#" class="social-login__icon fab fa-instagram"></a>
                            <a href="#" class="social-login__icon fab fa-facebook"></a>
                            <a href="#" class="social-login__icon fab fa-twitter"></a>
                        </div>
                    </div>
                </div>
                <div class="screen__background">
                    <span class="screen__background__shape screen__background__shape4"></span>
                    <span class="screen__background__shape screen__background__shape3"></span>
                    <span class="screen__background__shape screen__background__shape2"></span>
                    <span class="screen__background__shape screen__background__shape1"></span>
                </div>
            </div>
        </div>
    <% exist = ""; %>
    </body>
</html>
