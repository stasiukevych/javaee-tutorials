package javaeetutorials.config;

import jakarta.annotation.Resource;
import jakarta.ejb.SessionContext;
import jakarta.ejb.Stateless;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

@Path("session")
@Stateless
public class SessionConfig {

  @Resource
  private SessionContext context;

  @GET
  @Path("check")
  public Response checkSession() {
    return Response.ok(context.toString()).build();
  }
}