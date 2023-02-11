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
        <link href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,400italic,600,700' rel='stylesheet'
              type='text/css'>
        <link href="css/font-awesome.min.css" rel="stylesheet">
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/bootstrap-datetimepicker.min.css" rel="stylesheet">
        <link href="css/flexslider.css" rel="stylesheet">
        <link href="css/templatemo-style.css" rel="stylesheet">
        <link href="css/register.css" rel="stylesheet">
        <link href="css/style.css" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css2?family=Cinzel:wght@700&family=Nunito+Sans:wght@200&display=swap" rel="stylesheet">    
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
                                <li><a href="main.jsp">Main</a></li>                                
                                <li><a href="LogoutServlet">Logout</a></li>                                 
                            </ul>
                        </nav>
                    </div>
                </div>
            </div>
        </div>

        <div class="container">
            <div class="screen">
                <div class="screen__content">
                    <form class="register" method="POST" action="CreateAccountServlet">
                        <span class="message"><%= (message != null) ? message : ""%></span>

                        <div class="register__field">
                            <input type="text" name="name" class="register__input" value="<%= (nameError != null) ? nameError : "" %>" placeholder= <%= (nameError != null) ? nameError : "Name"%>>                            
                        </div>                        
                        <div class="register__field">
                            <input type="email" name="email" class="register__input" value="<%= (emailError != null) ? emailError : "" %>" placeholder=<%= (emailError != null) ? emailError : "Email"%>>
                        </div>
                        <div class="register__field">
                            <input type="password" name="password" class="register__input" placeholder=<%= (passError != null) ? passError : "Password"%>>
                        </div>
                        <div class="register__field">
                            <i class="register__icon fas fa-lock"></i>
                            <input type="text" name="dob" class="register__input" value="<%= (dobError != null) ? dobError : "" %>" onfocus="(this.type='date')" onblur="(this.type='text')" placeholder=<%= (dobError != null) ? dobError : "DOB"%>>
                        </div>
                        <div class="register__field">
                            <i class="register__icon fas fa-lock"></i>
                            <input type="text" name="phoneNumber" class="register__input" value="<%= (phoneError != null) ? phoneError : "" %>" placeholder=<%= (phoneError != null) ? phoneError : "Phone Number"%>>
                        </div>
                        
                        
                        <button class="button register__submit">
                            <span class="button__text">Create</span>
                            <i class="button__icon fas fa-chevron-right"></i>
                        </button>
                    </form>
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
    </body>
</html>
