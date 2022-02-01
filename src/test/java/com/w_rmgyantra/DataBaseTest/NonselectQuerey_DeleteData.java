package com.w_rmgyantra.DataBaseTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class NonselectQuerey_DeleteData {

	public static void main(String[] args) throws SQLException 
	{
		Connection conn=null;
		int resultset=0;
		try
		{
			Driver driverReq = new Driver();
			DriverManager.registerDriver(driverReq);
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/projects","root","root");
			System.out.println("connection DB");
			Statement stat = conn.createStatement();
			String query = " DELETE FROM project WHERE  project_id='TY_PROJ_005'";
			resultset = stat.executeUpdate(query);

		}
		catch(Exception e)
		{

		}
		finally
		{
			if(resultset==1)
			{
				System.out.println("Project is Deleted Pass");
			}
			else
			{
				System.err.println("Project is not Deleted Fail");

			}
			conn.close();
			System.out.println("=========connections close DB========================");

		}

	}

}
