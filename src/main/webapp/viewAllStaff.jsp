<%-- 
    Document   : viewAllStaff
    Created on : 28-Jan-2023, 10:31:34 AM
    Author     : Aiman
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
        <link href="css/templatemo-style.css" rel="stylesheet">
        <link href="css/style.css" rel="stylesheet">
        <link rel="stylesheet" href="css/w3.css"> 
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Cinzel:wght@700&family=Nunito+Sans:wght@200&display=swap" rel="stylesheet">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
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
        <div class="w3-row w3-border-bottom" >
            <div class="w3-col w3-container m6 l6 w3-margin-bottom" style="color:#333333;font-family: 'Nunito Sans'">
                <h3 style="font-family: 'Nunito Sans';font-weight: 700"><b>Staff List</b></h3>
                <p style="font-family: 'Nunito Sans';font-weight: 600"> Click on any Staff's Email to check their details. </p>
            </div>

            <div class="w3-col w3-container m6 l6 search"> 
                <form class="searchList example" method="POST" action="viewAllStaff.jsp">
                    <div class="w3-row"> 
                        <div class="w3-col m6" style="margin: 5px 0 " >  
                            <label for="searchOptions" style="padding: 10px;padding-right: 5px;font-size: 17px; border: none; color: #777777;font-family: 'Nunito Sans';;font-weight: 500";>Search By:</label>
                            <select name="searchOptions" id="searchOptions" style="marging-top:none;padding-right: 10px;font-size: 17px;border: none; border-radius: 3px;font-family: 'Nunito Sans';font-weight: 500">
                                <option value="email">Email</option>
                                <option value="ID">ID</option>                            
                            </select>
                        </div>
                        <div class="w3-col m6 l6 search_by" style="margin: 5px 0; display: flex; justify-content: flex-start; border: none">
                            <input type="text" name="search_value"class="search_field " placeholder="Search.." style="border: none; margin:2px; border-radius:5px">
                            <button type="submit" class="w3-button w3-border-white" style="background-color: #C8C2B9; width: 20%; border-radius:5px; margin:2px"><i class="fa fa-search"></i></button>
                            <button type="button" class="w3-button w3-border-white" style="background-color: #C8C2B9; width: 20%; border-radius:5px; margin:2px" onclick="window.location = 'viewAllStaff.jsp';" ><i class="fa fa-refresh"></i></button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
        <div class = "w3-container  w3-margin-top w3-white" >

            <table class="w3-table-all w3-hoverable" style="font-family: 'Nunito Sans'; font-weight: 700 ">
                <thead>
                    <tr class="w3-light-grey w3-text-dark-grey">
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
    </div>

</body>
</html>