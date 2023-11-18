package bank.management.system;
import java.sql.*;
public class Conn {
    Connection c;
    Statement s ;
    public Conn(){
        try{
//        Class.forName(oracle.jdbc.driver.OracleDriver);
          String s1 = "jdbc:oracle:thin:scott/tiger@localhost:1521:orcl";
          c = DriverManager.getConnection(s1);
          s = c.createStatement();
          
        } 
        catch(Exception e){
         System.out.println(e);
        }
     }
         
}
