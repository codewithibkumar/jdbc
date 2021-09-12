package com.ibkumar.jdbc;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MetaData {

	public static String URL = "jdbc:mysql://localhost:3306/ducatdb";
	public static String USER = "root";
	public static String PASS = "pass";
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try
		{
			Connection con = DriverManager.getConnection(URL,USER,PASS);
			
			DatabaseMetaData dbmd =	con.getMetaData();
			System.out.println(dbmd.getDriverName());
			System.out.println(dbmd.getDriverVersion());
			
			ResultSet rs = dbmd.getTables(null,null, null, new String[]{"TABLE"});
			
			while(rs.next())
			{
				System.out.println(rs.getString(3));
			}
			con.close();
		}
		catch(SQLException e)
		{
			System.out.println(e+"");
		}
		
	}

}
