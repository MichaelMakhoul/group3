<%-- 
    Document   : register
    Created on : 27-Jan-2023, 2:43:17 PM
    Author     : 236336
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register</title>
        <link href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,400italic,600,700' rel='stylesheet'type='text/css'>
        <link href="css/register.css" rel="stylesheet">
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/templatemo-style.css" rel="stylesheet">   
    </head>

    <body class="tm-gray-bg">
        <%
            String exist = (String) session.getAttribute("error");
            String nameError = (String) session.getAttribute("nameError");
            String emailError = (String) session.getAttribute("emailError");
            String passError = (String) session.getAttribute("passError");
            String dobError = (String) session.getAttribute("dobError");
            String phoneError = (String) session.getAttribute("phoneError");
            session.removeAttribute("error");
            session.removeAttribute("nameError");
            session.removeAttribute("emailError");
            session.removeAttribute("passError");
            session.removeAttribute("dobError");
            session.removeAttribute("phoneError");
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
                                <li><a href="register.jsp" class="active">Register</a></li>                                
                                <li><a href="login.jsp">Login</a></li>                                 
                            </ul>
                        </nav>
                    </div>
                </div>
            </div>
        </div>
        <div class="container">
            <p class="tip"></p>
            <div class="cont">
                <form class="register" method="POST" action="RegisterServlet">
                    <h2><label for="registerOptions">Register as:</label></h2>
                    <label>
                        <select class="dropmenu" name="registerOptions" id="registerOptions">
                            <option value="customer">Customer</option>
                            <option value="staff">Staff</option>                            
                        </select>
                    </label>
                    <label>
                        <span class="message"><%= (exist != null) ? exist : ""%></span>
                        <div class="register__field">
                            <input type="text" name="name" class="register__input" placeholder= <%= (nameError != null) ? nameError : "Name"%>>                            
                        </div>                        
                        <div class="register__field">
                            <input type="email" name="email" class="register__input" placeholder=<%= (emailError != null) ? emailError : "Email"%>>
                        </div>
                        <div class="register__field">
                            <input type="password" name="password" class="register__input" placeholder=<%= (passError != null) ? passError : "Password"%>>
                        </div>
                        <div class="register__field">
                            <i class="register__icon fas fa-lock"></i>
                            <input type="text" name="dob" class="register__input" onfocus="(this.type='date')" onblur="(this.type='text')" placeholder=<%= (dobError != null) ? dobError : "DOB"%>>
                        </div>
                        <div class="register__field">
                            <i class="register__icon fas fa-lock"></i>
                            <input type="text" name="phoneNumber" class="register__input" placeholder=<%= (phoneError != null) ? phoneError : "Phone Number"%>>
                        </div>
                    <button class="button register__submit">
                        <span>Sign Up Now</span>
                    </button>
                    </label>
                </form>
                <% exist = "";%>      
            </div>           
        </div>
    </div>
</div>
</body>
</html>

