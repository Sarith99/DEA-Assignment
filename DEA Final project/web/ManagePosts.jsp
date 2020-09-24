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
        <jsp:include page="LocalNavbar.jsp"/>
        <div>
            <form action="./ManagePosts" method="GET" >
                <input type="text" name="process" value="AddPage" hidden/>
                <button style="margin:20px" class="btn btn-primary" >Add Post</button>
                
            </form>
            
        </div>
        <div style="margin:20px">
            <table>
                <tr>
                    <th>id</th>
                    <th>title</th>
                    <th>description</th>
                    <th>price</th>
                </tr>
                
                    <c:forEach var="name" items="${posts}">
                        <tr>
                        <td>${name.id}</td>
                        <td>${name.title}</td>
                        <td>${name.desc}</td>
                        <td>${name.price}</td>
                        </tr>
                    </c:forEach>
                
            </table>
        </div>
    </body>
</html>
