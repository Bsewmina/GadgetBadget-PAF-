package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class inquiry {
	
	private Connection connect() {
		Connection con = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("-------------Driverrr ok----------");
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/gadgetbadget_db","root","");
			System.out.println("-------------Connection succeed----------");
		}catch(Exception e){
			System.out.println("-------------Error connectiong to database---------/n " + e.fillInStackTrace());
		}
		
		return con;
	}
	
	
	public String viewInquiry() {
		String result;
		
		try {
			Connection con = connect();		
			
			result ="<link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6\" crossorigin=\"anonymous\">"
					+ "<table class=\"table table-dark\">"
					+ "    <tr>"
					+ "      <th scope=\"col\">inquiry_ID</th>"
					+ "      <th scope=\"col\">Name</th>"
					+ "      <th scope=\"col\">Email</th>"
					+ "      <th scope=\"col\">message_Type</th>"
					+ "		<th scope=\"col\">message</th>"
					+ "    </tr>"
					+ "  <tbody>";
			
			PreparedStatement ps = null;
			String sql = "SELECT * FROM inquiry";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				result += "    <tr><th scope=\"row\">" + Integer.toString(rs.getInt("inqy_id")) + "</th>";
				result += "      <td>" + rs.getString("nama")  + "</td>";
				result += "      <td>" + rs.getString("email")  + "</td>";
				result += "      <td>" + rs.getString("type")  + "</td>";
				result += "      <td>" + rs.getString("message")  + "</td></tr>";
				
			}
			
			result += "</tbody></table>";
			
			
		}catch(Exception e) {
			System.err.println(e);
			return "error while displaying data !!!!!";
		}
		
		return result;
		
	}

	
	public String updateInquiry(int id,String name, String email, String type,String message) {
		
		String result = null;
		
		try {

			Connection con = connect();
			PreparedStatement ps = null;
			
			if(con == null) {
				return "	Null connection Error !!!";
			}
			
			String sql = "UPDATE inquiry SET nama=?, email=?, type=?, message=? WHERE inqy_id =?";
			
			ps = con.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, email);
			ps.setString(3, type);
			ps.setString(4, message);
			ps.setInt(5,id);
			
			ps.execute();
			
		}catch(Exception e) {
			
			System.err.println("error while Updating !!!!!\n" + e.getMessage());
			return "error while Updating !!!!!";
		}
		
		return "	Data successfully Updated !!!!!";
		
	}
	
	
	public String createInquiry(String name, String email, String type,String message) {
		String result = null;
		
		try {
			
			Connection con = connect();
			PreparedStatement ps = null;
			
			if(con == null) {
				return "	Null connection Error !!!";
			}
			
			String sql = "INSERT INTO inquiry VALUES (NULL,?,?,?,?)";
            ps = con.prepareStatement(sql);
            ps.setString(1,name);
            ps.setString(2,email);
            ps.setString(3,type);
            ps.setString(4,message);
            
            ps.execute();
            
            
		}catch(Exception e) {
			
			System.err.println("error while insering !!!!!\n" + e.getMessage());
			return "error while insering !!!!!";
			
		}
		
		return "	Data successfully aded !!!!!";
		
	}
		
		
	public String deleteInquiry(int id) {
		
		try {
			
			Connection con = connect();
			PreparedStatement ps = null;
			
			if (con == null) {
				return "	Null connection Error !!!";
			}
			
			String sql = "DELETE FROM inquiry WHERE inqy_id = ?";
			
			ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			
			ps.execute();
			
			
		}catch(Exception e) {
			
			System.err.println("error while Deleting !!!!!\n" + e.getMessage());
			return "error while Deleting !!!!!";
		}
		
		return "	Data successfully Deleted !!!!!";
	}
	
	
	
	
	
	

}
