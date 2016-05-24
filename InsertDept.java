import java.sql.*;
import javax.sql.*;
import oracle.jdbc.driver.*;
class InsertDept 
{
	public static void main(String[] args)
	{
		try
		{
			DriverManager.registerDriver(new OracleDriver());
			System.out.println("Drivers are Loaded");
			Connection con = DriverManager.getConnection("Jdbc:Oracle:thin:@localhost:1521:orcl","scott","tiger");
			System.out.println("Connection is Established");
			Statement st = con.createStatement();
			System.out.println("Statement object is Created");
			int i = st.executeUpdate("INSERT INTO DEPT1 VALUES(50,'IT','HYDERABAD')");
			if(i>0)
				System.out.println("Record is Inserted");
			else
				System.out.println("Record is Not Inserted");

		}
		catch (SQLException se)
		{
			System.out.println("Error : "+se);
		}
	}
}