package com.w_rmgyantra.DataBaseTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class NonselectQuerey_InsertData {

	public static void main(String[] args) throws SQLException 
	{ 
		Connection conn = null;
		int result=0;
		try
		{
		Driver driverReq=new Driver();
		DriverManager.registerDriver(driverReq);
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/projects","root","root");
		System.out.println("connection is done");
		Statement stat = conn.createStatement();
		String query = "insert into project values('TY_PROJ_211','Ramman',14/01/2023,'	HDFC1','CReated',8)";
		result = stat.executeUpdate(query);
		}
		catch(Exception e)
		{
			
		}
		finally
		{
			if(result==1)
			{
				System.out.println("Project insert succesfully");
			}
			else
			{
				System.err.println("project is not inserted");
			}
			conn.close();
			System.out.println("====================Close DB Connection====================");
		}
		
		
	}

}
