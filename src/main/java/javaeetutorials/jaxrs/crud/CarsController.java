package javaeetutorials.jaxrs.crud;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriInfo;
import java.net.URI;
import java.util.List;

@Path("cars")
@Stateless
public class CarsController {

  @Context
  private UriInfo uriInfo;

  @Inject
  private EntityManager manager;

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public Response getCars() {
    TypedQuery<Car> query = manager.createNamedQuery(Car.FIND_ALL, Car.class);
    List<Car> cars = query.getResultList();
    return Response.ok(cars).build();
  }

  @GET
  @Path("{id}")
  @Produces(MediaType.APPLICATION_JSON)
  public Response getCarById(@PathParam("id") Long id) {
    return Response.ok(manager.find(Car.class, id).toString()).build();
  }

  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public Response createCar(Car car) {
    manager.persist(car);
    URI bookUri = uriInfo.getAbsolutePathBuilder().path(car.getId().toString()).build();
    return Response.created(bookUri).build();
  }

  @DELETE
  @Path("{id}")
  public Response removeCar(@PathParam("id") Long carId) {
    manager.remove(manager.find(Car.class, carId));
    return Response.noContent().build();
  }
}