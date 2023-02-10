
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>View All Report Logs</title>
        <link href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,400italic,600,700' rel='stylesheet' type='text/css'>
        <link href="css/font-awesome.min.css" rel="stylesheet">
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/bootstrap-datetimepicker.min.css" rel="stylesheet">  
        <link href="css/flexslider.css" rel="stylesheet">
        <link href="css/templatemo-style.css" rel="stylesheet">
        <link href="css/customer_form.css" rel="stylesheet">
        <link rel="stylesheet" href="css/w3.css">  
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
                                <li><a href="main.jsp" >Main</a></li>                                                              
                                <li><a href="LogoutServlet">Logout</a></li>
                            </ul>
                        </nav>		
                    </div>				
                </div>
            </div>	  	
        </div>
        <div class = "w3-container  w3-margin-top w3-white">
            <div class="w3-row w3-border-bottom" style="display: flex; align-content: center">
                <div class="w3-col w3-container m6 l6 w3-margin-bottom">
                    <h3><b>Report Log List</b></h3>
                    <p> Click on any Report ID to check Report Summary. </p>
                </div>
                <div class="w3-col w3-container m6 l6 search" style="width: 50%; display: flex; justify-content: space-around; margin-top: 5px; " >
                    <label for="search_value" style="padding: 7px;font-size: 17px">Search By ID:</label>
                    <form  style="display: flex; height: 60%;" class="searchList" method="POST" action="reportView.jsp">
                        <input type="number" name="search_value" autofocus class="search_field" placeholder="Search..">
                        <button style="margin: 0 3px; min-width: 60px; background: #1eb860; border-radius: 5px;" type="submit"><i class="fa fa-search"></i></button>
                        <button style="min-width: 60px; border-radius: 5px;" type="button" onclick="window.location = 'reportView.jsp';"><i class="fa fa-retweet"></i></button>
                    </form>
                </div>
            </div>
        <div class="w3-container w3-margin-top ">
            <table class="w3-table-all w3-hoverable">
                <thead>
                    <tr class='w3-light-grey'>
                        <th class=""> ID </th>
                        <th class=""> Report Start Date </th>
                        <th class=""> Report End Date </th>
                        <th class=""> Number Of Rooms Booked </th>
                        <th class=""> Revenue </th>
                        <th class=""> Created Date Of Report </th>
                    </tr> 
                </thead>
                <tbody>
                    <jsp:include page="ReportLogViewServlet" flush="true"/>
                </tbody>
            </table>
        </div>
    </div>
</body>
</html>
