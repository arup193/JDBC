import javax.sql.*;
import java.sql.*;
import sun.jdbc.odbc.*;
class ConnT
 {
  public static void main(String args[])throws SQLException
   {
    //Step-1
    JdbcOdbcDriver d = new JdbcOdbcDriver();
    DriverManager.registerDriver(d);
    //DriverManager.registerDriver(new JdbcOdbcDriver());
    System.out.println("Drivers are Loaded");
    //Step-2
    Connection con = DriverManager.getConnection("jdbc:odbc:oradsn","scott","tiger");
     if(con!=null)
      {
       System.out.println("Connection is Established");
      }
     else
      {
       System.out.println("Connection Failed");
      }
   }
 }