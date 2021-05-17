/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package myCode;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Dulanga Methsara
 */
public class DBConnect {
    
    public static Connection connect(){
         Connection con=null;
          try{
                Class.forName("com.mysql.jdbc.Driver");
                con=DriverManager.getConnection("jdbc:mysql://localhost:3306/timetablemanage","root","");
                
            }catch(Exception e){
                System.out.println("Database Connection not SUCCESS");
            }
            return con;
         
    }
    
   

   
}
