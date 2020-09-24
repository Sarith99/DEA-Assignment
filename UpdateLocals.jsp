<%-- 
    Document   : UpdateLocals
    Created on : Jun 18, 2019, 12:20:05 AM
    Author     : imesh
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        <h4>Update Locals</h4>
        <form action="http://localhost:8080/DEAFINAL/Adminservlet" method="post">
            <input type="text" name="process" value="update-details" hidden/>
            <input type="text" name="id" value="${id}" hidden/>
            <label>Name</label><br>
            <input type="text" name="name" value="${name}"/><br>
            <label>Gender</label><br>
            <select name="gender">
                <c:choose>
                    <c:when test="${gender=='null'}">
                        <option value="" selected="selected"></option>
                    </c:when>
                    <c:otherwise>
                        <option value=""></option>
                    </c:otherwise>  
                </c:choose>
                <c:choose>
                    <c:when test="${gender=='male'}">
                        <option value="male" selected="selected">Male</option>
                    </c:when>
                    <c:otherwise>
                        <option value="male">Male</option>
                    </c:otherwise>  
                </c:choose>
                <c:choose>
                    <c:when test="${gender=='female'}">
                        <option value="female" selected="selected">Female</option>
                    </c:when>
                    <c:otherwise>
                        <option value="female">Female</option>
                    </c:otherwise> 
                </c:choose>
                <c:choose>
                    <c:when test="${gender=='other'}">
                        <option value="other" selected="selected">Other</option>
                    </c:when>
                    <c:otherwise>
                        <option value="other">Other</option>
                    </c:otherwise> 
                </c:choose>
            </select><br>
            <label>Email</label><br>
            <input type="text" name="email" value="${email}"/><br>
            <label>Contact Number</label><br>
            <input type="number" name="cnumber" value="${cnumber}"/><br>
            <label>Business Type</label><br>
            
            <select name="btype">
                
                <option value="" disabled selected>Gender</option>                
                <c:choose>
                    <c:when test="${btype=='null'}">
                        <option value="" selected></option>
                    </c:when>
                    <c:otherwise>
                        <option value=""></option>
                    </c:otherwise>
                </c:choose>
                <c:choose>
                    <c:when test="${btype=='Food'}">
                        <option value="Food" selected>Food&Beverage</option>
                    </c:when>
                    <c:otherwise>
                        <option value="Food">Food&Beverage</option>
                    </c:otherwise>
                </c:choose>
                <c:choose>
                    <c:when test="${btype=='accomodation'}">
                        <option value="accomodation" selected>Accommodation</option>
                    </c:when>
                    <c:otherwise>
                        <option value="accomodation">Accommodation</option>
                    </c:otherwise>
                </c:choose>
                <c:choose>
                    <c:when test="${btype=='transport'}">
                        <option value="transport" selected>Transport</option>
                    </c:when>
                    <c:otherwise>
                        <option value="transport">Transport</option>
                    </c:otherwise>
                </c:choose>
                <c:choose>
                    <c:when test="${btype=='medicine'}">
                        <option value="medicine" selected>Medicine</option>
                    </c:when>
                    <c:otherwise>
                        <option value="medicine">Medicine</option>
                    </c:otherwise>
                </c:choose>
            </select><br>
            <label>Business Name</label><br>
            <input type="text" name="bname" value="${bname}"/><br>
            <label>Interest</label><br>
            <select name="interest">
                <c:choose>
                    <c:when test="${inter=='null'}">
                        <option value="" selected="selected"></option>
                    </c:when>
                    <c:otherwise>
                        <option value=""></option>
                    </c:otherwise>  
                </c:choose>
                <c:choose>
                    <c:when test="${inter=='male'}">
                        <option value="male" selected="selected">Male</option>
                    </c:when>
                    <c:otherwise>
                        <option value="male">Male</option>
                    </c:otherwise>  
                </c:choose>
                <c:choose>
                    <c:when test="${inter=='female'}">
                        <option value="female" selected="selected">Female</option>
                    </c:when>
                    <c:otherwise>
                        <option value="female">Female</option>
                    </c:otherwise> 
                </c:choose>
                <c:choose>
                    <c:when test="${inter=='both'}">
                        <option value="both" selected="selected">Other</option>
                    </c:when>
                    <c:otherwise>
                        <option value="both">Other</option>
                    </c:otherwise> 
                </c:choose>
            </select><br>
            <label>Special Note</label><br>
            <input type="text" name="snote" value="${snote}"/><br><br>
            <button class="btn btn-sm btn-danger">Update</button>
        </form>
    </body>
</html>
