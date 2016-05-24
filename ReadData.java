import java.sql.*;
import javax.sql.*;
import sun.jdbc.odbc.*;
class ReadData 
{
	public static void main(String[] args)throws SQLException,Exception 
	{
		DriverManager.registerDriver(new JdbcOdbcDriver());
		System.out.println("Drivers are Loaded");
		Connection con = DriverManager.getConnection("jdbc:odbc:oradsn","scott","tiger");
		System.out.println("Connection is Established");
		Statement st = con.createStatement();
		System.out.println("Statement object is Created");
		ResultSet rs = st.executeQuery("SELECT * FROM DEPT");
		if(rs==null)
			System.out.println("No Records Found");
		else
		{
			while(rs.next())
			{
				Thread.sleep(500);
				int dno = rs.getInt(1);
				String dname = rs.getString(2);
				String loc = rs.getString(3);
				System.out.println(dno+"|"+dname+"|"+loc);
				System.out.println("----------------------------");
			}
		}
		con.close();
		st.close();
	}
}
