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
    public void displayEmployees(ResultSet res){
        try{
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
        catch(Exception e){
            System.err.println(e);
        }
    }

    public ResultSet getAllEmployees(){
        Database db = new Database();        
        try{
            con = db.createConnection(); 
            stmt = con.createStatement();
            res = stmt.executeQuery("select * from employee");    
        }
        catch(Exception e)
        {
            System.err.println(e);
        } 
        return res;
    }

    public ResultSet searchById(int id){
        Database db = new Database();        
       try{
            con = db.createConnection();
            pstmt = con.prepareStatement("select * from employee where eid=?");
            pstmt.setInt(1, id);
            res = pstmt.executeQuery();
        }
        catch(Exception e)
        {
            System.err.println(e);
        } 
        return res;
    }

    public ResultSet searchByName(String name){
        Database db = new Database();        
       try{
            con = db.createConnection();
            pstmt = con.prepareStatement("select * from employee where name=?");
            pstmt.setString(1, name);
            res = pstmt.executeQuery();
        }
        catch(Exception e)
        {
            System.err.println(e);
        } 
        return res;
    }
    public ResultSet searchByDesignation(String des){
        Database db = new Database();        
       try{
            con = db.createConnection();
            pstmt = con.prepareStatement("select * from employee where designation=?");
            pstmt.setString(1, des);
            res = pstmt.executeQuery();

        }
        catch(Exception e)
        {
            System.err.println(e);
        } 
        return res;
    } 
    public ResultSet searchByDepartment(String dept){
        Database db = new Database();        
       try{
            con = db.createConnection();
            pstmt = con.prepareStatement("select * from employee where dept=?");
            pstmt.setString(1, dept);
            res = pstmt.executeQuery();
        }
        catch(Exception e)
        {
            System.err.println(e);
        } 
        return res;
    } 
    public void removeById(int id){
        Database db = new Database();
        try{
            con = db.createConnection();
            pstmt = con.prepareStatement("delete from employee where eid = ?");
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            System.out.println("Employee of ID "+ id +" has been removed!\n----------------------------------------------------------------");
        }
        catch(Exception e){
            System.out.println(e);
        }        
    }
}
