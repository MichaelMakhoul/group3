<%-- 
    Document   : customers
    Created on : Jan 30, 2023, 9:55:01 PM
    Author     : 236351
--%>

<%@page import="com.model.Customers"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>View All Customers</title>
        <link href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,400italic,600,700' rel='stylesheet' type='text/css'>
        <link href="css/font-awesome.min.css" rel="stylesheet">
        <link href="css/customer_form.css" rel="stylesheet">
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/bootstrap-datetimepicker.min.css" rel="stylesheet">  
        <!--<link href="css/flexslider.css" rel="stylesheet">-->
        <link href="css/templatemo-style.css" rel="stylesheet">
        <link href="css/w3.css" rel="stylesheet">
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
                                <li><a href="main.jsp">Main</a></li>                                                              
                                <li><a href="LogoutServlet">Logout</a></li>
                            </ul>
                        </nav>		
                    </div>				
                </div>
            </div>	  	
        </div>

        <div class="list_form_wrapper">
            <div class="search_form">
                <form class="form" method="POST" action="customers.jsp">
                    <label for="searchOptions">Search By:</label>
                    <select name="searchOptions" id="searchOptions">
                        <option value="email">Email</option>
                        <option value="ID">ID</option>                            
                    </select>

                    <div class="search_by">
                        <input type="text" name="search_value" autofocus>
                    </div>
                    <button class="button search_submit">Search</button>
                    <a href="customers.jsp" style="color: #000;" class="button search_submit" >Cancel</a>
                </form>
            </div>

            <div class="w3-content w3-border w3-margin-top w3-white users_list" >
                <table class="w3-table-all w3-hoverable">
                    <thead><tr class='w3-light-grey'>
                            <th class="w3-container w3-margin"> ID </th>
                            <th class="w3-container w3-margin"> Name </th>
                            <th class="w3-container w3-margin"> Email </th>
                            <th class="w3-container w3-margin"> Phone </th>
                            <th class="w3-container w3-margin"> DOB </th>
                    </thead>
                    <tbody>
                        <jsp:include page="StaffViewServlet" flush="true"/>
                    </tbody>
                </table>
            </div>
        </div>
    </body>
</html>
