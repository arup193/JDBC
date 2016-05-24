import java.sql.*;
import javax.sql.*;
class ResSetMDE1
{
	public static void main(String args[])throws SQLException,ClassNotFoundException
	{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott","tiger");
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("SELECT * FROM DEPT");
		System.out.println("ResultSet Interface Object is Created");
		ResultSetMetaData rsmd = rs.getMetaData();
		int nc = rsmd.getColumnCount();
		System.out.println("Number of Columns in Table : "+nc);
		for(int i=1;i<=nc;i++)
		{
			System.out.println(rsmd.getColumnName(i));
			System.out.println(rsmd.getColumnTypeName(i));
			System.out.println("--------------------------");
		}
		while(rs.next())
		{
			for(int j=1;j<=rsmd.getColumnCount();j++)
			{
				System.out.print("  "+rs.getString(j));
			}
			System.out.println("\n----------------------------");
		}
		st.close();
		con.close();
	}
}