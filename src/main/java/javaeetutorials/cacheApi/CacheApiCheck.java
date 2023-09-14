package javaeetutorials.cacheApi;

import jakarta.inject.Inject;
import jakarta.persistence.Cache;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;
import javaeetutorials.jpa.orm.relationship.Order;
import javaeetutorials.jpa.orm.relationship.OrderLine;

import java.util.Date;
import java.util.List;

@Path("dbCache")
@Transactional
public class CacheApiCheck {

    @Inject
    private EntityManager entityManager;

    // first need to do this
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
    @Path("contains/{id}")
    public Response contains(@PathParam("id") Long id) {

        Cache cache = entityManager.getEntityManagerFactory().getCache();

        boolean containsRes = cache.contains(Order.class, id);

        return Response.ok().entity("Contains result for order with[" + id + "] id: " + containsRes).build();
    }

    @GET
    @Path("remove/{id}")
    public Response removeFromCache(@PathParam("id") Long id) {
        Cache cache = entityManager.getEntityManagerFactory().getCache();

        cache.evict(Order.class, id);

        boolean containsRes = cache.contains(Order.class, id);

        return Response.ok().entity("Contains result for order with[" + id + "] id: " + containsRes).build();
    }
}