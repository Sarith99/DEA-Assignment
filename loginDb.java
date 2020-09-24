
import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class loginDb implements Serializable{
    PreparedStatement st;
    String sql = "insert into login values(?,?)";
    void mysqldb(loginBean Bean) {
        
        try {
            connectDb();
            st.setString(1, Bean.getName());
            st.setString(2, Bean.getPword());
            st.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(loginDb.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    void connectDb() throws SQLException {
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/mydata";
            Connection con = DriverManager.getConnection(url, "root", "");
            st = con.prepareStatement(sql);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(loginDb.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
