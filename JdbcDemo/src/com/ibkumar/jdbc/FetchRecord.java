package com.ibkumar.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FetchRecord {

	public static void main(String[] args) {
		
		//Load the driver
				try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		//Get Connection with dbms
			Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/anshuldb","root","pass");
		// create or execute statement	
			PreparedStatement ps = con.prepareStatement("select roll,name, course, fee from students");
			ResultSet rs =ps.executeQuery();
		//processed returned data
			while(rs.next())
			{
				System.out.print(rs.getInt(1)+"\t");
				System.out.print(rs.getString(2)+"\t");
				System.out.print(rs.getString(3)+"\t");
				System.out.println(rs.getFloat(4));
			}
		//connection close
			con.close();
		
					
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

	}

}
