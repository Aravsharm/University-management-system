
package university.management.system;
import java.sql.*;
public class Conn {
    
    Connection con;
    Statement stmt;
    Conn()
    {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/universitymanagementsystem","root","");
            stmt=con.createStatement();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    public static void main(String []ar)
    {
      new Conn();
    }
}
 