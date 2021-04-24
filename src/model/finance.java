package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class finance {
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
	
	public String createfinance(int tax_id, String product_category, int tax_rate) {
		String result = null;
		
		try {
			
			Connection con = connect();
			PreparedStatement ps = null;
			
			if(con == null) {
				return "	Null connection Error !!!";
			}
			
			
			String sql = "INSERT INTO finance VALUES (NULL,?,?)";
            ps = con.prepareStatement(sql);
            ps.setString(1,product_category);
            ps.setInt(2,tax_rate);
            
          
            
            ps.execute();
            
            
		}catch(Exception e) {
			
			System.err.println("Error occurred while Inserting Data!\n" + e.getMessage());
			return "Error occurred while Inserting Data!";
			
		}
		
		return "	Data added to the database Successfully! ";
		
	}
	
	
	public String updatefinance(int tax_id, String product_category, int tax_rate) {
		
		String result = null;
		
		try {

			Connection con = connect();
			PreparedStatement ps = null;
			
			if(con == null) {
				return "	Null connection Error !!!";
			}
			
			String sql = "UPDATE finance SET tax_id=?, product_category=?, tax_rate=?";
			
			ps = con.prepareStatement(sql);
			ps.setInt(1,tax_id);
			ps.setString(2, product_category);
			ps.setInt(3, tax_rate);
            
			ps.setInt(8,tax_id);
			
			ps.execute();
			
			
			
		}catch(Exception e) {
			
			System.err.println("Error occurred while Updating Data!\n" + e.getMessage());
			return "Error occurred while Updating Data!";
		}
		
		return "	Data updated Successfully!";
		
	}
	
	public String deletefinance(int tax_id) {
		
		try {
			
			Connection con = connect();
			PreparedStatement ps = null;
			
			if (con == null) {
				return "	Null connection Error !!!";
			}
			
			String sql = "DELETE FROM finance WHERE tax_id = ?";
			
			ps = con.prepareStatement(sql);
			ps.setInt(1, tax_id);
			
			ps.execute();
			
			
		}catch(Exception e) {
			
			System.err.println("Error Deleting finance ! \n" + e.getMessage());
			return "Error Deleting finance ! ";
		}
		
		return "	finance Deleted Successfully !";
	}
	

}
