package com.ibkumar.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class InsertRecord {

	public static void main(String[] args) {
		//Load the driver
		
			try {
				Scanner sc = new Scanner(System.in);
				System.out.println("Enter your name");
				String name = sc.next();
				
				System.out.println("Enter course name: ");
				String course = sc.next();
				
				System.out.println("Enter fee: ");
				float fee = sc.nextFloat();
				
				Class.forName("com.mysql.cj.jdbc.Driver");
				
				//Get Connection with dbms
				Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/anshuldb","root","pass");
				
				PreparedStatement ps = con.prepareStatement("insert into students (name,course, fee) values(?,?,?)");
				
				//ps.setString(1,"Ritika");
				//ps.setString(2, "Java");
				//ps.setFloat(3, 847.99f);
				
				ps.setString(1,name);
				ps.setString(2, course);
				ps.setFloat(3, fee);
				
				int row = ps.executeUpdate();
				if(row > 0)
					System.out.println("Data Inserted");
				else
					System.out.println("Data Insertion fail");
				
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
