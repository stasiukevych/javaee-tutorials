package javaeetutorials.jpa.jpql;

import jakarta.inject.Inject;
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

@Path("manage")
@Transactional
public class JPQLEndpoint {

    @Inject
    private EntityManager entityManager;

    @GET
    @Path("findOderById/{id}")
    public Response findById(@PathParam("id") Long id) {
        return Response.ok().entity(entityManager.find(Order.class, id).toString()).build();
    }

    @GET
    @Path("referenceById/{id}")
    public Response referenceById(@PathParam("id") Long id) {
        return Response.ok().entity(entityManager.getReference(Order.class, id).toString()).build();
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
    @Path("mergeUsingMerge/{id}")
    public Response mergeUsingMerge(@PathParam("id") Long id) {
        Order order = entityManager.find(Order.class, id);

        order.setDescription("order #1 after merging");

        entityManager.merge(order);

        return Response.ok().entity(order.toString()).build();
    }

    @GET
    @Path("mergeUsingSet/{id}")
    public Response mergeUsingSet(@PathParam("id") Long id) {
        Order order = entityManager.find(Order.class, id);

        order.setDescription("order #1 after merging using setter");

        return Response.ok().entity(order.toString()).build();
    }

    @GET
    @Path("contains/{id}")
    public Response contains(@PathParam("id") Long id) {
        Order order = entityManager.find(Order.class, id);

        System.out.println("Exist status: " + entityManager.contains(order) + ", id: " + (order != null ? order.getId() : null));

        return Response.ok().entity("contains check").build();
    }

    @GET
    @Path("removeOrderById/{id}")
    public Response removeOrderById(@PathParam("id") Long id) {
        entityManager.remove(entityManager.find(Order.class, id));
        return Response.ok().entity("was removed order with id: " + id).build();
    }
}