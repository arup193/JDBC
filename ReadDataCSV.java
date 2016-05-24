import java.sql.*;
import javax.sql.*;
import sun.jdbc.odbc.*;
class ReadDataCSV 
{
	public static void main(String[] args)throws Exception 
	{
		try
		{
			DriverManager.registerDriver(new JdbcOdbcDriver());
			System.out.println("Drivers are Loaded");
			Connection con = DriverManager.getConnection("jdbc:odbc:csvdsn");
			System.out.println("Connection is Established");
			Statement st = con.createStatement();
			System.out.println("Statement object is Created");
			ResultSet rs = st.executeQuery("SELECT * FROM ReadDataCSV.txt");
			if(rs!=null)
			{
				while(rs.next())
				{
					Thread.sleep(500);
					String deptno = rs.getString(1);
					String dname = rs.getString(2);
					String loc = rs.getString(3);
					System.out.println(deptno+"|"+dname+"|"+loc);
					System.out.println("----------------------------");
				}
			}
			else
				System.out.println("Records Not Found");

		}
		catch (SQLException se)
		{
			System.out.println("Error : "+se);
		}
	}
}