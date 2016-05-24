import java.sql.*;
import javax.sql.*;
import oracle.jdbc.driver.*;
class AbDetDept 
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
			ResultSet rs = st.executeQuery("SELECT DEPTNO,COUNT(DISTINCT(JOB)),COUNT(EMPNO),MAX(SAL),MIN(SAL),AVG(SAL),SUM(SAL) FROM EMP GROUP BY DEPTNO HAVING SUM(SAL)>=6000");
			if(rs!=null)
			{
				while(rs.next())
				{
					Thread.sleep(500);
					int dno = rs.getInt(1);
					int cj = rs.getInt(2);
					int ce = rs.getInt(3);
					int max = rs.getInt(4);
					int min = rs.getInt(5);
					int avg = rs.getInt(6);
					int sum = rs.getInt(7);
					System.out.println(dno+"|"+cj+"|"+ce+"|"+max+"|"+min+"|"+avg+"|"+sum);
					System.out.println("-------------------------------------------------");
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