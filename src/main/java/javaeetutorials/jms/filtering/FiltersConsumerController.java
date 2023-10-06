package javaeetutorials.jms.filtering;

import jakarta.annotation.Resource;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.jms.Destination;
import jakarta.jms.JMSConnectionFactory;
import jakarta.jms.JMSContext;
import jakarta.jms.JMSException;
import jakarta.jms.Message;
import jakarta.jms.TextMessage;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;
import java.util.stream.StreamSupport;

@RequestScoped
@Path("filteringConsumer")
public class FiltersConsumerController {

  @Inject
  @JMSConnectionFactory("java:/ConnectionFactory")
  private JMSContext context;

  @Resource(lookup = "java:jboss/jms/javaee")
  private Destination destination;

  @GET
  @Path("retrieve")
  public Response retrieveMessage() throws JMSException {
    Message message = null;

    while (true) {
      message = context.createConsumer(destination, "isCustom AND propCount > 5").receive();
      String messageStr = ((TextMessage) message).getText();
      System.out.println("Received: " + messageStr);
      message.getPropertyNames().asIterator().forEachRemaining(System.out::println);
      if ("Communication was finished".equals(messageStr)) {
        break;
      }
    }

    return Response.ok().entity("Communication was finished").build();
  }
}