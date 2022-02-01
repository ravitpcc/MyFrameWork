package com.w_rmgyantra.DataBaseTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class retrive_data_Mysql
{
	public static void main(String []args) throws SQLException
	{
		
		
	Driver	driverRef = new Driver();
	/*Load/Register"mySQL"the database*/
	 DriverManager.registerDriver(driverRef);
	/*connection to Database*/
	Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/projects","root", "root");
	/*Create Querey statment*/
	Statement stat = conn.createStatement();
	String query = "select * from project";
	/*Execute Querey statment*/
	ResultSet resultSet = stat.executeQuery(query);
	while(resultSet.next())
	{
		System.out.println(resultSet.getString(1)+"\t"+resultSet.getString(2)+"\t"+resultSet.getString(4));
	}
		
	/*close the conction*/	
	conn.close();	
	}

}