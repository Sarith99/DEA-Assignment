<%-- 
    Document   : AddPost
    Created on : Jun 18, 2019, 7:53:33 AM
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
        <jsp:include page="LocalNavbar.jsp"/>
        <div style="width:100%; margin:10px 20px">
            <h4>Add Post</h4>
            <div >
                <form action="./ManagePosts" method="post">
                    <input type="text" name="process" value="add-post" hidden/><br>
                    <label>Title</label><br>
                    <input type="text" name="title"/><br>
                    <label>Description</label><br>
                    <input type="text" name="desc"/><br>
                    <label>Price</label><br>
                    <input type="number" name="price"/><br><br>
                    <input type="submit" value="Submit" class="btn btn-success"/><br>
                </form>
            </div>
        </div>
    </body>
</html>
