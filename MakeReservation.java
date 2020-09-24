/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import ModelClasses.Post;
import ModelClasses.Reservation;
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
 * @author Sarith
 */
public class MakeReservation extends HttpServlet {

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
       // processRequest(request, response);
       String process = request.getParameter("process");
       switch(process){
           case "view":
                List<Post> posts = getPosts();
                RequestDispatcher dispatcher = request.getRequestDispatcher("MakeReservation.jsp");
                request.setAttribute("posts", posts);
                dispatcher.forward(request, response);
            break;
           case "my-reservations":
               try
                {
                    Class.forName("com.mysql.jdbc.Driver");
                    String jdbcUrl="jdbc:mysql://localhost:3306/travellanka?useSSL=false";
                    String username="root";
                    String password="";
                    Connection connection=null;

                    connection = DriverManager.getConnection(jdbcUrl,username,password);
                    Statement statement = connection.createStatement();

                    HttpSession session = request.getSession();
                    String id = session.getAttribute("id").toString();
                    String sql="select * from reservations as rs,posts as ps where guestId='"+id+"' and "
                            + "rs.postId=ps.id";
                    ResultSet rs = statement.executeQuery(sql);

                    posts = new ArrayList<>();
                    ArrayList<Reservation> reservationList = new ArrayList<>();
                    while(rs.next())
                    {
                        Post post = new Post();
                        post.setId(rs.getInt("ps.id"));
                        post.setTitle(rs.getString("ps.title"));
                        post.setDesc(rs.getString("ps.description"));
                        post.setPrice(rs.getDouble("ps.price"));
                        
                        posts.add(post);
                        
                        Reservation reserve = new Reservation();
                        reserve.setId(rs.getInt("rs.id"));
                        reserve.setDate(rs.getString("rs.date"));
                        reservationList.add(reserve);
                        
                    }
                    if(reservationList.size()>0 && posts.size()>0){
                        request.setAttribute("reservations", reservationList);
                        request.setAttribute("posts", posts);
                        RequestDispatcher dispatch = request.getRequestDispatcher("ViewReservations.jsp");
                        dispatch.forward(request, response);
                    }

                    RequestDispatcher dispatch = request.getRequestDispatcher("MakeReservations.jsp");
                    dispatch.forward(request, response);
                }catch(Exception ex){
                    System.err.println(ex);
                }
       }
    }
    
    

    private List<Post> getPosts(){
        List<Post> posts = new ArrayList<>();
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            String jdbcUrl="jdbc:mysql://localhost:3306/travellanka?useSSL=false";
            String username="root";
            String password="";
            Connection connection=null;

            connection = DriverManager.getConnection(jdbcUrl,username,password);
            Statement statement = connection.createStatement();

            String sql="select*from posts";
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
       // processRequest(request, response);
       String process = request.getParameter("process");
       switch(process){
           case "reserve":
               try
                {
                    Class.forName("com.mysql.jdbc.Driver");
                    String jdbcUrl="jdbc:mysql://localhost:3306/travellanka?useSSL=false";
                    String username="root";
                    String password="";
                    Connection connection=null;

                    connection = DriverManager.getConnection(jdbcUrl,username,password);
                    

                    HttpSession session = request.getSession();
                    String id = session.getAttribute("id").toString();
                    
                    String sql="insert into reservations (date,postId,guestId) values (?,?,?);";
                    PreparedStatement statement = connection.prepareStatement(sql);
                    statement.setString(1, request.getParameter("date"));
                    statement.setInt(2, Integer.parseInt(request.getParameter("id")));
                    statement.setInt(3, Integer.parseInt(id));
                    boolean saved = statement.execute();
                    
                    List<Post> posts = getPosts();
                    request.setAttribute("posts", posts);
                    request.setAttribute("reserved", true);
                    RequestDispatcher dispatcher = request.getRequestDispatcher("MakeReservation.jsp");
                    dispatcher.include(request, response);
                    
           
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
