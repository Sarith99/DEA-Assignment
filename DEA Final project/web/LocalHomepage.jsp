<%-- 
    Document   : LocalHomeage
    Created on : Jun 18, 2019, 7:09:09 AM
    Author     : imesh
--%>

<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
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
        <jsp:include page="LocalNavbar.jsp"/>
        <div style="margin: 20px 100px;">
            <h4>Local Details</h4>
            <div>
                <table>
                    <tr>
                        <th>Name</th>
                        <th>Email</th>
                        <th>Gender</th>
                        <th>Contact Number</th>
                        <th>Business Type</th>
                        <th>Business Name</th>
                        <th>Interest</th>
                        <th>Special Note</th>
                    </tr>
                    <tr>
                        <td>${name}</td>
                        <td>${email}</td>
                        <td>${gender}</td>
                        <td>${cnumber}</td>
                        <td>${btype}</td>
                        <td>${bname}</td>
                        <td>${inter}</td>
                        <td>${snote}</td>
                    </tr>
                </table>
            </div>
        </div>
    </body>
</html>
