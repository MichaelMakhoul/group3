<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%-- 
    Document   : reportSummary
    Created on : 04-Feb-2023, 2:32:01 PM
    Author     : Monte
--%>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>View Report Summary</title>
        <link href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,400italic,600,700' rel='stylesheet' type='text/css'>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link href="https://fonts.googleapis.com/css2?family=Cinzel:wght@700&family=Nunito+Sans:wght@200&display=swap" rel="stylesheet">    
        <link href="css/font-awesome.min.css" rel="stylesheet">
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/bootstrap-datetimepicker.min.css" rel="stylesheet">  
        <link href="css/flexslider.css" rel="stylesheet">
        <link href="css/templatemo-style.css" rel="stylesheet">
        <link href="css/customer_form.css" rel="stylesheet">
        <link href="css/w3.css" rel="stylesheet">
    </head>
    <body class="tm-gray-bg">
        <% int reportLogID = Integer.parseInt(request.getParameter("reportLogID"));
            session.setAttribute("reportLogID", reportLogID);
        %>
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
                                <li><a href="main.jsp" >Main</a></li>
                                <li><a href="reportView.jsp">Report Logs</a></li>                                
                                <li><a href="LogoutServlet">Logout</a></li>
                            </ul>
                        </nav>		
                    </div>				
                </div>
            </div>	  	
        </div>
        <div class="w3-row w3-border-bottom" >
            <div class="w3-col w3-container m6 l6 w3-margin-bottom" style="color:#333333;font-family: 'Nunito Sans'">
                <h3 style="font-family: 'Nunito Sans';font-weight: 700"><b>Report Summary List</b></h3>
                <p style="font-family: 'Nunito Sans';font-weight: 600"> Viewing Report Summary of selected Report Log. </p>
            </div>
            <div class="w3-col w3-container m6 l6 search" style="width: 50%; display: flex; justify-content: space-around; margin-top: 20px; margin-bottom: 20px;">        
                <button style="min-width: 40px; border-radius: 3px;" type="button" onclick="window.location = 'ReportDeleteServlet';"><i class="fa fa-trash-o"></i> Delete</button>
            </div>
            <div class="w3-container  w3-margin-top" >
                <table class="w3-table-all w3-hoverable" style="font-family: 'Nunito Sans'; font-weight: 700 ">
                    <thead>
                        <tr class="w3-light-grey w3-text-dark-grey">
                            <th class="w3-container w3-margin"> Booking ID </th>
                            <th class="w3-container w3-margin"> Customer Check In </th>
                            <th class="w3-container w3-margin"> Customer Check Out </th>
                            <th class="w3-container w3-margin"> Number Of Rooms Booked </th>
                            <th class="w3-container w3-margin"> Booking Total Price </th>
                        </tr>
                    </thead>
                    <tbody class="customers_table_body">                   
                        <jsp:include page="ReportSummaryViewServlet" flush="true"/>                    
                    </tbody>
                </table>
            </div>
        </div>
    </body>
</html>
