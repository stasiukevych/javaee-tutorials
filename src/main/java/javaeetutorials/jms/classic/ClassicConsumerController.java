package javaeetutorials.jms.classic;

import jakarta.annotation.Resource;
import jakarta.enterprise.context.RequestScoped;
import jakarta.jms.Connection;
import jakarta.jms.ConnectionFactory;
import jakarta.jms.Destination;
import jakarta.jms.JMSException;
import jakarta.jms.Message;
import jakarta.jms.MessageConsumer;
import jakarta.jms.Session;
import jakarta.jms.TextMessage;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

@RequestScoped
@Path("consumer")
public class ClassicConsumerController {

  @Resource(lookup = "java:/ConnectionFactory")
  private ConnectionFactory factory;

  @Resource(lookup = "java:jboss/jms/javaee")
  private Destination destination;

  @GET
  @Path("retrieve")
  public Response retrieveMessage() throws JMSException {
    Connection connection = factory.createConnection();
    Session session = connection.createSession();
    MessageConsumer producer = session.createConsumer(destination);

    connection.start();

    Message message = null;

    while (true) {
      message = producer.receive();
      String messageStr = ((TextMessage) message).getText();
      System.out.println("Received: " + messageStr);
      if ("Communication was finished".equals(messageStr)) {
        break;
      }
    }

    return Response.ok().entity("Communication was finished").build();
  }
}