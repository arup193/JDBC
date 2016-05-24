import java.sql.*;
import javax.sql.*;
import java.util.Scanner;
class StoredP
{
	public static void main(String args[])throws SQLException,Exception
	{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott","tiger");
		String fcall = "{call Myvalues(?,?,?,?,?)}";
		CallableStatement cst = con.prepareCall(fcall);
		Scanner s = new Scanner(System.in);
		System.out.println("Enter Two Numbers :");
		int x = s.nextInt();
		int y = s.nextInt();
		cst.setInt(1,x);
		cst.setInt(2,y);
		cst.registerOutParameter(3,Types.INTEGER);
		cst.registerOutParameter(4,Types.INTEGER);
		cst.registerOutParameter(5,Types.INTEGER);
		cst.execute();
		int p = cst.getInt(3);
		int q = cst.getInt(4);
		int r = cst.getInt(5);
		System.out.println("Sum : "+p+"\nProduct : "+q+"\nDifference : "+r);
		con.close();
		cst.close();
	}
}