import java.sql.*;
import javax.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;


/**
 *
 * @author Harith Jayasena
 */
@WebServlet(urlPatterns = {"/formservlet2"})
public class formservlet2 extends HttpServlet {
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
                
                String a=req.getParameter("name1");
                String b=req.getParameter("sign_gender");
                String c=req.getParameter("uname");
                String d=req.getParameter("pword");
                String e=req.getParameter("email");
                String f=req.getParameter("contact");
                String g=req.getParameter("type");
                String h=req.getParameter("bname");
                String i=req.getParameter("interested");
                String j=req.getParameter("snote");
                System.err.println("gender "+b);
                String sql="insert into localdetails values('"+a+"','"+b+"','"
                        +c+"','"+d+"','"+e+"','"+f+"','"+g+"','"+h+"','"
                        +i+"','"+j+"','not available')";
                statement.executeUpdate(sql);
                
                
                
                RequestDispatcher rd=req.getRequestDispatcher("/index.jsp");
                req.setAttribute("localregistered",true);
                rd.include(req, res);
                
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
    }

    
}
