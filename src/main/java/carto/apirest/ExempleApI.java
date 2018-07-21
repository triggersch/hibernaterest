package carto.apirest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import carto.entities.User;
import carto.repositories.FakeUserRepository;

@Path("/users")
public class ExempleApI {
	
	private FakeUserRepository repo =new FakeUserRepository();
	
	@GET
	@Path("/fakes")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllFakeusers(){
		List<User> users = repo.getFakeUsers();
		try {
			return Response.ok().entity(users).build();
		} catch (Exception e) {
			return Response.serverError().build();
		}
		
	}
	
	@GET
	@Path("/all")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllusers(){
		List<User> users = repo.getUsers();
		try {
			return Response.ok().entity(users).build();
		} catch (Exception e) {
			return Response.serverError().build();
		}
		
	}
	
	@GET
	@Path("/add")
	@Produces(MediaType.APPLICATION_JSON)
	public Response addusers(){
		User user = repo.addRandomUser();
		try {
			return Response.ok().entity(user).build();
		} catch (Exception e) {
			return Response.serverError().build();
		}
		
	}

}
