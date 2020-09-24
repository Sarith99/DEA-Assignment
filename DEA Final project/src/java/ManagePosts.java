/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import ModelClasses.Post;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author imesh
 */
public class ManagePosts extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
        String process = request.getParameter("process");
        switch(process){
            case "view":
                List<Post> posts = getPosts(request);
                RequestDispatcher dispatcher = request.getRequestDispatcher("ManagePosts.jsp");
                request.setAttribute("posts", posts);
                dispatcher.include(request, response);
                break;
            case "AddPage":
                dispatcher = request.getRequestDispatcher("AddPost.jsp");
                dispatcher.include(request, response);
                break;
        }
    }

private List<Post> getPosts(HttpServletRequest request){
    List<Post> posts = new ArrayList<>();
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            String jdbcUrl="jdbc:mysql://localhost:3306/travellanka";
            String username="root";
            String password="";
            Connection connection=null;

            connection = DriverManager.getConnection(jdbcUrl,username,password);
            Statement statement = connection.createStatement();

            HttpSession session = request.getSession();
            String id = session.getAttribute("id").toString();
            String sql="select*from posts where localId='"+id+"' ";
            ResultSet rs = statement.executeQuery(sql);

            
            while(rs.next())
            {
                Post post = new Post();
                post.setId(rs.getInt("id"));
                post.setTitle(rs.getString("title"));
                post.setDesc(rs.getString("description"));
                post.setPrice(rs.getDouble("price"));

                posts.add(post);
            }
            connection.close();
        }catch(Exception ex){
            System.err.println(ex);
        }
        return posts;
}
    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
        String process = request.getParameter("process");
        switch(process){
            case "add-post":
                try
                {
                    Class.forName("com.mysql.jdbc.Driver");
                    String jdbcUrl="jdbc:mysql://localhost:3306/travellanka";
                    String username="root";
                    String password="";
                    Connection connection=null;

                    connection = DriverManager.getConnection(jdbcUrl,username,password);
                    

                    HttpSession session = request.getSession();
                    String id = session.getAttribute("id").toString();
                    
                    String sql="insert into posts (title,description,price,localId) values"
                            + " (?,?,?,?)";
                    PreparedStatement statement = connection.prepareStatement(sql);
                    statement.setString(1, request.getParameter("title"));
                    statement.setString(2, request.getParameter("title"));
                    statement.setDouble(3, Double.valueOf(request.getParameter("price")));
                    statement.setString(4, id);
                    boolean saved = statement.execute();
                    
                    List<Post> posts = getPosts(request);
                    //RequestDispatcher dispatcher = request.getRequestDispatcher("ManagePosts.jsp");
                    request.setAttribute("posts", posts);
                    RequestDispatcher dispatcher = request.getRequestDispatcher("ManagePosts.jsp");
                    dispatcher.forward(request, response);
                    connection.close();
                }catch(Exception ex){
                    System.err.println(ex);
                }
                break;
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
