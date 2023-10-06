package javaeetutorials.jms.classic;

import jakarta.annotation.Resource;
import jakarta.enterprise.context.RequestScoped;
import jakarta.jms.ConnectionFactory;
import jakarta.jms.Destination;
import jakarta.jms.JMSException;
import jakarta.jms.MessageProducer;
import jakarta.jms.Session;
import jakarta.jms.TextMessage;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;

@RequestScoped
@Path("producer")
public class ClassicProducerController {

  @Resource(lookup = "java:/ConnectionFactory")
  private ConnectionFactory factory;

  @Resource(lookup = "java:jboss/jms/javaee")
  private Destination destination;

  @GET
  @Path("send/{message}")
  public Response produceMessage(@PathParam("message") String message) throws JMSException {
    Session session = factory.createConnection().createSession();
    MessageProducer producer = session.createProducer(destination);
    TextMessage jmsMessage = session.createTextMessage(message);
    producer.send(jmsMessage);

    return Response.ok().build();
  }
}