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
 * @author Harith Jayasena
 */
@WebServlet(urlPatterns = {"/loginservlet2"})
public class loginservlet2 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      
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
                String sql="select*from localdetails where id='"+id+"' ";
                ResultSet rs = statement.executeQuery(sql);
                while(rs.next())
                {
                    String name=rs.getString("name");
                    String gender=rs.getString("gender");
                    String uname=rs.getString("uname");
                    String pword=rs.getString("pword");
                    String email=rs.getString("email");
                    String cnumber=rs.getString("cnumber");
                    String btype=rs.getString("btype");
                    String bname=rs.getString("bname");
                    String inter=rs.getString("inter");
                    String snote=rs.getString("snote");
                    String status=rs.getString("status");
                    
                    RequestDispatcher rd=req.getRequestDispatcher("/LocalHomepage.jsp");
                    req.setAttribute("name",name);
                    req.setAttribute("gender",gender);
                    req.setAttribute("email",email);
                    req.setAttribute("cnumber",cnumber);
                    req.setAttribute("btype",btype);
                    req.setAttribute("bname",bname);
                    req.setAttribute("inter",inter);
                    req.setAttribute("snote",snote);
                    rd.forward(req, resp);
                    
                }
                
            }
            catch(ClassNotFoundException cnfe)
            {
                System.out.println("Class not found");
            } catch (SQLException ex) {
            Logger.getLogger(loginservlet2.class.getName()).log(Level.SEVERE, null, ex);
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
                String sql="select*from localdetails where uname='"+z+"' and pword='"+x+"' ";
                ResultSet rs = statement.executeQuery(sql);
                while(rs.next())
                {
                    String id=rs.getString("id");
                    String name=rs.getString("name");
                    String gender=rs.getString("gender");
                    String uname=rs.getString("uname");
                    String pword=rs.getString("pword");
                    String email=rs.getString("email");
                    String cnumber=rs.getString("cnumber");
                    String btype=rs.getString("btype");
                    String bname=rs.getString("bname");
                    String inter=rs.getString("inter");
                    String snote=rs.getString("snote");
                    String status=rs.getString("status");
                    
                    if(status.equalsIgnoreCase("available")){
                        
                        HttpSession session = req.getSession();
                        session.setAttribute("id", id);
                        session.setMaxInactiveInterval(3600);
                        
                        RequestDispatcher rd=req.getRequestDispatcher("/LocalHomepage.jsp");
                        req.setAttribute("name",name);
                        req.setAttribute("gender",gender);
                        req.setAttribute("email",email);
                        req.setAttribute("cnumber",cnumber);
                        req.setAttribute("btype",btype);
                        req.setAttribute("bname",bname);
                        req.setAttribute("inter",inter);
                        req.setAttribute("snote",snote);
                        rd.forward(req, res);
                    }
                    
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
        RequestDispatcher rd=req.getRequestDispatcher("/locallogin.html");
        rd.forward(req, res);
    }

    
}
