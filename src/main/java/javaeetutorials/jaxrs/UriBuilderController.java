package javaeetutorials.jaxrs;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriBuilder;
import jakarta.ws.rs.core.UriInfo;

@Path("builder")
public class UriBuilderController {

  @Context
  private UriInfo uriInfo;

  @GET
  @Path("ping")
  public Response pingService() {
    return Response.ok(UriBuilder.fromUri(uriInfo.getBaseUri()).path("ping").build()).build();
  }
}