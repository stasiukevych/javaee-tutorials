package javaeetutorials.jms.classic;

import jakarta.annotation.Resource;
import jakarta.enterprise.context.RequestScoped;
import jakarta.jms.Connection;
import jakarta.jms.ConnectionFactory;
import jakarta.jms.Destination;
import jakarta.jms.JMSException;
import jakarta.jms.MessageConsumer;
import jakarta.jms.Session;
import jakarta.jms.TextMessage;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

@RequestScoped
@Path("consumer")
public class ConsumerController {

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

    return Response.ok().entity("was received: " + ((TextMessage) producer.receive()).getText())
                   .build();
  }
}