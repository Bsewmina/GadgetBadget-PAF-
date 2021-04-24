package com;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import model.finance;

@Path("/finance")

public class financeService {
	private finance objfinance;
	private JsonObject finJobj;
	
	
	
	
	@GET
	@Path("/")
	@Produces(MediaType.TEXT_PLAIN)
	public String test()
	 {
		objfinance = new finance();
		objfinance.test();
		return "Working!";
	 
	 } 
	
	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	public String createfinance(@FormParam ("tax_id") int tax_id, @FormParam ("product_category") String product_category,
							@FormParam ("tax_rate") int tax_rate)

	//
	{
		
		objfinance = new finance();
		
		String result = objfinance.createfinance(tax_id, product_category, tax_rate);
		return result;
	}
	
	
	@PUT
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String updatefinance(String financeData) 
	
	{
		finJobj = new JsonParser().parse(financeData).getAsJsonObject();
		
		int tax_id = finJobj.get("tax_id").getAsInt();
		String product_category = finJobj.get("product_category").getAsString();
		int tax_rate = finJobj.get("tax_rate").getAsInt();
		
		String result = objfinance.updatefinance(tax_id, product_category, tax_rate);
		return result;
	}
	
	
	@DELETE
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String deletefinance(String financeId)
	{
		objfinance = new finance();
		finJobj = new JsonParser().parse(financeId).getAsJsonObject();
		
		int tax_id = finJobj.get("tax_id").getAsInt();
		
		String result = objfinance.deletefinance(tax_id);
		return result;
	}


}
