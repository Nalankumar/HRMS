import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class AttMgmtService {
    private Connection con;
    private PreparedStatement pstmt;
    private Statement stmt;
    private ResultSet res;
    public void getAttendanceByDate(Date date){
        Database db = new Database();        
        try{
            con = db.createConnection();
            pstmt = con.prepareStatement("select * from attendance where date=?");
            pstmt.setDate(1, date);
            res = pstmt.executeQuery();
            System.out.println("---------------------------------");
            while (res.next()) {
                
                System.out.println(
                    "|" + res.getString("date") + "|" + 
                    "|" + res.getString("eid") + "|" + 
                    "|" + res.getString("status")  + "|"  
                );
                
            }
            System.out.println("---------------------------------");
        }
        catch(Exception e)
        {
            System.err.println(e);
        } 
    
    }
}
