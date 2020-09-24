/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.*;
import javax.sql.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;


/**
 *
 * @author Sarith Kalhara
 */
@WebServlet(urlPatterns = {"/loginservlet"})
public class loginservlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String process = req.getParameter("process");
        switch(process){
            case "view":
                try
            {
                Class.forName("com.mysql.jdbc.Driver");
                String jdbcUrl="jdbc:mysql://localhost:3306/travellanka";
                String username="root";
                String password="";
                Connection connection=null;
                
                connection = DriverManager.getConnection(jdbcUrl,username,password);
                Statement statement = connection.createStatement();
                
                HttpSession session = req.getSession();
                String id = session.getAttribute("id").toString();
                String sql="select*from guestdetails where id='"+id+"'";
               
                ResultSet rs = statement.executeQuery(sql);
                
                while(rs.next())
                {
                    String name=rs.getString("name");
                    String gender=rs.getString("gender");
                    
                    String email=rs.getString("email");
                    String cnumber=rs.getString("cnumber");
                    String inter=rs.getString("inter");
                    String snote=rs.getString("snote");
                    
                    String adate=rs.getString("adate");
                    String ddate=rs.getString("ddate");
                    
                    
                    req.setAttribute("name",name);
                    req.setAttribute("gender",gender);
                    req.setAttribute("email",email);
                    req.setAttribute("cnumber",cnumber);
                    req.setAttribute("inter",inter);
                    req.setAttribute("snote",snote);
                    req.setAttribute("adate",adate);
                    req.setAttribute("ddate",ddate);
                    
                    RequestDispatcher dispatcher = req.getRequestDispatcher("GuestHomepage.jsp");
                    dispatcher.forward(req, resp);
                }
                
            }
            catch(ClassNotFoundException cnfe)
            {
                System.out.println("Class not found");
            } catch (SQLException ex) {
            Logger.getLogger(loginservlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
    }
    
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
                Statement statement = connection.createStatement();
                
                String z=req.getParameter("uname");
                String x=req.getParameter("psw");
                String sql="select*from guestdetails where uname='"+z+"' and password='"+x+"' ";
                
                ResultSet rs = statement.executeQuery(sql);
                
                while(rs.next())
                {
                    String id=rs.getString("id");
                    String name=rs.getString("name");
                    String gender=rs.getString("gender");
                    
                    String email=rs.getString("email");
                    String cnumber=rs.getString("cnumber");
                    String inter=rs.getString("inter");
                    String snote=rs.getString("snote");
                    
                    String adate=rs.getString("adate");
                    String ddate=rs.getString("ddate");
                    
                    HttpSession session = req.getSession();
                    session.setAttribute("id", id);
                    session.setMaxInactiveInterval(3600);
                    
                    req.setAttribute("name",name);
                    req.setAttribute("gender",gender);
                    req.setAttribute("email",email);
                    req.setAttribute("cnumber",cnumber);
                    req.setAttribute("inter",inter);
                    req.setAttribute("snote",snote);
                    req.setAttribute("adate",adate);
                    req.setAttribute("ddate",ddate);
                    
                    RequestDispatcher dispatcher = req.getRequestDispatcher("GuestHomepage.jsp");
                    dispatcher.forward(req, res);
                }
                
            }
            catch(ClassNotFoundException cnfe)
            {
                out.println("Class not found");
            }
        }
        catch(SQLException e)
        {
            throw new RuntimeException("Cannot connect the database",e);
        }
        RequestDispatcher dispatcher = req.getRequestDispatcher("guestlogin.html");
        dispatcher.include(req, res);
    }

    
}
