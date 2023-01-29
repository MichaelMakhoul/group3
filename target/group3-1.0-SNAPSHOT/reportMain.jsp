<%@page import="com.model.Booking"%>
<%@page import="com.model.Manager"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Report Logs</title>
    </head>
    <body>
        <% 
            Manager manager = (Manager) session.getAttribute("manager");
            Booking booking = (Booking) session.getAttribute("booking");
        %>
        <h1>Welcome to Report Log Page <%= manager.getManagerName() %></h1>
        <form action="ReportLogServlet" method="POST">
            <table class="table">
                <caption>Logs </caption>
                <tr><td>Booking:</td><td> <%= booking.getBookingID()%> </td></tr>
                <tr><td></td>
                    <td>
                        <input class="button" type="submit" value="Blog" />
                        <a class="button" style="float: right" href="main.jsp">Dashboard</a>
                    </td>
                </tr>
            </table>
        </form>
    </body>
</html>
