package javaeetutorials.jaxrs.extractingParameters;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;

@Path("pathParams")
public class PathParametersController {

  @GET
  @Path("{text}")
  public Response ping(@PathParam("text") String text) {
    return Response.ok("Got pathParam: " + text).build();
  }

  @GET
  @Path("{digit:\\d+}")
  public Response pingWithValidation(@PathParam("digit") Long digit) {
    return Response.ok("Got pathParam: " + digit).build();
  }
}