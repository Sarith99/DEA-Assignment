/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author kavindu
 */
public class Adminservlet extends HttpServlet {


 
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
     try
        {
        String status = req.getParameter("process");
        switch(status){
            case "set-available":
                Class.forName("com.mysql.jdbc.Driver");
                String jdbcUrl="jdbc:mysql://localhost:3306/travellanka";
                String username="root";
                String password="";
                Connection connection=null;

                connection = DriverManager.getConnection(jdbcUrl,username,password);
                Statement statement = connection.createStatement();

                String id = req.getParameter("id");
                String sql="update localdetails set status='available' where id='"+id+"';";
                int response = statement.executeUpdate(sql);
                
                RequestDispatcher rd=req.getRequestDispatcher("/Admin.jsp");
                rd.include(req, res);
                break;
            case "delete":
                Class.forName("com.mysql.jdbc.Driver");
                jdbcUrl="jdbc:mysql://localhost:3306/travellanka";
                username="root";
                password="";
                connection=null;

                connection = DriverManager.getConnection(jdbcUrl,username,password);
                statement = connection.createStatement();

                id = req.getParameter("id");
                sql="delete from localdetails where id='"+id+"';";
                response = statement.executeUpdate(sql);
                
                rd=req.getRequestDispatcher("/ViewLocals.jsp");
                rd.include(req, res);
                break;
            case "update":
                Class.forName("com.mysql.jdbc.Driver");
                jdbcUrl="jdbc:mysql://localhost:3306/travellanka";
                username="root";
                password="";
                connection=null;

                connection = DriverManager.getConnection(jdbcUrl,username,password);
                statement = connection.createStatement();

                id = req.getParameter("id");
                sql="select * from localdetails where id='"+id+"';";
                ResultSet result = statement.executeQuery(sql);
                while(result.next()){
                    rd=req.getRequestDispatcher("/UpdateLocals.jsp");
                    req.setAttribute("id", result.getString("id"));
                    req.setAttribute("name", result.getString("name"));
                    req.setAttribute("gender", result.getString("gender"));
                    req.setAttribute("email", result.getString("email"));
                    req.setAttribute("cnumber", result.getString("cnumber"));
                    req.setAttribute("btype", result.getString("btype"));
                    req.setAttribute("bname", result.getString("bname"));
                    req.setAttribute("inter", result.getString("inter"));
                    req.setAttribute("snote", result.getString("snote"));
                    rd.include(req, res);
                }
                break;
            case "update-details":
                id = req.getParameter("id");
                String name=req.getParameter("name");
                String gender=req.getParameter("gender");
                String email=req.getParameter("email");
                String contact=req.getParameter("cnumber");
                String btype=req.getParameter("btype");
                String bname=req.getParameter("bname");
                String inter=req.getParameter("interest");
                String snote=req.getParameter("snote");
                
                Class.forName("com.mysql.jdbc.Driver");
                jdbcUrl="jdbc:mysql://localhost:3306/travellanka";
                username="root";
                password="";
                connection=null;

                connection = DriverManager.getConnection(jdbcUrl,username,password);
                statement = connection.createStatement();

                sql="update localdetails set name='"+name+"',gender='"+gender+"',email='"+email+
                        "',cnumber='"+contact+"',btype='"+btype+"',bname='"+bname+"',inter='"+
                        inter+"',snote='"+snote+"' where id='"+id+"';";
                response = statement.executeUpdate(sql);
                
                rd=req.getRequestDispatcher("/ViewLocals.jsp");
                rd.include(req, res);
                break;
                
        }
    

        }
        catch(SQLException e)
        {
            throw new RuntimeException("Cannot connect the database",e);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Adminservlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
}

