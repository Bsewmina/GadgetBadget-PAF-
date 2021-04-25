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
import model.Product;

@Path("/Product")
public class ProductService {
	    
	
	private Product obj_Pro;
	private JsonObject Pro_JasonObj;
	
	
	       
	
	@GET
	@Path("/")
	@Produces(MediaType.TEXT_PLAIN)
	public String test()
	 {
		obj_Pro =    new Product();
		obj_Pro.test();
		return "  Working!";
	 
	 } 
	
	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	public String createProduct(@FormParam ("p_name") String p_name, @FormParam ("innovator_name") String innovator_name,
							@FormParam ("initial_price") int initial_price, @FormParam ("stock_amount") int stock_amount, @FormParam ("product_category") String product_category)

	{
		//= new Product()
		obj_Pro = new Product();
		
		String result = obj_Pro.createProduct(p_name, innovator_name, initial_price, stock_amount, product_category);
		return result;
	}
	
	
	@PUT
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String updateProduct(String productData) 
	
	{
		Pro_JasonObj = new JsonParser().parse(productData).getAsJsonObject();
		
		int p_id    			= Pro_JasonObj.get("p_id").getAsInt();
		String p_name 			= Pro_JasonObj.get("p_name").getAsString();
		String innovator_name 	= Pro_JasonObj.get("innovator_name").getAsString();
		int initial_price 		= Pro_JasonObj.get("initial_price").getAsInt();
		int stock_amount 		= Pro_JasonObj.get("stock_amount").getAsInt();
		String product_category = Pro_JasonObj.get("product_category").getAsString();
		
		
		String result = Pro_JasonObj.updateProduct(p_id, p_name, innovator_name, initial_price, stock_amount, product_category);
		return result;
	}
	
	
	@DELETE
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String deleteProduct(String productId)
	{
		obj_Pro = new Product();
		Pro_JasonObj = new JsonParser().parse(productId).getAsJsonObject();
		
		int p_id = Pro_JasonObj.get("p_id").getAsInt();
		
		String result = obj_Pro.deleteProduct(p_id);
		return result;
	}

}
