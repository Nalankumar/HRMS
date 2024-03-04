import java.util.InputMismatchException;
import java.util.Scanner;
public class Hrms {
    public static void main(String[] args) {   
        Scanner sc = new Scanner(System.in);
        int choice, eid;
        String name, des, dept, contact;
        System.out.println("********************** WELCOME **********************");
        do{
            System.out.print("1. Employee management\n2. Attendance management\n3. Leave management\n0. Exit\nEnter your choice: ");
            choice = sc.nextInt();
            switch(choice){
                case 0:
                    System.out.println("****** Thank you ******");
                    break;
                case 1:
                    EmpMgmtService service = new EmpMgmtService();
                    do{
                        System.out.print("1. Add Employee\n2. View All Employees\n3. Search Employee \n4. Remove employee\n0. Go back\nEnter your choice: ");
                        choice = sc.nextInt();
                        switch(choice){
                            case 0:
                                break;
                            case 1:
                                try{
                                System.out.print("Enter Employee ID: ");
                                eid = sc.nextInt();
                                System.out.print("Enter name: ");
                                name = sc.next();
                                System.out.print("Enter designation: ");
                                des =  sc.next();
                                System.out.print("Enter department: ");
                                dept = sc.next();
                                System.out.print("Enter contact: ");
                                contact = sc.next();
                                service.createEmployee(eid, name, des, dept, contact);
                                }
                                catch(InputMismatchException e){
                                    System.out.println("Enter valid input!\n" + e);
                                }
                                break;
                            case 2:
                                service.getAllEmployees();
                                break;
                            case 3:
                                do{
                                    System.out.print("1.Search by EID\n2. Search by name\n3. Search by designation\n4. Search by department\n0. Go back\nEnter your choice: ");
                                    choice = sc.nextInt();
                                    switch(choice){
                                        case 0: 
                                            break;
                                        case 1:
                                            System.out.print("Enter id of employee to search: ");
                                            eid = sc.nextInt();
                                            service.searchById(eid);
                                            break;
                                        case 2:
                                            System.out.print("Enter name of employee to search: ");
                                            name = sc.next();
                                            service.searchByName(name);
                                            break;
                                        case 3:
                                        System.out.print("Enter designation to search employees: ");
                                            des = sc.next();
                                            service.searchByDesignation(des);
                                        break;
                                        case 4:
                                        System.out.print("Enter designation to search employees: ");
                                            dept = sc.next();
                                            service.searchByDepartment(dept);
                                        break;
                                        default:
                                        System.out.println("Enter valid choice");
                                        break;
                                    }
                                }while(choice!=0);
                                choice = 1;
                                break;
                            case 4:
                                System.out.print("Enter employee ID to remove: ");
                                int id = sc.nextInt();
                                service.removeById(id);
                                break;
                            default: 
                                System.out.println("Enter valid choice");
                                break;
                        }      
                    }while(choice!=0);
                    choice = 1;
                break;
                case 2:
                break;
                default: 
                    System.out.println("Enter valid choice");
                    break;
        }
        }while(choice!=0);        
        sc.close();        
    }
}