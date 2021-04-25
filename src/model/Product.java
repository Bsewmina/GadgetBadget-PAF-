package model;

import java.sql.*;

public class Product {
	
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
	
	public String createProduct(String p_name,String innovator_name,int initial_price,int stock_amount,String product_category) {
		String result = null;
		
		try {
			
			Connection con = connect();
			PreparedStatement ps = null;
			
			if(con == null) {
				return "Null connection Error !!!";
			}
			
			
			String sql = "INSERT INTO products VALUES (NULL,?,?,?,?,?)";
            ps = con.prepareStatement(sql);
            ps.setString(1,p_name);
            ps.setString(2,innovator_name);
            ps.setInt(3,initial_price);
            ps.setInt(4,stock_amount);
            ps.setString(5,product_category);
          
            
            ps.execute();
            
            
		}catch(Exception e) {
			
			System.err.println("Error occurred while Inserting Data!\n" + e.getMessage());
			return "Error occurred while Inserting Data!";
			
		}
		
		return "	   Data added to the database Successfully! ";
		
	}
	
	
	public String updateProduct(int p_id,String p_name,String innovator_name,int initial_price,int stock_amount,String product_category) {
		
		String result = null;
		
		try {

			Connection con = connect();
			PreparedStatement ps = null;
			
			if(con == null) {
				return "	Null connection Error !!!";
			}
			
			String sql = "UPDATE products SET p_id=?, p_name=?, innovator_name=?, initial_price=?, stock_amount=?, product_category=? ";
			
			ps = con.prepareStatement(sql);
			ps.setInt(1,p_id);
			ps.setString(2, p_name);
			ps.setString(3, innovator_name);
            ps.setInt(3,initial_price);
            ps.setInt(4,stock_amount);
            ps.setString(5,product_category);
			ps.setInt(8,p_id);
			
			ps.execute();
			
			
			
		}catch(Exception e) {
			
			System.err.println("Error occurred while Updating Data!\n" + e.getMessage());
			return "Error occurred while Updating Data!";
		}
		
		return "	Data updated Successfully!";
		
	}
	
	public String deleteProduct(int p_id) {
		
		try {
			
			Connection con = connect();
			PreparedStatement ps = null;
			
			if (con == null) {
				return "	Null connection Error !!!";
			}
			
			String sql = "DELETE FROM products WHERE p_id = ?";
			
			ps = con.prepareStatement(sql);
			ps.setInt(1, p_id);
			
			ps.execute();
			
			
		}catch(Exception e) {
			
			System.err.println("Error Deleting Product ! \n" + e.getMessage());
			return "Error Deleting Product ! ";
		}
		
		return "	Product Deleted Successfully !";
	}
	
	
	
	
	
	

}
