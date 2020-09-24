/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.sql.*;
import javax.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;


/**
 *
 * @author Sarith Kalhara
 */
@WebServlet(urlPatterns = {"/formservlet"})
@MultipartConfig(maxFileSize = 16177215)    // upload file's size up to 16MB
public class formservlet extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest req,HttpServletResponse res)
            throws ServletException,IOException
    {
        try
        {
            res.setContentType("text/html");
            PrintWriter out=res.getWriter();
            try
            {
                Class.forName("com.mysql.jdbc.Driver");
                String jdbcUrl="jdbc:mysql://localhost:3306/travellanka";
                String username="root";
                String password="";
                Connection connection=null;
                
                connection = DriverManager.getConnection(jdbcUrl,username,password);
                
                
                String a=req.getParameter("name");
                String b=req.getParameter("gender");
                String c=req.getParameter("uname");
                String d=req.getParameter("email");
                
                String e=req.getParameter("contact");
                String f=req.getParameter("interested");
                String g=req.getParameter("snote");
                String h=req.getParameter("pword");
                String i=req.getParameter("adate");
                String j=req.getParameter("ddate");
                
                InputStream inputStream = null;
                Part filePart = req.getPart("f1");
                if (filePart != null) {
                    inputStream = filePart.getInputStream();
                }

                
                String sql="insert into guestdetails (name,gender,uname,email,"
                        + "cnumber,inter,snote,password,adate,ddate,image) values(?,?,?,?,?,?,?,?,?,?,?)";
                
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setString(1, a);
                statement.setString(2, b);
                statement.setString(3, c);
                statement.setString(4, d);
                statement.setString(5, e);
                statement.setString(6, f);
                statement.setString(7, g);
                statement.setString(8, h);
                statement.setString(9, i);
                statement.setString(10, j);
                 if (inputStream != null) {
                    statement.setBlob(11, inputStream);
                }
                statement.execute();
                
                out.println("<h1>Record successfully inserted</h1>");
                RequestDispatcher rd=req.getRequestDispatcher("/index.jsp");
                rd.include(req, res);
                
            }
            catch(ClassNotFoundException cnfe)
            {
                
                out.println("Class not found");
            }
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            throw new RuntimeException("Cannot connect the database",e);
        }
    }

    
}
