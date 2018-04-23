//STEP 1. Import required packages
import java.sql.*;


//be sure to set the classpath to iinclude the current
//directory as well as the 
//directory where the .jar file

public class FirstExample {
   // JDBC driver name and database URL
   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
   static final String DB_URL = "jdbc:mysql://107.180.2.3:3306/dfb";

   //  Database credentials
   static final String USER = "cisc150student";
   static final String PASS = "cisc150student";
      public static void main(String[] args) {
            Connection conn = null;
            Statement stmt = null;
            try{
                  //STEP 2: Register JDBC driver
                  Class.forName("com.mysql.jdbc.Driver");

                  //STEP 3: Open a connection
                  System.out.println("Connecting to database...");
                  conn = DriverManager.getConnection(DB_URL,USER,PASS);

                  //STEP 4: Execute a query
                  System.out.println("Creating statement...");
                  stmt = conn.createStatement();
                  String sql;
                  sql = "SELECT ID, username FROM users";
                  ResultSet rs = stmt.executeQuery(sql);

                  //STEP 5: Extract data from result set
                  while(rs.next()){
                  //Retrieve by column name
                  int id  = rs.getInt("id");
                  String username = rs.getString("username");

                  //Display values
                  System.out.print("ID: " + id);
                  System.out.println(", Username: " + username);
                  }
                  //STEP 6: Clean-up environment
                  rs.close();
                  stmt.close();
                  conn.close();
            }catch(SQLException se){
                  //Handle errors for JDBC
                  se.printStackTrace();
            }catch(Exception e){
                  //Handle errors for Class.forName
                  e.printStackTrace();
            }finally{
                  //finally block used to close resources
                  try{
                        if(stmt!=null)
                              stmt.close();
                  }catch(SQLException se2){
                        // nothing we can do
                  }

                  
                  try{
                        if(conn!=null)
                              conn.close();
                  }catch(SQLException se){
                        se.printStackTrace();
                  }//end finally try
            }//end try
            System.out.println("Goodbye!");
      }//end main
}//end FirstExample
