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
            int a = 0,p = 0,l = 0;
            System.out.println("---------------------------------");
            while (res.next()) {
                
                System.out.println(
                    "|" + res.getString("date") + "|" + 
                    "|" + res.getString("eid") + "|" + 
                    "|" + res.getString("status")  + "|"  
                );
                switch(res.getString("status")){
                    case "a":
                        a++;
                        break;
                    case "p":
                        p++;
                        break;
                    case "l":
                        break;
                }
            }
                
            
            System.out.println("---------------------------------");
            System.out.println("Absent: "+ a +"\nPresent:" + p +"\nLeave: " + l);
        }
        catch(Exception e)
        {
            System.err.println(e);
        } 
    
    }
    public void getAttendanceByEid(int eid){
        Database db = new Database();        
        try{
            con = db.createConnection();
            pstmt = con.prepareStatement("select * from attendance where eid=?");
            pstmt.setInt(1, eid);
            res = pstmt.executeQuery();
            System.out.println("---------------------------------");
            int a = 0, l = 0, p = 0;
            while (res.next()) {
                
                System.out.println(
                    "|" + res.getString("date") + "|" + 
                    "|" + res.getString("eid") + "|" + 
                    "|" + res.getString("status")  + "|"  
                );
                switch(res.getString("status")){
                    case "a":
                        a++;
                        break;
                    case "p":
                        p++;
                        break;
                    case "l":
                        break;
                    }

                
            }
            System.out.println("---------------------------------");
            System.out.println("Absent: "+ a +"\nPresent:" + p +"\nLeave: " + l);
        }
        catch(Exception e)
        {
            System.err.println(e);
        } 

    }
}