//step 1:import jdbc packages
import java.sql.*;
public class FetchDataFromMySQL{
  public static void main(String[] args) {
      String url = "jdbc:mysql://localhost:3306/geudb";
      try{
        //step 2: Load and Register JDBC Driver
        Class.forName("com.mysql.cj.jdbc.Driver");
        //Step 3: Establish a Connection
        Connection con=DriverManager.getConnection(url, "root", "root");
        //Step 4: Create a Statement
        Statement stmt  = con.createStatement();
        //Step 5: Create and Execute a Query
        String sql = "Select * from student";
        ResultSet rs = stmt.executeQuery(sql);
        System.out.println("Id\tUsername\tEmail");
        //Step 6: Process the Result Set
        while(rs.next()){
          int id = rs.getInt(1);
          String username = rs.getString(2);
          String email = rs.getString(3);
          System.out.println(id+"\t"+username+"\t\t"+email);
        } 
        //Step 7: Close the Connection
        con.close();
        stmt.close();
        rs.close();
      }
      catch(Exception e){
        System.out.println(e);
      }
  }  
}