package MAIN;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
public class Main extends School_Management_12 {
	
        static final String Query1 = "SELECT  Username,Password FROM Register";
        public static final int username=10;
        public static final int password=8;
        public static final int teacher_id=7;
        public static final int parent_id=7;
        public static final int student_id=7;
        public static void main(String[] args) throws SQLException {
               DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
                String oracleUrl = "jdbc:oracle:thin:@localhost:1521:xe";
                Connection con = DriverManager.getConnection(oracleUrl, "Rakshitha","Rakshasi@07");
                Scanner sc = new Scanner(System.in);
                //Choosing the designation
                System.out.println("Welcome to School Management");
                System.out.println("1.Admin Registration");
                System.out.println("2.Admin Login");
                System.out.println("3.Teacher Login");
                System.out.println("4.Parent Login");
                System.out.println("5.Student Login");
                System.out.println("Choose the Option");
                int Option = sc.nextInt();
                if(Option >5 || Option<1) {
                    System.out.println("Enter valid Option");
                } 
                Statement stmt = con.createStatement();
                ResultSet rs1 = stmt.executeQuery(Query1);
                switch(Option) {
                case 1 :
                    Admin_Registration();
                    break;
                case 2:
                	//If Chosen 1, admin can login by providing username and password.
                System.out.println("Welcome to Admin Login");
                System.out.println("Enter the Username");
                String Username = sc.next();
                if(Username.length()>username) {
                	System.out.println("Enter valid username");
                	 Main.main(args);
                }else {
                System.out.println("Enter the Password");
                String Password = sc.next();
                if (Password.length()>password){
                	System.out.println("Enter valid password");
                	 Main.main(args);
                }else {
                try {
                    while(rs1.next()) {
                        String User = rs1.getString("Username");
                        String Pass = rs1.getString("Password");    
                        if(Username.equals(User) && Password.equals(Pass)) {
                            System.out.println("Login Success");                  
                           Admin_Module();
                           
                        }else {
                            System.out.println("Enter Valid Credentials");
                            break;
                        }
                        }break;
                        }
                
 

                catch (SQLException e) {
                    e.printStackTrace();                   
                  }    
                }
                }break;
                //if choosen 3, Teacher can login by providing their id.
                case 3:
                System.out.println("Welcome to School Management");
                System.out.println("Enter the Teacher_ID");
                String Teacher_ID = sc.next();
                if (Teacher_ID.length()>teacher_id) {
                	System.out.println("Enter valid Teacher ID");
                	 Main.main(args);
                }else {
                String Query1= "Select * from Teacher_Records WHERE Teacher_ID like '"+Teacher_ID+"%'";
                ResultSet rs2= stmt.executeQuery(Query1);
                try {
                    while(rs2.next()) {
                        String ID1 = rs2.getString("Teacher_ID");
                        if(Teacher_ID.equals(ID1)) {
                            System.out.println("Login Success");
                            Teacher_Module();
                            
                        }else {
                            System.out.println("Enter Valid Credentials");
                            break;
                        }
                        }break;
                        }
                
                catch (SQLException e) {
                    e.printStackTrace();                   
                  }  }   break;
                  //if choosen 4, Parent can login by providing their id.
                case 4:             
                 System.out.println("Welcome to School Management");
                System.out.println("Enter the Parent_ID");
                String Parent_ID = sc.next();
                if(Parent_ID.length()>parent_id) {
                	System.out.println("Enter valid Parent ID");
                	 Main.main(args);
                }else {
                String Query2= "Select * from Parents_Records WHERE Parent_ID like '"+Parent_ID+"%'";
                 ResultSet rs3 = stmt.executeQuery(Query2);
                  try {
                    while(rs3.next()) {
                        String ID2= rs3.getString("Parent_ID");
                        if(Parent_ID.equals(ID2)) {
                            System.out.println("Login Success");
                            Parent_Module();
                            
                        }else {
                            System.out.println("Enter valid Details");
                        }break;
    }
                } 
                catch (SQLException e) {
                    e.printStackTrace();                   
                  }   }  break;
                  //if choosen 5, Student can login  by providing their id.
                case 5:
                System.out.println("Welcome to School Management");
                System.out.println("Enter the Student_ID");
                String Student_ID = sc.next();
                if(Student_ID.length()>student_id) {
                	System.out.println("Enter valid Student ID");
                	 Main.main(args);
                }else {
                String Query3= "Select * from Student_Records WHERE Student_ID like '"+Student_ID+"%'";
                ResultSet rs4 = stmt.executeQuery(Query3);
                try {
                    while(rs4.next()) {
                        String ID3 = rs4.getString("Student_ID");
                        if(Student_ID.equals(ID3)) {
                            System.out.println("Login Success");
                            Student_Module();
                            
                        }else {
                            System.out.println("Enter valid Details");
                        }break;
    }
                } 
                catch (SQLException e) {
                    e.printStackTrace();                   
                  }     break;
    }
    } 
        }
		
			
		}
