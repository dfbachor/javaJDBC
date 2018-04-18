


import java.sql.*;


public class PersonLocation 
{

    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
    static final String DB_URL = "jdbc:mysql://107.180.2.3:3306/dfb";

    static final String USER = "cisc150student";
    static final String PASS = "cisc150student";
 
    public static void main(String[] args) 
    {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            
        } catch() {

        }

    }

}