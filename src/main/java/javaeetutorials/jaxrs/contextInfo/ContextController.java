package javaeetutorials.jaxrs.contextInfo;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.HttpHeaders;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.UriInfo;
import java.util.List;

@Path("context")
public class ContextController {

  @Context
  UriInfo uriInfo;

  @GET
  @Path("media")
  public String getDefaultMediaType(@Context HttpHeaders headers) {
    List<MediaType> mediaTypes = headers.getAcceptableMediaTypes();
    return mediaTypes.get(0).toString();
  }

  @GET
  @Path("language")
  public String getDefaultLanguage(@Context HttpHeaders headers) {
    List<String> mediaTypes = headers.getRequestHeader(HttpHeaders.ACCEPT_LANGUAGE);
    return mediaTypes.get(0);
  }

  @GET
  @Path("content")
  public String getContentType(@Context HttpHeaders headers) {
    List<String> mediaTypes = headers.getRequestHeader(HttpHeaders.CONTENT_TYPE);
    return mediaTypes.get(0);
  }
}