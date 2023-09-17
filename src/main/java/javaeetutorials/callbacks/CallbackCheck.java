package javaeetutorials.callbacks;

import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;
import java.util.Date;
import javaeetutorials.jpa.orm.attributes.Customer;
import javaeetutorials.jpa.orm.attributes.CustomerType;

@Path("callback")
@Transactional
public class CallbackCheck {

  @Inject
  private EntityManager entityManager;

  @GET
  @Path("persist")
  public Response temporalTest() {
    Customer customer = new Customer();
    customer.setId(1L);
    customer.setDateOfBirth(new Date());
    customer.setNameOfCustomer("customer #1");
    customer.setCustomerType(CustomerType.SHIPPING);

    entityManager.persist(customer);

    return Response.ok().entity(entityManager.find(Customer.class, customer.getId()).toString())
        .build();
  }

  @GET
  @Path("removeById/{id}")
  public Response removeById(@PathParam("id") Long id) {

    entityManager.remove(entityManager.find(Customer.class, id));

    return Response.ok().entity("Was removed customer with id: " + id).build();
  }
}