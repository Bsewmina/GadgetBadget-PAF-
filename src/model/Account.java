package model;

import java.sql.*;

public class Account {
	
	private Connection connect() {
		Connection con = null;
		
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gadgetbadget_db","root","toor");
			System.out.println("-------------Connection succeed----------");
		}catch(Exception e){
			System.out.println("-------------Error connectiong to database---------/n " + e.fillInStackTrace());
		}
		
		return con;
	}
	
	public void test() {
		
			Connection con = connect();		
	}
	
	public String createAccount(String fname,String lname,String gender,int num,String email,String pass) {
		String result = null;
		
		try {
			
			Connection con = connect();
			PreparedStatement ps = null;
			
			if(con == null) {
				return "	Null connection Error !!!";
			}
			//(acc_id,first_name,last_name,gender,mobile_no,email,password)
			
			String sql = "INSERT INTO account VALUES (NULL,?,?,?,?,?,?)";
            ps = con.prepareStatement(sql);
            ps.setString(1,fname);
            ps.setString(2,lname);
            ps.setString(3,gender);
            ps.setInt(4,num);
            ps.setString(5,email);
            ps.setString(6,pass);
            
            ps.execute();
            
            
		}catch(Exception e) {
			
			System.err.println("error while insering !!!!!\n" + e.getMessage());
			return "error while insering !!!!!";
			
		}
		
		return "	Data added successfully !!!!!";
		
	}
	
	
	public String updateAccount(int acc_id,String fname,String lname,String gender,int num,String email,String pass) {
		
		String result = null;
		
		try {

			Connection con = connect();
			PreparedStatement ps = null;
			
			if(con == null) {
				return "	Null connection Error !!!";
			}
			
			String sql = "UPDATE account SET acc_id=?, first_name=?, last_name=?, gender=?, mobile_no=?, email=?, password=? WHERE acc_id = ?";
			
			ps = con.prepareStatement(sql);
			ps.setInt(1,acc_id);
			ps.setString(2, fname);
			ps.setString(3, lname);
			ps.setString(4, gender);
			ps.setInt(5, num);
			ps.setString(6, email);
			ps.setString(7, pass);
			ps.setInt(8,acc_id);
			
			ps.execute();
			
			
			
		}catch(Exception e) {
			
			System.err.println("error while Updating !!!!!\n" + e.getMessage());
			return "error while Updating !!!!!";
		}
		
		return "	Data Updated successfully !!!!!";
		
	}
	
	public String deleteAccount(int acc_id) {
		
		try {
			
			Connection con = connect();
			PreparedStatement ps = null;
			
			if (con == null) {
				return "	Null connection Error !!!";
			}
			
			String sql = "DELETE FROM account WHERE acc_id = ?";
			
			ps = con.prepareStatement(sql);
			ps.setInt(1, acc_id);
			
			ps.execute();
			
			
		}catch(Exception e) {
			
			System.err.println("error while Deleting !!!!!\n" + e.getMessage());
			return "error while Deleting !!!!!";
		}
		
		return "	Data Deleted successfully !!!!!";
	}
	
	
	
	
	
	

}
