
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
        <link href="https://fonts.googleapis.com/css2?family=Cinzel:wght@700&family=Nunito+Sans:wght@200&display=swap" rel="stylesheet">    
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
                                <li><a href="main.jsp" >Manager Main</a></li>                                                              
                                <li><a href="LogoutServlet">Logout</a></li>
                            </ul>
                        </nav>		
                    </div>				
                </div>
            </div>	  	
        </div>
        <div>
            <form class="login" method="POST" action="reportView.jsp">
                <label for="searchOptions">Search By ID:</label>
                <div class="login__field">
                    <input type=number name="search_value">
                </div>
                <button class="button login__submit">Search</button>
                <a href="reportView.jsp" style="color: #000;" class="button login__submit" >Cancel</a>
            </form>
        </div>
        <div class="customers_table_div">
            <table class="customers_table">
                <thead>
                <th class="customers_table_th"> ID </th>
                <th class="customers_table_th"> Report Start Date </th>
                <th class="customers_table_th"> Report End Date </th>
                <th class="customers_table_th"> Number Of Rooms Booked </th>
                <th class="customers_table_th"> Revenue </th>
                <th class="customers_table_th"> Created Date Of Report </th>
                </thead>
                <tbody class="customers_table_body">
                    <jsp:include page="ReportLogViewServlet" flush="true"/>
                </tbody>
            </table>
        </div>
    </body>
</html>
