package com.w_rmgyantra.DataBaseTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class selectQuerey_SampleCode {

	public static void main(String[] args) throws SQLException
	{ 
		Connection  conn=null;
		int count=0;
		try
		{
		
		Driver driverReq=new Driver();
		DriverManager.registerDriver(driverReq);
		 conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/projects","root","root");
		 System.out.println("Connection on DataBase");
		 Statement stat= conn.createStatement();
		 String qurey = "select* from project";
		  ResultSet result = stat.executeQuery(qurey);
		  while(result.next())
		  {
			  System.out.println(result.getString(1)+"\t"+result.getString(2)+"\t"+result.getString(4));
			  count++;
		  }
		  
		}
		catch(Exception e)
		{
			System.out.println("Exception Handelled");
			
		}
		finally
		{
		if(count>0)
		{
			System.out.println("Data Retrive Sussfully");
		}
		if(count==0)
		{
			System.err.println("Data not Retrive");
		}
		 
		conn.close();
		System.out.println("============Close Conections from DataBase=============");
	
	}

	}
}
