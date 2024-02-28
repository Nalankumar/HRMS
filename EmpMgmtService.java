import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class EmpMgmtService {
    private Connection con;
    private PreparedStatement pstmt;
    private Statement stmt;
    private ResultSet res;

    public void createEmployee(int eid, String name, String desg, String dept, String contact){
        Database db = new Database();
        try{
            con = db.createConnection();
            pstmt = con.prepareStatement("insert into employee values(?,?,?,?,?)");
            pstmt.setInt(1, eid);
            pstmt.setString(2, name);
            pstmt.setString(3, desg);
            pstmt.setString(4,dept);
            pstmt.setString(5,contact);
            pstmt.executeUpdate();
            System.out.println("Employee created\n\"----------------------------------------------------------------");
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
    public void getAllEmployees(){
        Database db = new Database();        
        try{
            con = db.createConnection(); 
            stmt = con.createStatement();
            res = stmt.executeQuery("select * from employee");
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
    public void searchById(int id){
        Database db = new Database();        
       try{
            con = db.createConnection();
            pstmt = con.prepareStatement("select * from employee where eid=?");
            pstmt.setInt(1, id);
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
    public void searchByName(String name){
        Database db = new Database();        
       try{
            con = db.createConnection();
            pstmt = con.prepareStatement("select * from employee where name=?");
            pstmt.setString(1, name);
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
    public void searchByDesignation(String des){
        Database db = new Database();        
       try{
            con = db.createConnection();
            pstmt = con.prepareStatement("select * from employee where designation=?");
            pstmt.setString(1, des);
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
