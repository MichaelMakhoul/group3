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
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/bootstrap-datetimepicker.min.css" rel="stylesheet">  
        <link href="css/flexslider.css" rel="stylesheet">
        <link href="css/templatemo-style.css" rel="stylesheet">
        <link href="css/style.css" rel="stylesheet">
    </head>
    <body>
        <% Customers customers = (Customers) session.getAttribute("customers");%>
        <div>
            <table>
                <thead>
                <th> ID </th>
                <th> Name </th>
                <th> Email </th>
                <th> Phone </th>
                <th> DOB </th>
                </thead>
                <tbody>
                    <jsp:include page="StaffViewServlet" flush="true"/>
                </tbody>
            </table>
        </div>
    </body>
</html>
