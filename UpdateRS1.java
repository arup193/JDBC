import java.sql.*;
import javax.sql.*;
class UpdateRS1
{
	public static void main(String[] args)throws SQLException,ClassNotFoundException,Exception
	{
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		Connection con = DriverManager.getConnection("jdbc:odbc:oradsn","scott","tiger");
		Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
		ResultSet rs = st.executeQuery("SELECT * FROM DEPT1");
		System.out.println("INSERTING");
		rs.moveToInsertRow();
		rs.updateInt(1,50);
		rs.updateString(2,"IT");
		rs.updateString(3,"INDIA");
		rs.insertRow();
		rs.beforeFirst();
		while(rs.next())
		{
			System.out.println(rs.getString(1)+" | "+rs.getString(2)+" | "+rs.getString(3));
		}
		System.out.println("Record Inserted\n--------------------------------------");
		System.out.println("UPDATING");
		rs.absolute(2);
		rs.updateString(2,"PRODUCTION");
		rs.updateString(3,"MELBOURNE");
		rs.updateRow();
		rs.beforeFirst();
		while(rs.next())
		{
			System.out.println(rs.getString(1)+" | "+rs.getString(2)+" | "+rs.getString(3));
		}
		System.out.println("Record Updated\n----------------------------------------");
		System.out.println("DELETING");
		rs.absolute(3);
		rs.deleteRow();
		rs.beforeFirst();
		while(rs.next())
		{
			System.out.println(rs.getString(1)+" | "+rs.getString(2)+" | "+rs.getString(3));
		}
		System.out.println("Record Deleted\n----------------------------------------");
		System.out.println("\n\nDEPARTMENT TABLE");
		rs.beforeFirst();
		while(rs.next())
		{
			System.out.println(rs.getString(1)+" | "+rs.getString(2)+" | "+rs.getString(3));
		}
		st.close();
		con.close();
	}
}