package javaeetutorials.autorization;

import jakarta.annotation.security.RunAs;
import jakarta.ejb.EJB;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;
import java.security.Principal;

@RunAs("user")
@Path("authController")
public class AuthController {

  @EJB
  private AuthorizationSecurityService service;

  @Inject
  private Principal principal;

  @GET
  @Path("all")
  public Response getAll() {
    return Response.ok().entity(service.findUsers()).build();
  }
}