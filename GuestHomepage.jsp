<%-- 
    Document   : GuestHomapage
    Created on : Jun 18, 2019, 8:32:53 AM
    Author     : imesh
--%>

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
        <div style="margin: 20px 100px;">
            <h4>Guest Details</h4>
            <div>
                <table>
                    <tr>
                        <th>Name</th>
                        <th>Email</th>
                        <th>Gender</th>
                        <th>Contact Number</th>
                        <th>Interest</th>
                        <th>Special Note</th>
                        <th>Arrival Date</th>
                        <th>Depart Date</th>
                    </tr>
                    <tr>
                        <td>${name}</td>
                        <td>${email}</td>
                        <td>${gender}</td>
                        <td>${cnumber}</td>
                        <td>${inter}</td>
                        <td>${snote}</td>
                        <td>${adate}</td>
                        <td>${ddate}</td>
                    </tr>
                </table>
            </div>
        </div>
    </body>
</html>

