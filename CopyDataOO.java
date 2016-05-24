import java.sql.*;
import javax.sql.*;
class CopyDataOO
{
	public static void main(String args[])throws SQLException,ClassNotFoundException
	{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection ocon = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott","tiger");
		Statement st = ocon.createStatement();
		ResultSet rs = st.executeQuery("SELECT * FROM STU_MARKS");
		PreparedStatement pst = ocon.prepareStatement("INSERT INTO STU_MDETAILS VALUES(?,?,?)");
		while(rs.next())
			{
				String sname = rs.getString(1);
				int m1 = rs.getInt(2);
				int m2 = rs.getInt(3);
				int m3 = rs.getInt(4);
				
				int sum = m1+m2+m3;
				int avg = sum/3;

				pst.setString(1,sname);
				pst.setInt(2,sum);
				pst.setInt(3,avg);
				int i = pst.executeUpdate();
				if(i>0)
					System.out.println("Record is Inserted");
			}
		ocon.close();
	}
}