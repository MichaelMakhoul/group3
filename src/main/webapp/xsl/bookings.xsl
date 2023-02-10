<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
    <xsl:output method="html"/>
    <xsl:template match="/">
        <html>
            <head>
                <title>Bookings View</title>
                <link href="css/w3.css" rel="stylesheet" type="text/css"></link>
            </head>
            <body>            
                <xsl:apply-templates/>
            </body>
        </html>
    </xsl:template>
    <xsl:template match="bookings">
        <table class="w3-table-all w3-hoverable">
            <thead>
                <tr class='w3-light-grey'>
                  <th>Booking ID</th>
                  <th>Customer ID</th>
                  <th>Check In</th>
                  <th>Check Out</th>
                  <th>Total Price</th>
                  <th>Total Rooms</th>                  
                </tr>
            </thead>
            <tbody>
                <xsl:apply-templates/>
            </tbody>
        </table>
    </xsl:template>
    <xsl:template match="/bookings/booking">
        <tr>
            <td>
                <xsl:variable name="ID" select="bookingID"></xsl:variable>
                <a style="color:black; font-weight: bold;" href="http://localhost:8080/group3/BookingServlet?ID={$ID}">
                <xsl:value-of select="bookingID"/>
                </a>
            </td>
            <td>
                <xsl:value-of select="customerID"/>
            </td>
            <td>
                <xsl:value-of select="checkIn"/>
            </td>
            <td>
                <xsl:value-of select="checkOut"/>
            </td>            
            <td>
                <xsl:value-of select="totalPrice"/>
            </td>
            <td>
                <xsl:value-of select="count(rooms/room)"/>
            </td>
        </tr>        
    </xsl:template>
</xsl:stylesheet>
