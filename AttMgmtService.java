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
            while (res.next()) {
                System.out.println("----------------------------------------------------------------");
                System.out.println(
                    "Id: " + res.getString("eid") + "\n" + 
                    "Name: " + res.getString("name") + "\n" + 
                    "Designation: " + res.getString("designation")  + "\n" + 
                    "Department: "+ res.getString("dept")  + "\n" + 
                    "Contact: " + res.getString("contact")
                );
                System.out.println("----------------------------------------------------------------");
            }
        }
        catch(Exception e)
        {
            System.err.println(e);
        } 
    
    }
}
