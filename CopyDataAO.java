import java.sql.*;
import javax.sql.*;
class CopyDataAO
{
	public static void main(String args[])throws SQLException,ClassNotFoundException
	{
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection acon = DriverManager.getConnection("jdbc:odbc:mdbdsn");
		Connection ocon = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott","tiger");
		Statement st = acon.createStatement();
		ResultSet rs = st.executeQuery("SELECT * FROM A_O");
		PreparedStatement pst = ocon.prepareStatement("INSERT INTO SINFO VALUES(?,?,?)");
		while(rs.next())
			{
				int dno = rs.getInt(1);
				String dname = rs.getString(2);
				String dcity = rs.getString(3);
				pst.setInt(1,dno);
				pst.setString(2,dname);
				pst.setString(3,dcity);
				int i = pst.executeUpdate();
				if(i>0)
					System.out.println("Record is Inserted");
			}
		acon.close();
		ocon.close();
	}
}