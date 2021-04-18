package com;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import model.Account;

@Path("/Account")
public class AccountService {
	
	@GET
	@Path("/")
	@Produces(MediaType.TEXT_PLAIN)
	public String test()
	 {
		Account obj = new Account();
		obj.test();
	 return "Hello world.";
	 
	 } 

}
