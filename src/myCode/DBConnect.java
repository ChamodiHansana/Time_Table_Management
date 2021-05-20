
package myCode;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {
    
    public static Connection connect(){
         Connection con=null;
          try{
                Class.forName("com.mysql.cj.jdbc.Driver");
                con=(Connection )DriverManager.getConnection("jdbc:mysql://localhost:3306/timetablemanage","root","");
                
            }catch(ClassNotFoundException | SQLException e){
                System.out.println("Database Connection not SUCCESS");
            }
            return con;
         
    }
    
   

   
}
