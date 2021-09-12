package com.ibkumar.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class UpdateRecord {

	public static void main(String[] args) {
		//Load the driver
		
			try {
				Scanner sc = new Scanner(System.in);
				System.out.println("Enter your Roll");
				int roll = sc.nextInt();
				
				System.out.println("Enter course name: ");
				String course = sc.next();
						
				Class.forName("com.mysql.cj.jdbc.Driver");
				
				//Get Connection with dbms
				Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/anshuldb","root","pass");
				
				PreparedStatement ps = con.prepareStatement("update students set course=? where roll=?");
								
				ps.setString(1,course);
				ps.setInt(2, roll);
				//ps.setFloat(3, fee);
				
				int row = ps.executeUpdate();
				if(row > 0)
					System.out.println("Data Updated");
				else
					System.out.println("Data Updation fail");
				
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
