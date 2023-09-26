package javaeetutorials.autorization;

import jakarta.annotation.security.DeclareRoles;
import jakarta.ejb.EJB;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;

@Path("authorization")
public class AuthorizationController {

  @EJB
  private AuthorizationService authorizationService;

  @GET
  @Path("create/{userName}")
  public Response createUser(@PathParam("userName") String userName) {
    authorizationService.addUserName(userName);
    return Response.ok().build();
  }

  @GET
  @Path("getAll")
  public Response getAll() {
    return Response.ok(authorizationService.findUsers()).build();
  }

  @GET
  @Path("remove/{userName}")
  public Response delete(@PathParam("userName") String userName) {
    return Response.ok("was removed: " + authorizationService.deleteUserName(userName)).build();
  }
}