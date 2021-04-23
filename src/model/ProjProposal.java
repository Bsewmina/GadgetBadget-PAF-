package model;

import java.sql.*;

public class ProjProposal {
	
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
	
	public String createProjProposal(String researcher_name,String researcher_email,String proj_tittle,String proj_description,String requird_budget,String expected_date) {
		String result = null;
		
		try {
			
			Connection con = connect();
			PreparedStatement ps = null;
			
			if(con == null) {
				return "	Null connection Error !!!";
			}
			
			
			String sql = "INSERT INTO ProjProposal VALUES (NULL,?,?,?,?,?,?)";
            ps = con.prepareStatement(sql);
            ps.setString(1,researcher_name);
            ps.setString(2,researcher_email);
            ps.setString(3,proj_tittle);
            ps.setString(4,proj_description);
            ps.setString(5,requird_budget);
            ps.setString(6,expected_date);
            
            
            ps.execute();
            
            
		}catch(Exception e) {
			
			System.err.println("Error occurred while Inserting ProjProposal!\n" + e.getMessage());
			return "Error occurred while Inserting ProjProposal!";
			
		}
		
		return "	ProjProposal added to the database Successfully! ";
		
	}
	
	
	public String updateProjProposal(int proj_id,String researcher_name,String researcher_email,String proj_tittle,String proj_description,String requird_budget,String expected_date) {
		
		String result = null;
		
		try {

			Connection con = connect();
			PreparedStatement ps = null;
			
			if(con == null) {
				return "	Null connection Error !!!";
			}
			
			String sql = "UPDATE ProjProposal SET proj_id=?, researcher_name=?, researcher_email=?, proj_tittle=?, proj_description=?, requird_budget=?, expected_date=?";
			
			ps = con.prepareStatement(sql);
			ps.setInt(1,proj_id);
			ps.setString(2,researcher_name);
            ps.setString(3,researcher_email);
            ps.setString(4,proj_tittle);
            ps.setString(5,proj_description);
            ps.setString(6,requird_budget);
            ps.setString(7,expected_date);
			
			ps.execute();
			
			
			
		}catch(Exception e) {
			
			System.err.println("Error occurred while Updating ProjProposal!\n" + e.getMessage());
			return "Error occurred while Updating ProjProposal!";
		}
		
		return "	ProjProposal updated Successfully!";
		
	}
	
	public String deleteProjProposal(int proj_id) {
		
		try {
			
			Connection con = connect();
			PreparedStatement ps = null;
			
			if (con == null) {
				return "	Null connection Error !!!";
			}
			
			String sql = "DELETE FROM ProjProposal WHERE proj_id = ?";
			
			ps = con.prepareStatement(sql);
			ps.setInt(1, proj_id);
			
			ps.execute();
			
			
		}catch(Exception e) {
			
			System.err.println("Error Deleting ProjProposal ! \n" + e.getMessage());
			return "Error Deleting ProjProposal ! ";
		}
		
		return "	ProjProposal Deleted Successfully !";
	}
	
	
	
	
	
	

}
