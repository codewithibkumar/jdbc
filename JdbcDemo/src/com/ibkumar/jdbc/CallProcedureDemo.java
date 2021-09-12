package com.ibkumar.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class CallProcedureDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try
		{
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/anshuldb","root","pass");
			
			CallableStatement cs=	con.prepareCall("{call getAllStudents()}");
			
			ResultSet rs =	cs.executeQuery();
			
			while(rs.next())
			{
				System.out.print(rs.getInt(1)+"\t");
				System.out.println(rs.getString(2)+"\t");
			}
			con.close();
		}
		catch(Exception e)
		{}
	}
	

}
