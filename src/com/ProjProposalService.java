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
import model.ProjProposal;

@Path("/ProjProposal")
public class ProjProposalService {
	
	
	private ProjProposal objProjProposal;
	private JsonObject ProjProposalJobj;
	
	
	
	
	@GET
	@Path("/")
	@Produces(MediaType.TEXT_PLAIN)
	public String test()
	 {
		objProjProposal = new ProjProposal();
		
		return objProjProposal.viewProjProposal();
		
	 
	 } 
	
	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	public String createProjProposal(@FormParam ("researcher_name") String researcher_name, @FormParam ("researcher_email") String researcher_email, @FormParam ("proj_tittle") String proj_tittle,
							@FormParam ("proj_description") String proj_description, @FormParam ("requird_budget") String requird_budget, @FormParam ("expected_date") String expected_date)

	{
		
		objProjProposal = new ProjProposal();
		
		String result = objProjProposal.createProjProposal(researcher_name, researcher_email, proj_tittle, proj_description, requird_budget, expected_date);
		return result;
	}
	
	
	@PUT
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String updateAccount(String accountData) 
	
	{
		ProjProposalJobj = new JsonParser().parse(accountData).getAsJsonObject();
		
		int proj_id = ProjProposalJobj.get("proj_id").getAsInt();
		String researcher_name = ProjProposalJobj.get("researcher_name").getAsString();
		String researcher_email = ProjProposalJobj.get("researcher_email").getAsString();
		String proj_tittle = ProjProposalJobj.get("proj_tittle").getAsString();
		String proj_description = ProjProposalJobj.get("proj_description").getAsString();
		String requird_budget = ProjProposalJobj.get("requird_budget").getAsString();
		String expected_date = ProjProposalJobj.get("expected_date").getAsString();
		
		String result = objProjProposal.updateProjProposal(proj_id, researcher_name, researcher_email, proj_tittle, proj_description, requird_budget, expected_date);
		return result;
	}
	
	
	@DELETE
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String deleteAccount(String ProposalId)
	{
		objProjProposal = new ProjProposal();
		ProjProposalJobj = new JsonParser().parse(ProposalId).getAsJsonObject();
		
		int proj_id = ProjProposalJobj.get("proj_id").getAsInt();
		
		String result = objProjProposal.deleteProjProposal(proj_id);
		return result;
	}

}
