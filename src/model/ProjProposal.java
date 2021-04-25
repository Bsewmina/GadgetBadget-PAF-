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
	
	/*
	  public void test() {
		
			Connection con = connect();		
	}
	*/
	
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
		
		return "ProjProposal Deleted Successfully !";
	}
	
	
	public String viewProjProposal() {
		
		String result;
		
		try {
			
			
			Connection con = connect();		
			
			
			result ="<link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6\" crossorigin=\"anonymous\">"
					+ "<table class=\"table table-dark\">"
					
					+ " <tr>"
					
					+ " <th scope=\"col\">proj_id</th>"
					
					+ " <th scope=\"col\">researcher_name</th>"
					
					+ " <th scope=\"col\">researcher_email</th>"
					
					+ " <th scope=\"col\">proj_tittle</th>"
					
					+ " <th scope=\"col\">proj_description</th>"
					
					+ "	<th scope=\"col\">requird_budget</th>"
					
					+ "	<th scope=\"col\">expected_date</th>"
					
					+ " </tr>" + " <tbody>";
			
			PreparedStatement ps = null;
			
			String sql = "SELECT * FROM ProjProposal"; 
			
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				result += " <tr><th scope=\"row\">" + Integer.toString(rs.getInt("proj_id")) + "</th>";
				
				result += " <td>" + rs.getString("researcher_name")  + "</td>";
				
				result += " <td>" + rs.getString("researcher_email")  + "</td>";
				
				result += " <td>" + rs.getString("proj_tittle")  + "</td>";
				
				result += " <td>" + rs.getString("proj_description") + "</td>";
				
				result += "	<td>" + rs.getString("requird_budget") + "</td>";
				
				result += " <td>" + rs.getString("expected_date")  + "</td></tr>";
				
			}
			
			result += "</tbody></table>";
			
			
		}catch(Exception e) {
			System.err.println(e);
			
			return "error while displaying ProjProposal data !";
		}
		
		return result;
		
	}
	
	
	

}
