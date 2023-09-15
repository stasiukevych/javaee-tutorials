package javaeetutorials.concurrency;

import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;
import java.util.Date;
import java.util.List;
import javaeetutorials.jpa.orm.relationship.Order;
import javaeetutorials.jpa.orm.relationship.OrderLine;

@Path("conc")
@Transactional
public class ConcurrencyCheck {

  @Inject
  private EntityManager entityManager;

  @GET
  @Path("findOderById/{id}")
  public Response findById(@PathParam("id") Long id) {
    return Response.ok().entity(entityManager.find(Order.class, id).toString()).build();
  }

  @GET
  @Path("persistOrder")
  public Response persistOrder() {
    Order order = new Order();
    order.setCreation(new Date());
    order.setDescription("order #1");

    OrderLine orderLine = new OrderLine();
    orderLine.setNumberOfLine(1);
    orderLine.setDescription("order line #1");
    entityManager.persist(orderLine);

    order.setOrderLines(List.of(orderLine));

    entityManager.persist(order);

    return Response.ok().entity(order.toString()).build();
  }

  @GET
  @Path("updateDescription/{id}/{description}")
  public Response updateDescription(@PathParam("id") Long id,
      @PathParam("description") String description) {
    Order order = entityManager.find(Order.class, id);
    order.setDescription(description);
    entityManager.merge(order);

    return Response.ok()
        .entity("Was updated description for[" + id + "], description: " + description).build();
  }

  @GET
  @Path("findVersionById/{id}")
  public Response findVersionById(@PathParam("id") Long id) {
    return Response.ok().entity(entityManager.find(Order.class, id).getVersion()).build();
  }
}