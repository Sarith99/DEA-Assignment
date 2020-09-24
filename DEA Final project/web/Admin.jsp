
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.ResultSet"%>

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
        
        


<% 

                String driverName="com.mysql.jdbc.Driver";
                String jdbcUrl="jdbc:mysql://localhost:3306/travellanka";
                String username="root";
                String password="";
                Connection connection=null;
                
             try{
                 Class.forName(driverName);
             } catch(ClassNotFoundException e)
                 
            {
                out.println("Class not found");
            }
               
                %>

                <jsp:include page="AdminNav.jsp"/>
                <div style="margin:10px 5% 0px 5%">
                    
                    <h4>Newly Registered Locals</h4>
                    <table style="width:100%">
                        <tr>
                            <th>Name</th>
                            <th>Gender</th>
                            <th>Email</th>
                            <th>Contact Number</th>
                            <th>Business Type</th>
                            <th>Business Name</th>
                            <th>Interest</th>
                            <th></th>
                        </tr>
                        
                
                
                <%
                try{ 
                     
                connection = DriverManager.getConnection(jdbcUrl,username,password);
                Statement statement = connection.createStatement();
                
                
                String z=request.getParameter("uname");
                String x=request.getParameter("psw");
                String sql="select * from localdetails where status='not available'";
                
              
                
                ResultSet rs = statement.executeQuery(sql);
                
             
                while(rs.next()) 
                {  %>
                <tr>
                    <td><%=rs.getString("name")%></td>
                    <td><%=rs.getString("gender")%></td>
                    <td><%=rs.getString("email")%></td>
                    <td><%=rs.getString("cnumber")%></td>
                    <td><%=rs.getString("btype")%></td>
                    <td><%=rs.getString("bname")%></td>
                    <td><%=rs.getString("inter")%></td>
                    <td>
                        <form action="http://localhost:8080/DEAFINAL/Adminservlet" method="post">
                            <input type="text" name="process" value="set-available" hidden/>
                            <input type="text" name="id" value="<%=rs.getString("id")%>" hidden/>
                            <button class="btn btn-primary">Set Available</button>
                        </form>
                    </td>
                </tr>
                
                
       
                <%      }
              
                
                
        
          
        }
        catch(SQLException e)
        {
            throw new RuntimeException("Cannot connect the database",e);
        }
    

    

%>
                </table>
            </div>
    </body>
</html>
