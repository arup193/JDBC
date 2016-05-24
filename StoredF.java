import java.sql.*;
import javax.sql.*;
import java.util.Scanner;
class StoredF
{
	public static void main(String args[])throws SQLException,Exception
	{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott","tiger");
		String fcall = "{?=call addnum(?,?)}";
		CallableStatement cst = con.prepareCall(fcall);
		Scanner s = new Scanner(System.in);
		System.out.println("Enter Two Numbers :");
		int x = s.nextInt();
		int y = s.nextInt();
		cst.setInt(2,x);
		cst.setInt(3,y);
		cst.registerOutParameter(1,Types.INTEGER);
		cst.execute();
		int res = cst.getInt(1);
		System.out.println("Result is "+res);
		con.close();
		cst.close();
	}
}