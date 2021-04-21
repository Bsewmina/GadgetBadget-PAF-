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
	
	
	private Product objProduct;
	private JsonObject ProJobj;
	
	
	
	
	@GET
	@Path("/")
	@Produces(MediaType.TEXT_PLAIN)
	public String test()
	 {
		objProduct = new Product();
		objProduct.test();
		return "Working!";
	 
	 } 
	
	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	public String createProduct(@FormParam ("p_name") String p_name, @FormParam ("innovator_name") String innovator_name,
							@FormParam ("initial_price") int initial_price, @FormParam ("stock_amount") int stock_amount)

	{
		//= new Product()
		objProduct = new Product();
		
		String result = objProduct.createProduct(p_name, innovator_name, initial_price, stock_amount);
		return result;
	}
	
	
	@PUT
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String updateProduct(String productData) 
	
	{
		ProJobj = new JsonParser().parse(productData).getAsJsonObject();
		
		int p_id    			= ProJobj.get("p_id").getAsInt();
		String p_name 			= ProJobj.get("p_name").getAsString();
		String innovator_name 	= ProJobj.get("innovator_name").getAsString();
		int initial_price 		= ProJobj.get("initial_price").getAsInt();
		int stock_amount 		= ProJobj.get("stock_amount").getAsInt();
		
		
		String result = ProJobj.updateProduct(p_id, p_name, innovator_name, initial_price, stock_amount);
		return result;
	}
	
	
	@DELETE
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String deleteProduct(String productId)
	{
		objProduct = new Product();
		ProJobj = new JsonParser().parse(productId).getAsJsonObject();
		
		int p_id = ProJobj.get("p_id").getAsInt();
		
		String result = objProduct.deleteProduct(p_id);
		return result;
	}

}
