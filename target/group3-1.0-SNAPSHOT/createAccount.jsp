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
    </head>

    <body class="tm-gray-bg">
        <%
            String message = (String) session.getAttribute("message");
            String emailError = (String) session.getAttribute("emailError");
            String passError = (String) session.getAttribute("passError");
            String dobError = (String) session.getAttribute("dobError");
//            session.removeAttribute("message");
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
                                <li><a href="staffMain.jsp">Main</a></li>                                
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
                        <!-- <label for="registerOptions">Register as:</label>
                        <select name="registerOptions" id="registerOptions">                            
                            <option value="staff">Staff</option>
                            <option value="customer">Customer</option>
                        </select> -->
                        
                        <span class="message"><%= (message != null) ? message : ""%></span>
                        <div class="register__field">
                            <i class="register__icon fas fa-user"></i>
                            <input type="text" name="create_name" class="register__input" placeholder="Name">
                        </div>
                        <div class="register__field">
                            <i class="register__icon fas fa-user"></i>
                            <input type="email" name="create_email" class="register__input" placeholder="Email">
                        </div>
                            <span class="message"><%= (emailError != null) ? emailError : ""%></span>
                        <div class="register__field">
                            <i class="register__icon fas fa-lock"></i>
                            <input type="password" name="create_password" class="register__input" placeholder="Password">
                        </div>
                            <span class="message"><%= (passError != null) ? passError : ""%></span>
                        <div class="register__field">
                            <i class="register__icon fas fa-lock"></i>
                            <input type="date" name="create_dob" class="register__input" placeholder="DOB">
                        </div>
                            <span class="message"><%= (dobError != null) ? dobError:  ""%></span>

                        <div class="register__field">
                            <i class="register__icon fas fa-lock"></i>
                            <input type="text" name="create_phoneNumber" class="register__input" placeholder="Phone Number">
                        </div>
                        <button class="button register__submit">
                            <span class="button__text">Create</span>
                            <i class="button__icon fas fa-chevron-right"></i>
                        </button>
                    </form>
                </div>
                <div class="screen__background">
                    <span class="screen__background__shape screen__background__shape4"></span>
                    <span class="screen__background__shape screen__background__shape3"></span>
                    <span class="screen__background__shape screen__background__shape2"></span>
                    <span class="screen__background__shape screen__background__shape1"></span>
                </div>
            </div>
        </div>
        <% 
//            String message = (String) session.getAttribute("message");
//            String emailError = (String) session.getAttribute("emailError");
//            String passError = (String) session.getAttribute("passError");
//            String dobError = (String) session.getAttribute("dobError");
            session.removeAttribute("message");
            session.removeAttribute("emailError");
            session.removeAttribute("passError");
            session.removeAttribute("dobError");
        %>
    </body>
</html>
