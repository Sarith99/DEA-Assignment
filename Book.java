
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import org.jboss.logging.Logger;
import sun.util.logging.PlatformLogger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ASUS
 */
class Book {
Statement st;
    void addbook(String title,String author,String category) {
        connectToDb();
        String sql="INSERT INTO untitled()"
        
    }

    private void connectToDb() throws SQLException {
        String driver="com.mysql.jdbc.Driver";
        
        try{
            Class.forName(driver);
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sw","root","");
            
        }catch(ClassNotFoundException | SQLException ex){
            Logger.getLogger(Book.class.getName().Log(Level.SEVERE, null, ex));
        }
        
    }
    
}
