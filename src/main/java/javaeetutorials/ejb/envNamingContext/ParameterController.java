package javaeetutorials.ejb.envNamingContext;


import jakarta.ejb.EJB;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

@Path("parameters")
public class ParameterController {

  @EJB
  private ParameterSupplier supplier;

  @GET
  @Path("supply")
  public Response supplyParameters() {
    return Response.ok().entity(supplier.getCurrency() + ":" + supplier.getRate()).build();
  }
}