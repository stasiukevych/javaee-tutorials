package javaeetutorials.ejb;

import jakarta.ejb.EJB;
import jakarta.enterprise.context.SessionScoped;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;
import java.io.Serializable;

@Path("count")
@SessionScoped
public class StatefulRest implements Serializable {

  @EJB
  private StatefulLocal statefulBean;

  @GET
  @Path("add/{number}")
  public Response add(@PathParam("number") Integer number) {
    statefulBean.addNumber(number);
    return Response.ok(statefulBean.getNumbers().toString()).build();
  }
}