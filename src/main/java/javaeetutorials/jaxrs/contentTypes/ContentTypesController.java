package javaeetutorials.jaxrs.contentTypes;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("types")
@Produces(MediaType.APPLICATION_JSON)
public class ContentTypesController {

  @GET
  @Path("html")
  @Produces(MediaType.TEXT_HTML)
  public Response asHtml() {
    return Response.ok("It's a html.").build();
  }

  @GET
  @Path("text")
  @Produces(MediaType.TEXT_PLAIN)
  public Response asTextPlain() {
    return Response.ok("It's a plain text.").build();
  }
}