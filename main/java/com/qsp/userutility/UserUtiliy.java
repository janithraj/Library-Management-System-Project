package com.qsp.userutility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class UserUtiliy {
	private static String url ="jdbc:mysql://localhost:3306/janithraj1";
	private static  String user="root";
	private static String password="root";
	
	static {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");   
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	static public Connection getconnection() {
		
		Connection con=null;
		
		try {
			con=DriverManager.getConnection(url,user,password);
		} catch (SQLException e) {
			System.out.println("not get connected");
			e.printStackTrace();
		}
		
		return con;
		}
		
		
	
	
	static public void getcloseconnection(Connection con) throws SQLException {
		
		if(con!=null) {
			con.close();
		}
		else {
			System.out.println("not closed properly");
		}
		
	}
	
	
	
	
	

}
