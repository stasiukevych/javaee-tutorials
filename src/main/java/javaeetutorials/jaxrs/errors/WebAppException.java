package javaeetutorials.jaxrs.errors;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

@Path("webAppErrors")
public class WebAppException {

  @GET
  @Path("{id}")
  public Response checkingWebErrors(@PathParam("id") String id) {
    if (id == null) {
      throw new WebApplicationException(Status.NOT_FOUND);
    }

    if (id.length() < 3) {
      throw new WebApplicationException(Status.BAD_REQUEST);
    }

    return Response.ok("Got: " + id).build();
  }
}