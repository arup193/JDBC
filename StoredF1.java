import java.sql.*;
import javax.sql.*;
import java.util.Scanner;
class StoredF1
{
	public static void main(String args[])throws SQLException,Exception
	{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott","tiger");
		String fcall = "{?=call fres(?,?,?)}";
		CallableStatement cst = con.prepareCall(fcall);
		Scanner s = new Scanner(System.in);
		System.out.println("Enter Three Numbers :");
		int x = s.nextInt();
		int y = s.nextInt();
		int z = s.nextInt();
		cst.setInt(2,x);
		cst.setInt(3,y);
		cst.setInt(4,z);
		cst.registerOutParameter(1,Types.VARCHAR);
		cst.execute();
		String res = cst.getString(1);
		System.out.println("Result is "+res);
		con.close();
		cst.close();
	}
}