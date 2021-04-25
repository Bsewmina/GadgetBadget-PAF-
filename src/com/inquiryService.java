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
import model.inquiry;


@Path("/inquiry")
public class inquiryService {

	
		private inquiry objInqry1;
		private JsonObject obj;
		
		
		@GET
		@Path("/")
		@Produces(MediaType.TEXT_HTML)
		public String viewInquiry()
		 {
			objInqry1 = new inquiry();
			
			return objInqry1.viewInquiry();
		 
		 } 
		
		
		@POST
		@Path("/")
		@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
		@Produces(MediaType.TEXT_PLAIN)
		public String createInquiry(@FormParam ("name") String name, @FormParam ("email") String email, 
								@FormParam ("type") String type,@FormParam ("message") String message)

		{
			//= new Account()
			objInqry1 = new inquiry();
			
			String result = objInqry1.createInquiry(name, email, type, message);
			return result;
		}
		
	
		@PUT
		@Path("/")
		@Consumes(MediaType.APPLICATION_JSON)
		@Produces(MediaType.TEXT_PLAIN)
		public String updateInquiry(String inquiryData) 
		
		{
			obj = new JsonParser().parse(inquiryData).getAsJsonObject();
			
			int id = obj.get("id").getAsInt();
			String name = obj.get("name").getAsString();
			String email = obj.get("email").getAsString();
			String type = obj.get("type").getAsString();
			String message = obj.get("message").getAsString();
			
			String result = objInqry1.updateInquiry(id, name, email, type, message);
			return result;
		}
		
		
		@DELETE
		@Path("/")
		@Consumes(MediaType.APPLICATION_JSON)
		@Produces(MediaType.TEXT_PLAIN)
		public String deleteInquiry(String inquiryData)
		{
			objInqry1 = new inquiry();
			obj = new JsonParser().parse(inquiryData).getAsJsonObject();
			
			int inquiry_Id = obj.get("inquiry_Id").getAsInt();
			
			String result = objInqry1.deleteInquiry(inquiry_Id);
			return result;
		}
}
