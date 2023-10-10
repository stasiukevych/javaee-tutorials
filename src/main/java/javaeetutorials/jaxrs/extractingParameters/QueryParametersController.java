package javaeetutorials.jaxrs.extractingParameters;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("queryParams")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class QueryParametersController {

  @GET
  public Response ping(@QueryParam("user") String user, @QueryParam("age") Long age) {
    return Response.ok("This is: " + user + ", age: " + age).build();
  }
}