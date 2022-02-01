package com.w_rmgyantra.DataBaseTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class NonselectQuerey_UpdateData {

	public static void main(String[] args) throws SQLException 
	{
		Driver divReq = new Driver(); 
		DriverManager.registerDriver(divReq);
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/projects","root","root");
		System.out.println("connection is done");
		Statement stat = conn.createStatement();
		String query = "UPDATE project SET created_by = 'Akash'WHERE project_id='TY_PROJ_202'";
		int Resultset = stat.executeUpdate(query);
		conn.close();
		System.out.println("Close the connection");
		

	}

}
