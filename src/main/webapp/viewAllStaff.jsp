<%-- 
    Document   : managerMain
    Created on : 28-Jan-2023, 10:31:34 AM
    Author     : 236333
--%>

<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Manager Main</title>
        <link href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,400italic,600,700' rel='stylesheet' type='text/css'>
        <link href="css/font-awesome.min.css" rel="stylesheet">
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/bootstrap-datetimepicker.min.css" rel="stylesheet">  
        <link href="css/flexslider.css" rel="stylesheet">
        <link href="css/templatemo-style.css" rel="stylesheet">
        <link href="css/style.css" rel="stylesheet">
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
                                <li><a href="index.jsp">Home</a></li>
                                <li><a href="main.jsp" class="active">Main</a></li>                                                              
                                <li><a href="LogoutServlet">Logout</a></li>
                            </ul>
                        </nav>		
                    </div>				
                </div>
            </div>	  	
        </div>
        
        <div>
            <table class="customers_table">
                <thead>
                <th class="customers_table_th"> ID </th>
                <th class="customers_table_th"> Name </th>
                <th class="customers_table_th"> Email </th>
                <th class="customers_table_th"> Phone </th>
                <th class="customers_table_th"> DOB </th>
                </thead>
                <tbody class="customers_table_body">
                    <jsp:include page="ManagerViewServlet" flush="true"/>
                </tbody>
            </table>

<!--            <table  class="table">
                <tr><td colspan="2"><h2>Staff list</h2></td></tr>
                <tr><td>Staff member 1</td><td><a href="userUpdate.jsp">Update</a></td><td><a href="#">Delete</a></td></tr>
                <tr><td>Staff member 2</td><td><a href="#">Update</a></td><td><a href="#">Delete</a></td></tr>
                <tr><td>Staff member 3</td><td><a href="#">Update</a></td><td><a href="#">Delete</a></td></tr>
                <tr><td>Staff member 4</td><td><a href="#">Update</a></td><td><a href="#">Delete</a></td></tr>
                <tr><td>Staff member 5</td><td><a href="#">Update</a></td><td><a href="#">Delete</a></td></tr>
                
            </table>
           -->
            
        </div> 
       
    </body>
</html>