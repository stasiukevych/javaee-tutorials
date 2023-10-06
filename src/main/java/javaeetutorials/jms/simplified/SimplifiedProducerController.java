package javaeetutorials.jms.simplified;

import jakarta.annotation.Resource;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.jms.Destination;
import jakarta.jms.JMSConnectionFactory;
import jakarta.jms.JMSContext;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;

@RequestScoped
@Path("jmsProducer")
public class SimplifiedProducerController {

  @Inject
  @JMSConnectionFactory("java:/ConnectionFactory")
  private JMSContext context;

  @Resource(lookup = "java:jboss/jms/javaee")
  private Destination destination;

  @GET
  @Path("send/{message}")
  public Response produceMessage(@PathParam("message") String message) {
    context.createProducer().send(destination, message);
    return Response.ok().build();
  }
}