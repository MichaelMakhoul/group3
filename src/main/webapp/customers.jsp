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
        <link href="css/flexslider.css" rel="stylesheet">
        <link href="css/templatemo-style.css" rel="stylesheet">
        <link href="css/w3.css" rel="stylesheet">
        <link rel="stylesheet" href="css/search.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

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

        <% 
            String deleteMessage = (String) (session.getAttribute("deletedUser"));
            session.removeAttribute("deletedUser");
        %>
        <div id="id01" class="w3-modal" style="display: <%= (deleteMessage != null) ? "flex" : "none"%>;">
            <div class="w3-modal-content w3-card-4 w3-animate-zoom" >
                <div class="w3-center"><br>
                    <span onclick="document.getElementById('id01').style.display = 'none'" class="w3-button w3-xlarge w3-hover-red w3-display-topright" title="Close Modal">&times;</span>      
                </div>
                <div class="popup-div w3-container">
                    <div class="w3-section">
                        <h2 class="popup-h2"> <%= (deleteMessage != null) ? deleteMessage : ""%> </h2>
                        <button class="w3-button w3-red w3-right w3-margin w3-round" onclick="document.getElementById('id01').style.display = 'none'">close</button>
                    </div>
                </div>
            </div>
        </div>

        <div class = "w3-container  w3-margin-top w3-white">
            <div class="w3-row w3-border-bottom" >
                <div class="w3-col w3-container m6 l6 w3-margin-bottom">
                    <h3><b>Customers List</b></h3>
                    <p> Click on any Customer's Email to check their details. </p>
                </div>

                <div class="w3-col w3-container m6 l6 search"> 
                    <form class="searchList example" method="POST" action="customers.jsp">
                        <div class="w3-row"> 
                            <div class="w3-col m6 l6" style="margin-top: 5px; margin-bottom: 5px;" >  
                                <label for="searchOptions" style="padding: 13px;font-size: 17px">Search By:</label>
                                <select name="searchOptions" id="searchOptions" style="padding: 15px;font-size: 17px;border: 1px solid grey; border-radius: 5px;">
                                    <option value="email">Email</option>
                                    <option value="ID">ID</option>                            
                                </select>
                            </div>
                            <div class="w3-col m6 l6 search_by" style="margin: 5px 0; display: flex; justify-content: space-around">
                                <input type="text" name="search_value" autofocus class="search_field m6" placeholder="Search..">
                                <button style="background: #1eb860; border-radius: 5px; margin: 0 2px;" type="submit"><i class="fa fa-search"></i></button>
                                <button style="border-radius: 5px; margin: 0 2px;" type="button" onclick="window.location = 'customers.jsp';" ><i class="fa fa-refresh"></i></button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>

            <div class="w3-container w3-margin-top ">
                <table class="w3-table-all w3-hoverable">
                    <thead>
                        <tr class='w3-light-grey'>
                            <th class=""> ID </th>
                            <th class=""> Name </th>
                            <th class=""> Email </th>
                            <th class=""> Phone </th>
                            <th class=""> DOB </th>
                        </tr>
                    </thead>
                    <tbody>
                        <jsp:include page="StaffViewServlet" flush="true"/>
                    </tbody>
                </table>
            </div>
        </div>
    </body>
</html>
