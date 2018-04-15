//STEP 1. Import required packages
import java.sql.*;

public class GetUsers {
   // JDBC driver name and database URL
   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
   static final String DB_URL = "jdbc:mysql://localhost/plowing";

   //  Database credentials
   static final String USER = "dfbplower";
   static final String PASS = "dfbplower";
   
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
      sql = "SELECT id, username, email, phone FROM users";
      ResultSet rs = stmt.executeQuery(sql);

	  System.out.format("%s\t%-25s\t%-25s\t%-16s\n", "ID", "Name", "email", "phone");
      //STEP 5: Extract data from result set
      while(rs.next()){
         //Retrieve by column name
         int id  = rs.getInt("id");
         String flname = rs.getString("username");
         String email = rs.getString("email");
         String phone = rs.getString("phone");

         //Display values
         
         System.out.format("%s\t%-25s\t%-25s\t%-16s\n", id, flname, email, phone);
         //System.out.print("ID: " + id + "\t");
         //System.out.print("username: " + flname + "\t");
         //System.out.print("email: " + email + "\t");
         //System.out.println("phone: " + phone + "\t");
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
      }// nothing we can do
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