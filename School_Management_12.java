package MAIN;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class School_Management_12 {
	public static final int firstname=10;
	public static final int lastname=10;
	public static final int username=10;
	public static final int password=8;
	 public static final int teacher_id=7;
     public static final int parent_id=7;
     public static final int student_id=7;
     public static final int classteacher=15;
     public static final int subject=10;
     public static final int qualification=20;
     public static final int student_name=15;
     public static final int parent_name=15;
     public static final int update=50;
     public static final int complaint=50;
     public static final int recommend=50;
	 protected static void Admin_Registration() throws SQLException {
		DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
        String oracleUrl = "jdbc:oracle:thin:@localhost:1521:xe";
        Connection con = DriverManager.getConnection(oracleUrl, "Rakshitha","Rakshasi@07");  
     Statement stmt = con.createStatement();
     //Registering a new admin(Head master).
     Scanner sc = new Scanner(System.in);
     System.out.println("Welcome to School Management");
     System.out.println("Registration Page");
     System.out.println("Enter your First Name");    
     String First_Name = sc.next();
     if(First_Name.length()>firstname) {
    	 System.out.println("Enter valid first name");
    	 Admin_Registration();
     }else {
     System.out.println("Enter your Last Name");
     String Last_Name = sc.next();
     sc.nextLine();
     if(Last_Name.length()>lastname) {
    	 System.out.println("Enter valid lastname");
    	 Admin_Registration();
     }else {
     System.out.println("Enter your Gmail");
     String Email = sc.next();
      if(Email.contains("@gmail.com")) {
     System.out.println("Enter your Username");
     String Username = sc.next();
     if(Username.length()>username) {
    	 System.out.println("Enter valid Username");
    	 Admin_Registration();
     }else {
     System.out.println("Enter your Password");
     String Password = sc.next();
     if(Password.length()>password) {
    	 System.out.println("Enter valid password");
    	 Admin_Registration();
     }else {
     ResultSet rs = stmt.executeQuery("insert into Register values('"+First_Name+"','"+Last_Name+"','"+Email+"','"+Username+"','"+Password+"')");
     System.out.println("You are Succesfully Registered");
     }}}else {
    	  System.out.println("Enter valid Email address");
    	  Admin_Registration();
      }
     System.out.println("Do you want to leave the page ");
		System.out.println("1.Yes");
		System.out.println("2.No");
		sc.nextLine();
		int Log_Out = sc.nextInt();
		if(Log_Out == 2) {
			System.out.println("You have selected to Stay in the Site.");
			Admin_Registration();
		}else {
			System.out.println("Thank you for visiting school mangement system.");
		
		}
     }
     }
     
     }
	protected static void Admin_Module() throws SQLException {
		

		DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
        String oracleUrl = "jdbc:oracle:thin:@localhost:1521:xe";
        Connection con = DriverManager.getConnection(oracleUrl, "Rakshitha","Rakshasi@07");
		Scanner sc = new Scanner(System.in);
	   
		Statement stmt = con.createStatement();

		// Admin can do the following functions after loging in.
					 System.out.println("Welcome To Admin_Module");
						System.out.println("1.Add New Class");
						System.out.println("2.Add New Subject");
						System.out.println("3.Add New Teacher");
						System.out.println("4.Add New Student");
						System.out.println("5.Add New Parent");
						System.out.println("6.Log Out");
						System.out.println("Choose the Option");
						 int Admin_Module = sc.nextInt();
						 if(Admin_Module>6||Admin_Module<1) {
							 System.out.println("Choose valid option");
							 Admin_Module();
						 }else {
					switch (Admin_Module) {
					case 1 :
						System.out.println("New Class Creation");
						System.out.println("Enter Class Name");
						int Class_Name = sc.nextInt();
					    sc.nextLine();
					    if(Class_Name<0 || Class_Name>12) {
					    	System.out.println("The class is less or more than expected");
					    	Admin_Module();
					    }else {
						System.out.println("Enter Class Strength");
						int Class_Strength = sc.nextInt();
						if(Class_Strength<20 || Class_Strength>50) {
							System.out.println("The class strength is less or more than allowed");
							Admin_Module();
						}else {
						System.out.println("Enter Class Teacher");
						String Class_Teacher = sc.next();
						if(Class_Teacher.length()>classteacher) {
							System.out.println("Enter valid Teacher Name");
							Admin_Module();
						}else {
						ResultSet rs1 = stmt.executeQuery("insert into Class_Record values('"+Class_Name+"','"+Class_Strength+"','"+Class_Teacher+"')");
						System.out.println("The New Class " +Class_Name+ " is Created Succesfully");
						System.out.println("Do you want to Log Out");
						System.out.println("1.Yes");
						System.out.println("2.No");
						sc.nextLine();
						int Log_Out = sc.nextInt();
						if(Log_Out == 2) {
							System.out.println("You have selected to Stay in the Site.");
							Admin_Module();
						}else {
							System.out.println("You Have Succesfully Logged Out.");
							 
						}
						}
						}
					    }
					break;
					case 2 :
						System.out.println("New Subject Creation");
						System.out.println("Enter Subject Name");
						String Subject_Name = sc.next();
						sc.nextLine();
						if(Subject_Name.length()>subject) {
							System.out.println("Enter valid Subject name");
							Admin_Module();
						}else {
						System.out.println("Enter Subject Teacher");
						String Subject_Teacher = sc.next();
						if(Subject_Teacher.length()>classteacher) {
							System.out.println("Enter valid Teacher Name");
							Admin_Module();
						}else {
						ResultSet rs2 = stmt.executeQuery("insert into Subject_Record values('"+Subject_Name+"','"+Subject_Teacher+"')");
						System.out.println("The New Subject " +Subject_Name+ " is Added Succesfully");
						System.out.println("Do you want to Log Out");
						System.out.println("1.Yes");
						System.out.println("2.No");
						sc.nextLine();
						int Log_Out1 = sc.nextInt();
						if(Log_Out1 == 2) {
							System.out.println("You have selected to Stay in the Site.");
							Admin_Module();
						}else {
							System.out.println("You Have Succesfully Logged Out.");
						}
						}
						}
					break;
					case 3 :
				System.out.println("Adding New Teacher");
				System.out.println("Enter Teacher ID");
				String Teacher_ID = sc.next();
				sc.nextLine();
				if(Teacher_ID.length()>teacher_id) {
					System.out.println("Enter valid Teacher ID");
					Admin_Module();
				}else {
						System.out.println("Enter Teacher Name");
						String Teacher_Name = sc.next();
						sc.nextLine();
						if(Teacher_Name.length()>classteacher) {
							System.out.println("Enter valid Teacher Name");
							Admin_Module();
						}else {
						System.out.println("Enter Teacher Qualification");
						String Teacher_Qualification = sc.next();
						if(Teacher_Qualification.length()>qualification) {
							System.out.println("Enter valid Qualifications");
							Admin_Module();
						}else {
						System.out.println("Enter Teacher Years of Experience");
						sc.nextLine();
						int Teacher_Experience = sc.nextInt();
						if(Teacher_Experience < 1) {
							System.out.println("The teacher is not eligible ");
							Admin_Module();
						}else {
						ResultSet rs3 = stmt.executeQuery("insert into Teacher_Records values('"+Teacher_ID+"','"+Teacher_Name+"','"+Teacher_Qualification+"','"+Teacher_Experience+"')");
						System.out.println("The New Teacher " +Teacher_Name+ " is added Succesfully");
						System.out.println("Do you want to Log Out");
						System.out.println("1.Yes");
						System.out.println("2.No");
						sc.nextLine();
						int Log_Out2 = sc.nextInt();
						if(Log_Out2 == 2) {
							System.out.println("You have selected to Stay in the Site.");
							Admin_Module();
						}else {
							System.out.println("You Have Succesfully Logged Out.");
						} 
				}
				}
				}
				}
					break;
					case 4:
						System.out.println("Adding New Student");
						System.out.println("Enter the Student ID");
						String Student_ID=sc.next();
						if(Student_ID.length()>student_id) {
							System.out.println("Enter valid Student ID");
							Admin_Module();
						}else {
						System.out.println("Enter Student Name");
						String Student_Name = sc.next();
						sc.nextLine();
						if(Student_Name.length()>student_name) {
							System.out.println("Enter valid Student Name");
							Admin_Module();
						}else {
						System.out.println("Enter Parent name of Student");
						String Parent_Name = sc.next();
						if(Parent_Name.length()>parent_name) {
							System.out.println("Enter valid Parent name");
							Admin_Module();
						}else {
						System.out.println("Enter Age of Student");
						int Student_Age = sc.nextInt();
						if(Student_Age<0 || Student_Age>20) {
							System.out.println("The student age is less or more than expected");
							Admin_Module();
						}else {
						System.out.println("Enter Class of the Student");
						String Student_Class = sc.next();
						ResultSet rs4 = stmt.executeQuery("insert into Student_Records values('"+Student_ID+"', '"+Student_Name+"','"+Parent_Name+"','"+Student_Age+"','"+Student_Class+"')");
						System.out.println("The New Student " +Student_Name+ " is added Succesfully");
						System.out.println("Do you want to Log Out");
						System.out.println("1.Yes");
						System.out.println("2.No");
						sc.nextLine();
						int Log_Out3 = sc.nextInt();
						if(Log_Out3 == 2) {
							System.out.println("You have selected to Stay in the Site.");
							Admin_Module();
						}else {
							System.out.println("You Have Succesfully Logged Out.");
						} 
						}
						}
						}
						}
					break;
					case 5 :
						System.out.println("Adding New Parent");
						System.out.println("Enter Parent ID");
						String Parent_ID=sc.next();
						sc.nextLine();
						if(Parent_ID.length()>parent_id) {
							System.out.println("Enter valid Parent ID");
							Admin_Module();
						}else {
						System.out.println("Enter Parent Name");
						String Parent_Name1 = sc.next();
						sc.nextLine();
						if(Parent_Name1.length()>parent_name) {
							System.out.println("Enter valid Parent name");
							Admin_Module();
						}else {
						System.out.println("Enter Student name");
						String Parent_StudentName = sc.next();
						if(Parent_StudentName.length()>student_name) {
							System.out.println("Enter valid Student name");
							Admin_Module();
						}else {
						ResultSet rs5 = stmt.executeQuery("insert into Parents_Records values('"+Parent_ID+"','"+Parent_Name1+"','"+Parent_StudentName+"')");
						System.out.println("The New Parent " +Parent_Name1+ " is added Succesfully for " +Parent_StudentName+ "Student");
						System.out.println("Do you want to Log Out");
						System.out.println("1.Yes");
						System.out.println("2.No");
						sc.nextLine();
						int Log_Out4 = sc.nextInt();
						if(Log_Out4 == 2) {
							System.out.println("You have selected to Stay in the Site.");
							Admin_Module();
						}else {
							System.out.println("You Have Succesfully Logged Out.");
						} 
						}
						}
						}
					break;
					case 6 :
						System.out.println("Do you want to Log Out");
						System.out.println("1.Yes");
						System.out.println("2.No");
						int Log_Out5 = sc.nextInt();
						if(Log_Out5 == 2) {
							System.out.println("You have selected to Stay in the Site.");
							Admin_Module();
						}else {
							System.out.println("You Have Succesfully Logged Out.");
							 
						}
					
					break;
						default : 
							System.out.println("Choose the valid option");
					}
				}			
	}
	protected static void Teacher_Module() throws SQLException {
        String oracleUrl = "jdbc:oracle:thin:@localhost:1521:xe";
        Connection con = DriverManager.getConnection(oracleUrl, "Rakshitha","Rakshasi@07");
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Teacher Id");
       String  Teacher_ID = sc.next();
       if(Teacher_ID.length()>teacher_id) {
      	 System.out.println("Enter valid Teacher ID");
      	Teacher_Module();
       }else {
        Statement stmt = con.createStatement();
        String Query1= "Select * from Teacher_Records WHERE Teacher_ID like '"+Teacher_ID+"%'";
        ResultSet rs = stmt.executeQuery(Query1);
        try {
            while(rs.next()) {
                String Id= rs.getString("TEACHER_ID");
                if(Teacher_ID.contentEquals(Id) ) {
                	//A teacher can do the following functions after loging in successfully.
                     System.out.println("Welcome To Teaher module");
                        System.out.println("1.Enter Student Grade");
                        System.out.println("2.Post a Update or task");
                        System.out.println("3.View Complaint");
                        System.out.println("4.View Recommendation");
                        System.out.println("5.Log out");
                        int Option = sc.nextInt();
                        if(Option>5 ||Option<1) {
                        	System.out.println("Choose valid option");
                        	Teacher_Module();
                        }else {
                    switch (Option) {
                    case 1 :
                    	 System.out.println("Entering Student Grades");
                         String Id2= rs.getString("TEACHER_ID");
                         sc.nextLine();
                         if(Id2.length()>teacher_id) {
                        	 System.out.println("Enter valid Teacher ID");
                        	 Teacher_Module();
                         }else {
                         if(Teacher_ID.contentEquals(Id2) )  {
                         System.out.println("Enter Student_ID");
                         String Student_ID = sc.nextLine();
                         if(Student_ID.length()>student_id) {
                        	 System.out.println("Enter valid Student ID");
                        	 Teacher_Module();
                         }else {
                         System.out.println("Enter Subject");
                         String Subject = sc.nextLine();
                         if(Subject.length()>subject) {
                        	 System.out.println("Enter valid Subject");
                        	 Teacher_Module();
                         }else {
                         System.out.println("Enter Grade");
                         int Grade = sc.nextInt();
                         if(Grade<0) {
                        	 System.out.println("Enter valid Marks");
                        	 Teacher_Module();
                         }else {
                         ResultSet rs2 = stmt.executeQuery("insert into Student_Grades values('"+Student_ID+"','"+Subject+"','"+Grade+"')");
                         System.out.println("The Grades has been uploaded Succesfully");
                         }}}}else {
                             System.out.println("Enter valid Id");
                         }
                         System.out.println("Do you want to Log Out");
 						System.out.println("1.Yes");
 						System.out.println("2.No");
 						
 						int Log_Out1 = sc.nextInt();
 						if(Log_Out1 == 2) {
 							System.out.println("You have selected to Stay in the Site.");
 							Teacher_Module();
 						}else {
 							System.out.println("You Have Succesfully Logged Out.");
 						} 
                         }
                   break;
                    case 2:
                        System.out.println("Posting Updates");
                        String Id21= rs.getString("TEACHER_ID");
                        sc.nextLine();
                        if(Id21.length()>teacher_id) {
                        	System.out.println("Enter valid Teacher ID");
                        	Teacher_Module();
                        }else {
                        if(Teacher_ID.contentEquals(Id21) )  {
                        System.out.println("Enter your Update or Task");
                        String Updateortask = sc.next();
                        if(Updateortask.length()>update) {
                        	System.out.println("Enter valid Update or Task ");
                        	Teacher_Module();
                        }else {
                        ResultSet rs2 = stmt.executeQuery("insert into Teacher_Updates values('"+Id21+"','"+Updateortask+"')");
                        System.out.println("The update or task has been registered Succesfully");
                        }}else {
                            System.out.println("Enter valid Id");
                        }
                        System.out.println("Do you want to Log Out");
 						System.out.println("1.Yes");
 						System.out.println("2.No");
 					    sc.nextLine();
 						int Log_Out2 = sc.nextInt();
 						if(Log_Out2 == 2) {
 							System.out.println("You have selected to Stay in the Site.");
 							Teacher_Module();
 						}else {
 							System.out.println("You Have Succesfully Logged Out.");
 						} 
                        }
                    break;
                    case 3:
                        System.out.println("Viewing Complaints");
                        
                            String s1="Select * from Complaints";
                            ResultSet rs2=stmt.executeQuery(s1);                               
                            while(rs2.next()){                             
                            s1 = rs2.getString(1);
                            s1 = rs2.getString(2);
                            
                            System.out.println("The Received Complaints are from "+rs2.getString(1)+"  "+rs2.getString(2));
                            }
                            System.out.println("Do you want to Log Out");
     						System.out.println("1.Yes");
     						System.out.println("2.No");
     						  sc.nextLine();
     						int Log_Out3 = sc.nextInt();
     						if(Log_Out3 == 2) {
     							System.out.println("You have selected to Stay in the Site.");
     							Teacher_Module();
     						}else {
     							System.out.println("You Have Succesfully Logged Out.");
     						} 
                            
                          
                            
                    break;  
                    
                    case 4:
                    	System.out.println("Viewing Recommendations");
                        
                        String s2="Select * from Recommendations";
                        ResultSet rs3=stmt.executeQuery(s2);                               
                        while(rs3.next()){                             
                        s2 = rs3.getString(1);
                        s2 = rs3.getString(2);
                        
                        System.out.println("The Received Recommendations are from "+rs3.getString(1)+"  "+rs3.getString(2));
                        }
                        System.out.println("Do you want to Log Out");
 						System.out.println("1.Yes");
 						System.out.println("2.No");
 						  sc.nextLine();
 						int Log_Out4 = sc.nextInt();
 						if(Log_Out4 == 2) {
 							System.out.println("You have selected to Stay in the Site.");
 							Teacher_Module();
 						}else {
 							System.out.println("You Have Succesfully Logged Out.");
 						} 
                        
                     
                        
                break;  
                  
                    case 5:
                        System.out.println("Do you want to log out");
                        System.out.println("1.YES");
                        System.out.println("2.NO");
                        int Log_out=sc.nextInt();
                        if(Log_out ==2) {
                          Teacher_Module();
                        }else {
                            System.out.println("You have successfully logged out");
                        }
                        break;
                        default:
                            System.out.println("Choose Valid Option");
                    }
                }}else {
             	   System.out.println("Enter Valid ID");
             	   break;
                }
                        }
            } catch (SQLException e) {
                e.printStackTrace();
            }
       }
        	}
	
	static void Student_Module()  throws SQLException {
		 DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
         String oracleUrl = "jdbc:oracle:thin:@localhost:1521:xe";
         Connection con = DriverManager.getConnection(oracleUrl, "Rakshitha","Rakshasi@07");
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the Student Id");
   String  STUDENT_ID = sc.nextLine();
   if(STUDENT_ID.length()>student_id) {
  	 System.out.println("Enter valid Student ID");
  	Student_Module();
   }else {
    Statement stmt = con.createStatement();
    String Query2= "Select * from Student_Records WHERE STUDENT_ID like '"+STUDENT_ID+"%'";
    ResultSet rs = stmt.executeQuery(Query2);
    try {
        while(rs.next()) {
            String Id= rs.getString("STUDENT_ID");
            if(Id.length()>student_id) {
           	 System.out.println("Enter valid Student ID");
         	Student_Module();
            }else {
            if(STUDENT_ID.contentEquals(Id) )  {
              	//A Student can do the following functions after loging in successfully.
                 System.out.println("Welcome To Student Records");
                    System.out.println("1.View Subject Grade");
                    System.out.println("2.Post a complaint ");
                    System.out.println("3.Post a recommendation");
                    System.out.println("4.Log out");
                    int Studentrecord = sc.nextInt();
                    if(Studentrecord>4 ||Studentrecord<1) {
                    	System.out.println("Choose valid option");
                    	Student_Module();
                    }else {
                switch (Studentrecord) {
                case 1 :
                	 System.out.println("Viewing Your record");
                     System.out.println("Enter Student Id ");
                     String Student_ID  = sc.next(); 
                     if(Student_ID.length()>student_id) {
                    	 System.out.println("Enter valid Student ID");
                    		Student_Module();
                     }else {
                       String s2="Select * from Student_Grades WHERE STUDENT_ID like '"+Student_ID+"'";
                         ResultSet rs1=stmt.executeQuery(s2);                               
                         while(rs1.next()){                             
                         s2 = rs1.getString(2);
                         s2 = rs1.getString(3);           
                         System.out.println("The Grade of Student in Subject "+rs1.getString(2)+"\t"+rs1.getString(3));
                         }
                         System.out.println("Do you want to Log Out");
  						System.out.println("1.Yes");
  						System.out.println("2.No");
  						sc.nextLine();
  						int Log_Out1 = sc.nextInt();
  						if(Log_Out1 == 2) {
  							System.out.println("You have selected to Stay in the Site.");
  							Student_Module();
  						}else {
  							System.out.println("You Have Succesfully Logged Out.");
  						} 
                         
                     }
                 break;
                case 2:
                    System.out.println("Posting Complaint");
                    System.out.println("Enter Student ID");
                    String Id2 = sc.next();  
                    sc.nextLine();
                    if(Id2.length()>student_id) {
                   	 System.out.println("Enter valid Student ID");
                 	Student_Module();
                    }else {
                    if(Id2.contentEquals(Id2) )  {    
                    System.out.println("Enter your complaint");
                    String Complaint = sc.next();
                    sc.nextLine();
                    if(Complaint.length()>complaint) {
                    	System.out.println("Enter valid Complaint");
                    	Student_Module();
                    }else {
                    ResultSet rs2 = stmt.executeQuery("insert into Complaints values('"+Id2+"','"+Complaint+"')");
                    System.out.println("The complaint has been registered Succesfully");
                    }}else {
						System.out.println("You Have Succesfully Logged Out.");
					} 
                    System.out.println("Do you want to Log Out");
						System.out.println("1.Yes");
						System.out.println("2.No");						
						int Log_Out2 = sc.nextInt();
						if(Log_Out2 == 2) {
							System.out.println("You have selected to Stay in the Site.");
							Student_Module();
						
                }else {
                    System.out.println("Enter valid Id");
                }
                    }
                break;
                case 3 :
                    System.out.println("Posting Recommendation");
                    System.out.println("Enter Student ID");
                    String Id3 = sc.next();
                    sc.nextLine();
                    if(Id3.length()>student_id) {
                   	 System.out.println("Enter valid Student ID");
                 	Student_Module();
                    }else {
                    if(Id3.contentEquals(Id3) )  {
                    System.out.println("Enter your Recommendation");
                    String Recommend = sc.nextLine();
                    if(Recommend.length()>recommend) {
                    	System.out.println("Enter valid Recommendation");
                    	Student_Module();
                    }else {
                    ResultSet rs3= stmt.executeQuery("insert into Recommendations values('"+Id3+"','"+Recommend+"')");
                    System.out.println("The recommendation has been registered Succesfully");
                    }}else {
                        System.out.println("Enter valid Id");
                    }
                    System.out.println("Do you want to Log Out");
						System.out.println("1.Yes");
						System.out.println("2.No");						
						int Log_Out3 = sc.nextInt();
						if(Log_Out3 == 2) {
							System.out.println("You have selected to Stay in the Site.");
							Student_Module();
						}else {
							System.out.println("You Have Succesfully Logged Out.");
						} 
                    }
                break;
                case 4:
                    System.out.println("Do you want to log out");
                    System.out.println("1.YES");
                    System.out.println("2.NO");
                    int Log_out=sc.nextInt();
                    if(Log_out ==2) {
                    	System.out.println("You have selected to Stay in the Site.");
                        Student_Module();
                    }else {
                        System.out.println("You have successfully logged out");
                    }
                    break;
                    default:
                        System.out.println("Choose Valid Option");
            }
    }}else {
 	   System.out.println("Enter Valid ID");
 	   break;
    }
            }
        }
} catch (SQLException e) {
    e.printStackTrace();
}}}

	public static void Parent_Module() throws SQLException {
		 DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
         String oracleUrl = "jdbc:oracle:thin:@localhost:1521:xe";
         Connection con = DriverManager.getConnection(oracleUrl, "Rakshitha","Rakshasi@07");
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter Parent ID");
    String  PARENT_ID = sc.next();
    if(PARENT_ID.length()>parent_id) {
    	System.out.println("Enter valid Parent ID");
    	Parent_Module();
    }else {
    Statement stmt = con.createStatement();
    String Query3= "Select * from Parent_Login_Credential WHERE PARENT_ID like '"+PARENT_ID+"%'";
    ResultSet rs = stmt.executeQuery(Query3);
    try {
        while(rs.next()) {
            String Id= rs.getString("PARENT_ID");
            if(PARENT_ID.contentEquals(Id) )  {
              	//A Parent can do the following functions after loging in successfully.
                 System.out.println("Welcome To Parents module");
                    System.out.println("1.View Children Grade");
                    System.out.println("2.Post a complaint ");
                    System.out.println("3.Post a recommendation");
                    System.out.println("4.Log out");
                    int parentmodule= sc.nextInt();
                    if(parentmodule>4||parentmodule<1) {
                    	System.out.println("Choose valid option");
                    	Student_Module();
                    }else {
                switch (parentmodule) {
                case 1:
                	 System.out.println("Viewing Chrildren record");
                     System.out.println("Enter Student Id ");
                     String Student_ID  = sc.next();                       
                     if(Student_ID.length()>student_id) {
                    	 System.out.println("Enter valid Student ID");
                    	 Parent_Module();
                     }else {
                         String s4="Select * from Student_Grades WHERE STUDENT_ID like '"+Student_ID+"%'";
                         ResultSet rs1=stmt.executeQuery(s4);                               
                         while(rs1.next()){                             
                         s4 = rs1.getString(2);
                         s4 = rs1.getString(3);
           
                         System.out.println("The Grade of Student in Subject "+rs1.getString(2)+"\t"+rs1.getString(3));
                         }
                         System.out.println("Do you want to Log Out");
   						System.out.println("1.Yes");
   						System.out.println("2.No");
   						sc.nextLine();
   						int Log_Out1 = sc.nextInt();
   						if(Log_Out1 == 2) {
   							System.out.println("You have selected to Stay in the Site.");
   							Parent_Module();
   						}else {
   							System.out.println("You Have Succesfully Logged Out.");
   						} 
                     }
                         
                 break;       
                      
                case 2:
                    System.out.println("Posting Complaint");
                    System.out.println("Enter Parent_Id");
                    String ID2 = sc.next();
                    sc.nextLine();
                    if(ID2.length()>parent_id) {
                    	System.out.println("Enter valid Parent ID");
                    	Parent_Module();
                    }else {
                    if(PARENT_ID.contentEquals(ID2) )  {
                    System.out.println("Enter your complaint");
                    String Complaint = sc.next();
                    if(Complaint.length()>complaint) {
                    	System.out.println("Enter valid Complaint");
                    	Parent_Module();
                    }else {
                    ResultSet rs2 = stmt.executeQuery("insert into Complaints values('"+ID2+"','"+Complaint+"')");
                    System.out.println("The complaint has been registered Succesfully");
                    System.out.println("Do you want to Log Out");
						System.out.println("1.Yes");
						System.out.println("2.No");
						sc.nextLine();
						int Log_Out2 = sc.nextInt();
						if(Log_Out2 == 2) {
							System.out.println("You have selected to Stay in the Site.");
							Parent_Module();
						}else {
							System.out.println("You Have Succesfully Logged Out.");
						} 
                     
                    }}else {
                 	   System.out.println("Enter Valid ID");
                    }
                    }
                break;
                case 3:
                    System.out.println("Posting Recommendation");
                    System.out.println("Enter Parent_Id");
                    String ID3 = sc.next();
                    sc.nextLine();
                    if(ID3.length()>parent_id) {
                    	System.out.println("Enter valid Parent ID");
                    	Parent_Module();
                    }else {
                    if(PARENT_ID.contentEquals(ID3) )  {
                    System.out.println("Enter your Recommendation");
                    String Recommend = sc.next();
                    if(Recommend.length()>recommend) {
                    	System.out.println("Enter valid Recommendation");
                    	Parent_Module();
                    }else {
                    ResultSet rs3= stmt.executeQuery("insert into Recommendations values('"+ID3+"','"+Recommend+"')");
                    System.out.println("The recommendation has been registered Succesfully");
                    System.out.println("Do you want to Log Out");
						System.out.println("1.Yes");
						System.out.println("2.No");
						sc.nextLine();
						int Log_Out3 = sc.nextInt();
						if(Log_Out3 == 2) {
							System.out.println("You have selected to Stay in the Site.");
							Parent_Module();
						}else {
							System.out.println("You Have Succesfully Logged Out.");
						} 
                     
                    }}else {
                 	   System.out.println("Enter Valid ID");
                    }
                    }
                break;
                case 4:
                    System.out.println("Do you want to log out");
                    System.out.println("1.YES");
                    System.out.println("2.NO");
                    int Log_out=sc.nextInt();
                    if(Log_out ==2) {
                        return;
                    }else {
                        System.out.println("You have successfully logged out");
                    }
                    break;
                    default:
                        System.out.println("Choose Valid Option");
            }
                }
            }
}} catch (SQLException e) {
    e.printStackTrace();
}
	}

}

}