package com.w_rmgyantra.DataBaseTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.mysql.jdbc.Driver;

public class projectUnitTesting
{
	@Test
	public void projectUnitTesting() throws SQLException
	{
		String projectname = "zoho Crm";
		Connection conn = null;
		try
		{
			Driver diverReq=new Driver();
			DriverManager.registerDriver(diverReq);
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/projects","root","root");
			Reporter.log("conncetion is done");
			Statement stat = conn.createStatement();
			String query = "select * from project";
			ResultSet resultset = stat.executeQuery(query);
			boolean flag = false;
			while (resultset.next())
			{
				String actprojectname = resultset.getString(4);
				if(actprojectname.equals(projectname))
				{
					
					flag=true;
				}
				

			}
			Assert.assertTrue(flag);
		}
		catch(Exception a)
		{

		}
		finally
		{
			conn.close();
			Reporter.log("===========close Database Connection=============");
		}
	}

}
