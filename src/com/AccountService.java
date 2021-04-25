package com;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import model.Account;

@Path("/Account")
public class AccountService {
	
	
	private Account objAcc;
	private JsonObject accJobj;
	
	
	
	
	@GET
	@Path("/")
	@Produces(MediaType.TEXT_HTML)
	public String test()
	 {
		objAcc = new Account();
		return objAcc.viewallAccounts();
		
	 } 
	
	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	public String createAccount(@FormParam ("fName") String fName, @FormParam ("lName") String lName, @FormParam ("gender") String gender,
							@FormParam ("number") int number, @FormParam ("email") String email, @FormParam ("pass") String pass)

	{
		
		objAcc = new Account();
		//passing and arguments and returning response
		String result = objAcc.createAccount(fName, lName, gender, number, email, pass);
		return result;
	}
	
	
	@PUT
	@Path("/")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	public String updateAccount(@FormParam ("acc_id") int acc_id,@FormParam ("fName") String fName,@FormParam ("lName") String lName,@FormParam ("gender") String gender,
								@FormParam ("number") int number,@FormParam ("email") String email,@FormParam ("pass") String pass) 
	
	{
		
		objAcc = new Account();
		//passing and arguments and returning response
		String results = objAcc.updateAccount(acc_id,fName,lName,gender,number,email,pass);
		return results;
	}
		
		
	
	
	@DELETE
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String deleteAccount(String accountId)
	{
		objAcc = new Account();
		accJobj = new JsonParser().parse(accountId).getAsJsonObject();
		
		int acc_id = accJobj.get("acc_id").getAsInt();
		
		String result = objAcc.deleteAccount(acc_id);
		return result;
	}

}
