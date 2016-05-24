import java.sql.*;
import javax.sql.*;
import oracle.jdbc.driver.*;
class AbDetailsJob 
{
	public static void main(String[] args)throws Exception
	{
		try
		{
			DriverManager.registerDriver(new OracleDriver());
			System.out.println("Drivers are Loaded");
			Connection con = DriverManager.getConnection("Jdbc:Oracle:thin:@localhost:1521:orcl","scott","tiger");
			System.out.println("Connection is Established");
			Statement st = con.createStatement();
			System.out.println("Statement object is Created");
			ResultSet rs = st.executeQuery("SELECT JOB,SUM(SAL),MAX(SAL),AVG(SAL),MIN(SAL),COUNT(EMPNO) FROM EMP WHERE JOB NOT IN('MANAGER') GROUP BY JOB");
			if(rs!=null)
			{
				while(rs.next())
				{
					Thread.sleep(500);
					String jb = rs.getString(1);
					int sum = rs.getInt(2);
					int max = rs.getInt(3);
					int avg = rs.getInt(4);
					int min = rs.getInt(5);
					int count = rs.getInt(6);
					System.out.println(jb+"|"+sum+"|"+max+"|"+avg+"|"+min+"|"+count);
					System.out.println("---------------------------------------------");
				}
			}
			else
				System.out.println("Record Not Found");

		}
		catch (SQLException se)
		{
			System.out.println("Error : "+se);
		}
	}
}