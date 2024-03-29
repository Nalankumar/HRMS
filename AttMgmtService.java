import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class AttMgmtService {
    private Connection con;
    private PreparedStatement pstmt;
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
                int sta = res.getInt("status");
                switch(sta){
                    case 0:
                        p++;
                        break;
                    case 1:
                        a++;
                        break;
                    case 2:
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
                int sta = res.getInt("status");
                switch(sta){
                    case 0:
                        p++;
                        break;
                    case 1:
                        a++;
                        break;
                    case 2:
                        l++;
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

    public void takeAttendance(ResultSet res){
        Database db = new Database();        
        Scanner scan = new Scanner(System.in);
        try{
            con = db.createConnection();
            pstmt = con.prepareStatement("insert into attendance values(?,?,?)");
            long millis = System.currentTimeMillis();
            Date date = new Date(millis);
            while(res.next()){
                int eid = res.getInt("eid");
                System.out.print("Enter attendance for Emp ID "+ eid + ": ");
                int att = scan.nextInt();
                pstmt.setInt(1, eid);
                pstmt.setDate(2, date);
                pstmt.setInt(3, att);    
                pstmt.executeUpdate();
            }
            System.out.println("Attendance has been taken!");
        }
        catch(Exception e){
            System.err.println(e);
        }
        scan.close();
    }
}