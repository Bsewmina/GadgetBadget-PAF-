package model;

import java.sql.*;

public class Account {
	
	private Connection connect() {
		Connection con = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1.:3306/account","root","toor");
			System.out.println("-------------Connection succeed----------");
		}catch(Exception e){
			System.out.println("-------------Error connectiong to database---------/n " + e.fillInStackTrace());
		}
		
		return con;
	}
	
	public void test() {

		
			Connection con = connect();	
		
	}

}
