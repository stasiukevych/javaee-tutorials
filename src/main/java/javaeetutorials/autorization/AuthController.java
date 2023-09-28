package javaeetutorials.autorization;

import jakarta.annotation.security.PermitAll;
import jakarta.annotation.security.RunAs;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;
import java.security.Principal;

@Stateless
//@RunAs("user")
@RunAs("admin")
@Path("authController")
public class AuthController {

  @EJB
  private AuthorizationSecurityService service;

  @Inject
  private Principal principal;

  @GET
  @Path("all")
  @PermitAll
  public Response getAll() {
    return Response.ok().entity(service.findUsers()).build();
  }

  @GET
  @Path("create/{userName}")
  @PermitAll
  public Response addUserName(@PathParam("userName") String userName) {
    service.addUserName(userName);
    return Response.ok().entity("was added: " + userName).build();
  }

  @GET
  @Path("delete/{userName}")
  @PermitAll
  public Response delete(@PathParam("userName") String userName) {
    service.deleteUserName(userName);
    return Response.ok().entity("was removed: " + userName).build();
  }
}