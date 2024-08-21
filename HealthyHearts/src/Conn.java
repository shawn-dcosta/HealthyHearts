import java.sql.*;
public class Conn {
    Connection c;
    Statement s;
    Conn() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            c=DriverManager.getConnection("jdbc:mysql://localhost:3306/diet","root","Shawn@2004");

            s=c.createStatement();

            // Class.forName()
        } catch (Exception f) {
            f.printStackTrace();
        }
    }
}