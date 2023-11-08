package javaeetutorials.jaxrs.errors;


import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

@Path("customErrors")
public class CustomMapperException {

  @GET
  @Path("{id}")
  public Response checkingWebErrors(@PathParam("id") String id) {
    if (id == null) {
      throw new IllegalArgumentException("id not found");
    }

    if (id.length() < 3) {
      throw new IllegalArgumentException("id has incorrect length");
    }

    return Response.ok("Got: " + id).build();
  }
}