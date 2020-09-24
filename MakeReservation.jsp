<%-- 
    Document   : MakeReservation
    Created on : Jun 18, 2019, 9:00:53 AM
    Author     : imesh
--%>
<%-- 
    Document   : ManagePosts
    Created on : Jun 18, 2019, 7:25:16 AM
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
        <div>
            <form action="MakeReservation" method="GET" >
                <input type="text" name="process" value="my-reservations" hidden/>
                <button style="margin:20px 20px 10px 20px" class="btn btn-primary" >View My Reservations</button>
            </form>
            
        </div>
        <div style="margin:20px">
            <c:choose>
                <c:when test="${reserved}">
                    <script>alert("Reservation Successfully!");
                    </script>
                </c:when>
                <c:when test="${reserved==false}">
                    <script>alert("Reservation Un-Successfully!");
                    </script>
                </c:when>
            </c:choose>
            <table>
                <tr>
                    <th>title</th>
                    <th>description</th>
                    <th>price</th>
                    <th></th>
                </tr>
                
                    <c:forEach var="name" items="${posts}">
                        <tr>
                            <td>${name.title}</td>
                            <td>${name.desc}</td>
                            <td>${name.price}</td>
                            <td>
                                <form action="MakeReservation" method="post">
                                    <input type="text" name="process" value="reserve" hidden/>
                                    <input type="text" name="id" value="${name.id}" hidden/>
                                    <label>Reserve Date : </label>
                                    <input type="date" name="date" /><br>
                                    <input type="submit" value="Make Reservation" class="btn btn-success"/><br>
                                </form>
                            </td>
                        </tr>
                    </c:forEach>
                
            </table>
        </div>
    </body>
</html>

