package com.ibkumar.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;

public class CallPrameterizedProcedureDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try
		{
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/anshuldb","root","pass");
			
			CallableStatement cs=	con.prepareCall("{call insertStudent(?,?,?,?)}");
			//cs.setString(1, "Raju");
			//cs.setLong(2, 949499494L);
			//cs.setInt(3, 1);
			//cs.setInt(4, 1);
			//cs.setInt(1, 2);
			cs.setString(1, "Nipendra");
			cs.setString(2, "Java");
			cs.setFloat(3, 3434.3f);
			cs.registerOutParameter(4, Types.INTEGER);
			int r = cs.executeUpdate();
			System.out.println(r+" inserted");
			
			System.out.println("Total Student are: "+cs.getInt(4));
			con.close();
			
			
		}
		catch(SQLException e)
		{
			System.err.println(e+"");
		}
	}

}
