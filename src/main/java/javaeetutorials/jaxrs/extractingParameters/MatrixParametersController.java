package javaeetutorials.jaxrs.extractingParameters;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.MatrixParam;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

@Path("matrixParams")
public class MatrixParametersController {

  @GET
  public Response ping(@MatrixParam("firstName") String firstName,
      @MatrixParam("secondName") String secondName) {
    return Response.ok("I'm : " + firstName + " " + secondName).build();
  }
}