<%-- 
    Document   : ViewReservations
    Created on : Jun 18, 2019, 10:21:47 AM
    Author     : imesh
--%>

<%-- 
    Document   : MakeReservation
    Created on : Jun 18, 2019, 9:00:53 AM
    Author     : imesh
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"/>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"/>
        <link rel="stylesheet" href="css/components.css">
      <link rel="stylesheet" href="css/icons.css">
      <link rel="stylesheet" href="css/responsee.css">
      <link rel="stylesheet" href="owl-carousel/owl.carousel.css">
      <link rel="stylesheet" href="owl-carousel/owl.theme.css"> 
      <!-- CUSTOM STYLE -->
      <link rel="stylesheet" href="css/template-style.css"> 
      <link href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700,800&subset=latin,latin-ext' rel='stylesheet' type='text/css'>
      <script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
      <script type="text/javascript" src="js/jquery-ui.min.js"></script>  
        <title>JSP Page</title>
    </head>
    <body>
        <jsp:include page="GuestNavbar.jsp"/>
        <div style="margin:20px">
            <table>
                <tr>
                    <th>id</th>
                    <th>Title</th>
                    <th>Description</th>
                    <th>Price</th>
                    <th>Date</th>
                </tr>
                <c:forEach items="${reservations}" var="reserve" varStatus="status">
                <tr>
                    <td>${reserve.id}</td>
                    <td>${posts[status.index].title}</td>
                    <td>${posts[status.index].desc}</td>
                    <td>${posts[status.index].price}</td>
                    <td>${reserve.date}</td>
                    
                </tr>
                </c:forEach>
            </table>
        </div>
    </body>
</html>

