package javaeetutorials.jms.filtering;

import jakarta.annotation.Resource;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.jms.Destination;
import jakarta.jms.JMSConnectionFactory;
import jakarta.jms.JMSContext;
import jakarta.jms.JMSException;
import jakarta.jms.Message;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;

@RequestScoped
@Path("filteringProducer")
public class FiltersProducerController {

  @Inject
  @JMSConnectionFactory("java:/ConnectionFactory")
  private JMSContext context;

  @Resource(lookup = "java:jboss/jms/javaee")
  private Destination destination;

  @GET
  @Path("send/{message}")
  public Response produceMessageForSelection(@PathParam("message") String message)
      throws JMSException {
    Message filteringMessage = context.createTextMessage(message);
    filteringMessage.setBooleanProperty("isCustom", true);
    filteringMessage.setIntProperty("propCount", 10);
    context.createProducer().send(destination, filteringMessage);
    return Response.ok().build();
  }

  @GET
  @Path("sendNotCaught/{message}")
  public Response produceMessageForNotSelection(@PathParam("message") String message)
      throws JMSException {
    Message filteringMessage = context.createTextMessage(message);
    filteringMessage.setBooleanProperty("isCustom", false);
    filteringMessage.setIntProperty("propCount", 3);
    context.createProducer().send(destination, filteringMessage);
    return Response.ok().build();
  }
}