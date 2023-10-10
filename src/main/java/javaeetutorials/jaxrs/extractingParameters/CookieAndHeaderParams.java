package javaeetutorials.jaxrs.extractingParameters;

import jakarta.ws.rs.CookieParam;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.HeaderParam;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

@Path("cookieAndHeader")
public class CookieAndHeaderParams {

  @GET
  @Path("session")
  public Response extractSessionID(@CookieParam("sessionID") String sessionID) {
    return Response.ok("SessionId is: " + sessionID).build();
  }

  @GET
  @Path("user-agent")
  public Response extractUserAgent(@HeaderParam("User-Agent") String userAgent) {
    return Response.ok("User-Agent: " + userAgent).build();
  }
}