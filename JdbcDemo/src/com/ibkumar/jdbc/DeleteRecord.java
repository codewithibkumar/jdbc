package com.ibkumar.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class DeleteRecord {

	public static void main(String[] args) {
		//Load the driver
		
			try {
				Scanner sc = new Scanner(System.in);
				System.out.println("Enter your name");
				int roll = sc.nextInt();
							
				Class.forName("com.mysql.cj.jdbc.Driver");
				
				//Get Connection with dbms
				Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/anshuldb","root","pass");
				
				PreparedStatement ps = con.prepareStatement("delete from students where roll=?");
								
				ps.setInt(1,roll);
			
				int row = ps.executeUpdate();
				if(row > 0)
					System.out.println("Data Deleted");
				else
					System.out.println("Data Deletion fail");
				
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
