import java.sql.*;
import javax.sql.*;
class CopyDataOE
{
	public static void main(String args[])throws SQLException,ClassNotFoundException,Exception
	{
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection econ = DriverManager.getConnection("jdbc:odbc:xlsdsn");
		Connection ocon = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott","tiger");
		Statement st = ocon.createStatement();
		ResultSet rs = st.executeQuery("SELECT * FROM DEPT1");
		PreparedStatement pst = econ.prepareStatement("INSERT INTO [O_E$] VALUES(?,?,?)");
		while(rs.next())
			{
				String dno = new Integer(rs.getInt(1)).toString();
				String dname = rs.getString(2);
				String dcity = rs.getString(3);
				pst.setString(1,dno);
				pst.setString(2,dname);
				pst.setString(3,dcity);
				int i = pst.executeUpdate();
				if(i>0)
					System.out.println("Record is Inserted");
			}
		econ.close();
		ocon.close();
	}
}