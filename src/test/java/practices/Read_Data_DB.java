package practices;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.Reporter;
import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

public class Read_Data_DB 
{
	@Test

	public  void testDbConnection() throws SQLException
	{
		Driver driverReq = new Driver();
		/*Load/Register"mySQL"the database*/
		DriverManager.registerDriver(driverReq);
		/*connection to Database*/
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/projects","root", "root");
		/*Create Query statement*/
		Statement stat = conn.createStatement();
		String query = "select * from project";
		/*Execute Query statement*/
		ResultSet resultset = stat.executeQuery(query);
		while(resultset.next())
		{
			/*print on console*/
			Reporter.log(resultset.getString(1)+"\t"+resultset.getString(2)+"\t"+resultset.getString(4));
		}
			
		
	}

}
