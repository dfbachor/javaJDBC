


import java.sql.*;


public class PersonLocation 
{

    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
    static final String DB_URL = "jdbc:mysql://107.180.2.3:3306/dfb";

    static final String USER = "cisc150student";
    static final String PASS = "cisc150student";
 
    public static void main(String[] args) 
    {
        Connection connection = null;
        Statement statement = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");

            System.out.println("Connecting to database...");
            connection = DriverManager.getConnection(DB_URL,USER,PASS);

            System.out.println("Creating statement...");
            statement = connection.createStatement();
            
            String sql;
            sql = "select p.firstname, p.lastName, l.city, l.state from Person p, Location l where p.locationID = l.locationID";
            
            ResultSet resultSet = statement.executeQuery(sql);

            System.out.printf("%-15s %-15s %-15s %-5s\n", "First", "Last", "City", "State");
            System.out.println("-----------------------------------------------------");

            while(resultSet.next()){
                String firstName = resultSet.getString("firstName");
                String lastName = resultSet.getString("lastName");
                String city = resultSet.getString("city");
                String state = resultSet.getString("state");

                System.out.printf("%-15s %-15s %-15s %-15s", firstName, lastName, city, state);
                System.out.println();
            }

            resultSet.close();
            statement.close();
            connection.close();

        }catch(SQLException se){
                //Handle errors for JDBC
                se.printStackTrace();
        }catch(Exception e){
                //Handle errors for Class.forName
                e.printStackTrace();
        }finally{
                //finally block used to close resources
                try{
                    if(statement!=null)
                        statement.close();
                }catch(SQLException se2){
                    // nothing we can do
                }
                
                try{
                    if(connection!=null)
                        connection  .close();
                }catch(SQLException se){
                    se.printStackTrace();
                }//end finally try
        }//end try
        System.out.println("Goodbye!");
    }//end main
}//end FirstExample