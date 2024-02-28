import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database{
    public Connection createConnection(){
        Connection conn = null;
        try{
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hrms","admin","admin");
        }
        catch(SQLException e){
            System.out.println(e);
        }
        return conn; 
    }
}