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
        <title>View All Staff</title>
        <link href="css/font-awesome.min.css" rel="stylesheet">
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/bootstrap-datetimepicker.min.css" rel="stylesheet">  
        <link href="css/flexslider.css" rel="stylesheet">
        <link href="css/templatemo-style.css" rel="stylesheet">
        <link href="css/style.css" rel="stylesheet">
        <link rel="stylesheet" href="css/w3.css"> 
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Cinzel:wght@700&family=Nunito+Sans:wght@200&display=swap" rel="stylesheet">    
        
    </head>
    <body class="tm-gray-bg">
        <div class="tm-header">
            <div class="container">
                <div class="row">
                    <div class="col-lg-6 col-md-4 col-sm-3 tm-site-name-container tm-site-name">                        	
                        <p style="font-family: 'Cinzel', serif; color: #565656">The Grand Serene</p>
                    </div>
                    <div class="col-lg-6 col-md-8 col-sm-9">
                        <div class="mobile-menu-icon">
                            <i class="fa fa-bars"></i>
                        </div>
                        <nav class="tm-nav" >
                            <ul>
                                <li><a href="main.jsp">Main</a></li>                                                              
                                <li><a href="LogoutServlet">Logout</a></li>
                            </ul>
                        </nav>		
                    </div>				
                </div>
            </div>	  	
        </div>

             <div class = "w3-content  w3-margin-top w3-white" >

            <table class="w3-table-all w3-hoverable" style="font-family: helvetica; font-weight: italic ">
                <thead>
                    <tr class='w3-light-grey'>
                        <th class="w3-container w3-margin"> ID </th>
                        <th class="w3-container w3-margin"> NAME </th>
                        <th class="w3-container w3-margin"> EMAIL </th>
                        <th class="w3-container w3-margin"> PHONE </th>
                        <th class="w3-container w3-margin"> DOB </th>
                </thead>
                <tbody>
                    <jsp:include page="ManagerViewServlet" flush="true"/>
                </tbody>
            </table>
            </div>


    </body>
</html>